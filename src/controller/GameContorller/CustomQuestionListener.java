package controller.GameContorller;

import gui.MainFrame;
import main.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Class which allows user to load custom questions
 * Creates JFileChooser and loads absolute path
 * of selected file
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * created 04.01.2017
 * updated 04.01.2017
 */
public class CustomQuestionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files","txt","text");
        fileChooser.setFileFilter(filter);
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
        MainFrame.getCore().setTimer(new main.Timer());
        MainFrame.getGameMainPanel().initializeGUI();
        MainFrame.getCore().getTimer().start();

    }
}
