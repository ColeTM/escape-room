package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

public class AudioPuzzleTests {

    private AudioPuzzle puzzle;

    @BeforeEach
    public void setUp() {
        puzzle = new AudioPuzzle(UUID.randomUUID(), Difficulty.Intermediate, 0,
            new Clue(UUID.randomUUID(), "Listen to the beeps."),
            new ArrayList<Hint>(), false, "path/to/morse.wav", 12345);
    }

    @Test
    public void testAudioPuzzleSolveCorrect() {
        assertTrue(puzzle.solve(12345), "Should return true for the correct integer solution.");
    }

    @Test
    public void testAudioPuzzleSolveIncorrect() {
        assertFalse(puzzle.solve(54321), "Should return false for an incorrect integer.");
    }

    @Test
    public void testAudioPuzzleSolveIncorrectType() {
        assertFalse(puzzle.solve("12345"), "Should return false for a string answer.");
        assertFalse(puzzle.solve(123.45), "Should return false for a double answer.");
        assertFalse(puzzle.solve(null), "Should return false for a null answer.");
    }

    @Test
    public void testAudioPuzzleGetType() {
        assertEquals(Type.Audio, puzzle.getType(), "getType() should return Type.Audio.");
    }
}