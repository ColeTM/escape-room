package com.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;


public class UserListTests {

    private UserList userList;
    private final String testUserFile = "src/test/resources/testUsers.json";

    @BeforeEach
    public void setup(){
       
        userList = UserList.getInstance();
    }

    @AfterEach
    public void tearDown() {
        userList = null;
    }

    @Test
    public void testSingletonInstanceNotNull() {
        assertNotNull(userList);
        assertSame(userList, UserList.getInstance());
    }

    @Test
    public void testAddUserSuccessfully() {
        boolean added = userList.addUser("John", "Doe", "john@example.com", "johnny", "secret");
        assertTrue(added);
        assertTrue(userList.usernameTaken("johnny"));
    }

    @Test
    public void testAddDuplicateUsernameFails() {
        userList.addUser("John", "Doe", "john@example.com", "johnny", "secret");
        boolean result = userList.addUser("Jane", "Doe", "jane@example.com", "johnny", "password");
        assertFalse(result);
    }

    @Test
    public void testGetUserByUsernameAndPassword() {
        userList.addUser("Sam", "Rogers", "sam@example.com", "samr", "mypassword");
        User found = userList.getUser("samr", "mypassword");
        assertNotNull(found);
        assertEquals("samr", found.getUsername());
    }

    @Test
    public void testGetUserByUUID() {
        userList.addUser("Alex", "Turner", "alex@example.com", "alext", "beatles");
        User u = userList.getUser("alext", "beatles");
        User found = userList.getUserByUUID(u.getUserID());
        assertEquals(u, found);
    }

    @Test
    public void testUsernameTakenIsCaseInsensitive() {
        userList.addUser("Mia", "Jones", "mia@example.com", "MIAJ", "abc");
        assertTrue(userList.usernameTaken("miaj"));
    }

    @Test
    public void testSaveUsersCreatesJSONFile() {
        userList.addUser("Charlie", "Brown", "charlie@example.com", "charlieb", "peanuts");
        userList.saveUsers();

        File file = new File(testUserFile);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    public void testGetUsersReturnsList() {
        assertNotNull(userList.getUsers());
        assertTrue(userList.getUsers() instanceof ArrayList);
    }
}
