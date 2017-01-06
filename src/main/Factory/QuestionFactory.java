package main.Factory;

import main.Question;
import main.User;

import java.util.LinkedList;

/**
 * Question Factory class
 * Used to make project more in user-customer kind
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * Created 04.01.2017
 * Updated --.--.----
 */
public class QuestionFactory {

    public static Question createQuestion (LinkedList<String> wordsList1, LinkedList<String> wordsList2) {

        if (!wordsList1.isEmpty() && !wordsList2.isEmpty()) {
            return new Question(wordsList1, wordsList2);
        } else {
            return null;
        }

    }

    public static Question createEmptyQuestion(){
        return new Question();
    }
}
