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
    
    public Clue(UUID clueID, String text) {
        this.clueID = clueID;
        this.text = text;
    }

    public UUID getClueID() {
        return clueID;
    }

    public String getText() {
        return text;
    }

}
