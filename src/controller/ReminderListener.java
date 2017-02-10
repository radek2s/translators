package controller;

import main.Reminder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @version 1.3
 * @author Radosław Jajko
 *
 * Created 10.02.2017
 * Updated --.--.----
 */
public class ReminderListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        Reminder r = new Reminder();
        r.start();
    }
}
