package com.typingtest.typingtest;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import com.typingtest.typingtest.*;
import javafx.scene.text.TextFlow;

import java.util.Timer;
import java.util.TimerTask;

public class TypingTestController {
    public static Text wpm;
    public static Text acc;
    //use textflow so each character has a color
    public static TextFlow textFlow;
    public static TextArea textarea;
    private String targetText;
    private String[] list = {"I admps nlape bviauehv pyaega d apoey vmlpcmxzpa apeytad",
            "The morning sun cast long golden shadows across the empty parking lot as she walked toward the entrance of the building.",
            "He had spent the better part of three years working on a project that most people told him would never amount to anything worthwhile.",
            "The programmer stared at the screen for what felt like hours before finally spotting the missing semicolon that had caused everything to break.",
            "She closed her eyes, took a deep breath, and reminded herself that every difficult moment in life eventually passes if you are patient enough.",
            "The city was alive with the sound of traffic, distant music, and the quiet conversations of strangers passing each other on the crowded sidewalk.",
            "Learning to type faster is not simply about moving your fingers quickly but about training your mind to recognize patterns before your hands even begin to move.",
            "He packed everything he owned into two bags, said goodbye to the apartment he had lived in for six years, and walked out without looking back.",
            "The database had over a million records and querying it without a proper index meant waiting several minutes for results that should have taken milliseconds.",
            "Every great achievement in history began as a single idea in the mind of someone who was willing to work for it long after everyone else had given up.",
            "She typed the final line of code, saved the file, ran the build, and held her breath as the terminal output scrolled past the screen."
    };

    public void startTest(){
        int currentChar = 0;

        int random = (int) (Math.random() * list.length);
        targetText = list[random];

        //The user should first see the text color
        for(int i = 0; i < targetText.length(); i++){
            Text ch = new Text(String.valueOf(targetText.charAt(i)));
            ch.setFill(Color.LIGHTGRAY);
            textFlow.getChildren().add(ch);
        }


        textarea.textProperty().addListener((observable, oldValue, newValue) -> { //Notifies when the value changes, basically eveytime a user types/deletes it handles old text and new
            textFlow.getChildren().clear();

            for(int i = 0; i < targetText.length(); i++){
                Text ch = new Text(String.valueOf(targetText.charAt(i)));

                if(i< newValue.length()){
                    if(newValue.charAt(i) == targetText.charAt(i)){
                        ch.setFill(Color.DARKGRAY);
                    }else{
                        ch.setFill(Color.RED);
                    }
                }else{
                    ch.setFill(Color.LIGHTGRAY);
                }

                textFlow.getChildren().add(ch);
            }
        });
    }

    public void resetTest(){

    }

    public void calculateSpeed(){
        //when the user types the timer begins
        textarea.setOnKeyTyped(event -> {
            int[] seconds = {0};

            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    seconds[0]++;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            wpm.setText(seconds[0] + "s");
                        }
                    });
                }
            }, 0, 1000);
        });
    }
}
