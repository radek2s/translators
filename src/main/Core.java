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
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 21.12.2016
 * Updated 29.12.2016
 */
public class Core implements ICore, Serializable{

    private int duration = 5;
    private User activeUser = new User("Test");
    private LinkedList<Question> questions = new LinkedList<>();
    private LinkedList<User> users = new LinkedList<>();
    private ArrayList<Integer> order = new ArrayList<>();

    public LinkedList<User> getUsers() {
        return users;
    }

    public void addUsers(String username) {
        this.users.add(new User(username));
    }

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

    public ArrayList getOrder(){
        return order;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return duration;
    }

    public User getActiveUser (){
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public String getQuestion ( int i ) {
        return questions.get(i).getWord1();
    }

    public String getAnswer ( int i) {
        return questions.get(i).getWord2();
    }

    public LinkedList<Question> getQuestions(){
        return questions;
    }

    @Override
    public boolean checkAnswer(int i, String input ){
        return questions.get(i).isCorrect(input);
    }

    @Override
    public void loadData(String pathToFile){

        String path ="resources/database/"+pathToFile+".txt";
        if (questions.size() != 0){
            questions.clear();
        }
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String line = bufferedReader.readLine();
            String line1 = null;
            String line2;
            int i=0;

            while (line != null){
                if (i == 0){
                    line1 = line;
                    i++;
                } else {
                    line2 = line;
                    i=0;
                    questions.add(new Question(line1,line2));
                }
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
