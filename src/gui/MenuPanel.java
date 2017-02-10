package gui;

import controller.ReminderListener;
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
 * @version 1.3
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 10.02.2017
 *
 */

public class MenuPanel extends EPanel {

    ELabel activeUserLabel;

    MenuPanel(){

        EButton bPlay;
        EButton bScore;
        EButton bSettings;
        EButton bLogin;
        EButton bRemind;
        EButton bExit;
        ELabel lWelcome;

        EPanel bpanel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0,1);
        buttonGridLayout.setVgap(10);
        bpanel.setLayout(buttonGridLayout);

        lWelcome= new ELabel("Welcome!");
        lWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        activeUserLabel = new ELabel("");
        activeUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        activeUserLabel.setFont(new Font("Arial",Font.BOLD , 20));
        bPlay   = new EButton ("Play");
        bScore  = new EButton ("Score");
        bSettings=new EButton ("Settings");
        bLogin  = new EButton ("Login");
        bRemind = new EButton ("Remind Later");
        bExit   = new EButton ("EXIT");

        bpanel.add(lWelcome);
        bpanel.add(activeUserLabel);
        bpanel.add(bPlay);
        bpanel.add(bScore);
        bpanel.add(bSettings);
        bpanel.add(bLogin);
        bpanel.add(bRemind);
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
            MainFrame.getSettingsPanel().initializeGUI();
            MainFrame.getMainFrame().setContentPane(MainFrame.getSettingsPanel());
            MainFrame.getMainFrame().validate();
        });

        bLogin.addActionListener(e->{
            MainFrame.getMainFrame().setContentPane(MainFrame.getUserPanel());
            MainFrame.getMainFrame().validate();
        });

        bRemind.addActionListener(new ReminderListener());

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getCore().saveSession(MainFrame.getCore());
                System.exit(0);
            }
        });

    }

    public void initialize(){
        activeUserLabel.setText(MainFrame.getCore().getActiveUser().getUsername());
    }

}