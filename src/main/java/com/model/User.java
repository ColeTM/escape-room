package com.model;

import java.util.ArrayList;
import java.util.UUID;


/**
 * an account for the escape room game 
 * *still needs proper documentation*
 * @author coletm
 */
public class User {

    private UUID userID;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Difficulty skillLevel;
    private ArrayList<Character> characters;
    private LeaderboardEntry personalRecord;

    // constructor for a new user with default values
    public User(String firstName, String lastName, String email,
                String username, String password) {
        
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.skillLevel = Difficulty.Beginner;
        this.characters = new ArrayList<>();
    }

    // constructor for an existing character being read from data
    public User(UUID userID, String firstName, String lastName, String email, 
                String username, String password, Difficulty skillLevel, 
                ArrayList<Character> characters, LeaderboardEntry personalRecord) {
        
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.skillLevel = skillLevel;
        this.characters = characters;
        this.personalRecord = personalRecord;
    }

    public boolean checkPassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    public UUID getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Difficulty getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Difficulty skillLevel) {
        this.skillLevel = skillLevel;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public LeaderboardEntry getPersonalRecord() {
        return personalRecord;
    }

    public void setPersonalRecord(LeaderboardEntry personalRecord) {
        this.personalRecord = personalRecord;
    }

    @Override
    public String toString() {
        return "ID: " + userID.toString() +
                "\nName: " + firstName + " " + lastName +
                "\nEmail: " + email +
                "\nUsername: " + username +
                "\nPassword: " + password +
                "\nSkill Level: " + skillLevel;
    }

}
