package gui;

import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu Panel class
 * Creates main menu panel with buttons to sub-menus
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 02.01.2017
 *
 */

public class MenuPanel extends EPanel {

    MenuPanel(){

        EButton bPlay;
        EButton bScore;
        EButton bSettings;
        EButton bLogin;
        EButton bExit;
        ELabel lWelcome;

        EPanel bpanel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(6,0);
        buttonGridLayout.setVgap(10);
        bpanel.setLayout(buttonGridLayout);

        lWelcome= new ELabel("Welcome!");
        lWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        bPlay   = new EButton ("Play");
        bScore  = new EButton ("Score");
        bSettings=new EButton ("Settings");
        bLogin  = new EButton ("Login");
        bExit   = new EButton ("EXIT");

        bpanel.add(lWelcome);
        bpanel.add(bPlay);
        bpanel.add(bScore);
        bpanel.add(bSettings);
        bpanel.add(bLogin);
        bpanel.add(bExit);

        this.add(bpanel);

        bPlay.addActionListener(e -> {
            MainFrame.getMainFrame().setContentPane(MainFrame.getChooserPanel());
            MainFrame.getMainFrame().validate();

        });

        bScore.addActionListener( e->{
            MainFrame.getMainFrame().setContentPane(MainFrame.getScorePanel());
            MainFrame.getMainFrame().validate();
        });

        bSettings.addActionListener(e -> {
            MainFrame.getMainFrame().setContentPane(MainFrame.getSettingsPanel());
            MainFrame.getMainFrame().validate();
        });

        bLogin.addActionListener(e->{
            MainFrame.getMainFrame().setContentPane(MainFrame.getUserPanel());
            MainFrame.getMainFrame().validate();
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getCore().saveSession(MainFrame.getCore());
                System.exit(0);
            }
        });

    }

}