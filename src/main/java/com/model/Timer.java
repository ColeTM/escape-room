package com.model;
import java.time.Duration;
import java.time.Instant;

/**
 * This class represents a timer for the escape room
 * @author Kelly Sullivan
 */
public class Timer {
    /**
     * attributes
     * timeRemaining - amount of time in double until time runs out 
     * initialTime - instant that the timer is restarted
     * isRunning - boolean of if the timer is running
     * stopTime- instant that the timer was stopped
     */
    private double timeRemaining;
    private Instant initialTime;
    private boolean isRunning;
    private Instant stopTime;

    /**
     * constructor for the timer
     */
    public Timer() {
        this.timeRemaining = 1800.0;
        this.isRunning = false;
    }

    /**
     * constructor for the timer with parameters for starting again after stopping
     * @param timeRemaining - the time left on the timer
     * @param isRunning - boolean for if the timer is currently running
     */
    public Timer(double timeRemaining, boolean isRunning){
        this.timeRemaining = timeRemaining;
        this.isRunning = isRunning;
    }
    /**
     * getter for the time remaining
     * @return double of time remaining
     */
    public double getTimeRemaining() {
        return timeRemaining;
    }

    /**
     * getter for the initial time
     * @return instant that the timer was started
     */
    public Instant getInitialTime() {
        return initialTime;
    }

    /**
     * getter for the boolean is running
     * @return boolean isRunning
     */
    public boolean getIsRunning() {
        return isRunning;
    }

    /**
     * getter for stop time
     * @return instant that the timer was stopped
     */
    public Instant getStopTime() {
        return stopTime;
    }

    /**
     * method to start the timer
     */
    public void start(){
        isRunning = true;
        initialTime = Instant.now();
    }

    /**
     * method to pause the timer
     */
    public void pause() {
        //updateTime();
        if(isRunning == true) {
            isRunning = false;
            stopTime = Instant.now();
            updateTime();
        }
    }

    /**
     * method to restart the timer after pausing
     */
    public void resume() {
        if(isRunning == false){
            if (timeRemaining > 0){
                isRunning = true;
                initialTime = Instant.now();
            }
        }
    }

    /**
     * method to add a certain amount of time to the timer
     * @param seconds to be added
     */
    public void addTime(int seconds){
        timeRemaining += seconds;
    }

    /**
     * method to subtract time from time remaining
     * @param seconds to subtract
     */
    public void subtractTime(int seconds){
        timeRemaining -= seconds;
    }

    /**
     * method to check if the timer has run out of time
     * @return boolean for if the timer has expired
     */
    public boolean isExpired(){
        updateTime();
        return timeRemaining <= 0;
    }

    /**
     * method to update the time remaining
     */
    public void updateTime(){
        if (isRunning) {
            Instant now = Instant.now();
            Duration passed = Duration.between(initialTime, now);
            timeRemaining -= passed.toSeconds();
        }
        else if (initialTime != null && stopTime != null){ 
            Duration passed = Duration.between(initialTime, stopTime);
           timeRemaining -= passed.toSeconds();
        }
    }

    /**
     * method to convert seconds as a double to a duration
     * @param seconds time elapsed of seconds as a double
     * @return the duration in seconds
     */
    public static Duration secondsToDuration(double seconds) {
        long millis = Math.round(seconds * 1000);
        return Duration.ofMillis(millis);
    }


    /**
     * mutator for time remaining. only used for testing. we will not keep this method.
     */
    public void setTimeRemaining(double seconds) {
        this.timeRemaining = seconds;
    }

}
