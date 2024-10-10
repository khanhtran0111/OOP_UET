package com.khanhtran0111.testingjvfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class AppController {
    @FXML
    private TextArea chatarea;
    @FXML
    private TextField userinput; //user chat import to gemini
    @FXML
    private Button sendButton;

    private ChatBot chatbot;

    public void initialize(){
        chatbot = new ChatBot();
    }

    @FXML
    private void manage_send_message(){
        sendMessage();
    }

    @FXML
    private void manage_key_press(javafx.scene.input.KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            sendMessage();
        }
    }

    private void sendMessage(){
        String message = userinput.getText();
        if(message.isEmpty()) return;
        chatarea.appendText("You: " + message + "\n");
        userinput.clear();

        //call gemini chat
        try{
            String response = chatbot.getGeminiResponse(message);
            String plaintext = convert(response);
            chatarea.appendText("Bot " + plaintext + "\n");
        } catch (Exception e){
            e.printStackTrace();
            chatarea.appendText("Bot: Error getting answer :((!!!");
        }
    }

    //this function will help clear some markdown text (i still can not render markdown text on java fx, send help!!!!!!)
    private String convert(String raw_input){
        String string_output = raw_input
                .replaceAll("#+\\s", "")      // Remove headers (e.g., #, ##, ###)
                .replaceAll("\\*\\*(.*?)\\*\\*", "$1")  // Replace bold (**text**) with plain text
                .replaceAll("\\*(.*?)\\*", "$1")        // Replace italics (*text*) with plain text
                .replaceAll("`(.*?)`", "$1");  // Replace inline code with plain text
        return string_output;
    }
}
