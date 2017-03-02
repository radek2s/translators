package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.MainFx;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * ScorePane Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class ScorePaneController implements Initializable {

    private MainController mainController;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        label1.setText(MainFx.getCore().getScoresTab().printRecord(0));
        label2.setText(MainFx.getCore().getScoresTab().printRecord(1));
        label3.setText(MainFx.getCore().getScoresTab().printRecord(2));
        label4.setText(MainFx.getCore().getScoresTab().printRecord(3));
        label5.setText(MainFx.getCore().getScoresTab().printRecord(4));
        label6.setText(MainFx.getCore().getScoresTab().printRecord(5));
        label7.setText(MainFx.getCore().getScoresTab().printRecord(6));
        label8.setText(MainFx.getCore().getScoresTab().printRecord(7));
        label9.setText(MainFx.getCore().getScoresTab().printRecord(8));
        label10.setText(MainFx.getCore().getScoresTab().printRecord(9));

    }
}
