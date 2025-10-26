package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Represents an audio-based puzzle in the escape room.
 * This type of puzzle requires the player to solve a challenge based on an audio clip and submit an integer as the answer.
 * @author ndmcginnis21
 */
public class AudioPuzzle extends Puzzle
{

    private String audioContent;
    private String audioSolution;
    /**
     * Constructor for AudioPuzzle
     * @param puzzleID The unique identifier for the puzzle
     * @param name the name of the puzzle
     * @param difficulty The difficulty level of the puzzle
     * @param attempts The number of attempts allowed to solve the puzzle
     * @param clue The clue associated with the puzzle
     * @param hints A list of hints available for the puzzle
     * @param isSequential A boolean indicating if hints must be used in order
     * @param audioContent The audio content of the puzzle
     * @param audioSolution The solution to the audio puzzle
     */
    public AudioPuzzle(UUID puzzleID, String name, Difficulty difficulty, int attempts, Clue clue,
                       ArrayList<Hint> hints, boolean isSequential, String audioContent, String audioSolution)
    {
        super(puzzleID, name, difficulty, attempts, clue, hints, isSequential);
        this.audioContent = audioContent;
        this.audioSolution = audioSolution;
        this.type = Type.Audio;
    }

    /**
     * Gets and returns the audio content
     * @return The audio content of the puzzle
     */
    public Object getContent() {
        return audioContent;
    }

    /**
     * Gets and returns the solution to the audio puzzle
     * @return The solution to the audio puzzle
     */
    public Object getSolution() {
        return audioSolution;
    }

    /**
     * Checks if the provided answer is correct
     * @param answer, The users answer 
     * @return True if the answer is correct, false otherwise
     */
    public boolean solve(Object answer)
    {
       if (answer instanceof String)
        {
            return this.audioSolution.equalsIgnoreCase((String) answer);
        }
        return false;
    }
}