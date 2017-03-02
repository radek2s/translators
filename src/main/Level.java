package main;

import java.io.Serializable;

/**
 * Level class
 * Class which describe levels in application
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 02.03.2017
 *
 */
public class Level implements Serializable{

    private int score;
    private int cLevel; //current level

    public void setScore(int score){
        this.score += score;
        setLevel(this.score);
    }
    
    public int getScore(){
        return score;
    }

    public String getCurrentLevel(){

        switch (this.cLevel){
            case 0:{
                return "N/A";
            }
            case 1:{
                return "Beginner";
            }
            case 2:{
                return "Score keeper";
            }
            case 3:{
                return "Score fighter";
            }
            case 4:{
                return "Advanced user";
            }
            case 5:{
                return "Loyal user";
            }
            case 6:{
                return "Premium user";
            }
            case 7:{
                return "Maser of translations";
            }
            case 8:{
                return "Smart person";
            }
            case 9:{
                return "King of kings!";
            }
        }
        return null;
    }

    private void setLevel(int score){

        if (score <= 0){
            this.score = 0;
            cLevel = 0;
        } else if (score > 0 && score <= 10 ){
            cLevel = 1;
        } else if (score >10 && score <= 25){
            cLevel = 2;
        } else if (score >25 && score <= 100){
            cLevel = 3;
        } else if (score >100 && score <= 200){
            cLevel = 4;
        } else if (score >200 && score <= 300){
            cLevel = 5;
        } else if (score >300 && score <= 500){
            cLevel = 6;
        } else if (score >500 && score <= 1000){
            cLevel = 7;
        } else if (score >1000 && score <= 2500){
            cLevel = 8;
        } else {
            cLevel = 9;
        }

    }

    /**
     * Calculate progress to next level based on
     * the current level and next one
     *
     * @return float number form 0 to 1 as a percentage progress
     */
    public float toNextLevel(){
        int score = this.score;
        float max;
        int min = 0;
        if (score <= 0){
            max = 1;
        } else if (score > 0 && score <= 10 ){
            min = 0;
            max = 10;
        } else if (score >10 && score <= 25){
            min = 10;
            max = 25;
        } else if (score >25 && score <= 100){
            min = 25;
            max = 100;
        } else if (score >100 && score <= 200){
            min = 100;
            max = 200;
        } else if (score >200 && score <= 300){
            min = 200;
            max = 300;
        } else if (score >300 && score <= 500){
            min = 300;
            max = 500;
        } else if (score >500 && score <= 1000){
            min = 500;
            max = 1000;
        } else if (score >1000 && score <= 2500){
            min = 1000;
            max = 1500;
        } else {
            min = 1500;
            max = 2500;
        }
        score = score - min;
        max = max - min;
        return score/max;

    }

}
