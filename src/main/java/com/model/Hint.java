package com.model;

import java.awt.image.BufferedImage;
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
    private Image picture;
    private HintLevel level;
    private double timePenalty;

    //Constructor for creating a new Hint.
    public Hint(String text, boolean hasPicture, Image picture, HintLevel level)
    {
        this.hintID = UUID.randomUUID();
        this.text = text;
        this.hasPicture = hasPicture;
        this.picture = picture;
        this.level = level;
    }

    public String getText()
    {
        return this.text;
    }

    public boolean hasPicture()
    {
        return this.hasPicture;
    }

    public Image getPicture()
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