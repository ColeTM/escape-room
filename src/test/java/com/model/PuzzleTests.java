package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

public class PuzzleTests {

    private Puzzle mockPuzzle;
    private Puzzle emptySolutionPuzzle;
    private Puzzle nullSolutionPuzzle;
    private Clue testClue;
    private ArrayList<Hint> testHints;
    private UUID puzzleID = UUID.randomUUID();

    private class MockPuzzle extends Puzzle {
        private final String mockSolution;

        public MockPuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                          ArrayList<Hint> hints, boolean isSequential, String solution) {
            super(puzzleID, solution, difficulty, attempts, clue, hints, isSequential);
            this.mockSolution = solution;
        }

        @Override
        public Object getContent() { return "mock content"; }

        @Override
        public Object getSolution() { return mockSolution; }

        @Override
        public boolean solve(Object answer) {
            if (mockSolution == null) {
                return answer == null;
            }
            if (answer instanceof String) {
                return mockSolution.equalsIgnoreCase((String) answer);
            }
            return false;
        }
    }

    @BeforeEach
    public void setUp() {
        testClue = new Clue(UUID.randomUUID(), "A mock clue");
        testHints = new ArrayList<>();
        mockPuzzle = new MockPuzzle(puzzleID, Difficulty.Beginner, 0, testClue, testHints, false, "Solution");
        emptySolutionPuzzle = new MockPuzzle(UUID.randomUUID(), Difficulty.Beginner, 0, testClue, testHints, false, "");
        nullSolutionPuzzle = new MockPuzzle(UUID.randomUUID(), Difficulty.Beginner, 0, testClue, testHints, false, null);
    }

    @Test
    public void testPuzzleConstructorInitialState() {
        assertEquals(puzzleID, mockPuzzle.getPuzzleID());
        assertEquals(Difficulty.Beginner, mockPuzzle.getDifficulty());
        assertEquals(0, mockPuzzle.getAttempts());
        assertEquals(testClue, mockPuzzle.getClue());
        assertEquals(testHints, mockPuzzle.getHints());
        assertFalse(mockPuzzle.getIsSequential());
        assertFalse(mockPuzzle.isCompleted(), "Puzzle should be incomplete by default.");
    }

    @Test
    public void testAddAttempt() {
        assertEquals(0, mockPuzzle.getAttempts(), "Attempts should be 0 initially.");
        mockPuzzle.addAttempt();
        assertEquals(1, mockPuzzle.getAttempts(), "Attempts should be 1 after one call.");
        mockPuzzle.addAttempt();
        assertEquals(2, mockPuzzle.getAttempts(), "Attempts should be 2 after two calls.");
    }

    @Test
    public void testReset() {
        assertFalse(mockPuzzle.isCompleted(), "Puzzle is incomplete initially.");
        mockPuzzle.reset();
        assertFalse(mockPuzzle.isCompleted(), "Puzzle should still be incomplete after reset.");
    }

    @Test
    public void testSolveWithCorrectCapitalization() {
        assertTrue(mockPuzzle.solve("Solution"), "Should return true for an exact match.");
    }

    @Test
    public void testSolveWithIncorrectCapitalization() {
        assertTrue(mockPuzzle.solve("solution"), "Solve should be case-insensitive and return true.");
        assertTrue(mockPuzzle.solve("SOLUTION"), "Solve should be case-insensitive and return true.");
    }

    @Test
    public void testSolveWithEmptySolution() {
        assertTrue(emptySolutionPuzzle.solve(""), "Should return true when the answer is an empty string and the solution is empty.");
        assertFalse(emptySolutionPuzzle.solve("a"), "Should return false for non-empty answer to an empty solution.");
        assertFalse(emptySolutionPuzzle.solve(null), "Should return false for null answer to an empty solution.");
    }

    @Test
    public void testSolveWithNullSolution() {
        assertTrue(nullSolutionPuzzle.solve(null), "Should return true when the answer and solution are both null.");
        assertFalse(nullSolutionPuzzle.solve(""), "Should return false for empty string answer to a null solution.");
        assertFalse(nullSolutionPuzzle.solve("null"), "Should return false for the string 'null' answer to a null solution.");
    }
}