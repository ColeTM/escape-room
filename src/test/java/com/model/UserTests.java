package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import static org.junit.Assert.assertThrows;
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
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("12345", "Clark", "bobclark@gmail.com", "bobby123", "apassword1"));
        assertEquals(message.getMessage(), "first name must be 1-20 characters and can only contain letters, spaces, hyphens, and apostrophes");
    }

    @Test
    public void validLastName() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("Clark", user.getLastName());
    }

    @Test
    public void invalidLastName() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "12345", "bobclark@gmail.com", "bobby123", "apassword1"));
        assertEquals(message.getMessage(), "last name must be 1-20 characters and can only contain letters, spaces, hyphens, and apostrophes");
    }

    @Test
    public void validEmail() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("bobclark@gmail.com", user.getEmail());
    }

    @Test
    public void invalidEmail() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclarkATgmail.com", "bobby123", "apassword1"));
        assertEquals(message.getMessage(), "invalid email");
    }

    @Test
    public void validUsername() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("bobby123", user.getUsername());
    }

    @Test
    public void invalidUsernameIllegalCharacters() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclark@gmail.com", "{bobby123}", "apassword1"));
        assertEquals(message.getMessage(), "username must be 1-20 characters and can only contain letters, numbers, and underscores");
    }

    @Test
    public void emptyUsername() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclark@gmail.com", "", "apassword1"));
        assertEquals(message.getMessage(), "username must be 1-20 characters and can only contain letters, numbers, and underscores");
    }

    @Test
    public void invalidUsernameTooLong() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclark@gmail.com", "bobbybobbybobbybobbybobbybobbybobby", "apassword1"));
        assertEquals(message.getMessage(), "username must be 1-20 characters and can only contain letters, numbers, and underscores");
    }

    @Test
    public void validPassword() {
        User user = new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "apassword1");
        assertEquals("apassword1", user.getPassword());
    }

    @Test
    public void invalidPasswordTooShort() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "m3"));
        assertEquals(message.getMessage(), "password must be 6-20 characters and include a letter and a number");
    }

    @Test
    public void invalidPasswordTooLong() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "bobbybobbybobbybobbybobbybobby12345"));
        assertEquals(message.getMessage(), "password must be 6-20 characters and include a letter and a number");
    }

    @Test
    public void invalidPasswordNoLetters() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "123456789"));
        assertEquals(message.getMessage(), "password must be 6-20 characters and include a letter and a number");
    }

    @Test
    public void invalidPasswordNoNumbers() {
        IllegalArgumentException message = assertThrows(IllegalArgumentException.class, () -> new User("Bob", "Clark", "bobclark@gmail.com", "bobby123", "abcdefghij"));
        assertEquals(message.getMessage(), "password must be 6-20 characters and include a letter and a number");
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
