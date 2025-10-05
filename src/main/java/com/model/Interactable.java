package com.model;

import java.util.UUID;

/**
 * Represents an object in a room that the user can interact with
 * @author ndmcginnis21
 */

public class Interactable
{
    private UUID interactableID;
    private String name;
    private String description;
    private boolean isHighlighted;
    private String soundEffect;
    private String clueText;

    //Constructor for creating a new Interactable object
    public Interactable(UUID interactableID, String name, String description,
    boolean isHighlighted, String soundEffect, String clueText)
    {
        this.interactableID = interactableID;
        this.name = name;
        this.description = description;
        this.isHighlighted = isHighlighted;
        this.soundEffect = soundEffect;
        this.clueText = clueText;
    }

    public void highlight()
    {
    
    }

    public void interact()
    {

    }

    public void playSoundEffect()
    {

    }

    public String getClueText()
    {
        return this.clueText;
    }
}