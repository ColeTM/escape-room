package com.model;

import java.util.UUID;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * a specific room in the escape room *needs documentation*
 * @author coletm
 */
public class Room {

    private UUID roomID;
    private String story;
    private BufferedImage background;
    private ArrayList<Interactable> = interactables;
    private ArrayList<Puzzle> = puzzles;

    public Room(UUID id, String story, BufferedImage background,
                ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {

        this.roomID = id;
        this.story = story;
        this.background = background;
        this.interactables = interactables;
        this.puzzles = puzzles;
    }
    
}
