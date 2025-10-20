package com.model;

import java.util.ArrayList;
import java.util.UUID;


/**
 * an account for the escape room game 
 * *still needs proper documentation*
 * @author coletm
 */
public class User {

    /** UUID for this user */
    private UUID userID;
    /** the user's first name */
    private String firstName;
    /** the user's last name */
    private String lastName;
    /** the email address connected to the user's account */
    private String email;
    /** the user's chosen username */
    private String username;
    /** the password for the user's account */
    private String password;
    /** the player's skill level (Beginner, Intermediate, or Pro) */
    private Difficulty skillLevel;
    /** list of the user's saved in-progress games */
    private ArrayList<Character> characters;
    /** the player's entry on the leaderboard */
    private LeaderboardEntry personalRecord;

    /** 
     * constructor for a new user account when they register
     * @param firstName String -- the user's first name
     * @param lastName String -- the user's last name
     * @param email String -- the email address connected to the account
     * @param username String -- the player's username
     * @param password String -- the account's password
     */
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

    /** 
     * constructor for an existing user account being read from data
     * @param userID UUID -- the UUID linked to the account
     * @param firstName String -- the user's first name
     * @param lastName String -- the user's last name
     * @param email String -- the email address connected to the account
     * @param username String -- the player's username
     * @param password String -- the account's password
     * @param skillLevel Difficulty -- the player's skill level
     * @param characters ArrayList<Character> -- list of the user's saved in-progress games
     * @param personalRecord LeaderboardEntry -- the player's entry on the leaderboard
     */
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

    /**
     * accessor for user's UUID
     * @return UUID -- the user's UUID
     */
    public UUID getUserID() {
        return userID;
    }
    
    /**
     * accessor for the user's username
     * @return String -- the user's username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * mutator for the user's username
     * @param username String -- the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * accessor for the user's password
     * @return String -- the account password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * mutator for the user's password
     * @param password String -- the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    // currently not utilized
    public boolean checkPassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    /**
     * accessor for the user's first name
     * @return String -- the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * mutator for the user's first name
     * @param firstName String -- the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * accessor for the user's last name
     * @return String -- the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * mutator for the user's last name
     * @param lastName String -- the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * accessor for the user's email
     * @return String -- the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * mutator for the user's email
     * @param email String -- the new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * accessor for the user's skill level
     * @return Difficulty -- the user's skill level
     */
    public Difficulty getSkillLevel() {
        return skillLevel;
    }

    /**
     * if the player completes the game at the difficulty matching their current
     * skill level, then their skill level moves up. if already pro, stays at pro
     * @param difficulty Difficulty -- the difficulty level of a completed game
     */
    public void upgradeSkillLevel(Difficulty difficulty) {
        if(difficulty.equals(Difficulty.Beginner) && this.skillLevel.equals(Difficulty.Beginner)) {
            this.skillLevel = Difficulty.Intermediate;
            System.out.println("Your skill level has been upgraded to intermediate!");
        } else if(difficulty.equals(Difficulty.Intermediate) && this.skillLevel.equals(Difficulty.Intermediate)) {
            this.skillLevel = Difficulty.Pro;
            System.out.println("Your skill level has been upgraded to pro!");
        }
    }

    /**
     * accessor for the user's list of saved games
     * @return ArrayList<Character> -- the list of saved games
     */
    public ArrayList<Character> getCharacters() {
        return characters;
    }

    /**
     * adds a character to the user's list of saved characters
     * @param character Character -- the character to be added
     */
    public void addCharacter(Character character) {
        characters.add(character);
    }

    /**
     * accessor for the user's entry on the leaderboard
     * @return LeaderboardEntry -- the player's leaderboard entry
     */
    public LeaderboardEntry getPersonalRecord() {
        return personalRecord;
    }

    /**
     * mutator for the user's entry on the leaderboard
     * @param personalRecord Leaderboard entry -- the new leaderboard entry
     */
    public void setPersonalRecord(LeaderboardEntry personalRecord) {
        this.personalRecord = personalRecord;
    }

    /**
     * method that prints the user's UUID, name, email, username, password, and skill level
     * @return String -- the user's information in a list
     */
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
