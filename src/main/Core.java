package main;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Core class
 * Main class which stores every data from running application
 * All created users with them stats and loaded questions
 * Loads data from files and saves Sessions
 * checks users answers
 *
 * @version 1.1
 * @author Radosław Jajko
 *
 * Created 21.12.2016
 * Updated 03.01.2017
 */
public class Core implements ICore, Serializable{


    private int duration                    = 5;
    private ArrayList<Integer> order        = new ArrayList<>();

    private Question activeQuestionSet      = new Question();
    private LinkedList<Question> questions  = new LinkedList<>();

    private User activeUser                 = new User("Test");
    private LinkedList<User> users          = new LinkedList<>();

    /* Getters and setters*/
    //Duration
    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return duration;
    }

    //order
    public ArrayList getOrder(){
        return order;
    }

    //activeQuestionSet
    public void setActiveQuestionSet(Question activeQuestionSet) {
        this.activeQuestionSet = activeQuestionSet;
    }

    public Question getActiveQuestionSet() {
        return activeQuestionSet;
    }

    //questions
    public LinkedList<Question> getQuestions(){
        return questions;
    }

    //activeUser
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public User getActiveUser (){
        return activeUser;
    }

    //users
    public void addUsers(String username) {
        this.users.add(new User(username));
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    /* Methods to control Core */

    /**
     *  Generate random order of reading words in LinkedList object
     *  and return LinkedList of random numbers without repetition
     *
     * @param bound - max number
     */
    public void generateNewOrder(int bound){

        if (order.size() != 0){
            order.clear();
        }
        Random randomGenerator = new Random();
        while (order.size() < duration) {
            int random = randomGenerator.nextInt(bound);
            if (!order.contains(random)){
                order.add(random);
            }
        }
    }

    /**
     * Prepare environment:
     *  Load All data from database files and save as LinkedList of Questions
     *  Generates 90 Questions objects containing words for every domain and kind
     *
     *  k:                          i:
     *  1 "School",                 0 - 8
     *  2 "Health",                 9 - 15
     *  3 "House",                  16 - 19
     *  4 "Family life",            20 - 26
     *  5 "Work",                   27 - 32
     *  6 "Tourism",                33 - 40
     *  7 "Food",                   41 - 46
     *  8 "Human",                  47 - 55
     *  9 "Culture",                56 - 60
     *  10"Sport",                  61 - 67
     *  11"Science and Technology", 68 - 73
     *  12"World of nature",        74 - 82
     *  13"Country and Society",    83 - 90
     *
     *
     */

    @Override
    public void loadAllData(){

        String path = "resources/database/";
        for ( int k = 1 ; k <= 13 ; k++ ){

            String domain = String.valueOf(k);
            for ( int i = 1 ; i <= 9 ; i++ ){

                String baseId = "0" + String.valueOf(i) + ".txt";
                LinkedList<String> words1 = new LinkedList<>();
                LinkedList<String> words2 = new LinkedList<>();

                try{
                    BufferedReader bufferedReader = new BufferedReader((new FileReader(new File(path + domain + baseId))));
                    String line  = bufferedReader.readLine();
                    int    j     = 0;

                    while (line != null){
                        if ( j == 0 ){
                            words1.add(line);
                            j++;
                        } else {
                            words2.add(line);
                            j = 0;
                        }
                        line = bufferedReader.readLine();
                    }
                } catch ( IOException e ){
                    //e.printStackTrace();
                    System.err.println("Not found file: \"" + path + domain + baseId + "\"!");
                }

                if (words1.size() != 0 && words2.size() != 0){
                    questions.add(new Question(words1,words2));
                }
            }
        }
    }

    @Override
    public Core initialize(Core core) {

        try {
            ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream("resources/data.bin"));
            core = (Core) inputStream.readObject();
        } catch ( IOException e){
            e.printStackTrace();
        } catch ( ClassNotFoundException e) {
            e.printStackTrace();
        }

        loadAllData();
        return core;

    }

    @Override
    public void saveSession(Core core){

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("resources/data.bin"));
            outputStream.writeObject(core);
        } catch ( IOException e){
            e.printStackTrace();
        }
    }

}
