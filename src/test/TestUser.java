package test;

import main.Factory.UserFactory;
import main.User;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * JUnit tests for UserClass
 *
 * @version 1.2
 * @author Radosław Jajko
 *
 * Created 06.01.2017
 * Updated --.--.----
 */

public class TestUser {

    private User testUser = UserFactory.createUser("Test");

    @Test
    public void userValueInputTest(){

        //Input Values
        Date testDate   = new Date();
        testUser.setLastScore(10);
        testUser.getLevel().setScore(testUser.getLastScore());
        testUser.setLastActive(testDate);

        //Validate saved data
        assertEquals("Test",testUser.getUsername());
        assertEquals(10, testUser.getLastScore());
        assertEquals(testDate, testUser.getLastActive());
        assertEquals("Beginner", testUser.getLevel().getCurrentLevel());

    }

    @Test
    public void createNewUserTest(){

        //Try to create new user and save as test user
        testUser = UserFactory.createUser("Tester");

        //Try to read username
        if (testUser != null) {
            assertEquals("Tester",testUser.getUsername());
        } else {
            fail();
        }

    }

    @Test
    public void createNewUserInvalidDataTest(){

        //Try to create user with empty username
        testUser = UserFactory.createUser("");

        assertNull(testUser);

        //Try to create user with too long username
        testUser = UserFactory.createUser("1234567890qwertyuiopasdfghjklzxcvbnm1qaz2wsx3edc4rfv5tgb6yhn7ujm8ik9ol0p");

        assertNull(testUser);

    }

}
