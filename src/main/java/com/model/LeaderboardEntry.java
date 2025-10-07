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

    public LeaderboardEntry(UUID userID, Duration time, LocalDate date) {
        this.time = time;
        this.date = date;
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

}
