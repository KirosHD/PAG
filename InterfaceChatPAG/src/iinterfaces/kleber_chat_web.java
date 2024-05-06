package iinterfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class kleber_chat_web extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        VBox chats = new VBox();
        chats.setSpacing(10);
        chats.setPadding(new Insets(10));

        for (int i = 1; i <= 6; i++) {
            Label chatLabel = new Label("Chat " + i);
            chatLabel.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1px; -fx-padding: 5px;");
            chatLabel.setOnMouseClicked(e -> abrirChat(chatLabel.getText()));
            chats.getChildren().add(chatLabel);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(chats);
        scrollPane.setFitToWidth(true);

        root.setLeft(scrollPane);

        VBox chatBox = new VBox();
        chatBox.setPadding(new Insets(10));
        chatBox.setStyle("-fx-background-color: #f4f4f4;");

        TextArea chatText = new TextArea();
        chatText.setPrefHeight(300);
        chatText.setEditable(false);

        TextField messageField = new TextField();
        messageField.setPromptText("Escribe tu mensaje ....");

        chatBox.getChildren().addAll(chatText, messageField);

        root.setCenter(chatBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kleber chat web");
        primaryStage.show();
    }

    private void abrirChat(String chat) {
        System.out.println("Abriendo chat: " + chat);

    }

    public static void main(String[] args) {
        launch(args);
    }
}