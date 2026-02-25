package appScriptTest;

import java.io.*;
import java.net.*;
import java.util.regex.*;
//Calling:
//SheetReporter2.ReportResult r = SheetReporter2.reportFormRun("Client PT State KAR");
//System.out.println("Sheet update -> " + r);
	
public class SheetReporter2 {
    // 1) Put webhook URL here once (no need to pass every time)
	
	//1. Update and remove existing dates (Not Recommended URL)
    //private static final String WEBHOOK = "https://script.google.com/macros/s/AKfycbwWo9HCKPOOw8psOeUHNsB2FfnipOkrykdFd4IQlpTTTWucYwqeL3W4v9UnPlWwZ1FL/exec";
    
	//2. Update Pending and Done both (Not Recommended URL)
    //private static final String WEBHOOK = "https://script.google.com/macros/s/AKfycbyeoYzjwqscMO8PLa6avmBXbDrwqu2cmoscMpHXv_zhNEUx09eBLfGwBXRgQ-feGhj_/exec";
    
    //3. Update Only Done (Recommended URL)
	private static final String WEBHOOK = "https://script.google.com/macros/s/AKfycbwmiil7kTXtcdRyU_F65xiBpE5wsLIgdzRLmD2zfWaIUdEiuCRbxaDDTt3ge-aAja2A/exec";
    private static final String DEFAULT_SHEET = "TestCases";

    // 2) One-line method to call from tests
    public static ReportResult reportFormRun(String formName) {
        try {
            String payload = "{\"formName\":\"" + escapeJson(formName) + "\",\"sheetName\":\"" + escapeJson(DEFAULT_SHEET) + "\"}";
            String resp = postJson(WEBHOOK, payload);
            // parse foundMatches if present
            int found = parseIntField(resp, "foundMatches");
            return new ReportResult(true, found, resp);
        } catch (Exception e) {
            return new ReportResult(false, 0, e.getMessage());
        }
    }

    // helper to POST JSON and return response body as string
    private static String postJson(String urlStr, String json) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(15000);
        con.setReadTimeout(30000);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            os.write(json.getBytes("utf-8"));
        }

        int code = con.getResponseCode();
        InputStream is = (code >= 200 && code < 300) ? con.getInputStream() : con.getErrorStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            return "HTTP " + code + " -> " + sb.toString();
        }
    }

    private static int parseIntField(String resp, String fieldName) {
        // crude parse: look for "fieldName":<number>
        Pattern p = Pattern.compile("\"" + Pattern.quote(fieldName) + "\"\\s*:\\s*(\\d+)");
        Matcher m = p.matcher(resp);
        if (m.find()) {
            return Integer.parseInt(m.group(1));
        }
        // check for plain text style (PowerShell shows key : value). Try that too.
        p = Pattern.compile(fieldName + "\\s*[:=]\\s*(\\d+)");
        m = p.matcher(resp);
        if (m.find()) return Integer.parseInt(m.group(1));
        return 0;
    }

    private static String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    // small result holder
    public static class ReportResult {
        public final boolean success;
        public final int foundMatches;
        public final String rawResponse;
        public ReportResult(boolean success, int foundMatches, String rawResponse) {
            this.success = success;
            this.foundMatches = foundMatches;
            this.rawResponse = rawResponse;
        }
        public String toString() {
            return "success=" + success + ", foundMatches=" + foundMatches + ", resp=" + rawResponse;
        }
    }
}
