package gui.settings;

import controller.BackButtonListener;
import gui.*;
import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;
import gui.customcomponents.ERadioButton;

import javax.swing.*;
import java.awt.*;

/**
 * SettingsPanel creates panel to choose number of questions
 * in single game
 *
 * @version 1.3
 * @author Radosław Jajko
 *
 * Created 11.12.2016
 * Updated 06.01.2016
 */
public class SettingsPanel extends EPanel implements IEngPanels{


    private ELabel lSettings;
    private EButton bBack;

    private ERadioButton radioButton1;
    private ERadioButton radioButton2;
    private ERadioButton radioButton3;
    private ERadioButton radioButton4;
    private ERadioButton radioButton5;
    private ERadioButton radioButton6;
    private ERadioButton radioButton7;
    private ERadioButton radioButton8;

    public SettingsPanel(){

        createAndShowGUI();

        bBack.addActionListener(new BackButtonListener());

    }

    private EPanel createDurationPanel(){

        EPanel panel = new EPanel();

        ELabel label                = new ELabel("Set number of words to translate:");
        radioButton1 = new ERadioButton("Short (5 words)");
        radioButton2 = new ERadioButton("Medium (10 words)");
        radioButton3 = new ERadioButton("Long (15 words)");
        radioButton4 = new ERadioButton("Maximum (all words)");

        radioButton1.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);


        //Add action listeners
        radioButton1.addActionListener(e -> { MainFrame.getCore().setDuration(5); });
        radioButton2.addActionListener(e -> { MainFrame.getCore().setDuration(10); });
        radioButton3.addActionListener(e -> { MainFrame.getCore().setDuration(15);});
        radioButton4.addActionListener(e -> { MainFrame.getCore().setDuration(MainFrame.getCore().getQuestions().size());});


        //Put radio buttons in a column in a panel
        EPanel radioPanel = new EPanel(new GridLayout(0,1));
        radioPanel.add(label);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.add(radioButton3);
        radioPanel.add(radioButton4);

        panel.add(radioPanel,BorderLayout.LINE_START);
        return panel;
    }

    private EPanel createReminderPanel(){

        EPanel panel = new EPanel();

        ELabel label = new ELabel("Set break duration time");
        radioButton5 = new ERadioButton("Short (5 minutes)");
        radioButton6 = new ERadioButton("Medium (15 minutes)");
        radioButton7 = new ERadioButton("Long (45 minutes)");
        radioButton8 = new ERadioButton("Custom");

        EPanel customPanel  = new EPanel(new GridLayout(1,0));
        EButton bAcccept    = new EButton("Set");
        JTextField tfCusotm = new JTextField("'Set duration in minutes'");
        customPanel.add(bAcccept);
        customPanel.add(tfCusotm);
        customPanel.setVisible(false);

        radioButton1.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton5);
        group.add(radioButton6);
        group.add(radioButton7);
        group.add(radioButton8);


        //Add action listeners
        radioButton5.addActionListener(e -> {
            customPanel.setVisible(false);
            MainFrame.getCore().setReminderTime(5); });
        radioButton6.addActionListener(e -> {
            customPanel.setVisible(false);
            MainFrame.getCore().setReminderTime(15); });
        radioButton7.addActionListener(e -> {
            customPanel.setVisible(false);
            MainFrame.getCore().setReminderTime(45);});
        radioButton8.addActionListener(e -> {
            customPanel.setVisible(true);});
        bAcccept.addActionListener(e -> {
            if(!tfCusotm.getText().trim().isEmpty()){
                try {
                    MainFrame.getCore().setReminderTime(Integer.parseInt(tfCusotm.getText(),10));
                } catch (NumberFormatException ex){
                    tfCusotm.setText("This is not a number!");
                }
            }
        });


        //Put radio buttons in a column in a panel
        EPanel radioPanel = new EPanel(new GridLayout(0,1));
        radioPanel.add(label);
        radioPanel.add(radioButton5);
        radioPanel.add(radioButton6);
        radioPanel.add(radioButton7);
        radioPanel.add(radioButton8);
        radioPanel.add(customPanel);

        panel.add(radioPanel,BorderLayout.LINE_START);
        return panel;
    }


    @Override
    public void createAndShowGUI() {

        EPanel panel= new EPanel(new BorderLayout());

        lSettings   = new ELabel("Settings");
        lSettings.setHorizontalAlignment(SwingConstants.CENTER);

        bBack       = new EButton("Back");

        EPanel optionsPanel = new EPanel(new GridLayout(0,2));
        optionsPanel.add(createDurationPanel());
        optionsPanel.add(createReminderPanel());

        panel.add(lSettings,BorderLayout.PAGE_START);
        panel.add(optionsPanel,BorderLayout.CENTER);
        panel.add(bBack,BorderLayout.PAGE_END);

        this.add(panel);


    }

    @Override
    public void initializeGUI() {

        switch (MainFrame.getCore().getDuration()){
            case 5: {
                radioButton1.setSelected(true);
                radioButton2.setSelected(false);
                radioButton3.setSelected(false);
                radioButton4.setSelected(false);
                break;
            }
            case 10: {
                radioButton1.setSelected(false);
                radioButton2.setSelected(true);
                radioButton3.setSelected(false);
                radioButton4.setSelected(false);
                break;
            }
            case 15: {
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
                radioButton3.setSelected(true);
                radioButton4.setSelected(false);
                break;
            }
            default: {
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
                radioButton3.setSelected(false);
                radioButton4.setSelected(true);
                break;
            }
        }
        switch ((int)MainFrame.getCore().getReminderTime()){
            case 5: {
                radioButton5.setSelected(true);
                radioButton6.setSelected(false);
                radioButton7.setSelected(false);
                radioButton8.setSelected(false);
                break;
            }
            case 15: {
                radioButton5.setSelected(false);
                radioButton6.setSelected(true);
                radioButton7.setSelected(false);
                radioButton8.setSelected(false);
                break;
            }
            case 45: {
                radioButton5.setSelected(false);
                radioButton6.setSelected(false);
                radioButton7.setSelected(true);
                radioButton8.setSelected(false);
                break;
            }
            default: {
                radioButton5.setSelected(false);
                radioButton6.setSelected(false);
                radioButton7.setSelected(false);
                radioButton8.setSelected(true);
                break;
            }
        }

    }
}
