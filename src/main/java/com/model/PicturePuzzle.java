package com.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * A picture-based puzzle.
 * @author ndmcginnis21
 */
public class PicturePuzzle extends Puzzle
{
    private File pictureContent;
    private char pictureSolution;

    public PicturePuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                         ArrayList<Hint> hints, HashMap<UUID, Boolean> hintsUsed,
                         boolean isSequential, File pictureContent, char pictureSolution)
    {
        super(puzzleID, difficulty, attempts, clue, hints, hintsUsed, isSequential);
        this.pictureContent = pictureContent;
        this.pictureSolution = pictureSolution;
        this.type = Type.Picture;
    }

    public Object getContent() {
        return pictureContent;
    }

    public Object getSolution() {
        return pictureSolution;
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