package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

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
    }

    @Test
    public void testParameterizedConstructorSetsFields() {
        Timer paramTimer = new Timer(600.0, true);
        assertEquals(600.0, paramTimer.getTimeRemaining(), 0.001);
        assertTrue(paramTimer.getIsRunning());
    }

    @Test
    public void testStartSetsInitialTimeAndRunningTrue() {
        timer.start();
        assertTrue(timer.getIsRunning());
        assertNotNull(timer.getInitialTime());
    }

    //error in timer logic- 
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
        assertEquals(before + 60, timer.getTimeRemaining(), 0.001);
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

    @Test
    public void testIsExpiredReturnsFalseInitially() {
        assertFalse(timer.isExpired());
    }

    @Test
    public void testUpdateTimeDoesNotThrowIfNotStarted() {
        assertDoesNotThrow(() -> timer.updateTime());
    }

    @Test
    public void testResumeStartsIfTimeRemainingNegative() {
        Timer t = new Timer(-5, false);
        t.resume();
        assertTrue(t.getIsRunning());
        assertNotNull(t.getInitialTime());
    }

    @Test
    public void testUpdateTimeReducesTimeWhenRunning() throws InterruptedException {
        timer.start();
        Thread.sleep(1000); // wait 1 second
        timer.updateTime();
        assertTrue(timer.getTimeRemaining() < 1800.0);
    }

    @Test
    public void testIsExpiredTrueAfterSubtractingAllTime() {
        timer.subtractTime(1800);
        assertTrue(timer.isExpired());
    }
}
