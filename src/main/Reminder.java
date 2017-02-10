package main;

import gui.MainFrame;

/**
 * Class which extends the main application with the remind option
 * it makes the main frame invisible than after duration it becomes
 * visible again.
 * @version 1.3
 * @author Radosław Jajko
 *
 * Created 10.02.2017
 * Updated --.--.----
 */
public class Reminder extends Thread {

    private long start;
    private long duration;

    public Reminder(){
        start = System.currentTimeMillis();
        duration = MainFrame.getCore().getReminderTime()*60000; //To count as minutes
    }

    @Override
    public void run(){

        if(MainFrame.getMainFrame().isVisible()){
            MainFrame.getMainFrame().setVisible(false);
        }
        while ( System.currentTimeMillis() - start < duration ){
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MainFrame.getMainFrame().setVisible(true);
        interrupt();
    }
}
