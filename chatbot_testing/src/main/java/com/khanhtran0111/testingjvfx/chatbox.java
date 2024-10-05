package com.khanhtran0111.testingjvfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class chatbox extends Application {

    private TextArea chatArea;
    private TextField userInput;
    private Button sendButton;

    private final String OPENAI_API_KEY = "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";

    @Override
    public void start(Stage primaryStage) {
        // Create chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        // Create input field
        userInput = new TextField();
        userInput.setPromptText("Type your message here...");
        // Create send button
        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());
        // Layout
        VBox layout = new VBox(10, chatArea, userInput, sendButton);
        layout.setPadding(new Insets(10));
        // Scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Chatbot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void sendMessage() {
        String message = userInput.getText();
        if (message.isEmpty()) {
            return;
        }
        // Display user's message
        chatArea.appendText("You: " + message + "\n");
        // Clear input field
        userInput.clear();
        // Call the OpenAI API to get the response
        String botResponse = getOpenAIResponse(message);
        // Display bot's response
        chatArea.appendText("Bot: " + botResponse + "\n");
    }

    private String getOpenAIResponse(String prompt) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String apiUrl = "https://api.openai.com/v1/completions";

            // Create request JSON payload
            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("model", "text-davinci-003");
            requestBody.addProperty("prompt", prompt);
            requestBody.addProperty("max_tokens", 100);

            // Send HTTP POST request to OpenAI API
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + OPENAI_API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse response JSON to get the reply
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonResponse.getAsJsonArray("choices").get(0).getAsJsonObject().get("text").getAsString().trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry, something went wrong.";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
