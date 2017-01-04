package controller.GameContorller;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.1
 * @author Radosław Jajko
 *
 * created 03.01.2017
 * updated --.--.----
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
        MainFrame.getGameMainPanel().initializeGUI();

    }

}
