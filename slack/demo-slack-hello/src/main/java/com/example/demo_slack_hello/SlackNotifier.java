package com.example.demo_slack_hello;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SlackNotifier {

    //#Generall用 webhookURL
    private static final String WEBHOOK_URL = "https://hooks.slack.com/services/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 "; // ← ここを実際のURLに変更


    public static void send(String message) {
        try {
            String payload = String.format("{\"text\":\"%s\"}", message);

            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes("UTF-8"));
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Slack response: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}