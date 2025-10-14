package com.model;
import java.time.Duration;
import java.time.Instant;

/**
 * This class represents a timer for the escape room
 * @author Kelly Sullivan
 */
public class Timer {
    private double timeRemaining;
    private Instant initialTime;
    private boolean isRunning;
    private Instant stopTime;

    public Timer() {
        this.timeRemaining = 1800.0;
        this.isRunning = false;
    }
    public Timer(double timeRemaining, boolean isRunning){
        this.timeRemaining = timeRemaining;
        this.isRunning = isRunning;
    }
    public double getTimeRemaining() {
        return timeRemaining;
    }
    public Instant getInitialTime() {
        return initialTime;
    }
    public boolean getIsRunning() {
        return isRunning;
    }
    public Instant getStopTime() {
        return stopTime;
    }
    public void start(){
        isRunning = true;
        initialTime = Instant.now();
    }
    public void pause() {
        updateTime();
        isRunning = false;
        stopTime = Instant.now();
    }
    public void resume() {
        if (timeRemaining < 0){
            isRunning = true;
            initialTime = Instant.now();
        }
    }
    public void addTime(int seconds){
        timeRemaining += seconds;
    }
    public void subtractTime(int seconds){
        timeRemaining -= seconds;
    }
    public boolean isExpired(){
        return timeRemaining <= 0;
    }
    private void updateTime(){
        if (isRunning) {
            Instant now = Instant.now();
            Duration passed = Duration.between(initialTime, now);
            timeRemaining -= passed.toSeconds();
        } 
        Duration passed = Duration.between(initialTime, stopTime);
        timeRemaining -= passed.toSeconds();
    }

}
