package controller.GameContorller;

import gui.MainFrame;
import main.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.2
 * @author Radosław Jajko
 *
 * created 03.01.2017
 * updated 04.01.2017
 */
public class SetChooserListener implements ActionListener {

    private int index;

    public SetChooserListener(int i){

        this.index = i;

    }

    @Override
    public void actionPerformed(ActionEvent e){

        MainFrame.getCore().setActiveQuestionSet(
                MainFrame.getCore().getQuestions().get(index));

        MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
        MainFrame.getMainFrame().validate();
        MainFrame.getCore().generateNewOrder(MainFrame.getCore().getActiveQuestionSet().getMaxSize());
        MainFrame.getCore().setTimer(new Timer());
        MainFrame.getGameMainPanel().initializeGUI();
        MainFrame.getCore().getTimer().start();

    }

}
