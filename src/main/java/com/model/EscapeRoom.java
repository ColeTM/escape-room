
/**
 * author: James Efird
 * facade for the escape room
 */
package com.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class EscapeRoom {
    private User user;
    private Character character;
    private Room currentRoom;
    private Puzzle currentPuzzle;
    private Difficulty currentDifficulty;
    private Timer timer;
    private static EscapeRoom escapeRoom;

    private EscapeRoom() {
        user = null;
        currentRoom = null;
        currentPuzzle = null;
        currentDifficulty = Difficulty.Beginner;
        timer = new Timer();
    }

    public static EscapeRoom getInstance() {
        if(escapeRoom == null){
            escapeRoom = new EscapeRoom();
        }

        return escapeRoom;
    }

    public void startNewGame(String characterName) {
        character = new Character(characterName);
        user.addCharacter(character);
        if (user != null) {
            currentRoom = RoomList.getInstance().getRooms().get(0);
        }
        timer.start();
    }

    public void saveCurrentGame() {
        UserList.saveUsers();
    }
 
    // when the user completes the game successfully
    public void endGame() {
        timer.pause();
        LeaderboardEntry stats = new LeaderboardEntry(user.getUsername(), Timer.secondsToDuration(timer.getTimeRemaining()),
                                                        LocalDate.now(), character.getNumHintsUsed(), currentDifficulty);
        if (stats.getTime().compareTo(user.getPersonalRecord().getTime()) < 0)
            user.setPersonalRecord(stats);
        user.upgradeSkillLevel(currentDifficulty);
        UserList.saveUsers();

    }

    public boolean registerUser(String firstName, String lastName, String email, 
                                    String username, String password) {
        return UserList.getInstance().addUser(firstName, lastName, email, username, password);
    }

    public boolean login(String username, String password) {
        User temp = UserList.getInstance().getUser(username, password);
        if (temp == null)
            return false;
        setCurrentUser(temp);
        return true;
    }

    public void logout() {
        timer.pause();
        saveCurrentGame();
        user = null;

    
    }

    public void setDifficulty(Difficulty difficultyLevel) {
        this.currentDifficulty = difficultyLevel;
    }

    public boolean submitPuzzleAnswer(Object solution) {
        return solution.equals(currentPuzzle.getSolution());
    }

    public void requestHint() {
        Hint hint = character.requestHint();
        if (hint != null)
            System.out.println(hint);
        else
            System.out.println("no hint available!");
    }

    public double getTimeRemaining() {
        return timer.getTimeRemaining();
    }

    public void displayLeaderboard() {
        System.out.println(Leaderboard.getInstance().displayGlobal().toString());
    }

    public ArrayList<Character> getCharacters() {
        return user.getCharacters();
    }

    public User getCurrentUser() {
        return user;
    }
    
    public void setCurrentUser(User user) {
        this.user = user;
    }
}
