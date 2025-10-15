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
    private File picture;
    
    public Clue(UUID clueID, String text, File picture) {
        this.clueID = clueID;
        this.text = text;
        this.picture = picture;
    }

    public UUID getClueID() {
        return clueID;
    }

    public String getText() {
        return text;
    }

    public File getPicture() {
        return picture;
    }

}
