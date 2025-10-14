package com.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 * This class represents the leaderboard for the game
 * @author Kelly Sullivan
 */
public class Leaderboard {
    private ArrayList<LeaderboardEntry> globalEntries;
    private static Leaderboard leaderboard;

    public Leaderboard() {
        this.globalEntries = new ArrayList<>();
    }

    public static Leaderboard getInstance() {
        if(leaderboard == null){
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }
    public ArrayList<LeaderboardEntry> displayGlobal() {
        return globalEntries;
    }

    public void addEntry(LeaderboardEntry entry){
        globalEntries.add(entry);
        sortEntries();
    }

    public void sortEntries(){
        Collections.sort(globalEntries, Comparator.comparing(LeaderboardEntry::getTime));
    }
    
    public String toString(ArrayList<Leaderboard> entries) {
        StringBuilder leader = new StringBuilder();
        for (Leaderboard entry : entries) {
            leader.append(entry.toString()).append("|n");
        }
        return "Leaderboard:\n" + leader.toString();
    }
}
