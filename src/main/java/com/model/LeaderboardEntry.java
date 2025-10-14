package com.model;
import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

/**
 * this class represensts a single entry on the leaderboard
 * @author Kelly Sullivan
 */
public class LeaderboardEntry {
    private User user;
    private Duration time;
    private LocalDate date;
    private int hintsUsed;
    private Difficulty difficulty;

    public LeaderboardEntry(UUID userID, Duration time, LocalDate date, 
                            int hintsUsed, Difficulty difficulty) {
        this.time = time;
        this.date = date;
        this.hintsUsed = hintsUsed;
        this.difficulty = difficulty;
        this.user = UserList.getInstance().getUserByUUID(userID);
    }

    public User getUser() {
        return user;
    }

    public Duration getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHintsUsed() {
        return hintsUsed;
    }
    
    public Difficulty getDifficulty() {
        return difficulty;
    }
    

    public String getFormatDuration(){
        String ISO = time.toString();
        Duration time = Duration.parse(ISO);
        long hours = time.toHours();
        long minutes = time.toMinutesPart();
        long seconds = time.toSecondsPart();
        if (hours == 0) {
            return String.format("%02d:%02d", minutes, seconds);
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String toString() {
        return "User: " + user + 
                ", Time: " + getFormatDuration() + 
                ", Date: " + date + 
                ", Hints Used: " + hintsUsed + 
                ", Difficulty: " + difficulty;
    }

}
