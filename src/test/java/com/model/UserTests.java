package com.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class UserTests {

    private final ArrayList<User> testUsers = new ArrayList<>();
    private final ArrayList<Character> testCharacters = new ArrayList<>();

    @Before
    public void setup() {
        LeaderboardEntry personalRecord = null;
        testUsers.add(new User(UUID.fromString("2167fefa-35d6-4525-9754-6d7e1a57f511"), "Shelley", "Brown", "shelleyb@gmail.com", 
                        "shelleyb41", "password!!!", Difficulty.Beginner, testCharacters, personalRecord));
        testCharacters.add(new Character("shell", Difficulty.Beginner));
        testUsers.get(0).addCharacter(testCharacters.get(0));
        
    }

    @After
    public void tearDown() {
        testUsers.clear();
    }

    // new constructor -- User(String firstName, String lastName, String email,
                        //      String username, String password)

    // saved constructor -- public User(UUID userID, String firstName, String lastName, String email, 
                        //          String username, String password, Difficulty skillLevel, 
                        //          ArrayList<Character> characters, LeaderboardEntry personalRecord)


    // checkPassword() -- might not have been used, i need to check
    
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
    public void getCharacterInList() {
        assertEquals(testCharacters.get(0), testUsers.get(0).getCharacter("shell"));
    }

    @Test
    public void getCharacterNotInList() {
        assertTrue(testUsers.get(0).getCharacter("fake") == null);

    }

    // addCharacter(Character character)
    
}
