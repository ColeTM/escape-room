package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardEntryTest {

    private LeaderboardEntry entry;
    private LocalDate testDate;

    @BeforeEach
    public void setUp() {
        testDate = LocalDate.of(2025, 10, 26);
        entry = new LeaderboardEntry(
                "Leni",
                Duration.ofMinutes(75).plusSeconds(30), // 1h15m30s
                testDate,
                2,
                Difficulty.Intermediate,
                950.5
        );
    }

    @Test
    public void testConstructorSetsFieldsCorrectly() {
        assertEquals("LeniR", entry.getUsername());
        assertEquals(Duration.ofMinutes(75).plusSeconds(30), entry.getTime());
        assertEquals(testDate, entry.getDate());
        assertEquals(2, entry.getHintsUsed());
        assertEquals(Difficulty.Intermediate, entry.getDifficulty());
        assertEquals(950.5, entry.getScore(), 0.0001);
    }

    @Test
    public void testGetFormatDuration_HoursIncluded() {
        // 1 hour, 15 minutes, 30 seconds → "01:15:30"
        String formatted = entry.getFormatDuration();
        assertEquals("01:15:30", formatted);
    }

    @Test
    public void testGetFormatDuration_NoHours() {
        LeaderboardEntry shortEntry = new LeaderboardEntry(
                "Sam",
                Duration.ofMinutes(5).plusSeconds(8), // 5m 8s
                LocalDate.now(),
                0,
                Difficulty.Beginner,
                500.0
        );
        String formatted = shortEntry.getFormatDuration();
        assertEquals("05:08", formatted);
    }

    @Test
    public void testToStringIncludesAllFields() {
        String output = entry.toString();
        assertTrue(output.contains("Leni"));
        assertTrue(output.contains("950.5"));
        assertTrue(output.contains("Hints Used: 2"));
        assertTrue(output.contains("Intermediate"));
        assertTrue(output.contains(testDate.toString()));
        assertTrue(output.contains("01:15:30"));
    }

    @Test
    public void testToStringFormatIsReadable() {
        String output = entry.toString();
        assertTrue(output.startsWith("Leni: "));
        assertTrue(output.contains("\nTime:"));
    }
}
