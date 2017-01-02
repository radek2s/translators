package controller;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author Radosław Jajko
 *
 * created 29.12.2016
 * updated 29.12.2016
 */
public class BackButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getMainFrame().setContentPane(MainFrame.getMenuPanel());
        MainFrame.getMainFrame().validate();
    }
}
