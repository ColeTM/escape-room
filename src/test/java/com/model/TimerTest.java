package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.time.Instant;

public class TimerTest {

    private Timer timer;

    @BeforeEach
    public void setUp() {
        timer = new Timer();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(1800.0, timer.getTimeRemaining());
        assertFalse(timer.getIsRunning());
        assertNull(timer.getInitialTime());
        assertNull(timer.getStopTime());
    }

    @Test
    public void testParameterizedConstructor() {
        Timer paramTimer = new Timer(600.0, true);
        assertEquals(600.0, paramTimer.getTimeRemaining());
        assertTrue(paramTimer.getIsRunning());
    }

    @Test
    public void testStartSetsInitialTime() {
        timer.start();
        assertNotNull(timer.getInitialTime());
    }
    @Test
    public void testStartRunningTrue() {
        timer.start();
        assertTrue(timer.getIsRunning());
    }

    @Test
    public void testResumeRunningTrue() {
        timer.resume();
        assertTrue(timer.getIsRunning());
    }

    //error in timer logic
    @Test
    public void testPauseRunningFalse() {
        timer.start();
        timer.pause();
        assertFalse(timer.getIsRunning());
    }

    //error in timer logic
    @Test
    public void testPauseStopsTimerAndSetsStopTime() {
        timer.start();
        timer.pause();
        assertFalse(timer.getIsRunning());
        assertNotNull(timer.getStopTime());
    }

    @Test
    public void testAddTimeIncreasesTimeRemaining() {
        double before = timer.getTimeRemaining();
        timer.addTime(60);
        assertEquals(before + 60, timer.getTimeRemaining());
    }

    @Test
    public void testSubtractTimeDecreasesTimeRemaining() {
        double before = timer.getTimeRemaining();
        timer.subtractTime(90);
        assertEquals(before - 90, timer.getTimeRemaining(), 0.001);
    }

    @Test
    public void testSecondsToDurationConvertsProperly() {
        Duration duration = Timer.secondsToDuration(90.5);
        assertEquals(Duration.ofMillis(90500), duration);
    }

    //error in timer logic
    @Test
    public void testIsExpiredReturnsFalseInitially() {
        timer.start();
        assertFalse(timer.isExpired());
    }

    @Test
    public void testisExpiredDoesNotThrowIfNotStarted() {
        assertDoesNotThrow(() -> timer.isExpired());
    }

    @Test
    public void testisExpiredDoesNotThrowIfStarted() {
        timer.start();
        assertDoesNotThrow(() -> timer.isExpired());
    }

    @Test
    public void testUpdateTimeDoesNotThrowIfNotStarted() {
        assertDoesNotThrow(() -> timer.updateTime());
    }

     @Test
    public void testUpdateTimeDoesNotThrowIfStarted() {
        timer.start();
        assertDoesNotThrow(() -> timer.updateTime());
    }

     @Test
    public void testPauseTimeDoesNotThrowIfNotStarted() {
        assertDoesNotThrow(() -> timer.pause());
    }

     @Test
    public void testPauseTimeDoesNotThrowIfStarted() {
        timer.start();
        assertDoesNotThrow(() -> timer.pause());
    }

     @Test
    public void testStartTimeDoesNotThrow() {
        assertDoesNotThrow(() -> timer.start());
    }

     @Test
    public void testResumeTimeDoesNotThrow() {
        assertDoesNotThrow(() -> timer.resume());
    }

     @Test
    public void testResumeTimeDoesNotThrowifStarted() {
        timer.start();
        assertDoesNotThrow(() -> timer.resume());
    }

    @Test
    public void testResumeDoesNotChangeInitialTimeifNeverPaused() {
        timer.start();
        Instant init = timer.getInitialTime();
        timer.resume();
        assertEquals(init, timer.getInitialTime());
    }
    
    @Test
    public void testResumeStartsIfTimeRemainingNegativeFails() {
        Timer t = new Timer(-5, false);
        t.resume();
        assertFalse(t.getIsRunning());
    }

    //issue with timer logic
    @Test
    public void testUpdateTimeReducesTimeWhenRunning() throws InterruptedException{
        timer.start();
        Thread.sleep(2000);
        timer.updateTime();
        assertTrue(timer.getTimeRemaining() < 1800.0);
    }

    //issue with timer logic
    @Test
    public void testIsExpiredTrueAfterSubtractingAllTime() {
        timer.subtractTime(1800);
        assertTrue(timer.isExpired());
    }
}
