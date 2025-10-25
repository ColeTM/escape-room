package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * An abstract class representing a generic puzzle in the escape room.
 * This class serves as a base for different types of puzzles, such as text, audio, and picture puzzles.
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

    /**
     * Constructs a new Puzzle.
     * @param puzzleID The unique ID of the puzzle.
     * @param difficulty The difficulty level of the puzzle.
     * @param attempts The initial number of attempts (usually 0).
     * @param clue The clue for the puzzle.
     * @param hints A list of hints for the puzzle.
     * @param isSequential True if the puzzle is sequential, false otherwise.
     */    
    public Puzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                  ArrayList<Hint> hints, boolean isSequential) {
        this.puzzleID = puzzleID;
        this.difficulty = difficulty;
        this.attempts = attempts;
        this.clue = clue;
        this.hints = hints;
        this.isSequential = isSequential;
        this.isCompleted = false;
    }

    /**
     * Gets the unique ID of the puzzle.
     * @return The UUID of the puzzle.
     */   
    public UUID getPuzzleID() {
        return puzzleID;
    }

    /**
     * Gets the difficulty level of the puzzle.
     * @return The difficulty of the puzzle.
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Gets the number of attempts made on the puzzle.
     * @return The number of attempts.
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * Gets the clue for the puzzle.
     * @return The clue.
     */
    public Clue getClue() {
        return clue;
    }

    /**
     * Gets the list of hints for the puzzle.
     * @return The list of hints.
     */
    public ArrayList<Hint> getHints() {
        return hints;
    }

    /**
     * Checks if the puzzle is sequential.
     * @return true if the puzzle is sequential, false otherwise.
     */
    public boolean getIsSequential() {
        return isSequential;
    }

    /**
     * Checks if the puzzle has been completed.
     * @return true if the puzzle is completed, false otherwise.
     */
    public boolean getIsCompleted() {
        return isCompleted;
    }

    /**
     * Gets the type of the puzzle.
     * @return The puzzle's type.
     */
    public Type getType() {
        return type;
    }

    /**
     * Resets the puzzle to its initial, unsolved state.
     */
    public void reset() {
        this.isCompleted = false;
    }

    /**
     * Checks if the puzzle has been completed.
     * @return true if the puzzle is completed, false otherwise.
     */
    public boolean isCompleted() {
        return this.isCompleted;
    }

    /**
     * Increments the number of attempts made on the puzzle.
     */
    public void addAttempt() {
        this.attempts++;
    }

    /**
     * An abstract method to get the main content of the puzzle.
     * @return The puzzle's content (e.g., text, audio file path, image file).
     */
    public abstract Object getContent();

    /**
     * An abstract method to get the solution of the puzzle.
     * @return The puzzle's solution.
     */
    public abstract Object getSolution();

    /**
     * An abstract method to check if a given answer is correct.
     * @param answer The player's proposed answer.
     * @return true if the answer is correct, false otherwise.
     */
    public abstract boolean solve(Object answer);

    /**
     * Returns a string representation of the puzzle.
     * @return A string containing the puzzle's ID, difficulty, and completion status.
     */
    public String toString() {
        return "Puzzle ID: " + puzzleID + " (Difficulty: " + difficulty + ", Completed: " + isCompleted + ")";
    }

}