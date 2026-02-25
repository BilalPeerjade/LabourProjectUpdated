package rcp;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class UploadHelper {

    public static void uploadFileRobust(WebDriver driver,
                                       By inputLocatorCandidates[], // array of candidate locators, best first
                                       By filenameSpanLocator,      // optional: locator for span that shows filename (can be null)
                                       String filePath,
                                       By uploadButtonLocator,      // optional: click after uploading (can be null)
                                       int timeoutSeconds) throws Exception {

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
//    	WebDriverWait  wait = getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));
        File f = new File(filePath);
        if (!f.exists()) throw new IllegalArgumentException("File not found: " + f.getAbsolutePath());
        String abs = f.getAbsolutePath();

        WebElement fileInput = null;
        Exception lastException = null;

        // Try each candidate locator
        for (By locator : inputLocatorCandidates) {
            try {
                // Wait presence (not necessarily visible)
                List<WebElement> candidates = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
                for (WebElement cand : candidates) {
                    try {
                        // Try to unhide + make interactable via JS
                        makeElementInteractable(driver, cand);

                        // scroll into view
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", cand);
                        Thread.sleep(150);

                        // Try sendKeys
                        cand.sendKeys(abs);

                        // Success — set fileInput and break
                        fileInput = cand;
                        break;
                    } catch (WebDriverException e) {
                        lastException = e;
                        // try next candidate element
                    }
                }
                if (fileInput != null) break;
            } catch (TimeoutException te) {
                lastException = te;
                // try next locator
            }
        }

        // If still null, try finding input relative to filename span
        if (fileInput == null && filenameSpanLocator != null) {
            try {
                List<WebElement> spans = driver.findElements(filenameSpanLocator);
                for (WebElement span : spans) {
                    try {
                        // try to find input sibling/descendant near this span
                        WebElement nearInput = findNearbyInput(driver, span);
                        if (nearInput != null) {
                            makeElementInteractable(driver, nearInput);
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", nearInput);
                            Thread.sleep(150);
                            nearInput.sendKeys(abs);
                            fileInput = nearInput;
                            break;
                        }
                    } catch (Exception e) {
                        lastException = e;
                    }
                }
            } catch (Exception e) {
                lastException = e;
            }
        }

        if (fileInput == null) {
            // Nothing worked — throw informative error
            String msg = "Failed to upload file. Tried locators but could not interact with any file input. Last error: "
                    + (lastException != null ? lastException.getMessage() : "none");
            throw new RuntimeException(msg, lastException);
        }

        // Wait optionally until filename span updates (if provided)
        if (filenameSpanLocator != null) {
            try {
                wait.until(driver1 -> {
                    try {
                        WebElement span = driver1.findElement(filenameSpanLocator);
                        String txt = span.getText().trim();
                        return txt.length() > 0 && !txt.equalsIgnoreCase("No file chosen");
                    } catch (NoSuchElementException ex) {
                        return false;
                    }
                });
            } catch (TimeoutException ignored) {
                // not fatal
            }
        }

        // Click upload button if provided
        if (uploadButtonLocator != null) {
            try {
                WebElement upBtn = wait.until(ExpectedConditions.elementToBeClickable(uploadButtonLocator));
                upBtn.click();
            } catch (Exception e) {
                // log but not fatal
                System.out.println("Could not click upload button: " + e.getMessage());
            }
        }
    }

    // make element visible and remove overlay issues
    private static void makeElementInteractable(WebDriver driver, WebElement el) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // set display block if hidden
        js.executeScript(
                "arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].style.opacity=1; " +
                "arguments[0].style.zIndex=2147483647; arguments[0].style.position='relative';", el);

        // also try to remove pointer-events of parent overlays (best-effort)
        js.executeScript(
                "var p = arguments[0].parentElement; " +
                "if(p){ p.style.pointerEvents='auto'; p.style.zIndex=2147483646; }", el);

        // try to remove any overlay elements that are covering (brute-force: set pointer-events:none on siblings)
        js.executeScript(
                "var s = arguments[0].parentElement ? arguments[0].parentElement.children : []; " +
                "for(var i=0;i<s.length;i++){ if(s[i] !== arguments[0]) { s[i].style.pointerEvents='none'; } }", el);
    }

    // try to find an input near the span in DOM (siblings, previous, next)
    private static WebElement findNearbyInput(WebDriver driver, WebElement span) {
        try {
            // check siblings
            WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", span);
            if (parent != null) {
                List<WebElement> inputs = parent.findElements(By.xpath(".//input[@type='file']"));
                if (!inputs.isEmpty()) return inputs.get(0);
            }
            // try following nodes globally
            WebElement near = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "var s=arguments[0]; var n=s.nextSibling; while(n){ if(n.querySelector && n.querySelector('input[type=file]')) return n.querySelector('input[type=file]'); n=n.nextSibling;} return null;",
                    span);
            if (near != null) return near;
        } catch (Exception ignored) {}
        return null;
    }
}

