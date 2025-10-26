package com.model;

import java.util.UUID;
import javax.sound.sampled.*;

/**
 * Represents an object in a room that the user can interact with.
 * Each interactable has a unique ID, a description, a highlight status, an optional sound effect, and can provide a clue to the player.
 * @author ndmcginnis21
 */
public class Interactable
{
    private UUID interactableID;
    private String name;
    private String description;
    private boolean isHighlighted;
    private static SoundEffect soundEffect;
    private String clueText;
    private boolean isItem;

    /**
     * Constructs a new Interactable object.
     * @param interactableID The unique ID for the interactable.
     * @param description A text description of the object.
     * @param isHighlighted A boolean indicating if the object is highlighted.
     * @param clueText The clue text associated with the object.
     */    public Interactable(UUID interactableID, String name, String description,
                        boolean isHighlighted, String clueText, boolean isItem) {
        this.interactableID = interactableID;
        this.name = name;
        this.description = description;
        this.isHighlighted = isHighlighted;
        this.clueText = clueText;
        this.isItem = isItem;
    }
    /**
     * getter for interactable name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unique ID of the interactable object.
     * @return The UUID of this interactable.
     */
    public UUID getInteractableID() {
        return interactableID;
    } 

    /**
     * Gets the description of the interactable object.
     * @return The description of this interactable.
     */ 
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the interactable object is currently highlighted.
     * @return true if the object is highlighted, false otherwise.
     */
    public boolean getIsHighlighted() {
        return isHighlighted;
    }

    /**
     * Gets the clue text associated with this interactable object.
     * @return The clue text.
     */
    public String getClueText() {
        return clueText;
    }

    /**
     * Checks if this interactable object represents an item that can be picked up.
     * @return true if it is an item, false otherwise.
     */
    public boolean getIsItem() {
        return isItem;
    }

    /**
     * Sets whether this interactable object represents an item.
     * @param isItem true if it should be an item, false otherwise.
     */
    public void setIsItem(boolean isItem) {
        this.isItem = isItem;
    }

    /**
     * Highlights the interactable object.
     */
    public void highlight() {
    
    }

    /**
     * Performs the primary interaction with the object.
     */
    public void interact() {

    }

    /**
     * Plays a sound effect a specified number of times.
     * @param num The number of times to play the sound effect.
     */
    public void playSoundEffect(String file, int num) {
        SoundEffect.play(file, num);
    }

    /**
     * Returns a string representation of the interactable object.
     * @return A string containing the interactable's ID and description.
     */
    public String toString() {
        return name + ": " + description;
    }
}