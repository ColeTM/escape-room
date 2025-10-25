package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Represents a text-based puzzle in the escape room.
 * This type of puzzle requires the player to solve a challenge by submitting a text-based answer.
 * @author ndmcginnis21
 */
public class TextPuzzle extends Puzzle
{

    private String textContent;
    private String textSolution;

    /**
     * Constructs a new TextPuzzle.
     * @param puzzleID The unique ID of the puzzle.
     * @param difficulty The difficulty level of the puzzle.
     * @param attempts The number of attempts the player has made.
     * @param clue The clue associated with the puzzle.
     * @param hints A list of hints for the puzzle.
     * @param isSequential True if the puzzle is part of a sequence, false otherwise.
     * @param textContent The main text content of the puzzle.
     * @param textSolution The correct text solution to the puzzle.
     */
    public TextPuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                      ArrayList<Hint> hints, boolean isSequential, String textContent, String textSolution) {
        super(puzzleID, difficulty, attempts, clue, hints, isSequential);
        this.textContent = textContent;
        this.textSolution = textSolution;
        this.type = Type.Text;
    }

    /**
     * Gets the content of the puzzle.
     * @return The text content of the puzzle.
     */
    public Object getContent() {
        return textContent;
    }

    /**
     * Gets the solution to the puzzle.
     * @return The text solution of the puzzle.
     */
    public Object getSolution() {
        return textSolution;
    }

    /**
     * Checks if the provided answer is the correct solution to the puzzle.
     * @param answer The player's proposed answer.
     * @return true if the answer is correct (case-insensitive), false otherwise.
     */
    public boolean solve(Object answer) {
        if (answer instanceof String)
        {
            return this.textSolution.equalsIgnoreCase((String) answer);
        }
        return false;
    }
}