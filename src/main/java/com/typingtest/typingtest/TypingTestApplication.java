package com.typingtest.typingtest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static com.typingtest.typingtest.TypingTestController.acc;
import static com.typingtest.typingtest.TypingTestController.wpm;

public class TypingTestApplication extends Application {
    TypingTestController controller;
    @Override
    public void start(Stage stage) throws IOException {

        Text metric = new Text("Metrics: ");
        metric.setTextAlignment(TextAlignment.LEFT);

        Text speed = new Text("Speed: ");
        wpm = new Text("s");
        HBox hb = new HBox(speed,wpm);

        Text accuracy = new Text("Accuracy: ");
        acc = new Text("");
        HBox hb1 = new HBox(accuracy,acc);

        Text correct = new Text("correct: ");
        Text corr = new Text("");

        Text incorrrect = new Text("incorrect: ");
        Text incorr =  new Text("");

        Button resetButton = new Button("Reset Button");
        resetButton.addActionListener();

        HBox hbox = new HBox(metric, hb, hb1);
        hbox.setPadding( new Insets(0,0,50,0) );
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(70);

        TypingTestController.textarea = new TextArea();
        TypingTestController.textarea.setMaxWidth(500);
        TypingTestController.textarea.setPrefHeight(200);

        TypingTestController.textFlow = new TextFlow();
        TypingTestController.textFlow.setMaxWidth(500);
        TypingTestController.textFlow.setPrefHeight(80);

        controller = new TypingTestController();
        controller.startTest();
        controller.calculateSpeed();

        VBox root = new VBox(hbox, TypingTestController.textFlow, TypingTestController.textarea);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Typing Test Application");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
