package gui.game;

import controller.BackButtonListener;
import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;
import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

/**
 * Game Main Panel creates panel with current game
 * words to translate and buttons to operate during
 * making progress in questions
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 11.12.2016
 * Updated 02.01.2016
 */

public class GameMainPanel extends EPanel {

    private int i = 0;
    private int max;

    private ELabel lWord1b;
    private JTextField tfWord2;

    private EButton bNext;
    private EButton bBack;

    private GameProgressPanel progressPanel;

    public GameMainPanel(){


        createMainUI();

        bBack.addActionListener(new BackButtonListener());

        tfWord2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    bNext.doClick();
                }
                if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    bBack.doClick();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        bNext.addActionListener(nextQuestionAction());


    }

    public ELabel getlWord1b() {
        return lWord1b;
    }

    public JTextField getTfWord2() {
        return tfWord2;
    }

    void createMainUI(){

        /*Create panel which contains satus and current game*/
        EPanel panel = new EPanel(new GridLayout(1,2));

        /*Create mainPanel which contains word panel and buttons*/
        EPanel mainPanel = new EPanel(new GridLayout(0,1));

        /* Create word panel which contains word to translate and tex field to write*/
        //Words Panel
        EPanel wordPanel = new EPanel( new GridLayout(0,1));
        wordPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        lWord1b = new ELabel();
        lWord1b.setHorizontalAlignment(SwingConstants.LEFT);

        tfWord2 = new JTextField();
        tfWord2.setHorizontalAlignment(SwingConstants.LEFT);

        wordPanel.add(new ELabel("Translate:"));
        wordPanel.add(lWord1b);
        wordPanel.add(tfWord2);
        wordPanel.setPreferredSize(new Dimension(200,80));

        //Buttons Panel
        EPanel buttonsPane = new EPanel( new GridLayout(1,2));
        buttonsPane.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));

        bNext           = new EButton("Start");
        bBack           = new EButton("Back");


        buttonsPane.add(bBack);
        buttonsPane.add(bNext);

        //Creating main panel and adding word and buttons panels
        mainPanel.add(wordPanel);
        mainPanel.add(buttonsPane);

        //Creating panel and adding progress panel and main panel to panel and to "this"
        progressPanel = new GameProgressPanel();
        panel.add(progressPanel);
        panel.add(mainPanel);

        this.add(panel);

    }

    void nextQuestion(){

        lWord1b.setVisible(true);
        tfWord2.setVisible(true);
        progressPanel.setVisible(true);
        bNext.setText("Next");

        max = MainFrame.getCore().getDuration();
        if ( i >= max-1 ) {
            i = 0;
            MainFrame.getScorePanel().addRecord(MainFrame.getCore().getActiveUser().getUsername(),MainFrame.getCore().getActiveUser().getLastScore());
            MainFrame.getMainFrame().setContentPane(MainFrame.getScorePanel());
            MainFrame.getMainFrame().revalidate();
            MainFrame.getCore().saveSession(MainFrame.getCore());
            MainFrame.getCore().getActiveUser().getLevel().setScore(MainFrame.getCore().getActiveUser().getLastScore());
            MainFrame.getCore().getActiveUser().getBestScores().put(new Date(),MainFrame.getCore().getActiveUser().getLastScore());
            MainFrame.getUserPanel().getTfLevel().setText(MainFrame.getCore().getActiveUser().getLevel().getCurrentLevel());
            MainFrame.getCore().getActiveUser().setLastScore(0);
            lWord1b.setVisible(false);
            tfWord2.setVisible(false);
            progressPanel.setVisible(false);
        } else {
            i++;
            System.out.println(MainFrame.getCore().getOrder().get(i - 1));
            progressPanel.setProgresPanel(MainFrame.getCore().getActiveUser().getUsername(), max, i);
            lWord1b.setText(MainFrame.getCore().getQuestion((Integer) MainFrame.getCore().getOrder().get(i)));
            tfWord2.setText("");
            tfWord2.requestFocus();

        }
    }

    private ActionListener nextQuestionAction(){

        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean test = MainFrame.getCore().checkAnswer((Integer) MainFrame.getCore().getOrder().get(i),tfWord2.getText());
                if (test){
                    System.out.print("Brawo!");
                    MainFrame.getCore().getActiveUser().setLastScore(MainFrame.getCore().getActiveUser().getLastScore()+1);
                    progressPanel.setWasCorrect(true);
                }else {
                    if( i != 0 ){
                        System.out.print("Źle!");
                        progressPanel.setWasCorrect(false);
                        progressPanel.setLastAnswer(tfWord2.getText(), MainFrame.getCore().getAnswer((Integer) MainFrame.getCore().getOrder().get(i)));
                    }

                }
                progressPanel.setPoints(MainFrame.getCore().getActiveUser().getLastScore(),i+1);

                nextQuestion();
            }
        };

        return actionListener;

    }



}
