
package com.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * author: James Efird
 * facade for the escape room
 */
public class EscapeRoom {
    private User user;
    private UserList userList = UserList.getInstance();
    private Character character;
    private Room currentRoom;
    private Puzzle currentPuzzle;
    private Difficulty currentDifficulty;
    private Timer timer;
    private static EscapeRoom escapeRoom;

    /** 
     * Private constructor for singleton pattern
     */
    private EscapeRoom() {
        user = null;
        userList.getUsers();
        currentRoom = null;
        currentPuzzle = null;
        currentDifficulty = Difficulty.Beginner;
        timer = new Timer();
    }

    /**
     * Gets and returns the singleton instance of EscapeRoom
     * @return The singleton instance of EscapeRoom
     */
    public static EscapeRoom getInstance() {
        if(escapeRoom == null){
            escapeRoom = new EscapeRoom();
        }
        return escapeRoom;
    }

    /**
     * Starts a new game for the current user with the specified character 
     * @param characterName The name of the character to be used in the game  
     * @return boolean -- whether a new save was successfully created  
     */
    public boolean startNewGame(String characterName) {
        if(user.getCharacter(characterName) != null) {
            System.out.println("You've already used this character name!");
            return false;
        }
        character = new Character(characterName, currentDifficulty);
        user.addCharacter(character);
        
        /*String intro = "You are trick-or-treating on Halloween when you pass by a house you don't recognize. \n"
                           + "When you enter the house, the door closes behind you; you're trapped! \n"
                           + "Solve the puzzles in each of the 4 open rooms to unlock the room at the end of the hallway. \n"
                           + "Solve the final challenge to leave! \n"
                           + "You have 30 minutes to escape this house of horrors before your soul is stuck here FOREVER!!! \n";
        System.out.println(intro);
        Speech.speak(intro);*/
        timer.start();
        currentRoom = RoomList.getInstance().getRoomByUUID(UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85"));
        return true;
    }

    /**
     * sets the current character to passed character
     * @param characterName String -- name of the character to play
     * @return boolean -- true if the character was set successfully
     */
    public boolean resumeGame(String characterName) {
        if (user.getCharacter(characterName) == null) {
            return false;
        }
        character = user.getCharacter(characterName);
        currentRoom = RoomList.getRoomByUUID(character.getCurrentRoom());
        currentDifficulty = character.getDifficulty();
        timer = character.getTimer();
        timer.resume();
        return true;
    }

    /**
     * Saves the current game state for the user
     */
    public void saveCurrentGame() {
        userList.saveUsers();
    }
 
    /**
     * When a player wins, this method ends the game, updates the user's record, and
     * creates a text file containing a certificate of completion for the player
     */
    public void endGame() {
        //timer.pause();
        if(user.getPersonalRecord() != null) {
            if (character.calculateScore(currentDifficulty) > user.getPersonalRecord().getScore())
        user.setPersonalRecord(new LeaderboardEntry(user.getUsername(), Timer.secondsToDuration(timer.getTimeRemaining()), 
                                                        LocalDate.now(), character.getNumHintsUsed(), currentDifficulty,
                                                        character.calculateScore(currentDifficulty)));
        }else {
            user.setPersonalRecord(new LeaderboardEntry(user.getUsername(), Timer.secondsToDuration(timer.getTimeRemaining()), 
                                                        LocalDate.now(), character.getNumHintsUsed(), currentDifficulty,
                                                        character.calculateScore(currentDifficulty)));
        }
        user.upgradeSkillLevel(currentDifficulty);
        userList.saveUsers();
        character.certificateOfCompletion(currentDifficulty);
        displayLeaderboard();
    }

    /**
     * Registers a new user with the provided information
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param email The email of the user
     * @param username The username of the user
     * @param password The password of the user
     * @return True if the user was successfully registered, false otherwise
     */
    public boolean registerUser(String firstName, String lastName, String email, 
                                    String username, String password) {
        user = UserList.getInstance().getUser(username, password);
        return UserList.getInstance().addUser(firstName, lastName, email, username, password);
    }

    /**
     * Logs in a user with the provided username and password
     * @param username The username of the user 
     * @param password The password of the user
     * @return True if the user was successfully logged in, false otherwise
     */
    public boolean login(String username, String password) {
        User temp = UserList.getInstance().getUser(username, password);
        if (temp == null)
            return false;
        setCurrentUser(temp);
        return true;
    }

    /**
     * Logs out the current user
     * @return boolean -- whether the logout was successful
     */
    public boolean logout() {
        saveCurrentGame();
        user = null;
        currentRoom = null;
        currentPuzzle = null;
        
        return user == null;
    }

    /**
     * Sets the current difficulty level for the game
     * @param difficultyLevel The difficulty level to be set
     */
    public void setDifficulty(Difficulty difficultyLevel) {
        this.currentDifficulty = difficultyLevel;
    }

    /**
     * Submits an answer for the current puzzle
     * @param solution The solution to be submitted
     * @return True if the answer is correct, false otherwise
     */
    public boolean submitPuzzleAnswer(Object solution) {
        return solution.equals(currentPuzzle.getSolution());
    }

    /**
     * Requests a hint for the current puzzle
     */
    public void requestHint() {
        character.requestHint();
    }

    /**
     * Gets and returns the time remaining in the game
     * @return The time remaining in the game
     */
    public double getTimeRemaining() {
        return timer.getTimeRemaining();
    }

    /**
     * Displays the global leaderboard
     */
    public void displayLeaderboard() {
        System.out.println(Leaderboard.getInstance().displayGlobal().toString());
    }

    /**
     * Gets and returns the current user
     * @return The current user
     */
    public User getCurrentUser() {
        return user;
    }
    
    /**
     * Sets the current user
     * @param user The user to be set as the current user
     */
    public void setCurrentUser(User user) {
        this.user = user;
    }

    /**
     * prints out what percentage of the game a player has completed,
     * which puzzles they have completed, and which hints they have used
     */
    public void showProgress() {
        System.out.println("Game progress: " + character.getPercentage() + "%\n");
        System.out.println(character.questionsAnswered());
        System.out.println(character.hintsUsed());
    }

    /**
     * mutator for the current room. also calls mutator for character class
     * @param roomID UUID - the room's UUID
     */
    public void setRoom(UUID roomID) {
        currentRoom = RoomList.getRoomByUUID(roomID);
        character.setCurrentRoom(roomID);
        System.out.println(currentRoom.getStory());
    }

    public void setCurrentPuzzle(Puzzle puzzle){
        currentPuzzle = puzzle;
    }
}
