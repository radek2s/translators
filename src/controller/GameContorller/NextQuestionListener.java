package controller.GameContorller;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.1
 * @author Radosław Jajko
 *
 * created 03.01.2017
 * updated --.--.----
 */
public class NextQuestionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        int index = MainFrame.getGameMainPanel().getCurrentIndex();
        int maximum     = MainFrame.getCore().getDuration();
        int     order   = (int) MainFrame.getCore().getOrder().get(index);
        String  answer  = MainFrame.getGameMainPanel().getTfWord2().getText();

        boolean test    = MainFrame.getCore().getActiveQuestionSet().isCorrect(answer,order);

        if ( index != maximum  ){

            if ( test ) {
                System.out.println("Great!");
                MainFrame.getGameMainPanel().getProgressPanel().setWasCorrect(true);
                MainFrame.getCore().getActiveUser().setLastScore(MainFrame.getCore().getActiveUser().getLastScore()+1);

            } else {
                System.out.println("Wrong answer.");
                MainFrame.getGameMainPanel().getProgressPanel().setWasCorrect(false);
                MainFrame.getGameMainPanel().getProgressPanel().setLastAnswer(
                        answer,
                        MainFrame.getCore().getActiveQuestionSet().getWord2(
                                (Integer) MainFrame.getCore().getOrder().get(index))
                );
            }

            MainFrame.getGameMainPanel().getProgressPanel().setPoints(
                    MainFrame.getCore().getActiveUser().getLastScore(),
                    index
            );

            MainFrame.getGameMainPanel().nextQuestion();

        } else {

            MainFrame.getGameMainPanel().nextQuestion();

        }

    }
}
