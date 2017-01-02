package gui;

import gui.game.ChooserPanel;
import gui.game.GameMainPanel;
import gui.settings.SettingsPanel;
import gui.user.UserPanel;
import main.Core;

import javax.swing.*;
import java.awt.*;

/**
 * Main Frame class
 * Contains every static panels using by an application
 * Contains also Core object which include all user data and game data
 *
 * @version 1.0
 * @author  Radosław Jajko
 *
 * Created 10.12.2016.
 * Updated 29.12.2016.
 */

public class MainFrame extends JFrame{

    private static MainFrame mainFrame = null;

    private static MenuPanel menuPanel         = new MenuPanel();
    private static GameMainPanel gameMainPanel = new GameMainPanel();
    private static ChooserPanel chooserPanel   = new ChooserPanel();
    private static ScorePanel scorePanel       = new ScorePanel();
    private static SettingsPanel settingsPanel = new SettingsPanel();
    private static UserPanel userPanel         = new UserPanel();

    private static Core core = new Core();

    //Singleton antipattern
    private MainFrame(){}

    public static MainFrame getMainFrame(){
        if(mainFrame == null){
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }

    /* Methods to get each element of MainFrame class */

    public static Core getCore() {
        return core;
    }

    public static MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public static GameMainPanel getGameMainPanel() {
        return gameMainPanel;
    }

    public static ChooserPanel getChooserPanel() { return chooserPanel; }

    public static ScorePanel getScorePanel() { return scorePanel; }

    public static SettingsPanel getSettingsPanel() {
        return settingsPanel;
    }

    public static UserPanel getUserPanel() {
        return userPanel;
    }

    /* Main method to start */

    public static void main(String[] args){

        MainFrame.getMainFrame().prepareEnvironment();
        SwingUtilities.invokeLater(() -> {

            CreateAndShowGUI();
        });
    }

    /**
     *  Create and show Graphic User Interface
     *  MainFrame object mainFrame is created on application start
     *  because it is static object. This method sets its behaviour
     *  and makes this object visible and sets up first panel.
     */
    private static void CreateAndShowGUI(){

        getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getMainFrame().setMinimumSize(new Dimension(400,300));
        getMainFrame().setPreferredSize(new Dimension(600,500));
        getMainFrame().setLocation(300,200);
        getMainFrame().setTitle("Java English Word Translator");


        getMainFrame().setContentPane(menuPanel);
        getMainFrame().validate();

        getMainFrame().pack();
        getMainFrame().setVisible(true);

    }

    private void prepareEnvironment(){

        core = core.initialize(core);
        getUserPanel().initialize();
    }



}
