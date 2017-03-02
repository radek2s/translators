package main;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static java.util.Comparator.comparing;

/**
 * Scores Tab class
 * Collects data from the best score attacks
 *
 * @version 2.0
 * @author Radosław Jajko
 *
 * Created 02.03.2017
 */

public class ScoresTab implements Serializable {
    
    private ArrayList<Record> records;

    public ScoresTab(){
        records = new ArrayList<>();
    }

    public void addRecord(int score, String username){
        records.add(new Record(score,username));
        Collections.sort(records);

        while (records.size()>10){
            records.remove(records.size());
        }
    }

    public String printRecord(int i){
        try {
            return records.get(i).toString();
        } catch (IndexOutOfBoundsException e){
            return "";
        }

    }

    private class Record implements Serializable, Comparable<Record>{
        
        private Date    date;
        private int     score;
        private String  username;
        private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        
        Record(int score, String username){
            this.date = new Date();
            this.score = score;
            this.username = username;
        }
        private int getScore(){
            return score;
        }

        @Override
        public String toString(){
            return dateFormat.format(date)+ "    " + score + "  -   " + username;
        }

        @Override
        public int compareTo(Record o) {
            return (o.getScore()- score);
        }
    }
    
}
