package utils;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//scroll and re try
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;



/**
 * DownloadHelper: reliable clicks for "Download" icons in a grid.
 *
 * HOW IT WORKS (high level)
 * 1) We locate the Download <img> using a dynamic XPath that joins the action container
 *    with the data cell by using the same row index (aria-rowindex). This avoids mistakes
 *    where the action icons appear in a separate DOM subtree.
 *
 * 2) Once the correct WebElement is found we ensure it is visible and scrolled to center:
 *    - we center it inside the nearest scrollable ancestor (inner grid scrollbar),
 *    - then we center it in the viewport (window.scrollTo(...)).
 *    This makes clicks reliable when the app has nested scrolling or sticky headers.
 *
 * 3) Click strategy (in order):
 *    - Actions.moveToElement(el).click()  (best for overlays/sticky elements)
 *    - wait.until(elementToBeClickable(el)).click()
 *    - javascriptExecutor("arguments[0].click()") (last resort)
 *
 * 4) Retry: The helper supports a retry loop (defaultRetries). On each retry we re-find
 *    the target elements because some grids virtualize rows and elements can be re-created.
 *
 * USAGE (public wrappers)
 * - clickDownload(stateText)                        -> exact match, first occurrence
 * - clickDownload(stateText, occurrence)            -> exact match, 1-based occurrence
 * - clickDownload(stateText, occurrence, contains, caseInsensitive)
 *                                                  -> flexible matching (if needed)
 * - clickDownloadWithRetry(stateText, occurrence, retries)
 *                                                  -> explicit per-call retry control
 *
 * PARAMETER EXPLANATIONS
 * - stateText: the text we match (could be "MAH", "Maharashtra", "Branch-XYZ"). The internal XPath uses a safe literal builder.
 * - occurrence: 1-based index meaning which matching row to click:
 *      1 -> first matching row,
 *      2 -> second matching row,
 *      <=0 -> last matching row
 * - useContains: (boolean) if true, use contains() style match (useful when cell contains extra text).
 * - caseInsensitive: (boolean) if true, match ignoring case.
 *
 * NOTE: In the current implementation the row-index join expects the matching cell to have @title or similar text exact match.
 *       If you need partial/case-insensitive for the row-index join, we can extend XPath; for most apps passing exact title works.
 */


/*
//=== Simple / common calls ===
//1) Exact code, first occurrence (most common / recommended)
dl.clickDownload("MAH");                        // exact match "MAH", occurrence=1 (first), no contains, case-sensitive

//2) Exact code, 3rd occurrence
dl.clickDownload("MAH", 3);                     // exact match "MAH", occurrence=3 -> clicks 3rd matching row (if <3, clicks last and warns)

//3) Last occurrence (use <=0 to mean last)
dl.clickDownload("MAH", 0);                     // picks last matching occurrence

//=== Partial / name matching variants ===
//4) Partial match (cell contains the text), case-sensitive
dl.clickDownload("Maharashtra", 1, true, false); // useContains=true -> matches "Maharashtra (Zone A)"
                                              // caseInsensitive=false -> "maharashtra" (lowercase) will NOT match

//5) Partial + case-insensitive (most forgiving)
dl.clickDownload("maharashtra", 1, true, true);  // useContains=true, caseInsensitive=true -> matches any capitalization and any extra text

//6) Exact + case-insensitive (exact text ignoring case)
dl.clickDownload("maharashtra", 1, false, true); // useContains=false -> exact equality; caseInsensitive=true -> "MAHARASHTRA" matches

//=== Readable enum overload (if you added MatchOption) ===
dl.clickDownload("Maharashtra", 1, DownloadHelper.MatchOption.CONTAINS, true); // same as useContains=true, caseInsensitive=true

//=== Retry control (per-call override) ===
//7) Per-call retries: attempt initial + 2 retries (3 total attempts)
dl.clickDownloadWithRetry("MAH", 1, 2);          // retries=2 => will try up to 3 times (useful for flaky rendering)

//=== Advanced / helper examples ===
//8) If you want the last occurrence with contains + case-insensitive:
dl.clickDownload("branch-xyz", -1, true, true);  // occurrence <=0 means last; contains + case-insensitive

//9) If multiple rows have similar names and you want the 2nd match (partial)
dl.clickDownload("Mumbai Office", 2, true, false); // clicks 2nd row that contains "Mumbai Office"

//10) Use the default overloads (convenience):
// - clickDownload(stateText) => first occurrence, exact, case-sensitive
// - clickDownload(stateText, occurrence) => exact, case-sensitive
dl.clickDownload("ORS");                        // same as clickDownload("ORS", 1, false, false)
dl.clickDownload("ORS", 2);                     // same as clickDownload("ORS", 2, false, false)
*/



