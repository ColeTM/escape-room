package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * A text-based puzzle
 * @author ndmcginnis21
 */
public class TextPuzzle extends Puzzle
{

    private String textContent;
    private String textSolution;

    public TextPuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                      ArrayList<Hint> hints, HashMap<Hint, Boolean> hintsUsed,
                      boolean isSequential, String textContent, String textSolution)
    {
        super(puzzleID, difficulty, attempts, clue, hints, hintsUsed, isSequential);
        this.textContent = textContent;
        this.textSolution = textSolution;
    }

    public boolean solve(Object answer)
    {
        if (answer instanceof String)
        {
            return this.textSolution.equalsIgnoreCase((String) answer);
        }
        return false;
    }
}