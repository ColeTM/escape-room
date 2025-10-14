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
    
    public UUID getRoomUUID(Room room) {
        return roomID;
    }

    public void setRoomID(UUID id) {
        this.roomID = id;
    }

    public String toString() {
        return "ID: " + roomID +
                "\nstory: " + story;
    }
    
}
