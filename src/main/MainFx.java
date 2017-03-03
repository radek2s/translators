package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * Main Application class
 * Launching the application with loading data.
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 * Updated 03.03.2017
 */

public class MainFx extends Application {


    private static Stage stage;

    private static Core core = new Core();

    public static Core getCore(){
        return core;
    }

    public static Stage getStage(){
        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        stage.getIcons().add(new Image("file:resources/icon/icon.png"));
        stage.setTitle("English Translator");

        core.testDataLoading();
        core = core.initialize(core);



        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/MainScreen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        if (core.getActiveStyleSheet() == null || core.getActiveStyleSheet().equals("")){
            scene.getStylesheets().add("/gui/css/engThemeRed.css");
            core.setActiveStyleSheet("/gui/css/engThemeRed.css");
        } else {
            scene.getStylesheets().add(core.getActiveStyleSheet());
        }

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
