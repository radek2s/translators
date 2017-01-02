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
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 11.12.2016
 * Updated 02.01.2016
 */
public class SettingsPanel extends EPanel {


    private ELabel lSettings;
    private EButton bBack;

    public SettingsPanel(){

        EPanel panel= new EPanel(new BorderLayout());

        lSettings   = new ELabel("Settings");
        lSettings.setHorizontalAlignment(SwingConstants.CENTER);

        bBack       = new EButton("Back");

        EPanel optionsPanel = new EPanel(new GridLayout(0,2));
        optionsPanel.add(createDurationPanel());

        panel.add(lSettings,BorderLayout.PAGE_START);
        panel.add(optionsPanel,BorderLayout.CENTER);
        panel.add(bBack,BorderLayout.PAGE_END);

        this.add(panel);

        bBack.addActionListener(new BackButtonListener());

    }

    private EPanel createDurationPanel(){

        EPanel panel = new EPanel();

        ELabel label                = new ELabel("Set number of words to translate:");
        ERadioButton radioButton1   = new ERadioButton("Short (5 words)");
        ERadioButton radioButton2   = new ERadioButton("Medium (10 words)");
        ERadioButton radioButton3   = new ERadioButton("Long (15 words)");
        ERadioButton radioButton4   = new ERadioButton("Maximum (all words)");

        radioButton1.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);


        //Add action lieteners
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


}
