package com.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * A picture-based puzzle.
 * @author ndmcginnis21
 */
public class PicturePuzzle extends Puzzle
{
    private BufferedImage pictureContent;
    private char pictureSolution;

    public PicturePuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                         ArrayList<Hint> hints, HashMap<Hint, Boolean> hintsUsed,
                         boolean isSequential, BufferedImage pictureContent, char pictureSolution)
    {
        super(puzzleID, difficulty, attempts, clue, hints, hintsUsed, isSequential);
        this.pictureContent = pictureContent;
        this.pictureSolution = pictureSolution;
    }
    
    public boolean solve(Object answer)
    {
        if (answer instanceof Character)
        {
            return Character.toLowerCase(this.pictureSolution) == Character.toLowerCase((Character) answer);
        }
        return false;
    }
}