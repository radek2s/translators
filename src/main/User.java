package main;

import controller.UserPanelController.Observable;
import controller.UserPanelController.UserModelListener;
import gui.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User class
 * Describing simple attributes of simple user
 *
 * @version 1.3
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 10.02.2017
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

    /**
     * Method to save active user to file to export progress outside the application.
     * Saves into file "<activeUser_username>.usr in application directory.
     * @param index - save selected user
     */
    public void saveUser(int index){

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MainFrame.getCore().getUsers().get(index).getUsername()+".usr"));
            os.writeObject(MainFrame.getCore().getUsers().get(index));
        } catch ( IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Method to load single user data form file "*.usr".
     * It's loads the data and adds into users array list.
     */
    public void loadUser(){

        /* Prepare fileChooser */
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("User Save","usr","UserData");
        fileChooser.setFileFilter(filter);
        File selectedFile = null;
        int returnValue = fileChooser.showOpenDialog(null);
        if ( returnValue == JFileChooser.APPROVE_OPTION ){
            selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }

        /* Open and read User Saved data */
        try {
            ObjectInputStream is = new ObjectInputStream( new FileInputStream(selectedFile.getAbsolutePath()));
            MainFrame.getCore().addUsers((User) is.readObject());
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
