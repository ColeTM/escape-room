package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    private final ArrayList<User> testUsers = new ArrayList<>();
    private final ArrayList<Character> testCharacters = new ArrayList<>();

    @Before
    public void setup() {
        LeaderboardEntry personalRecord = null;
        testUsers.add(new User(UUID.fromString("2167fefa-35d6-4525-9754-6d7e1a57f511"), "Shelley", "Brown", "shelleyb@gmail.com", 
                        "shelleyb41", "password!!!", Difficulty.Beginner, testCharacters, personalRecord));
        testCharacters.add(new Character("shell", Difficulty.Beginner));
        testCharacters.add(new Character("katherine", Difficulty.Beginner));
        testCharacters.add(new Character("steve", Difficulty.Beginner));
        for (int i = 0; i < 3; ++i)
            testUsers.get(0).addCharacter(testCharacters.get(i));
    }

    @After
    public void tearDown() {
        testUsers.clear();
        testCharacters.clear();
    }

    // constructor -- User(String firstName, String lastName, String email,
    //                      String username, String password)

    @Test
    public void validFirstName() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("Bob", user.getFirstName());
    }

    @Test
    public void invalidFirstName() {
        User user = new User("12345", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertNotEquals("12345", user.getFirstName());
    }

    @Test
    public void validLastName() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("Clark", user.getLastName());
    }

    @Test
    public void invalidLastName() {
        User user = new User("Bob", "12345", "bobclark@gmail.com", "bobby123", "apassword1");
        assertNotEquals("12345", user.getLastName());
    }

    @Test
    public void validEmail() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("bobclark@gmail.com", user.getEmail());
    }

    @Test
    public void invalidEmail() {
        User user = new User("Bob", "Clark", "bobclarkATgmail.com", "bobby123", "apassword1");
        assertNotEquals("bobclarkATgmail.com", user.getEmail());
    }

    @Test
    public void validUsername() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("bobby123", user.getUsername());
    }

    @Test
    public void invalidUsernameIllegalCharacters() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "{bobby123}", "apassword1");
        assertNotEquals("{bobby123}", user.getUsername());
    }

    @Test
    public void emptyUsername() {
        User user = new User("", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertNotEquals("", user.getUsername());
    }

    @Test
    public void invalidUsernameTooLong() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobbybobbybobbybobbybobbybobbybobby", "apassword1");
        assertNotEquals("bobbybobbybobbybobbybobbybobbybobby", user.getUsername());
    }

    @Test
    public void validPassword() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("apassword1", user.getPassword());
    }

    @Test
    public void invalidPasswordTooShort() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "m3");
        assertNotEquals("m3", user.getPassword());
    }

    @Test
    public void invalidPasswordTooLong() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "bobbybobbybobbybobbybobbybobby12345");
        assertNotEquals("bobbybobbybobbybobbybobbybobby12345", user.getPassword());
    }

    @Test
    public void invalidPasswordNoLetters() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "123456789");
        assertNotEquals("123456789", user.getPassword());
    }

    @Test
    public void invalidPasswordNoNumbers() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "abcdefghij");
        assertNotEquals("abcdefghij", user.getPassword());
    }
    

    // upgradeSkillLevel(Difficulty skillLevel)

    @Test
    public void updgradeSkillLevelBeginner() {
        testUsers.get(0).upgradeSkillLevel(Difficulty.Beginner);
        assertEquals(testUsers.get(0).getSkillLevel(), Difficulty.Intermediate);
    }

    @Test
    public void upgradeSkillLevelIntermediate() {
        testUsers.get(0).upgradeSkillLevel(Difficulty.Beginner);
        testUsers.get(0).upgradeSkillLevel(Difficulty.Intermediate);
        assertEquals(testUsers.get(0).getSkillLevel(), Difficulty.Pro);
    }

    @Test
    public void upgradeSkillLevelPro() {
        testUsers.get(0).upgradeSkillLevel(Difficulty.Beginner);
        testUsers.get(0).upgradeSkillLevel(Difficulty.Intermediate);
        testUsers.get(0).upgradeSkillLevel(Difficulty.Pro);
        assertEquals(testUsers.get(0).getSkillLevel(), Difficulty.Pro);
    }

    @Test
    public void dontUpgradeSkillLevelIntermediate() {
        testUsers.get(0).upgradeSkillLevel(Difficulty.Beginner);
        testUsers.get(0).upgradeSkillLevel(Difficulty.Beginner);
        assertEquals(testUsers.get(0).getSkillLevel(), Difficulty.Intermediate);
    }

    @Test
    public void dontUpgradeSkillLevelPro() {
        testUsers.get(0).upgradeSkillLevel(Difficulty.Beginner);
        testUsers.get(0).upgradeSkillLevel(Difficulty.Intermediate);
        testUsers.get(0).upgradeSkillLevel(Difficulty.Beginner);
        testUsers.get(0).upgradeSkillLevel(Difficulty.Intermediate);
        assertEquals(testUsers.get(0).getSkillLevel(), Difficulty.Pro);
    }


    // getCharacter(String name)

    @Test
    public void getFirstCharacterInList() {
        assertEquals(testCharacters.get(0), testUsers.get(0).getCharacter("shell"));
    }

    @Test
    public void getCharacterInList() {
        assertEquals(testCharacters.get(1), testUsers.get(0).getCharacter("katherine"));
    }

    @Test
    public void getLastCharacterInList() {
        assertEquals(testCharacters.get(2), testUsers.get(0).getCharacter("steve"));
    }

    @Test
    public void getCharacterNotCaseSensitive() {
        assertEquals(testCharacters.get(1), testUsers.get(0).getCharacter("Katherine"));
    }

    @Test
    public void getCharacterNotInList() {
        assertTrue(testUsers.get(0).getCharacter("fake") == null);
    }


    // addCharacter(Character character)

    @Test
    public void addValidCharacter() {
        Character ch = new Character("Helen", Difficulty.Beginner);
        testUsers.get(0).addCharacter(ch);
        assertEquals(ch, testUsers.get(0).getCharacter("Helen"));
    }
    
}
