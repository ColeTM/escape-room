package com.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class UserListTests {

    private UserList userList;

    @BeforeEach
    public void setup(){
        userList = UserList.getInstance();
    }

    @AfterEach
    public void tearDown() {
        userList = null;
    }

    @Test
    public void testSingletonInstance() {
        assertNotNull(userList);
        assertSame(userList, UserList.getInstance());
    }

    @Test
    public void testAddUserSuccessfully() {
        boolean added = userList.addUser("John", "Doe", "john@example.com", "jjohnny101", "password1");
        assertTrue(added);
    }

    @Test
    public void testAddUserandUsernameTakenSuccessfully() {
        boolean added = userList.addUser("John", "Doe", "john@example.com", "johnny101", "password1");
        assertTrue(added);
        assertTrue(userList.usernameTaken("johnny101"));
    }

    @Test
    public void testAddDifferentUsernameSameOthersSuccessfully() {
        userList.addUser("John", "Doe", "john@example.com", "johnny101", "password1");
        boolean result = userList.addUser("John", "Doe", "john@example.com", "johnnyjohn", "password1");
        assertTrue(result);
    }

    @Test
    public void testAddDuplicateUsernameFails() {
        userList.addUser("John", "Doe", "john@example.com", "johnny", "secret1");
        boolean result = userList.addUser("Jane", "Doe", "jane@example.com", "johnny", "password");
        assertFalse(result);
    }

    //null username should fail
    @Test
    public void testNullUsernameFails() {
        boolean result =userList.addUser("John", "Doe", "john@example.com", null, "password1");
        assertFalse(result);
    }

    //null name should fail
    @Test
    public void testNullFirstNameLastNameFails() {
        boolean result =userList.addUser(null, null, "john@example.com", "johnny", "password1");
        assertFalse(result);
    }

    //null password should fail
    @Test
    public void testNullPasswordFails() {
        boolean result =userList.addUser("John", "Doe", "john@example.com", "johnny", null);
        assertFalse(result);
        
    }

    //null email should fail
    @Test
    public void testNullEmailFails() {
        boolean result =userList.addUser("John", "Doe", null, "johnny", "password");
        assertFalse(result);
    }

    @Test
    public void testGetUserByUsernameAndPassword() {
        userList.addUser("Sam", "Rogers", "sam@example.com", "samr", "mypassword1");
        User found = userList.getUser("samr", "mypassword1");
        assertNotNull(found);
        assertEquals("samr", found.getUsername());
    }

    @Test
    public void testGetUserByNullUsernameAndPassword() {
        userList.addUser("Sam", "Rogers", "sam@example.com", "samr", "mypassword1");
        User found = userList.getUser(null, "mypassword1");
        assertNull(found);
    }

    @Test
    public void testGetUserByUsernameAndNullPassword() {
        userList.addUser("Sam", "Rogers", "sam@example.com", "samr", "mypassword1");
        User found = userList.getUser("samr", null);
        assertNull(found);
    }

    @Test
    public void testGetUserByUsernameAndPasswordCaseSensitive() {
        userList.addUser("Sam", "Rogers", "sam@example.com", "samr", "myPassword1");
        User found = userList.getUser("samr", "mypassword1");
        assertNull(found);
    }

    @Test
    public void testGetUserByUUID() {
        userList.addUser("Alex", "Turner", "alex@example.com", "alext", "beatles8");
        User u = userList.getUser("alext", "beatles");
        User found = userList.getUserByUUID(u.getUserID());
        assertEquals(u, found);
    }

    @Test
    public void testUsernameTakenIsCaseInsensitive() {
        userList.addUser("Mia", "Jones", "mia@example.com", "MIAJ", "abcdef1");
        assertTrue(userList.usernameTaken("miaj"));
    }

    @Test
    public void testGetUsersReturnsList() {
        assertNotNull(userList.getUsers());
        assertTrue(userList.getUsers() instanceof ArrayList);
    }
}
