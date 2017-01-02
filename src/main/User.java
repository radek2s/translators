package main;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User class
 * Describing simple attributes of simple user
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 02.01.2017
 */

public class User implements Serializable{

    private String username;
    private int lastScore;
    private Date lastActive;
    private Level level;
    private Map<Date, Integer> bestScores;

    public User(String username){
        this.username = username;
        this.lastScore= 0;
        this.lastActive = new Date(2017,1,1);
        level = new Level();
        bestScores = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLastScore() {
        return lastScore;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }

    public Date getLastActive() { return lastActive; }

    public void setLastActive(Date date) { this.lastActive = date; }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Map getBestScores(){
        return bestScores;
    }


}
