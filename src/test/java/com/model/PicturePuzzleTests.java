package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Tests for the PicturePuzzle class.
 */
public class PicturePuzzleTests {

    private PicturePuzzle puzzle;

    @BeforeEach
    public void setUp() {
        puzzle = new PicturePuzzle(UUID.randomUUID(), Difficulty.Pro, 0,
            new Clue(UUID.randomUUID(), "What letter is shown?"),
            new ArrayList<Hint>(), true, new File("path/to/image.png"), 'A');
    }

    @Test
    public void testPicturePuzzleSolveCorrect() {
        assertTrue(puzzle.solve('A'), "Should return true for the correct char solution.");
    }

    @Test
    public void testPicturePuzzleSolveCorrectCaseInsensitive() {
        assertTrue(puzzle.solve('a'), "Should return true for correct char, ignoring case.");
    }

    @Test
    public void testPicturePuzzleSolveIncorrect() {
        assertFalse(puzzle.solve('B'), "Should return false for an incorrect char.");
    }

    @Test
    public void testPicturePuzzleSolveIncorrectType() {
        assertFalse(puzzle.solve("A"), "Should return false for a string answer.");
        assertFalse(puzzle.solve(65), "Should return false for an integer answer (even if ASCII matches).");
        assertFalse(puzzle.solve(null), "Should return false for a null answer.");
    }

    @Test
    public void testPicturePuzzleGetType() {
        assertEquals(Type.Picture, puzzle.getType(), "getType() should return Type.Picture.");
    }
}