package controller.GameContorller;

import gui.MainFrame;
import main.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class which create new expanded Question which contains more
 * than one simple question.
 *
 * @version 1.1
 * @author Radosław Jajko
 *
 * created 04.01.2017
 * updated --.--.----
 */
public class AllQuestionsSetListener implements ActionListener {

    private int index;
    private Question expandedQuestion;

    public AllQuestionsSetListener(int i){

        this.index = i;
        expandedQuestion = new Question();

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        switch (index) {
            case 0: {
                for (int i = 0; i < MainFrame.getCore().getQuestions().size(); i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 1: {
                for (int i = 0; i <= 8; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 2: {
                for (int i = 9; i <= 15; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 3: {
                for (int i = 16; i <= 19; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 4: {
                for (int i = 20; i <= 26; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 5: {
                for (int i = 27; i <= 32; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 6: {
                for (int i = 33; i <= 40; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 7: {
                for (int i = 41; i <= 46; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 8: {
                for (int i = 47; i <= 55; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 9: {
                for (int i = 56; i <= 60; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 10: {
                for (int i = 61; i <= 67; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 11: {
                for (int i = 68; i <= 73; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 12: {
                for (int i = 74; i <= 82; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }
            case 13: {
                for (int i = 83; i <= 90; i++) {
                    expandedQuestion.addNextSet(MainFrame.getCore().getQuestions().get(i));
                }
                MainFrame.getCore().setActiveQuestionSet(expandedQuestion);
                break;
            }

        }
        MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
        MainFrame.getMainFrame().validate();
        MainFrame.getCore().generateNewOrder(MainFrame.getCore().getActiveQuestionSet().getMaxSize());
        MainFrame.getGameMainPanel().initializeGUI();
    }
}
