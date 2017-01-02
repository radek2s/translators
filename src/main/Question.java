package main;

import java.io.Serializable;

/**
 * Question class
 * Class to create simple question
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 10.12.2016
 */

public class Question implements Serializable{

    private String word1;
    private String word2;

    Question(String word1, String word2){
        this.word1 = word1;
        this.word2 = word2;
    }

    boolean isCorrect(String input){

        if(input.equalsIgnoreCase(word2))
            return true;
        else
            return false;
    }

    String getWord1() {
        return word1;
    }

    String getWord2() {
        return word2;
    }

}
