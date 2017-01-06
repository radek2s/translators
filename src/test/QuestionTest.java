package test;

import main.Factory.QuestionFactory;
import main.Question;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * JUnit tests for Question Class
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * Created 06.01.2017
 * Updated --.--.----
 */

public class QuestionTest {

    Question emptyQuestion = QuestionFactory.createEmptyQuestion();

    @Test
    public void dataValidation(){

        //Create data
        LinkedList<String> testWords1 = new LinkedList<>();
        LinkedList<String> testWords2 = new LinkedList<>();

        for ( int i = 1; i <= 400; i++ ){
            testWords1.add(String.valueOf(i)+"testQuestion");
            testWords2.add(String.valueOf(i)+"testAnswer");
        }

        Question testQuestions = QuestionFactory.createQuestion(testWords1, testWords2);

        //Test
        assertEquals(400,testQuestions.getMaxSize());
        assertEquals("400testQuestion",testQuestions.getWord1(399));
        assertEquals("400testAnswer",testQuestions.getWord2(399));

        assertTrue(testQuestions.isCorrect("322testAnswer",321));
        assertNotNull(emptyQuestion);
        assertEquals(0,emptyQuestion.getMaxSize());

        //Simple adding questions
        emptyQuestion.addNextSet(testQuestions);
        assertEquals(400,emptyQuestion.getMaxSize());

        emptyQuestion.addNextSet(testQuestions);
        assertEquals(800,emptyQuestion.getMaxSize());



    }

}
