package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import main.MainFx;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Practice Pane Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class PracticeController implements Initializable{

    private MainController mainController;

    @FXML
    private Button bNext;
    @FXML
    private Label lCorrect;
    @FXML
    private Label lCorrectWord;
    @FXML
    private Label lInputWord;
    @FXML
    private Label lActiveUser;
    @FXML
    private Label lPoints;
    @FXML
    private Label lWord;
    @FXML
    private TextField tfAnswer;
    @FXML
    private ProgressBar pgbar;

    @FXML
    private Label lPercentage;
    @FXML
    private Label lComment;
    @FXML
    private Label lUsername;
    @FXML
    private Button bContinue;


    private int currentId = 0;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    public void nextWord(){

        checkAnswer(tfAnswer.getText(),MainFx.getCore().getActiveQuestionSet().getWord2((int)MainFx.getCore().getOrder().get(currentId)));
        if (currentId < MainFx.getCore().getDuration()-1 ){
            currentId++;


            pgbar.setProgress(Double.parseDouble(String.valueOf(currentId))/Double.parseDouble(String.valueOf(MainFx.getCore().getDuration()-1)));
            lWord.setText(MainFx.getCore().getActiveQuestionSet().getWord1((int)MainFx.getCore().getOrder().get(currentId)));
        } else {

            double gained = (double) MainFx.getCore().getActiveUser().getLastScore();
            double maximum= (double) MainFx.getCore().getDuration();

            tfAnswer.setVisible(false);
            lWord.setVisible(false);
            bNext.setVisible(false);

            lPercentage.setVisible(true);
            lComment.setVisible(true);
            lUsername.setVisible(true);
            bContinue.setVisible(true);

            lUsername.setText(MainFx.getCore().getActiveUser().getUsername());
            lComment.setText(opinionGeneration((int)gained,(int)maximum));
            lPercentage.setText(String.valueOf((gained/maximum)*100)+"%");

            MainFx.getCore().getActiveUser().getLevel().setScore(scoreAdding(gained,maximum));
            MainFx.getCore().getActiveUser().setLastScore(0);
            MainFx.getCore().saveSession(MainFx.getCore());
        }

    }

    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /* Hide pane with data */
        lPercentage.setVisible(false);
        lComment.setVisible(false);
        lUsername.setVisible(false);
        bContinue.setVisible(false);

        lCorrect.setVisible( false );
        lCorrectWord.setVisible( false );
        lInputWord.setVisible( false );

        /* Prepare user progress panel */
        lActiveUser.setText(MainFx.getCore().getActiveUser().getUsername());
        lPoints.setText(calculatePoints());
        pgbar.setProgress(0);

        currentId = 0;
        lWord.setText(MainFx.getCore().getActiveQuestionSet().getWord1(
                (int) MainFx.getCore().getOrder().get(currentId)
        ));

        tfAnswer.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                if ( event.getCode() == KeyCode.ENTER){
                    bNext.fire();
                }
            }
        });

    }

    private String calculatePoints(){
        return MainFx.getCore().getActiveUser().getLastScore()+"/"+MainFx.getCore().getDuration();
    }

    private void checkAnswer(String input, String correct){

        lCorrect.setVisible(true);

        if ( input.equalsIgnoreCase(correct) ){
            lCorrectWord.setVisible(false);
            lInputWord.setVisible(false);
            MainFx.getCore().getActiveUser().setLastScore(MainFx.getCore().getActiveUser().getLastScore()+1);
            lPoints.setText(calculatePoints());
            lCorrect.setText("Correct answer!");

        } else {
            lCorrect.setText("Wrong answer...");
            lCorrectWord.setVisible(true);
            lInputWord.setVisible(true);
            lCorrectWord.setText(correct);
            lInputWord.setText(input);

        }
        tfAnswer.requestFocus();
        tfAnswer.setText("");

    }

    private String opinionGeneration(int score, int maximum){

        double valPercent = score * 1.0 / (double) maximum;

        if (valPercent < 0.3 ){
            return "Not so good...";
        } else if ( valPercent >= 0.3 && valPercent < 0.5 ){
            return "You are making progress";
        } else if ( valPercent >= 0.5 && valPercent < 0.7 ){
            return "Good work";
        } else if ( valPercent >= 0.7 && valPercent < 1 ){
            return "Great!";
        } else {
            return "Flawless!!!";
        }

    }

    private int scoreAdding(double score, double maximum){

        double valPercent = score * 1.0 / maximum;
        if ( valPercent == 0.0 ){
            return -1;
        } else if (valPercent > 0.0 && valPercent < 0.5 ){
            return 0;
        } else if ( valPercent >= 0.5 && valPercent < 1 ){
            return 1;
        } else {
            return 3;
        }

    }

}
