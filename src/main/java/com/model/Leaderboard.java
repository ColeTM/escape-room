package com.model;

import java.util.ArrayList;

/**
 * This class represents the leaderboard for the game
 * @author Kelly Sullivan
 */
public class Leaderboard {
    private ArrayList<LeaderboardEntry> globalEntries;
    private ArrayList<LeaderboardEntry> personalEntries;
    private static Leaderboard leaderboard;

    public ArrayList<LeaderboardEntry> displayGlobal() {
        return globalEntries;
    }

    public Leaderboard() {
        this.globalEntries = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if(leaderboard == null){
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    public ArrayList<LeaderboardEntry> displayUser(User user){
        this.personalEntries = new ArrayList<>();
        for(LeaderboardEntry entry : globalEntries){
            if(entry.getUser() == user){
                personalEntries.add(entry);
            }
        }
        return personalEntries;
    }

    public void addEntry(LeaderboardEntry entry){
        globalEntries.add(entry);
    }
    public void sortEntries(){
        
    }
}
