package controller.GameContorller;

import gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Class which allows user to load custom questions
 * Creates JFileChooser and loads absolute path
 * of selected file
 *
 * @version 1.1
 * @author Radosław Jajko
 *
 * created 04.01.2017
 * updated --.--.----
 */
public class CustomQuestionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        File selectedFile = null;
        int returnValue = fileChooser.showOpenDialog(null);
        if ( returnValue == JFileChooser.APPROVE_OPTION ){
            selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }


        MainFrame.getCore().loadCustomData(selectedFile.getAbsolutePath());
        MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
        MainFrame.getMainFrame().validate();
        MainFrame.getCore().generateNewOrder(MainFrame.getCore().getActiveQuestionSet().getMaxSize());
        MainFrame.getGameMainPanel().initializeGUI();

    }
}
