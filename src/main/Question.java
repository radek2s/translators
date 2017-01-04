package main;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Question class
 * Class to create simple question
 *
 * @version 1.1
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 03.01.2017
 */

public class Question implements Serializable{

    private LinkedList<String> words1;
    private LinkedList<String> words2;

    public Question() {
        this.words1 = new LinkedList<>();
        this.words2 = new LinkedList<>();
    }

    Question(LinkedList<String> words1, LinkedList<String> words2){

        this.words1 = new LinkedList<>();
        this.words2 = new LinkedList<>();

        this.words1.addAll(words1);
        this.words2.addAll(words2);

    }

    public String getWord1(int index){
        return words1.get(index);
    }

    public String getWord2 (int index) {
        return words2.get(index);
    }

    public int getMaxSize(){
        return words1.size();
    }

    public boolean isCorrect(String answer, int index){
        return answer.equalsIgnoreCase(words2.get(index));
    }

    public void addNextSet(Question question){

        this.words1.addAll(question.words1);
        this.words2.addAll(question.words2);

    }

    public void clearWords(){
        this.words1.clear();
        this.words2.clear();
    }


    }

