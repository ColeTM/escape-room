package com.model;

// import javafx.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;
/*
 * @author: Nick Hippchen 
 * A clue object that contains a text clue and an image clue
 */
public class Clue {
    
    private UUID clueID;
    private String text;
    
    /*
     * Constructor for Clue
     * @param clueID The unique identifier for the clue
     * @param text The text of the clue
     */
    public Clue(UUID clueID, String text) {
        this.clueID = clueID;
        this.text = text;
    }

    /*
     * Gets and returns the clue ID
     * @return The unique identifier for the clue
     */
    public UUID getClueID() {
        return clueID;
    }

    /*
     * Gets and returns the text of the clue
     * @return The text of the clue
     */
    public String getText() {
        return text;
    }

}
