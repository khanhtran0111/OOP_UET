package com.khanhtran0111.testingjvfx;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    private TextArea chatArea;
    private TextField userInput;
    private Button sendButton;
    private ChatBot chatBot; // Instance of ChatBot

    @Override
    public void start(Stage primaryStage) {
        chatBot = new ChatBot(); // Tạo đối tượng ChatBot

        // Create chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        // Create input field
        userInput = new TextField();
        userInput.setPromptText("Type your message here...");
        userInput.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER:
                    sendMessage();
                    break;
                default:
                    break;
            }
        });

        // Create send button
        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        VBox layout = new VBox(10, chatArea, userInput, sendButton);
        layout.setPadding(new Insets(10));

        VBox.setVgrow(chatArea, javafx.scene.layout.Priority.ALWAYS);

        Scene scene = new Scene(layout, 400, 300);
        layout.prefWidthProperty().bind(scene.widthProperty());
        layout.prefHeightProperty().bind(scene.heightProperty());

        primaryStage.setTitle("Chatbot using Gemini API");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Display chat
    private void sendMessage() {
        String message = userInput.getText();
        if (message.isEmpty()) {
            return;
        }

        chatArea.appendText("You: " + message + "\n");
        userInput.clear();

        try {
            String botResponse = chatBot.getGeminiResponse(message); // Gọi qua đối tượng chatBot
            chatArea.appendText("Bot: " + botResponse + "\n");
        } catch (Exception e) {
            e.printStackTrace();
            chatArea.appendText("Bot: Error getting response\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
