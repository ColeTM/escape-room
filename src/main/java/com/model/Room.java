package com.model;

import java.util.UUID;
import java.util.ArrayList;
//import java.awt.image.BufferedImage;

/**
 * a specific room in the escape room *needs documentation*
 * @author coletm
 */
public class Room {

    private UUID roomID;
    private String story;
    //private BufferedImage background;
    private ArrayList<Interactable> interactables;
    private ArrayList<Puzzle> puzzles;

    //correct constructor 
/*  public Room(UUID id, String story, BufferedImage background,
                ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {

        this.roomID = id;
        this.story = story;
        this.background = background;
        this.interactables = interactables;
        this.puzzles = puzzles;
    }*/
    
    // Constructor for testing purposes only for RoomList
    public Room(String story) {
        this.roomID = UUID.randomUUID();
        this.story = story;
        //this.interactables = new ArrayList<Interactable>();
        //this.puzzles = new ArrayList<Puzzle>();
    }

    public UUID getRoomID() {
        return roomID;
    }

    public void setRoomID(UUID id) {
        this.roomID = id;
    }
    
}
