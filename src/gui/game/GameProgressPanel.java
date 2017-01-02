package gui.game;

import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;
import gui.MainFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Game Progress Panel creates panel with game progress
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 11.12.2016
 * Updated 02.01.2016
 */

public class GameProgressPanel extends EPanel {

    ELabel lUsername;
    ELabel lPoints;
    JProgressBar progressBar;

    ELabel lWasCorrect;
    ELabel lLastCorrect;
    ELabel lLastAnswer;

    public GameProgressPanel(){

        EPanel mainPanel = new EPanel(new GridLayout(0,1));

        EPanel statusPanel = new EPanel(new GridLayout(0,1));
        statusPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        statusPanel.setPreferredSize(new Dimension(100,60));
        statusPanel.setAlignmentY(TOP_ALIGNMENT);


        lUsername   = new ELabel();
        lUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lUsername.setFont(new Font("Arial",Font.BOLD,11));
        lPoints     = new ELabel();
        lPoints.setHorizontalAlignment(SwingConstants.CENTER);
        progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(5);
        progressBar.setStringPainted(true);


        statusPanel.add(lUsername);
        statusPanel.add(lPoints);
        statusPanel.add(progressBar);

        mainPanel.add(statusPanel);
        mainPanel.add(lastAnswerPanel());

        this.add(mainPanel,CENTER_ALIGNMENT);

    }

    private EPanel lastAnswerPanel(){

        EPanel panel = new EPanel(new GridLayout(0,1));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,20,0));

        lWasCorrect = new ELabel();
        lWasCorrect.setHorizontalAlignment(SwingConstants.CENTER);

        lLastAnswer = new ELabel();
        lLastCorrect = new ELabel();
        lLastAnswer.setVisible(false);
        lLastCorrect.setVisible(false);

        panel.add(lWasCorrect);
        panel.add(lLastAnswer);
        panel.add(lLastCorrect);

        return panel;
    }

    public void setLastAnswer(String userAnswer, String correctWord){

        lLastAnswer.setText(userAnswer);
        lLastCorrect.setText(correctWord);

    }

    public void setWasCorrect(boolean wasCorrect){

        if(wasCorrect){
            lWasCorrect.setText("Correct!");
            lWasCorrect.setFont(new Font("Arial", Font.BOLD, 13));
            lWasCorrect.setForeground(Color.GREEN);
            lLastAnswer.setVisible(false);
            lLastCorrect.setVisible(false);
        } else {
            lWasCorrect.setText("Wrong answer!");
            lWasCorrect.setFont(new Font("Calibri", Font.BOLD, 13));
            lWasCorrect.setForeground(Color.RED);
            lLastAnswer.setVisible(true);
            lLastCorrect.setVisible(true);
        }

    }

    public void setProgresPanel(String username, int duration, int i){
        String label = i + "/" + duration;
        lUsername.setText(username);
        progressBar.setMaximum(duration);
        progressBar.setString(label);
    }

    public void setPoints(int points, int duration) {
        lPoints.setText(points+"/"+ MainFrame.getCore().getDuration());
        progressBar.setValue(duration);
    }
    
}
