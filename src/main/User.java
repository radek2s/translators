package main;

import controller.UserPanelController.Observable;
import controller.UserPanelController.UserModelListener;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User class
 * Describing simple attributes of simple user
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 04.01.2017
 */

public class User implements Serializable , Observable{

    private String username;
    private int lastScore;
    private Date lastActive;
    private Level level;
    private Map<Date, Integer> bestScores;

    private UserModelListener listener;

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

    public int getLastScore() {
        return lastScore;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }

    public Date getLastActive() { return lastActive; }

    public void setLastActive(Date date) {
        this.lastActive = date;
        modelChanged();
    }

    public Level getLevel() {
        return level;
    }

    public Map getBestScores(){
        return bestScores;
    }

    /**
     * ModelChanged method base on the Observer pattern
     * when last score has changed inform listeners
     * that userChanged
     */

    private void modelChanged(){
        if ( listener != null ){
            listener.userChanged();
        }
    }

    @Override
    public void subscribe(UserModelListener l) {
        listener = l;
    }

    @Override
    public void unsubscribe(UserModelListener l) {
        listener = null;
    }
}
