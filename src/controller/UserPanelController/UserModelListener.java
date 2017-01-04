package controller.UserPanelController;

/**
 * Interface to monitor changes in User class
 * when something has changed inside object
 * make some changes when userChanged()
 *
 * @version 1.1
 * @author Radosław Jajko
 *
 * created 04.01.2017
 * updated --.--.----
 */
public interface UserModelListener {

    void userChanged();

}
