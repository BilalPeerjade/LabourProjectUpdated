package com.registers.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeekOffApiUtil {

    private static final String BASE_URL =
            "https://labourapi.teamleaseregtech.com/api/Common/GetWeekOffDetailsByClientID";

    /**
     * Fetch WeekOff data from API
     *
     * @param clientId Client ID
     * @param month    Month (1-12)
     * @param year     Year (e.g. 2026)
     * @param printJsonInConsole true = print pretty JSON, false = no print
     * @return JSON response as String
     */
    public static String getWeekOffData(String clientId, int month, int year, boolean printJsonInConsole) {

        if (clientId == null || clientId.isEmpty()) {
            throw new IllegalArgumentException("ClientID is required to call WeekOffAPI");
        }

        try {
            String urlString = BASE_URL +
                    "?ClientID=" + clientId +
                    "&month=" + month +
                    "&year=" + year;

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(15000);

            int status = conn.getResponseCode();

            BufferedReader reader;

            if (status >= 200 && status < 300) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );
            } else {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getErrorStream())
                );
            }

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            conn.disconnect();

            String jsonResponse = response.toString();

            // 🔥 Pretty Print Logic
            if (printJsonInConsole) {
                printPrettyJson(jsonResponse);
            }
            System.out.println("APIs");

            return jsonResponse;

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch WeekOff data", e);
        }
    }

    /**
     * Pretty print JSON (array or object)
     */
    private static void printPrettyJson(String json) {
        try {
            if (json.trim().startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                System.out.println(jsonArray.toString(4)); // 4 = indentation
            } else {
                JSONObject jsonObject = new JSONObject(json);
                System.out.println(jsonObject.toString(4));
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + json);
        }
    }
}