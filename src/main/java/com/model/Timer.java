package com.model;

public class Timer {
    private double timeRemaining;
    private double initialTime;
    private boolean isRunning;

    public Timer() {
        this.timeRemaining = 30.00;
        this.initialTime = 0;
        this.isRunning = isRunning;
    }
    public Timer(double timeRemaining, boolean isRunning){
        this.timeRemaining = timeRemaining;
        this.initialTime = initialTime;
    }
    public void start(){
        isRunning = true;
    }
    public void pause() {
        isRunning = false;
    }
    public void resume() {
        isRunning = true;
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

    public double getTimeRemaining() {
        return this.timeRemaining;
    }

    public double getInitialTime() {
        return this.initialTime;
    }

    public boolean getIsRunning() {
        return this.isRunning;
    }
}
