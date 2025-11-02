package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LeaderboardEntryTest {

    private LeaderboardEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new LeaderboardEntry( "Jasper", Duration.ofMinutes(75).plusSeconds(30), LocalDate.now(), 2, Difficulty.Intermediate, 950.5);
    }

    @Test
    public void testConstructorSetsFieldsCorrectly() {
        assertEquals("Jasper", entry.getUsername());
        assertEquals(Duration.ofMinutes(75).plusSeconds(30), entry.getTime());
        assertEquals(LocalDate.now(), entry.getDate());
        assertEquals(2, entry.getHintsUsed());
        assertEquals(Difficulty.Intermediate, entry.getDifficulty());
        assertEquals(950.5, entry.getScore());
    }

    @Test
    public void testGetUsername() {
        assertEquals("Jasper", entry.getUsername());
    }

    @Test
    public void testGetTime() {
        assertEquals(Duration.ofMinutes(75).plusSeconds(30), entry.getTime());
    }

    @Test
    public void testGetDate() {
       assertEquals(LocalDate.now(), entry.getDate());
    }

    @Test
    public void testGetHintsUsed() {
        assertEquals(2, entry.getHintsUsed());
    }

    @Test
    public void testGetDifficulty() {
        assertEquals(Difficulty.Intermediate, entry.getDifficulty());
    }

    @Test
    public void testGetScore() {
        assertEquals(950.5, entry.getScore());
    }

    @Test
    public void testGetFormatDuration_HoursIncluded() {
        String formatted = entry.getFormatDuration();
        assertEquals("01:15:30", formatted);
    }

    @Test
    public void testGetFormatDuration_NoHours() {
        LeaderboardEntry shortEntry = new LeaderboardEntry("Sam", Duration.ofMinutes(5).plusSeconds(8), LocalDate.now(), 0, Difficulty.Beginner, 500.0);
        String formatted = shortEntry.getFormatDuration();
        assertEquals("05:08", formatted);
    }

    @Test
    public void testGetFormatDuration_NoMins() {
        LeaderboardEntry shorterEntry = new LeaderboardEntry("Lola", Duration.ofSeconds(8), LocalDate.now(), 0, Difficulty.Beginner, 500.0);
        String formatted = shorterEntry.getFormatDuration();
        assertEquals("00:08", formatted);
    }

    @Test
    public void testToStringIncludesAllFields() {
        String output = entry.toString();
        assertTrue(output.contains("Jasper"));
        assertTrue(output.contains("950.5"));
        assertTrue(output.contains("Hints Used: 2"));
        assertTrue(output.contains("Intermediate"));
        assertTrue(output.contains(LocalDate.now().toString()));
        assertTrue(output.contains("01:15:30"));
    }

    @Test
    public void testToStringFormatIsReadable() {
        String output = entry.toString();
        assertTrue(output.startsWith("Jasper: "));
        assertTrue(output.contains("\nTime:"));
    }
}
