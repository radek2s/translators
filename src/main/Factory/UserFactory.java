package main.Factory;

import main.User;

/**
 * User Factory class
 * Used to make project more in user-customer kind
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * Created 04.01.2017
 * Updated --.--.----
 */
public class UserFactory {

    public static User createUser (String username){
        if ( !username.isEmpty() && username.length() < 36){
            return new User(username);
        } else {
            return null;
        }
    }

}
