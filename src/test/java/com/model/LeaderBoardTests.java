package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;


public class LeaderBoardTests {
    private Leaderboard leaderboard;

    @BeforeEach
    public void setUp() {
        leaderboard = new Leaderboard();

    }

    @Test
    public void testSingletonInstance() {
        Leaderboard leaderboard1 = Leaderboard.getInstance();
        Leaderboard leaderboard2 = Leaderboard.getInstance();
        assertSame(leaderboard1, leaderboard2);
    }
    @Test
    public void testAddEntry() {
        LeaderboardEntry entry = new LeaderboardEntry("shellyloo", Duration.ofSeconds(15), LocalDate.now(),3, Difficulty.Beginner, 2.0);
        leaderboard.addEntry(entry);
        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        assertTrue(entries.contains(entry));
    }

    @Test
    public void testSortEntriesSortsByTime() {
        LeaderboardEntry fast = new LeaderboardEntry(
            "simonlovesgames", Duration.ofSeconds(90), LocalDate.now(), 1, Difficulty.Beginner, 3.0 );
        LeaderboardEntry slow = new LeaderboardEntry(
            "julie101", Duration.ofSeconds(180), LocalDate.now(), 2, Difficulty.Beginner, 9.6);

        leaderboard.addEntry(slow);
        leaderboard.addEntry(fast);

        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        assertEquals(fast, entries.get(0));
        assertEquals(slow, entries.get(1));
    }

    @Test
    public void testDisplayGlobalReturnsSameListReference() {
        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        entries.add(new LeaderboardEntry("unicornlover", Duration.ofSeconds(60), LocalDate.now(), 0, Difficulty.Intermediate, 5.0));
        assertEquals(1, leaderboard.displayGlobal().size());
    }

    @Test
    public void testToStringFormatsCorrectly() {
        LeaderboardEntry entry = new LeaderboardEntry(
            "sammyQ", Duration.ofSeconds(75), LocalDate.now(), 1, Difficulty.Pro, 5.5);
        leaderboard.addEntry(entry);
        String text = leaderboard.toString();
        assertTrue(text.contains("Leaderboard:"), "toString() should include 'Leaderboard:' header");
        assertTrue(text.contains("|n"), "toString() should include '|n' between entries");
    }

    
}
