package main;

import controller.GameContorller.ObservableTime;
import controller.GameContorller.TimeModelListener;

import java.io.Serializable;

/**
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * Created 04.01.2017
 * Updated --.--.----
 */
public class Timer extends Thread implements Serializable,ObservableTime{

    private long start;
    private float time;

    private TimeModelListener listener;

    public Timer(){
        start = System.currentTimeMillis();
    }

    @Override
    public void run(){

        while (true){
            time = (System.currentTimeMillis() - start) / 1000F;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            modelChanged();
        }

    }

    public float getTime(){
        return time;
    }

    private void modelChanged(){
        if ( listener != null ){
            listener.timeChanged();
        }
    }


    @Override
    public void subscribe(TimeModelListener l) {
        listener = l;
    }

    @Override
    public void unsubscribe(TimeModelListener l) {
        listener = null;
    }
}
