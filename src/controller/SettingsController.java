package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import main.MainFx;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * SettingsPane Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class SettingsController implements Initializable {

    private MainController mainController;

    @FXML
    RadioButton rbDurationMin;
    @FXML
    RadioButton rbDurationMid;
    @FXML
    RadioButton rbDurationLong;
    @FXML
    RadioButton rbDurationAll;

    ToggleGroup durationGroup;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }


    public void setDuration(){

        if ( rbDurationMin.isSelected() ){
            MainFx.getCore().setDuration(5);
        } else if ( rbDurationMid.isSelected()) {
            MainFx.getCore().setDuration(10);
        } else if ( rbDurationLong.isSelected()) {
            MainFx.getCore().setDuration(15);
        } else {
            MainFx.getCore().setDuration(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        durationGroup = new ToggleGroup();
        rbDurationMin.setToggleGroup(durationGroup);
        rbDurationMid.setToggleGroup(durationGroup);
        rbDurationLong.setToggleGroup(durationGroup);
        rbDurationAll.setToggleGroup(durationGroup);

        switch (MainFx.getCore().getDuration()){
            case 5:{
                rbDurationMin.setSelected(true);
                rbDurationMid.setSelected(false);
                rbDurationLong.setSelected(false);
                rbDurationAll.setSelected(false);
                break;
            }
            case 10: {
                rbDurationMin.setSelected(false);
                rbDurationMid.setSelected(true);
                rbDurationLong.setSelected(false);
                rbDurationAll.setSelected(false);
                break;
            }
            case 15: {
                rbDurationMin.setSelected(false);
                rbDurationMid.setSelected(false);
                rbDurationLong.setSelected(true);
                rbDurationAll.setSelected(false);
                break;
            }
            default: {
                rbDurationMin.setSelected(true);
                rbDurationMid.setSelected(false);
                rbDurationLong.setSelected(false);
                rbDurationAll.setSelected(true);
             }
        }
    }
}
