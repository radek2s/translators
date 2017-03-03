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
 * Updated 03.03.2017
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

    @FXML
    private RadioButton rbThemeDark;
    @FXML
    private RadioButton rbThemeLime;
    @FXML
    private RadioButton rbThemeRed;

    ToggleGroup durationGroup;
    ToggleGroup themeGroup;

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

    public void setTheme() {

        String path;
        if (rbThemeDark.isSelected()){
            path = "/gui/css/engThemeDark.css";
            MainFx.getCore().setActiveStyleSheet(path);
            MainFx.getStage().getScene().getStylesheets().clear();
            MainFx.getStage().getScene().getStylesheets().add(path);
        } else if ( rbThemeLime.isSelected()){
            path = "/gui/css/engThemeLime.css";
            MainFx.getCore().setActiveStyleSheet(path);
            MainFx.getStage().getScene().getStylesheets().clear();
            MainFx.getStage().getScene().getStylesheets().add(path);
        } else {
            path = "/gui/css/engThemeRed.css";
            MainFx.getCore().setActiveStyleSheet(path);
            MainFx.getStage().getScene().getStylesheets().clear();
            MainFx.getStage().getScene().getStylesheets().add(path);
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

        themeGroup = new ToggleGroup();
        rbThemeDark.setToggleGroup(themeGroup);
        rbThemeLime.setToggleGroup(themeGroup);
        rbThemeRed.setToggleGroup(themeGroup);

        if ( MainFx.getCore().getActiveStyleSheet().contains("Dark")) {
            rbThemeDark.setSelected(true);
            rbThemeLime.setSelected(false);
            rbThemeRed.setSelected(false);
        } else if ( MainFx.getCore().getActiveStyleSheet().contains("Lime")) {
            rbThemeDark.setSelected(false);
            rbThemeLime.setSelected(true);
            rbThemeRed.setSelected(false);
        } else {
            rbThemeDark.setSelected(false);
            rbThemeLime.setSelected(false);
            rbThemeRed.setSelected(true);
        }


    }
}
