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
    private boolean isItem;

    //Constructor for creating a new Interactable object
    public Interactable(UUID interactableID, String description,
                        boolean isHighlighted, String clueText, boolean isItem) {
        this.interactableID = interactableID;
        this.description = description;
        this.isHighlighted = isHighlighted;
        this.clueText = clueText;
        this.isItem = isItem;
    }

    //the UUID for the interactable object
    public UUID getInteractableID() {
        return interactableID;
    } 

    //a description of the object (ex: "a blue book")
    public String getDescription() {
        return description;
    }

    /**
    * true/false if the interactable object will be highlighted for the user
    * (easier to spot or hidden in the room)
    */
    public boolean getIsHighlighted() {
        return isHighlighted;
    }

    /**
     * clues the user on what the interactable is used for
     * ex: "One of the keys to the final room!"
     */
    public String getClueText() {
        return clueText;
    }

    /**
     * true/false if the interactable object is an item that can be stored in the user's inventory
     */
    public boolean getIsItem() {
        return isItem;
    }

    public void setIsItem(boolean isItem) {
        this.isItem = isItem;
    }

    public void highlight() {
    
    }

    public void interact() {

    }

    public void playSoundEffect(String file, int num) {
        SoundEffect.play(file, num);
    }

    public String toString() {
        return interactableID.toString() + ": " + description;
    }
}