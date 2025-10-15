package com.model;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * a specific room in the escape room *needs documentation*
 * @author coletm
 */
public class Room {

    private UUID roomID;
    private String story;
    private File background;
    private ArrayList<Interactable> interactables;
    private ArrayList<Puzzle> puzzles;

    public Room(UUID roomID, String story, File background,
                ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {

        this.roomID = roomID;
        this.story = story;
        this.background = background;
        this.interactables = interactables;
        this.puzzles = puzzles;
    }
    
    public UUID getRoomID() {
        return roomID;
    }

    public void setRoomID(UUID id) {
        this.roomID = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public File getBackground() {
        return background;
    }

    public void setBackground(File background) {
        this.background = background;
    }

    public ArrayList<Interactable> getInteractables() {
        return interactables;
    }

    public void setInteractables(ArrayList<Interactable> interactables) {
        this.interactables = interactables;
    }

    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    public void setPuzzles(ArrayList<Puzzle> puzzles) {
        this.puzzles = puzzles;
    }


    public String toString() {
        return "ID: " + roomID +
                "\nstory: " + story;
    }
    
}
