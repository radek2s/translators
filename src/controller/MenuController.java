package controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main.Factory.QuestionFactory;
import main.MainFx;
import main.Question;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;


/**
 * MenuPane Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class MenuController implements Initializable{

    @FXML
    private Label userLabel;

    /* Time to remind */
    // 600  <=> 1min
    // 3000 <=> 5min
    // 9000 <=> 15min
    // 27000<=> 45min
    private int time = 600;

    Task task = new Task<Void>(){
        @Override public Void call() throws InterruptedException {
            for (int i = 1; i <= time; i++){
                if (isCancelled()){
                    break;
                }
                sleep(100);
            }
            MainFx.getStage().show();
            try {
                this.finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return null;
        }
    };

    private MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    public void openPlay(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/play/SelectionPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        PlayController playController = loader.getController();
        playController.setMainController(mainController);
        mainController.setScreen(pane);
    }
    @FXML
    public void openScoreAttack(){

        /* Prepare question word set */
        Question question = QuestionFactory.createEmptyQuestion();
        for (int i = 0; i < MainFx.getCore().getQuestions().size(); i++){
            question.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(question);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize(),MainFx.getCore().getActiveQuestionSet().getMaxSize());

        // Open Score Attack Panel //
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/play/ScoreAttackPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        ScoreAttackController scoreAttackController = loader.getController();
        scoreAttackController.setMainController(mainController);
        mainController.setScreen(pane);
    }

    @FXML
    public void openScores(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/PointsPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        ScorePaneController scorePaneController = loader.getController();
        scorePaneController.setMainController(mainController);
        mainController.setScreen(pane);
    }
    @FXML
    public void openUserPanel(){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/UserPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        UserController userController = loader.getController();
        userController.setMainController(mainController);
        mainController.setScreen(pane);


    }

    @FXML
    public void openSettings(){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/settings/SettingsPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        SettingsController settingsController = loader.getController();
        settingsController.setMainController(mainController);
        mainController.setScreen(pane);

    }

    @FXML
    public void remind5(){
        MainFx.getCore().saveSession(MainFx.getCore());
        time = 3000;
        MainFx.getStage().hide();
        task.run();
    }
    @FXML
    public void remind15(){
        MainFx.getCore().saveSession(MainFx.getCore());
        time = 9000;
        MainFx.getStage().hide();
        task.run();
    }
    @FXML
    public void remind45(){
        MainFx.getCore().saveSession(MainFx.getCore());
        time = 27000;
        MainFx.getStage().hide();
        task.run();
    }


    @FXML
    public void exit(){
        MainFx.getCore().saveSession(MainFx.getCore());
        Platform.exit();
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userLabel.setText(MainFx.getCore().getActiveUser().getUsername());
    }
}
