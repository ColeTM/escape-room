package com.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * This class represents the leaderboard for the game
 * @author Kelly Sullivan
 */
public class Leaderboard {
    /**
     * attributes
     * globalEntries- an array list of all entries in the leaderboard
     * leaderboard- singleton instnace of leaderboard
     */
    private ArrayList<LeaderboardEntry> globalEntries;
    private static Leaderboard leaderboard;

    /**
     * constructor for leaderboard
     */
    public Leaderboard() {
        this.globalEntries = new ArrayList<>();
    }

    /**
     * getter for leaderboard singleton instance
     * @returns instance of leaderboard
     */
    public static Leaderboard getInstance() {
        if(leaderboard == null){
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    /**
     * getter for leadeboard
     * @return array list of leaderboard entries
     */
    public ArrayList<LeaderboardEntry> displayGlobal() {
        return globalEntries;
    }

    /**
     * method to add an entry to the leaderboard
     * @param entry to be added
     */
    public void addEntry(LeaderboardEntry entry){
        globalEntries.add(entry);
        sortEntries();
    }

    /**
     * method to sort the entires in the leaderboard
     */
    public void sortEntries(){
        Collections.sort(globalEntries, Comparator.comparing(LeaderboardEntry::getTime));
    }
    
    /**
     * tostring method to display the leaderboard as a string
     * @return string representation of leaderboard
     */
    public String toString() {
        StringBuilder leader = new StringBuilder();
        for (LeaderboardEntry entry : globalEntries) {
            leader.append(entry.toString()).append("|n");
        }
        return "Leaderboard:\n" + leader.toString();
    }
}
