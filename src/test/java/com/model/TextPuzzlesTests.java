package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

public class TextPuzzlesTests {

    private TextPuzzle puzzle;

    @BeforeEach
    public void setUp() {
        puzzle = new TextPuzzle(UUID.randomUUID(), null, Difficulty.Beginner,
            0, new Clue(UUID.randomUUID(), "I have T at the beginning..."),
            new ArrayList<Hint>(), false,
            "I have T at the beginning, middle, and end. What am I?",
            "Teapot");
    }

    @Test
    public void testTextPuzzleSolveCorrect() {
        assertTrue(puzzle.solve("Teapot"), "Should return true for the correct answer.");
    }

    @Test
    public void testTextPuzzleSolveCorrectCaseInsensitive() {
        assertTrue(puzzle.solve("teapot"), "Should return true for correct answer, ignoring case.");
        assertTrue(puzzle.solve("TEAPOT"), "Should return true for correct answer, ignoring case.");
    }

    @Test
    public void testTextPuzzleSolveIncorrect() {
        assertFalse(puzzle.solve("Coffee"), "Should return false for an incorrect answer.");
    }

    @Test
    public void testTextPuzzleSolveIncorrectType() {
        assertFalse(puzzle.solve(12345), "Should return false for a non-string answer.");
        assertFalse(puzzle.solve(null), "Should return false for a null answer.");
    }

    @Test
    public void testTextPuzzleGetType() {
        assertEquals(Type.Text, puzzle.getType(), "getType() should return Type.Text.");
    }
}