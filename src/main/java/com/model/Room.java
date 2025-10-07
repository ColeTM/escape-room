package com.model;

import java.util.UUID;
import java.util.ArrayList;
import java.awt.Image;

/**
 * a specific room in the escape room *needs documentation*
 * @author coletm
 */
public class Room {

    private UUID roomID;
    private String story;
    private Image background;
    private ArrayList<Interactable> interactables;
    private ArrayList<Puzzle> puzzles;

    //correct constructor 
    public Room(String story, Image background,
                ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {

        this.roomID = UUID.randomUUID();
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
    
}
