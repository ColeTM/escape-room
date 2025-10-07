package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * this class represents a puzzle in the escape room
 * @author ndmcginnis21
 */

public abstract class Puzzle
{
    private UUID puzzleID;
    private Difficulty difficulty;
    private int attempts;
    private Clue clue;
    private ArrayList<Hint> hints;
    private HashMap<UUID, Boolean> hintsUsed;
    private boolean isSequential;
    private boolean isCompleted;

    //Constructor for creating a new Puzzle
    public Puzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                  ArrayList<Hint> hints, HashMap<UUID, Boolean> hintsUsed, boolean isSequential)
    {
        this.puzzleID = puzzleID;
        this.difficulty = difficulty;
        this.attempts = attempts;
        this.clue = clue;
        this.hints = hints;
        this.hintsUsed = hintsUsed;
        this.isSequential = isSequential;
        this.isCompleted = false;
    }

    public void reset()
    {
        this.isCompleted = false;
    }

    public boolean isCompleted()
    {
        return this.isCompleted;
    }

    public void addAttempt()
    {
        this.attempts++;
    }

    public abstract boolean solve(Object answer);

    public String toString()
    {
        return "Puzzle ID: " + puzzleID + " (Difficulty: " + difficulty + ", Completed: " + isCompleted + ")";
    }

}