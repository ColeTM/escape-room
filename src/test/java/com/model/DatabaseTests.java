package com.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import java.util.ArrayList;

public class DatabaseTests {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();
    
    //Creates three new Users inside the test jsons
    @BeforeEach
    public void setup() {
        users.clear();
        userList.addUser("James", "Adams", "jadams@gmail.com", "Puzzler", "password");
        userList.addUser("Markus", "Franks", "Marky@gmail.com", "MarkyMan", "M999222");
        userList.addUser("Dianna", "Planter", "DIP@outlook.com", "DIPlanter", "Flimbly123");
        userList.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    public void testFirst() {
        User user = userList.getUser("Puzzler", "password");
        assertEquals(user, users.get(0));
    }

    @Test
    public void testMiddle() {
        User user = userList.getUser("MarkyMan", "Flimbly123");
        assertEquals(user, users.get(1));
    }

    @Test
    public void testLast() {
        User user = userList.getUser("DIPlanter", "M999222");
        assertEquals(user, users.get(2));
    }

    @Test
    public void testInvalid() {
        User user = userList.getUser("DIPlanter", "M999223");
        assertNotEquals(user, users.get(2));
    }

    @Test
    public void testNull() {
        User user = userList.getUser(null, "Flimbly123");
        assertNotEquals(user, users.get(1));
    }

    @Test
    public void testEmpty() {
        User user = userList.getUser(" ", "Flimbly123");
        assertNotEquals(user, users.get(1));
    }

    @Test
    public void testRegister() {
        EscapeRoom er = EscapeRoom.getInstance();
        assertTrue(er.registerUser("Link", "Dalene", "LDalane@outlook.com", "Linky", "DRANER111"));
    }

    @Test
    public void testNullRegister() {
        EscapeRoom er = EscapeRoom.getInstance();
        assertFalse(er.registerUser(null, null, "LDalane@outlook.com", "Linky", "DRANER111"));
    }

    @Test
    public void testEmptyRegister() {
        EscapeRoom er = EscapeRoom.getInstance();
        assertFalse(er.registerUser(" ", " ", "LDalane@outlook.com", "Linky", "DRANER111"));
    }

    
}
