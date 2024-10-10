package com.khanhtran0111.testingjvfx;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatBot {

    private static final String apiKey = "AIzaSyCKGWbNpxkRbo7A__GU3_DEv5DKVHq6YnE";
    private static final String endpointurl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro-latest:generateContent?key=" + apiKey;

    public static String getGeminiResponse(String userMessage) throws Exception {
        JsonObject requestjson = new JsonObject();
        JsonObject userpart = new JsonObject();
        userpart.addProperty("text", userMessage);

        JsonObject userContent = new JsonObject();
        userContent.addProperty("role", "user");
        userContent.add("parts", userpart);

        requestjson.add("contents", userContent);

        JsonObject generationConfig = new JsonObject();
        generationConfig.addProperty("temperature", 1);
        generationConfig.addProperty("topK", 0);
        generationConfig.addProperty("topP", 0.95);
        generationConfig.addProperty("maxOutputTokens", 8192);

        requestjson.add("generationConfig", generationConfig);

        // Send the request
        URL url = new URL(endpointurl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(requestjson.toString().getBytes());
        }

        // Get the response
        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        // Parse response from Gemini API
        JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
        JsonArray candidatesArray = jsonResponse.getAsJsonArray("candidates");

        // Fetch the first response from the candidates array
        for (JsonElement candidateElement : candidatesArray) {
            JsonObject candidateObject = candidateElement.getAsJsonObject();
            JsonObject contentObject = candidateObject.getAsJsonObject("content");
            JsonArray partsArray = contentObject.getAsJsonArray("parts");

            for (JsonElement partElement : partsArray) {
                JsonObject partObject = partElement.getAsJsonObject();
                return partObject.get("text").getAsString(); // Return the bot's response
            }
        }

        return "No response from bot.";
    }
}
