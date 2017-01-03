package gui.game;

import controller.BackButtonListener;
import controller.GameContorller.NextQuestionListener;
import gui.IEngPanels;
import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;
import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

/**
 * Game Main Panel creates panel with current game
 * words to translate and buttons to operate during
 * making progress in questions
 *
 * @version 1.1
 * @author Radosław Jajko
 *
 * Created 11.12.2016
 * Updated 03.01.2017
 */

public class GameMainPanel extends EPanel implements IEngPanels {

    private int i = 0;
    private int max;

    private ELabel lWord1b;
    private JTextField tfWord2;

    private EButton bNext;
    private EButton bBack;

    private GameProgressPanel progressPanel;
    private EPanel mainPanel;
    private EPanel summaryPanel;

    //Objects of summaryPanel
    private ELabel username;
    private ELabel opinion;
    private ELabel percent;

    /* Constructor */
    public GameMainPanel(){

        createAndShowGUI();

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

        bNext.addActionListener(new NextQuestionListener());

    }

    /* Getters and Setters */
    public int getCurrentIndex(){
        return this.i;
    }

    public ELabel getlWord1b() {
        return lWord1b;
    }

    public JTextField getTfWord2() {
        return tfWord2;
    }

    public GameProgressPanel getProgressPanel() { return progressPanel; }

    @Override
    public void createAndShowGUI() {

        /* Create main panel to handle other panels*/
        EPanel panel = new EPanel(new BorderLayout());


        /*Create mainPanel which contains word panel and buttons*/
        mainPanel = new EPanel(new GridLayout(0,1));

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
        wordPanel.setPreferredSize(new Dimension(250,80));

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
        panel.add(progressPanel,BorderLayout.LINE_START);
        panel.add(mainPanel, BorderLayout.CENTER);

        summaryPanel = summaryPanel();
        summaryPanel.setVisible(false);

        this.add(panel);
        this.add(summaryPanel);

    }

    /**
     * Next question method increments index of current word
     * also controls when the next question should change
     * panels from mainPanel to SummaryPanel
     *
     */
    public void nextQuestion(){

        i++;
        max = MainFrame.getCore().getDuration() - 1;

        if ( i > max ){

            //Initialize summary panel
            MainFrame.getCore().getActiveUser().getLevel().setScore(MainFrame.getCore().getActiveUser().getLastScore());
            MainFrame.getUserPanel().getTfLevel().setText(MainFrame.getCore().getActiveUser().getLevel().getCurrentLevel());
            MainFrame.getCore().getActiveUser().getBestScores().put(new Date(),MainFrame.getCore().getActiveUser().getLastScore());

            initializeSummaryPanel();

        } else {

            //Do just the next word visible
            progressPanel.setProgressPanel(MainFrame.getCore().getActiveUser().getUsername(), max, i);
            lWord1b.setText(MainFrame.getCore().getActiveQuestionSet().getWord1((Integer) MainFrame.getCore().getOrder().get(i)));
            tfWord2.setText("");
            tfWord2.requestFocus();

        }
    }

    /**
     *  Create summary panel which will show
     *  your progress after finishing this round
     *
     * @return summaryPanel
     */
    private EPanel summaryPanel(){

        EPanel panel = new EPanel(new BorderLayout());

        EPanel dataPanel = new EPanel(new GridLayout(0,1));
        dataPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        Font bolderFont = new Font("Arial",Font.BOLD , 17);
        username = new ELabel();
        username.setHorizontalAlignment(SwingConstants.CENTER);
        opinion  = new ELabel();
        opinion.setHorizontalAlignment(SwingConstants.CENTER);
        percent  = new ELabel();
        percent.setFont(bolderFont);
        percent.setHorizontalAlignment(SwingConstants.CENTER);
        percent.setFont(bolderFont);

        dataPanel.add(username);
        dataPanel.add(opinion);
        dataPanel.add(percent);

        EButton button  = new EButton("Continue");
        button.addActionListener(e -> {

            MainFrame.getScorePanel().addRecord(MainFrame.getCore().getActiveUser().getUsername(),MainFrame.getCore().getActiveUser().getLastScore());
            MainFrame.getMainFrame().setContentPane(MainFrame.getScorePanel());
            MainFrame.getMainFrame().revalidate();
            MainFrame.getCore().getActiveUser().setLastScore(0);
            MainFrame.getCore().saveSession(MainFrame.getCore());


        });

        panel.add(new ELabel("Round Completed"),BorderLayout.PAGE_START);
        panel.add(dataPanel,BorderLayout.CENTER);
        panel.add(button,BorderLayout.PAGE_END);

        return panel;
    }

    /**
     * Generate opinion based on percent gain during the round
     *
     * @param score - user gained score
     * @param maximum - maximum available point to gain
     * @return answer (String) - some text which describes user progress
     */
    private String opinionGeneration(int score, int maximum){

        double valPercent = score * 1.0 / (double) maximum;

        if (valPercent < 0.3 ){
            percent.setForeground(Color.RED);
            opinion.setForeground(Color.RED);
            return "Not so good...";
        } else if ( valPercent >= 0.3 && valPercent < 0.5 ){
            percent.setForeground(Color.BLACK);
            opinion.setForeground(Color.BLACK);
            return "You are making progress";
        } else if ( valPercent >= 0.5 && valPercent < 0.7 ){
            percent.setForeground(Color.BLACK);
            opinion.setForeground(Color.BLACK);
            return "Good work";
        } else if ( valPercent >= 0.7 && valPercent < 1 ){
            percent.setForeground(Color.GREEN);
            opinion.setForeground(Color.GREEN);
            return "Great!";
        } else {
            percent.setForeground(Color.ORANGE);
            opinion.setForeground(Color.ORANGE);
            return "Flawless!!!";
        }

    }

    @Override
    public void initializeGUI() {

        i = 0;
        progressPanel.initializeGUI();
        max = MainFrame.getCore().getDuration()-1;
        mainPanel.setVisible(true);
        summaryPanel.setVisible(false);
        progressPanel.setProgressPanel(
                MainFrame.getCore().getActiveUser().getUsername(),
                max,
                i
        );
        progressPanel.setVisible(true);
        progressPanel.hideLastAnswers();
        progressPanel.setPoints(i, max);

        lWord1b.setText(
                MainFrame.getCore().getActiveQuestionSet().getWord1(
                        (Integer) MainFrame.getCore().getOrder().get(i)
                )
        );
        lWord1b.setVisible(true);

        tfWord2.setText("");
        tfWord2.setVisible(true);
        tfWord2.requestFocus();

    }

    /**
     *  Initialize Summary panel and fill it by collected data
     */
    private void initializeSummaryPanel(){

        int score = MainFrame.getCore().getActiveUser().getLastScore();
        double doublemax = (double) max+1;
        double doublepercent = score * 1.0 / doublemax;

        mainPanel.setVisible(false);
        summaryPanel.setVisible(true);
        username.setText(MainFrame.getCore().getActiveUser().getUsername());
        opinion.setText(opinionGeneration(score,max+1));
        percent.setText(String.valueOf(doublepercent*100)+"%");

    }
}
