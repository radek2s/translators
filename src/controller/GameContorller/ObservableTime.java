package controller.GameContorller;

/**
 * @version 1.2
 * @author Radosław Jajko
 *
 * created 04.01.2017
 * updated --.--.----
 */
public interface ObservableTime {

    void subscribe (TimeModelListener l);

    void unsubscribe (TimeModelListener l);
}
