package com.model;

// import java.awt.Image;
import java.io.File;
import java.util.UUID;

/**
 * Represents a hint that can be provided to the player for a puzzle.
 * Each hint has a unique ID, text content, an optional picture, a level of directness, and a time penalty.
 * @author ndmcginnis21
 */
public class Hint
{
    private UUID hintID;
    private String text;
    private boolean hasPicture;
    private File picture;
    private HintLevel level;

    /**
     * Constructs a new Hint.
     * @param hintID The unique ID for the hint.
     * @param text The text content of the hint.
     * @param hasPicture True if the hint includes a picture, false otherwise.
     * @param picture The image file for the hint (can be null).
     * @param level The hint's level of directness.
     * @param timePenalty The time penalty for using the hint.
     */    
    public Hint(UUID hintID, String text, boolean hasPicture, File picture, HintLevel level) {
        this.hintID = hintID;
        this.text = text;
        this.hasPicture = hasPicture;
        this.picture = picture;
        this.level = level;
    }

    /**
     * Gets the unique ID of the hint.
     * @return The UUID of the hint.
     */
    public UUID getHintID() {
        return hintID;
    }

    /**
     * Gets the text of the hint.
     * @return The hint's text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Checks if the hint has an associated picture.
     * @return true if there is a picture, false otherwise.
     */
    public boolean getHasPicture() {
        return this.hasPicture;
    }

    /**
     * Gets the picture for the hint.
     * @return The hint's image file.
     */
    public File getPicture() {
        return this.picture;
    }

    /**
     * Gets the level of the hint.
     * @return The hint's level (Vague or Direct).
     */
    public HintLevel getLevel() {
        return level;
    }

    /**
     * Returns a string representation of the hint.
     * @return A string containing the hint's text, level, and time penalty.
     */
    public String toString()
    {
        return "Hint: " + text + " (Level: " + level + ")";
    }

}