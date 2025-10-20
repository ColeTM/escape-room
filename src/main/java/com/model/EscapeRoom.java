
/**
 * author: James Efird
 * facade for the escape room
 */
package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class EscapeRoom {
    private User user;
    private Room currentRoom;
    private Puzzle currentPuzzle;
    private Difficulty currentDifficulty;
    private String currentAnswer;
    private int totalHints;
    private Timer timer;

    public EscapeRoom() {
        user = null;
        currentRoom = null;
        currentPuzzle= null;
        currentDifficulty = Difficulty.Beginner;
        currentAnswer = "";
        totalHints = 0;
        timer = new Timer();
    }

    public void startNewGame() {
        if (user != null) {
            currentRoom = RoomList.getInstance().getRooms().get(0);
            currentPuzzle = currentRoom.getPuzzles().get(0);
        }
    }

    public void saveCurrentGame() {
        UserList.saveUsers();
    }

    // needs rewriting using UserList
    public void endGame() {
        DataWriter.saveRooms();
        DataWriter.saveUsers();

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
        timer.pause();
        saveCurrentGame();
        user = null;

    
    }

    public void setDifficulty(Difficulty difficultyLevel) {
        this.currentDifficulty = difficultyLevel;
    }

    public boolean moveRoom(UUID roomID) {
        return false;
    }

    public boolean submitPuzzleAnswer(Object solution) {
        return solution.equals(currentPuzzle.getSolution());
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

    public void displayLeaderboard() {
        System.out.println(Leaderboard.getInstance().displayGlobal().toString());
    }
    
}
