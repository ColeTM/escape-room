
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

    public void registerUser() {

    }

    public boolean login(String username, String password) {
        return false;
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
