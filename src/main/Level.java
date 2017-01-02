package main;

import java.io.Serializable;

/**
 * Level class
 * Class which describe levels in application
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 02.01.2017
 *
 */
public class Level implements Serializable{

    private int score = 0;
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

        if (score == 0){
            cLevel = 0;
        } else if (score > 0 && score <= 50 ){
            cLevel = 1;
        } else if (score >50 && score <= 150){
            cLevel = 2;
        } else if (score >150 && score <= 300){
            cLevel = 3;
        } else if (score >300 && score <= 500){
            cLevel = 4;
        } else if (score >500 && score <= 1000){
            cLevel = 5;
        } else if (score >1000 && score <= 2000){
            cLevel = 6;
        } else if (score >2000 && score <= 5000){
            cLevel = 7;
        } else if (score >5000 && score <= 10000){
            cLevel = 8;
        } else {
            cLevel = 9;
        }

    }

}
