package com.model;
import java.time.Duration;
import java.time.LocalDate;

/**
 * this class represensts a single entry on the leaderboard
 * @author Kelly Sullivan
 */
public class LeaderboardEntry {
    /**
     * attributes 
     * username- the user's username in the entry
     * time - time time taken to complete the game
     * date - the date of the entry
     * hintsUsed - the number of hints used in that entry
     * difficulty - the difficulty level of that entry
     * score - the score for the entry
     */
    private String username;
    private Duration time;
    private LocalDate date;
    private int hintsUsed;
    private Difficulty difficulty;
    private double score;

    /**
     * constructor for a leaderboard entry
     * @param username - the user's username in the entry
     * @param time - time time taken to complete the game
     * @param date - the date of the entry
     * @param hintsUsed - the number of hints used in that entry
     * @param difficulty - the difficulty level of that entry
     */
    public LeaderboardEntry(String username, Duration time, LocalDate date, 
                            int hintsUsed, Difficulty difficulty, double score) {
        this.time = time;
        this.date = date;
        this.hintsUsed = hintsUsed;
        this.difficulty = difficulty;
        this.username = username;
        this.score = score;
    }

    /**
     * getter for the username
     * @return string username
     */
    public String getUsername() {
        return username;
    }

    /**
     * getter for time
     * @return duration of time
     */
    public Duration getTime() {
        return time;
    }

    /**
     * getter for date
     * @return localdate date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * getter for hints used
     * @return int hints used
     */
    public int getHintsUsed() {
        return hintsUsed;
    }
    
    /**
     * getter for diffuculty
     * @return Difficulty difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * accessor for score
     * @return double - the score
     */
    public double getScore() {
        return score;
    }

    /**
     * method to convert duration in IS08601 format to readable hh:mm:ss format
     * @return time in string hh:mm:ss format
     */
    public String getFormatDuration(){
        long hours = time.toHours();
        long minutes = time.toMinutesPart();
        long seconds = time.toSecondsPart();
        if (hours == 0) {
            return String.format("%02d:%02d", minutes, seconds);
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /**
     * toString method for leaderboard entry
     * @return string of entry
     */
    public String toString() {
        return username + ": " + score +
                "\nTime: " + getFormatDuration() + 
                ", Date: " + date + 
                ", Hints Used: " + hintsUsed + 
                ", Difficulty: " + difficulty;
    }

}
