package com.model;

// import java.awt.Image;
import java.io.File;
import java.util.UUID;

/**
 * This class represents a hint for a puzzle
 * @author ndmcginnis21
 */

public class Hint
{
    private UUID hintID;
    private String text;
    private boolean hasPicture;
    private File picture;
    private HintLevel level;
    private double timePenalty;

    //Constructor for creating a new Hint.
    public Hint(UUID hintID, String text, boolean hasPicture, File picture, HintLevel level, double timePenalty)
    {
        this.hintID = hintID;
        this.text = text;
        this.hasPicture = hasPicture;
        this.picture = picture;
        this.level = level;
        this.timePenalty = timePenalty;
    }

    public String getText()
    {
        return this.text;
    }

    public boolean hasPicture()
    {
        return this.hasPicture;
    }

    public File getPicture()
    {
        return this.picture;
    }

    public double getTimePenalty()
    {
        return this.timePenalty;
    }

    public String toString()
    {
        return "Hint: " + text + " (Level: " + level + ", Penalty: " + timePenalty + ")";
    }

}