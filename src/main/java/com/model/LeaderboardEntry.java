package com.model;
import java.time.Duration;
import java.time.LocalDate;

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

    public LeaderboardEntry(String username, Duration time, LocalDate date) {
      
    }
}
