package gui.game;

import gui.IEngPanels;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;
import gui.MainFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * Game Progress Panel creates panel with game progress
 *
 * @version 1.1
 * @author Radosław Jajko
 *
 * Created 11.12.2016
 * Updated 03.01.2016
 */

public class GameProgressPanel extends EPanel implements IEngPanels{

    private ELabel lUsername;
    private ELabel lPoints;
    private JProgressBar progressBar;

    private ELabel lWasCorrect;
    private ELabel lLastCorrect;
    private ELabel lLastAnswer;

    public GameProgressPanel(){

        createAndShowGUI();

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

        if ( !lWasCorrect.isVisible() ){
            lWasCorrect.setVisible(true);
        }
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

    public void setProgressPanel(String username, int duration, int i){
        duration    = ++duration;
        i           = ++i;
        String label = i + "/" + duration;
        lUsername.setText(username);
        progressBar.setMaximum(duration);
        progressBar.setString(label);
    }

    public void setPoints(int points, int duration) {
        duration= ++duration;
        lPoints.setText(points+"/"+ MainFrame.getCore().getDuration());
        progressBar.setValue(duration);
    }

    public void hideLastAnswers(){

        lWasCorrect.setVisible(false);
        lLastAnswer.setVisible(false);
        lLastCorrect.setVisible(false);
    }

    @Override
    public void createAndShowGUI() {

        EPanel mainPanel = new EPanel(new GridLayout(0,1));

        EPanel statusPanel = new EPanel(new GridLayout(0,1));
        statusPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        statusPanel.setPreferredSize(new Dimension(100,60));
        statusPanel.setAlignmentY(TOP_ALIGNMENT);
        statusPanel.setSize(100,60);


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

    @Override
    public void initializeGUI() {

        lUsername.setText(MainFrame.getCore().getActiveUser().getUsername());
        progressBar.setMaximum(MainFrame.getCore().getDuration());
        setPoints(0,MainFrame.getCore().getDuration());

    }
}
