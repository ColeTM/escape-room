package com.model;

import java.util.UUID;
import javax.sound.sampled.*;

/**
 * Represents an object in a room that the user can interact with
 * @author ndmcginnis21
 */

public class Interactable
{
    private UUID interactableID;
    private String description;
    private boolean isHighlighted;
    private static SoundEffect soundEffect;
    private String clueText;

    //Constructor for creating a new Interactable object
    public Interactable(UUID interactableID, String description,
                        boolean isHighlighted, String clueText)
    {
        this.interactableID = interactableID;
        this.description = description;
        this.isHighlighted = isHighlighted;
        this.clueText = clueText;
    }

    public UUID getInteractableID() {
        return interactableID;
    } 

    public String getDescription() {
        return description;
    }

    public boolean getIsHighlighted() {
        return isHighlighted;
    }

    public String getClueText() {
        return clueText;
    }

    public void highlight()
    {
    
    }

    public void interact()
    {

    }

    public void playSoundEffect(int num)
    {
        SoundEffect.play(num);
    }

    public String toString()
    {
        return interactableID.toString() + ": " + description;
    }

    /*
    public static void main(String[] args)
    {
        Interactable i = new Interactable("a","a",true,"a");
        i.playSoundEffect(2);
    } */
}