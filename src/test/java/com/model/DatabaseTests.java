package com.model;

import org.junit.Test;
import static org.junit.Assert.*;
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
}
