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
    public void testAddEntryWithNullTimeFails() {
        LeaderboardEntry entry = new LeaderboardEntry("shellyloo", null, LocalDate.now(),3, Difficulty.Beginner, 2.0);
        leaderboard.addEntry(entry);
        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        assertFalse(entries.contains(entry));
    }

    @Test //should throw 
    public void testSortEntryWithNullTimeFails() {
        LeaderboardEntry entry = new LeaderboardEntry("shellyloo", null, LocalDate.now(),3, Difficulty.Beginner, 2.0);
        leaderboard.addEntry(entry);
        assertDoesNotThrow(() -> leaderboard.sortEntries());
    }
    @Test
    public void testAddEntryWithNullUsernameFails() {
        LeaderboardEntry entry = new LeaderboardEntry(null, Duration.ofSeconds(15), LocalDate.now(),3, Difficulty.Beginner, 2.0);
        leaderboard.addEntry(entry);
        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        assertFalse(entries.contains(entry));
    }
    @Test //should throw
    public void testSortEntryWithNullUsernameFails() {
        LeaderboardEntry entry = new LeaderboardEntry(null, Duration.ofSeconds(15), LocalDate.now(),3, Difficulty.Beginner, 2.0);
        leaderboard.addEntry(entry);
        assertDoesNotThrow(() -> leaderboard.sortEntries());
    }

    @Test
    public void testAddEntryWithNullDateFails() {
        LeaderboardEntry entry = new LeaderboardEntry("shelly", Duration.ofSeconds(15), null ,3, Difficulty.Beginner, 2.0);
        leaderboard.addEntry(entry);
        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        assertFalse(entries.contains(entry));
    }

    @Test //should throw
    public void testSortEntryWithNullDateFails() {
        LeaderboardEntry entry = new LeaderboardEntry("shelly", Duration.ofSeconds(15), null ,3, Difficulty.Beginner, 2.0);
        leaderboard.addEntry(entry);
        assertDoesNotThrow(() -> leaderboard.sortEntries());
    }

    @Test
    public void testAddEntryWithNullDifficultyFails() {
        LeaderboardEntry entry = new LeaderboardEntry("shelly", Duration.ofSeconds(15), LocalDate.now(), 3 , null, 2.0);
        leaderboard.addEntry(entry);
        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        assertFalse(entries.contains(entry));
    }
    @Test //should throw
    public void testSortEntryWithNullDifficultyFails() {
        LeaderboardEntry entry = new LeaderboardEntry("shelly", Duration.ofSeconds(15), LocalDate.now(), 3 , null, 2.0);
        leaderboard.addEntry(entry);
        assertDoesNotThrow(() -> leaderboard.sortEntries());
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

    //same time but different scores, two should be higher
    @Test
    public void testSortEntriesSortsBySameTime() {
        LeaderboardEntry one = new LeaderboardEntry(
            "simonlovesgames", Duration.ofSeconds(180), LocalDate.now(), 1, Difficulty.Beginner, 3.0 );
        LeaderboardEntry two = new LeaderboardEntry(
            "julie101", Duration.ofSeconds(180), LocalDate.now(), 2, Difficulty.Beginner, 9.6);

        leaderboard.addEntry(one);
        leaderboard.addEntry(two);

        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        assertEquals(two, entries.get(0));
        assertEquals(one, entries.get(1));
    }

    @Test
    public void testSortEntriesSortsWithOneEntry() {
        LeaderboardEntry one = new LeaderboardEntry(
            "simonlovesgames", Duration.ofSeconds(180), LocalDate.now(), 1, Difficulty.Beginner, 3.0 );
        leaderboard.addEntry(one);
        assertDoesNotThrow(() -> leaderboard.sortEntries());
    }

    @Test
    public void testAddSameEntryTwice() {
        LeaderboardEntry one = new LeaderboardEntry(
            "simonlovesgames", Duration.ofSeconds(180), LocalDate.now(), 1, Difficulty.Beginner, 3.0 );
        leaderboard.addEntry(one);
        LeaderboardEntry two = new LeaderboardEntry(
            "simonlovesgames", Duration.ofSeconds(180), LocalDate.now(), 1, Difficulty.Beginner, 3.0 );
        assertDoesNotThrow(() ->leaderboard.addEntry(two));
    }

    @Test
    public void testSortSameEntryTwice() {
        LeaderboardEntry one = new LeaderboardEntry(
            "simonlovesgames", Duration.ofSeconds(180), LocalDate.now(), 1, Difficulty.Beginner, 3.0 );
        leaderboard.addEntry(one);
        LeaderboardEntry two = new LeaderboardEntry(
            "simonlovesgames", Duration.ofSeconds(180), LocalDate.now(), 1, Difficulty.Beginner, 3.0 );
        assertDoesNotThrow(() ->leaderboard.addEntry(two));
        assertDoesNotThrow(() -> leaderboard.sortEntries());
    }

    @Test
    public void testDisplayGlobalReturnsSameList() {
        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        entries.add(new LeaderboardEntry("unicornlover", Duration.ofSeconds(60), LocalDate.now(), 0, Difficulty.Intermediate, 5.0));
        assertEquals(1, leaderboard.displayGlobal().size());
    }

    @Test
    public void testToStringFormatsCorrectly() {
        LeaderboardEntry entry = new LeaderboardEntry("sammyQ", Duration.ofSeconds(75), LocalDate.now(), 1, Difficulty.Pro, 5.5);
        leaderboard.addEntry(entry);
        String text = leaderboard.toString();
        assertTrue(text.contains("Leaderboard:"));
        assertTrue(text.contains("|n"));;
    }

    
}
