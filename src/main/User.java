package main;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Date;

/**
 * User class
 * Describing simple attributes of simple user
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 10.12.2016
 * Updated 02.03.2017
 */

public class User implements Serializable{

    private String username;
    private int lastScore;
    private Date lastActive;
    private Level level;

    public User(String username){
        this.username = username;
        this.lastScore= 0;
        this.lastActive = new Date(2017,1,1);
        level = new Level();
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
    }

    public Level getLevel() {
        return level;
    }

    /**
     * Method to save active user to file to export progress outside the application.
     * Saves into file "<activeUser_username>.usr in application directory.
     * @param index - save selected user
     */
    public void saveUser(int index){

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MainFx.getCore().getUsers().get(index).getUsername()+".usr"));
            os.writeObject(MainFx.getCore().getUsers().get(index));
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
            MainFx.getCore().addUsers((User) is.readObject());
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
