package controller;

import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import main.MainFx;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.Factory.UserFactory;
import main.User;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * UserPane Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 * Updated 03.03.2017
 */

public class UserController implements Initializable {

    private MainController mainController;

    @FXML
    private Label lActiveUser;
    @FXML
    private Label lLastActive;
    @FXML
    private Label lLevel;
    @FXML
    private Label lScore;
    @FXML
    private ListView<String> list;
    @FXML
    private TextField tfNewUser;
    @FXML
    private ProgressBar pbProgress;

    private int selectedId;
    private ObservableList<String> items = FXCollections.observableArrayList();
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }

    @FXML
    public void setAsActive(){

        MainFx.getCore().setActiveUser(MainFx.getCore().getUsers().get(selectedId));
        MainFx.getCore().getActiveUser().setLastActive(new Date());
        lLastActive.setText(dateFormat.format(MainFx.getCore().getActiveUser().getLastActive()));

    }

    @FXML
    public void exportUser(){
        JOptionPane.showMessageDialog(new Frame(),"User saved correctly.");
        MainFx.getCore().getActiveUser().saveUser(selectedId);
    }

    @FXML
    public void importUser(){
        MainFx.getCore().getActiveUser().loadUser();
        items.add(MainFx.getCore().getUsers().getLast().getUsername());
        list.setItems(items);
    }

    @FXML
    public void deleteUser(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete user");
        alert.setHeaderText("Deleting user");
        alert.setContentText("Are you sure?");
        alert.initStyle(StageStyle.UTILITY);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            MainFx.getCore().getUsers().remove(selectedId);
            items.remove(selectedId);
            list.setItems(items);
        }

    }

    @FXML
    public void addUser(){
        if ( !tfNewUser.getText().isEmpty() )
        MainFx.getCore().getUsers().add(UserFactory.createUser(tfNewUser.getText().trim()));
        items.add(MainFx.getCore().getUsers().getLast().getUsername());
        list.setItems(items);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for ( User user: MainFx.getCore().getUsers() ) {
            items.add(user.getUsername());

        }

        list.setItems(items);

        lActiveUser.setText(MainFx.getCore().getActiveUser().getUsername());
        lLastActive.setText(dateFormat.format(MainFx.getCore().getActiveUser().getLastActive()));
        lLevel.setText(MainFx.getCore().getActiveUser().getLevel().getCurrentLevel());
        lScore.setText(String.valueOf(MainFx.getCore().getActiveUser().getLevel().getScore()));

        list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                selectedId = (int)newValue;

                lActiveUser.setText(MainFx.getCore().getUsers().get(selectedId).getUsername());
                lLastActive.setText(dateFormat.format(MainFx.getCore().getUsers().get(selectedId).getLastActive()));
                lLevel.setText(MainFx.getCore().getUsers().get(selectedId).getLevel().getCurrentLevel());
                lScore.setText(String.valueOf(MainFx.getCore().getUsers().get(selectedId).getLevel().getScore()));
                pbProgress.setProgress(MainFx.getCore().getUsers().get(selectedId).getLevel().toNextLevel());
            }
        });

        pbProgress.setProgress(MainFx.getCore().getActiveUser().getLevel().toNextLevel());




    }
}
