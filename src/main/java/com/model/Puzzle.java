package com.model;

import java.util.ArrayList;
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
    private boolean isSequential;
    private boolean isCompleted;
    protected Type type;

    //Constructor for creating a new Puzzle
    public Puzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                  ArrayList<Hint> hints, boolean isSequential)
    {
        this.puzzleID = puzzleID;
        this.difficulty = difficulty;
        this.attempts = attempts;
        this.clue = clue;
        this.hints = hints;
        this.isSequential = isSequential;
        this.isCompleted = false;
    }

    //the UUID for the Puzzle
    public UUID getPuzzleID() {
        return puzzleID;
    }

    //the difficulty of the puzzle (beginner, intermediate, pro)
    public Difficulty getDifficulty() {
        return difficulty;
    }

    //number of attempts the user gets to solve the puzzle
    public int getAttempts() {
        return attempts;
    }

    //clue for the user to know how to do a puzzle
    public Clue getClue() {
        return clue;
    }

    //an array list of hints for a specific puzzle
    public ArrayList<Hint> getHints() {
        return hints;
    }

    //
    public boolean getIsSequential() {
        return isSequential;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public Type getType() {
        return type;
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

    public abstract Object getContent();

    public abstract Object getSolution();

    public abstract boolean solve(Object answer);

    public String toString()
    {
        return "Puzzle ID: " + puzzleID + " (Difficulty: " + difficulty + ", Completed: " + isCompleted + ")";
    }

}