public class DownloadHelper {

    private final WebDriver driver;
    private final ExtentTest test;
    private final int defaultTimeoutSeconds = 10;
    private final int defaultRetries = 2;           // 1 => will try twice (attempts = defaultRetries + 1)


    public DownloadHelper(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    // --- simple defaults (exact match, first occurrence) ---
    public boolean clickDownload(String stateText) {
        return clickDownload(stateText, 1);
    }

    public boolean clickDownload(String stateText, int occurrence) {
        return clickDownload(stateText, occurrence, false, false);
    }

    // --- flexible overloads (contains/case-insensitive) ---
    public boolean clickDownload(String stateText, int occurrence, boolean useContains, boolean caseInsensitive) {
        return clickDownloadForStateInternal(stateText, occurrence, useContains, caseInsensitive);
    }

    // --- enum-friendly overload (cleaner calls) ---
    public enum MatchOption { EXACT, CONTAINS }
    public boolean clickDownload(String stateText, int occurrence, MatchOption matchOption, boolean caseInsensitive) {
        boolean useContains = matchOption == MatchOption.CONTAINS;
        return clickDownload(stateText, occurrence, useContains, caseInsensitive);
    }

    // --- retry helper (simple) ---
    public boolean clickDownloadWithRetry(String stateText, int occurrence, int retries) {
        for (int i = 0; i <= retries; i++) {
            boolean ok = clickDownload(stateText, occurrence);
            if (ok) return true;
            try { Thread.sleep(700); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            test.log(com.relevantcodes.extentreports.LogStatus.INFO, "Retry #" + (i+1) + " for clickDownload(" + stateText + ")");
        }
        return false;
    }

    // ===== Internal implementation (moved from OneCommonMethod style) =====
    
    
    private boolean clickDownloadForStateInternal(String stateText, int occurrence, boolean useContains, boolean caseInsensitive) {
        // defaultTimeoutSeconds and defaultRetries are fields in the class
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeoutSeconds));
        WebDriverWait wait = new WebDriverWait(getDriver(), (30));
        // attempts = defaultRetries + 1 so defaultRetries=1 => 2 attempts
        int maxAttempts = Math.max(1, defaultRetries + 1);

        try {
            // Build the dynamic XPath that joins via aria-rowindex (works for your grid)
            String literal = xpathStringLiteral(stateText); // keep helper in class
            // we ignore useContains/caseInsensitive here because the row-index join requires exact title match;
            // if you need contains/case-insensitive, we can expand xpath, but this version uses title/text exact.
            String xp = String.format(
                "//div[@class='cell-content ng-star-inserted']//div[@style='text-align:center']" +
                "[ancestor::tr/@aria-rowindex = //div[@title=%s]/ancestor::tr/@aria-rowindex]" +
                "//img[@title='Download']",
                literal
            );

            List<WebElement> els = driver.findElements(By.xpath(xp));
            if (els == null || els.isEmpty()) {
                test.log(com.relevantcodes.extentreports.LogStatus.FAIL,
                         "❌ No Download icons found for text: " + stateText + " — tried XPath: " + xp);
                return false;
            }

            // choose index
            int pickIdx;
            if (occurrence <= 0) pickIdx = els.size() - 1;
            else if (occurrence > els.size()) {
                pickIdx = els.size() - 1;
                test.log(com.relevantcodes.extentreports.LogStatus.WARNING,
                         "⚠️ Requested occurrence " + occurrence + " but only " + els.size() + " available. Selecting last (" + (pickIdx + 1) + ")");
            } else pickIdx = occurrence - 1;

            WebElement el = els.get(pickIdx);
            boolean clicked = false;
            String scrollCenterJS =
                "function scrollToCenter(el){"
              + "  var p = el.parentElement;"
              + "  while(p && p !== document.body){"
              + "    var s = window.getComputedStyle(p);"
              + "    if((s.overflowY === 'auto' || s.overflowY === 'scroll') && p.clientHeight < p.scrollHeight){"
              + "      var rectEl = el.getBoundingClientRect();"
              + "      var rectP = p.getBoundingClientRect();"
              + "      var top = rectEl.top - rectP.top + p.scrollTop;"
              + "      p.scrollTop = Math.max(0, Math.round(top - (p.clientHeight/2) + (rectEl.height/2)));"
              + "      break;"
              + "    }"
              + "    p = p.parentElement;"
              + "  }"
              + "  var rect = el.getBoundingClientRect();"
              + "  window.scrollTo({top: Math.max(0, Math.round(rect.top + window.pageYOffset - (window.innerHeight/2))), behavior: 'auto'});"
              + "}"
              + "scrollToCenter(arguments[0]);";

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                try {
                    // center element in nearest scrollable ancestor and viewport
                    ((JavascriptExecutor) driver).executeScript(scrollCenterJS, el);

                    // small wait to allow virtualization/render
                    try { Thread.sleep(300); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }

                    // wait for visibility
                    wait.until(ExpectedConditions.visibilityOf(el));

                    // Try Actions click (best)
                    try {
                        new Actions(driver)
                          .moveToElement(el)
                          .pause(Duration.ofMillis(150))
                          .click()
                          .perform();
                        clicked = true;
                    } catch (Exception actionEx) {
                        // fallback: elementToBeClickable then click
                        try {
                            wait.until(ExpectedConditions.elementToBeClickable(el)).click();
                            clicked = true;
                        } catch (Exception clickableEx) {
                            // final fallback: JS click
                            try {
                                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
                                clicked = true;
                            } catch (Exception jsEx) {
                                clicked = false;
                            }
                        }
                    }

                    if (clicked) {
                    	  // Status Hide
         //               test.log(com.relevantcodes.extentreports.LogStatus.PASS,"✅ Scrolled & clicked Download for '" + stateText + "' (occurrence: " + (pickIdx + 1) + ", attempt: " + attempt + ")");
                        return true;
                    } else {
                        test.log(com.relevantcodes.extentreports.LogStatus.INFO, "ℹ️ Click attempt " + attempt + " failed for '" + stateText + "'. Retrying...");
                    }

                } catch (Exception eAttempt) {
                  //   test.log(com.relevantcodes.extentreports.LogStatus.INFO,"ℹ️ Attempt " + attempt + " exception while clicking '" + stateText + "': " + eAttempt.getMessage());
                }

                // sleep between attempts (except after last)
                if (attempt < maxAttempts) {
                    try { Thread.sleep(400); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
                    // After retry wait, re-acquire the element reference in case DOM re-rendered
                    try {
                        List<WebElement> fresh = driver.findElements(By.xpath(xp));
                        if (fresh != null && fresh.size() > pickIdx) el = fresh.get(pickIdx);
                    } catch (Exception reacq) {
                        // ignore — continue next attempt
                    }
                }
            }

            // all attempts exhausted
            test.log(com.relevantcodes.extentreports.LogStatus.FAIL,
                     "❌ All attempts failed to click Download for '" + stateText + "' (occurrence: " + (pickIdx + 1) + ")");
            return false;

        } catch (Exception e) {
            test.log(com.relevantcodes.extentreports.LogStatus.ERROR,
                     "⚠️ Exception in clickDownloadForStateInternal for '" + stateText + "': " + e.getMessage());
            return false;
        }
    }

    
    
  

    // helper for safe XPath string literal
    private static String xpathStringLiteral(String s) {
        if (s == null) return "''";
        if (!s.contains("'")) return "'" + s + "'";
        if (!s.contains("\"")) return "\"" + s + "\"";
        String[] parts = s.split("'");
        StringBuilder sb = new StringBuilder("concat(");
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) sb.append(", \"'\", ");
            sb.append("'").append(parts[i]).append("'");
        }
        sb.append(")");
        return sb.toString();
    }

    // Expose driver/test if caller needs them
    public WebDriver getDriver(){ return driver; }
    public ExtentTest getTest(){ return test; }
}
