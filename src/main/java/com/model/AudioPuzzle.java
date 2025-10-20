package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * An audio-based puzzle.
 * @author ndmcginnis21
 */
public class AudioPuzzle extends Puzzle
{

    private String audioContent;
    private int audioSolution;

    public AudioPuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                       ArrayList<Hint> hints, HashMap<UUID, Boolean> hintsUsed,
                       boolean isSequential, String audioContent, int audioSolution)
    {
        super(puzzleID, difficulty, attempts, clue, hints, hintsUsed, isSequential);
        this.audioContent = audioContent;
        this.audioSolution = audioSolution;
        this.type = Type.Audio;
    }

    public Object getContent() {
        return audioContent;
    }

    public Object getSolution() {
        return audioSolution;
    }

    public boolean solve(Object answer)
    {
        if (answer instanceof Integer)
        {
            return this.audioSolution == (Integer) answer;
        }
        return false;
    }
}