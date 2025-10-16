
/**
 * author: James Efird
 * facade for the escape room
 */
package com.model;

import java.util.ArrayList;

public class EscapeRoom {
    private User user;
    private Room currentRoom;
    private Puzzle currentPuzzle;
    private Difficulty currentDifficulty;
    private String currentAnswer;
    private int totalHints;
    private Timer timer;

    public EscapeRoom() {
        
    }

    public void startNewGame() {

    }

    public void saveCurrentGame() {

    }

    public void endGame() {

    }

    public boolean registerUser(String firstName, String lastName, String email, 
                                    String username, String password) {
        User user = new User(firstName, lastName, email, username, password);
        if(UserList.getInstance().getUser(username, password) != null) {
            return false;
        }
        UserList.getInstance().addUser(user);
        return true;

    }

    public boolean login(String username, String password) {
        User temp = UserList.getInstance().getUser(username, password);
        return temp != null;
    }

    public void logout() {

    }

    public void setDifficulty(Difficulty difficultyLevel) {
        
    }

    public boolean submitPuzzleAnswer(String answer) {
        return false;
    }

    public Hint requestHint() {
        return null;
    }

    public int getTotalHintsUsed() {
        return totalHints;
    }

    public double getTimeRemaining() {
        return timer.getTimeRemaining();
    }

    public ArrayList<LeaderboardEntry> getPersonalLeaderboard() {
        return null;
    }

    public ArrayList<LeaderboardEntry> getGlobalLeaderboard() {
        return null;
    }
    
}
