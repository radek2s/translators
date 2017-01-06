package controller.GameContorller;

/**
 * Interface to monitor changes in Timer class
 * when something has changed inside object
 * make some changes when timeChanged()
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * created 04.01.2017
 * updated --.--.----
 */
public interface TimeModelListener {

    void timeChanged();
}
