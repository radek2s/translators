package controller;

import main.MainFx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Factory.QuestionFactory;
import main.Question;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * PlayPane Controller Class
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class PlayController implements Initializable {

    private MainController mainController;


    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public void openPracticePanel(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/gui/fxml/play/PracticePane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        PracticeController practiceController = loader.getController();
        practiceController.setMainController(mainController);
        mainController.setScreen(pane);

    }

    /********************************************************************************/
    /**             School                                                         **/
    /********************************************************************************/

    @FXML
    public void open0(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(0)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open1(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(1)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open2(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(2)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open3(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(3)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open4(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(4)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open5(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(5)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open6(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(6)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open7(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(7)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open8(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(8)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from school //
    @FXML
    public void open1All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 0; i <= 8; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Health                                                         **/
    /********************************************************************************/

    @FXML
    public void open9(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(9)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open10(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(10)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open11(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(11)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open12(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(12)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open13(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(13)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open14(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(14)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open15(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(15)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from health //
    @FXML
    public void open2All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 9; i <= 15; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             House                                                          **/
    /********************************************************************************/

    @FXML
    public void open16(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(16)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open17(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(17)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open18(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(18)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open19(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(19)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from house //
    @FXML
    public void open3All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 16; i <= 19; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Family                                                          **/
    /********************************************************************************/

    @FXML
    public void open20(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(20)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open21(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(21)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open22(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(22)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open23(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(23)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open24(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(24)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open25(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(25)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open26(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(26)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from family //
    @FXML
    public void open4All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 20; i <= 26; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Work                                                          **/
    /********************************************************************************/

    @FXML
    public void open27(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(27)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open28(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(28)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open29(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(29)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open30(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(30)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open31(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(31)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open32(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(32)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from work //
    @FXML
    public void open5All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 27; i <= 32; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**            Travel                                                          **/
    /********************************************************************************/

    @FXML
    public void open33(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(33)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open34(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(34)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open35(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(35)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open36(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(36)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open37(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(37)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open38(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(38)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open39(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(39)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from school //
    @FXML
    public void open6All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 33; i <= 39; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }


    /********************************************************************************/
    /**             Food                                                           **/
    /********************************************************************************/


//    @FXML
//    public void open40(){

//        MainFx.getCore().setActiveQuestionSet(
//                MainFx.getCore().getQuestions().get(1)
//        );
//        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
//        openPracticePanel();
//    }

    @FXML
    public void open41(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(41)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open42(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(42)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open43(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(43)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open44(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(44)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open45(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(45)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open46(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(46)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from food //
    @FXML
    public void open7All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 41; i <= 46; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Human                                                          **/
    /********************************************************************************/


    @FXML
    public void open47(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(47)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open48(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(48)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }
    @FXML
    public void open49(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(49)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open50(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(50)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open51(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(51)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open52(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(52)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open53(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(53)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open54(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(54)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open55(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(55)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from familly //
    @FXML
    public void open8All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 47; i <= 55; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Culture                                                         **/
    /********************************************************************************/


    @FXML
    public void open56(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(56)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open57(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(57)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open58(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(58)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open59(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(59)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open60(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(1)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from culture //
    @FXML
    public void open9All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 56; i <= 60; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Sport                                                          **/
    /********************************************************************************/

    @FXML
    public void open61(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(61)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open62(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(62)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open63(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(63)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open64(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(64)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open65(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(65)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open66(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(66)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open67(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(67)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from sport //
    @FXML
    public void open10All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 61; i <= 67; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }


    /********************************************************************************/
    /**             Science                                                        **/
    /********************************************************************************/


    @FXML
    public void open68(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(68)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open69(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(69)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open70(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(70)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open71(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(71)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open72(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(72)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from science //
    @FXML
    public void open11All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 68; i <= 72; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Nature                                                         **/
    /********************************************************************************/


//    @FXML
//    public void open73(){

//        MainFx.getCore().setActiveQuestionSet(
//                MainFx.getCore().getQuestions().get(1)
//        );
//        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
//        openPracticePanel();
//    }

    @FXML
    public void open74(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(74)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open75(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(75)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open76(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(76)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open77(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(77)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open78(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(78)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open79(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(79)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open80(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(80)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open81(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(81)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open82(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(82)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from nature //
    @FXML
    public void open12All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 74; i <= 82; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    /********************************************************************************/
    /**             Country                                                        **/
    /********************************************************************************/


    @FXML
    public void open83(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(83)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open84(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(84)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open85(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(85)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open86(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(86)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open87(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(87)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open88(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(88)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open89(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(89)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void open90(){

        MainFx.getCore().setActiveQuestionSet(
                MainFx.getCore().getQuestions().get(90)
        );
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    // All from country //
    @FXML
    public void open13All(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 83; i <= 90; i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void openAll(){
        Question expandedQuestion = QuestionFactory.createEmptyQuestion();
        for (int i = 0; i < MainFx.getCore().getQuestions().size(); i++ ){
            expandedQuestion.addNextSet(MainFx.getCore().getQuestions().get(i));
        }
        MainFx.getCore().setActiveQuestionSet(expandedQuestion);
        MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
        openPracticePanel();
    }

    @FXML
    public void openCustom(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose file");
        File file = fc.showOpenDialog(new Stage());
        if (file != null){
            MainFx.getCore().loadCustomData(file.getAbsolutePath());
            MainFx.getCore().generateNewOrder(MainFx.getCore().getActiveQuestionSet().getMaxSize());
            openPracticePanel();
        }

    }

    @FXML
    public void backMenu(){
        mainController.loadMenuScreen();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
