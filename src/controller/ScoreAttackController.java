package controller;

import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.MainFx;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;


/**
 * Score Attack Pane Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class ScoreAttackController implements Initializable{

    private MainController mainController;

    @FXML
    private ProgressBar pgBarTime;
    @FXML
    private TextField tfWord;
    @FXML
    private Label lWord;
    @FXML
    private Button bNext;
    @FXML
    private Label lPoints;
    @FXML
    private Label lPointsNum;
    @FXML
    private Label lLastWord;
    @FXML
    private Label lLastAnsw;
    @FXML
    private Button bContinue;
    @FXML
    private Label lTimes;

    private int currentId = 0;
    private int currentPoints = 0;

    Task task = new Task<Void>(){
        @Override public Void call() throws InterruptedException {
            final int time = 600; // 10 == 1 sec
            for (int i = 1; i <= time; i++){
                if (isCancelled()){
                    break;
                }
                updateProgress(i,time);
                sleep(100);
            }
            fin();
            return null;
        }
    };

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    public void nextWord(){

        checkAnswer(
                tfWord.getText(),
                MainFx.getCore().getActiveQuestionSet().getWord2(
                        (int)MainFx.getCore().getOrder().get(currentId))
        );
        // Jump to next word //
        currentId++;
        // Show next word //
        lWord.setText(
                MainFx.getCore().getActiveQuestionSet().getWord1(
                        (int)MainFx.getCore().getOrder().get(currentId)
                )
        );


    }

    @FXML
    public void backMenu(){
        MainFx.getCore().getScoresTab().addRecord(
                currentPoints,
                MainFx.getCore().getActiveUser().getUsername()
        );
        mainController.loadMenuScreen();
    }

    private void checkAnswer(String input, String correct){

        if ( input.equalsIgnoreCase(correct) ){
            lLastWord.setVisible(false);
            lLastAnsw.setVisible(false);
            currentPoints++;
            lPointsNum.setText(String.valueOf(currentPoints));
        } else {
            lLastWord.setVisible(true);
            lLastAnsw.setVisible(false);
            lLastWord.setText(correct);
            lLastAnsw.setText(input);
            if (currentPoints > 0){
                currentPoints--;
                lPointsNum.setText(String.valueOf(currentPoints));
            }
        }
        tfWord.requestFocus();
        tfWord.setText("");

    }

    private void fin(){

        /* Show pane with data */
        bContinue.setVisible(true);
        lTimes.setVisible(true);
        lWord.setVisible(false);
        tfWord.setVisible(false);
        bNext.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /* Hide pane with data */
        bContinue.setVisible(false);
        lTimes.setVisible(false);
        lLastAnsw.setVisible(false);
        lLastWord.setVisible(false);

        currentId = 0;
        currentPoints = 0;
        lWord.setText(
                MainFx.getCore().getActiveQuestionSet().getWord1(
                        (int) MainFx.getCore().getOrder().get(currentId)
                )
        );
        pgBarTime.progressProperty().bind(task.progressProperty());
        new Thread(task).start();

        tfWord.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent event) {
                if ( event.getCode() == KeyCode.ENTER){
                    bNext.fire();
                }
            }
        });

    }

}
