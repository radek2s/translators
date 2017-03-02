package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Main Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class MainController {

    @FXML
    private StackPane mainStackPane;

    @FXML
    void initialize(){

        loadMenuScreen();
    }

    public void loadMenuScreen(){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/MenuPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch ( IOException e){
            e.printStackTrace();
        }

        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setScreen(pane);

    }

    public void setScreen(Pane pane){
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }

    public StackPane getMainStackPane(){
        return mainStackPane;
    }
}
