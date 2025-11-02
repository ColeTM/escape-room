package com.model;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class HintTests {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();

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
    public void testText() {
        Hint h = new Hint(UUID.randomUUID(),"test",false,null,HintLevel.Direct);
        assertEquals("test", h.getText());
    }

    @Test
    public void testPicture() {
        Hint h = new Hint(UUID.randomUUID(),"test",false,null,HintLevel.Direct);
        assertEquals(null,h.getPicture());
    }

    @Test
    public void testToString() {
        Hint h = new Hint(UUID.randomUUID(),"test",false,null,HintLevel.Direct);
        assertEquals("Hint: test (Level: Direct)", h.toString());
    }

    @Test
    public void testNullText() {
        Hint h = new Hint(UUID.randomUUID(),null,false,null,HintLevel.Direct);
        assertNotEquals(null,h.getText());
    }

    @Test
    public void testEmptyText() {
        Hint h = new Hint(UUID.randomUUID()," ",false,null,HintLevel.Direct);
        assertNotEquals(" ",h.getText());
    }
}
