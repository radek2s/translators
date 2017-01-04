package controller.UserPanelController;

/**
 * @version 1.1
 * @author Radosław Jajko
 *
 * created 04.01.2017
 * updated --.--.----
 */
public interface Observable {

    void subscribe ( UserModelListener l );

    void unsubscribe ( UserModelListener l);

}
