package gui;

import controller.BackButtonListener;
import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.2
 * @author Radosław Jajko
 *
 * created 20.12.2016
 * updated 06.01.2017
 */

public class ScorePanel extends EPanel implements IEngPanels{

    private EPanel pScores = null;

    ScorePanel(){

        createAndShowGUI();

    }

    public void addRecord(String user, int points, float time){

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

        //Add new Panel with scores:
        EPanel panel = new EPanel(new GridLayout(0,4));

        panel.add(new ELabel(user+": "));
        panel.add(new ELabel(String.valueOf(points)));
        panel.add(new ELabel(String.format("%.2f",time)+"s"));
        panel.add(new ELabel(dateFormat.format(date)));

        //Add panel as record
        pScores.add(panel);
        pScores.updateUI();
    }

    @Override
    public void createAndShowGUI() {

        //Main panel to handle objects
        EPanel panel = new EPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));


        ELabel lScore = new ELabel("Best Scores");
        lScore.setHorizontalAlignment(SwingConstants.CENTER);
        lScore.setAlignmentY(TOP_ALIGNMENT);

        EButton bBack = new EButton("Back");

        bBack.addActionListener(new BackButtonListener());

        pScores = new EPanel(new GridLayout(0,1));

        panel.add(lScore, BorderLayout.PAGE_START);
        panel.add(pScores, BorderLayout.CENTER);
        panel.add(bBack, BorderLayout.PAGE_END);

        this.add(panel);

    }

    @Override
    public void initializeGUI() {

    }
}
