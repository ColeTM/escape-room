package com.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Represents a picture-based puzzle in the escape room.
 * This type of puzzle requires the player to solve a challenge based on an image and submit a character as the answer.
 * @author ndmcginnis21
 */
public class PicturePuzzle extends Puzzle
{
    private File pictureContent;
    private char pictureSolution;

    /**
     * Constructs a new PicturePuzzle.
     * @param puzzleID The unique ID of the puzzle.
     * @param difficulty The difficulty level of the puzzle.
     * @param attempts The number of attempts the player has made.
     * @param clue The clue associated with the puzzle.
     * @param hints A list of hints for the puzzle.
     * @param isSequential True if the puzzle is part of a sequence, false otherwise.
     * @param pictureContent The image file for the puzzle.
     * @param pictureSolution The correct character solution to the puzzle.
     */
    public PicturePuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                         ArrayList<Hint> hints, boolean isSequential, File pictureContent, char pictureSolution)
    {
        super(puzzleID, difficulty, attempts, clue, hints, isSequential);
        this.pictureContent = pictureContent;
        this.pictureSolution = pictureSolution;
        this.type = Type.Picture;
    }

    /**
     * Gets the content of the puzzle.
     * @return The picture file of the puzzle.
     */
    public Object getContent() {
        return pictureContent;
    }

    /**
     * Gets the solution to the puzzle.
     * @return The character solution of the puzzle.
     */
    public Object getSolution() {
        return pictureSolution;
    }
    
    /**
     * Checks if the provided answer is the correct solution to the puzzle.
     * @param answer The player's proposed answer.
     * @return true if the answer is correct (case-insensitive), false otherwise.
     */
    public boolean solve(Object answer)
    {
        if (answer instanceof java.lang.Character)
        {
            return java.lang.Character.toLowerCase(this.pictureSolution) == 
                    java.lang.Character.toLowerCase((java.lang.Character) answer);
        }
        return false;
    }
}