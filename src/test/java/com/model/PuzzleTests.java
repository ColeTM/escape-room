package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

public class PuzzleTests {

    private Puzzle mockPuzzle;
    private Clue testClue;
    private ArrayList<Hint> testHints;
    private UUID puzzleID = UUID.randomUUID();

    private class MockPuzzle extends Puzzle {
        public MockPuzzle(UUID puzzleID, Difficulty difficulty, int attempts, Clue clue,
                          ArrayList<Hint> hints, boolean isSequential) {
            super(puzzleID, null, difficulty, attempts, clue, hints, isSequential);
        }

        @Override
        public Object getContent() { return "mock content"; }

        @Override
        public Object getSolution() { return "mock solution"; }

        @Override
        public boolean solve(Object answer) {
            boolean solved = answer.equals("mock solution");
            /**
             * need to finish this part of the tests
             */
            if (solved) {
                
            }
            return solved;
        }
    }

    @BeforeEach
    public void setUp() {
        testClue = new Clue(UUID.randomUUID(), "A mock clue");
        testHints = new ArrayList<>();
        mockPuzzle = new MockPuzzle(puzzleID, Difficulty.Beginner, 0, testClue, testHints, false);
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
}