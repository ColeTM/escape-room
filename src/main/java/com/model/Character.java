package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Represents the player's in-game character, holding their progress and inventory.
 * A character is tied to a user account and tracks the current room, hints used, puzzles completed, and the game timer.
 * @author ndmcginnis21
 */
public class Character
{
    private String name;
    private ArrayList<Item> inventory;
    private UUID currentRoom;
    private int numHintsUsed;
    private HashMap<UUID, Boolean> hintsUsed;
    private HashMap<UUID, Boolean> puzzlesCompleted;
    private Timer timer;

/**
     * Constructs a new character with a given name.
     * Initializes inventory, hints used, and puzzles completed to empty states.
     * @param name The name of the character.
     */    
    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
        // need to individually initialize all values for these two hash maps
        this.numHintsUsed = 0;
        this.hintsUsed = new HashMap<>();
        this.puzzlesCompleted = new HashMap<>();
    }

    /**
     * Constructs a character from saved data.
     * Used for loading a game in progress.
     * @param name The name of the character.
     * @param inventory The character's inventory.
     * @param currentRoom The ID of the room the character is in.
     * @param numHintsUsed The number of hints the character has used.
     * @param hintsUsed A map of used hints.
     * @param puzzlesCompleted A map of completed puzzles.
     * @param timer The character's timer state.
     */
    public Character(String name, ArrayList<Item> inventory, UUID currentRoom, int numHintsUsed, 
                HashMap<UUID, Boolean> hintsUsed, HashMap<UUID, Boolean> puzzlesCompleted, Timer timer) {
        this.name = name;
        this.inventory = inventory;
        this.currentRoom = currentRoom;
        this.numHintsUsed = numHintsUsed;
        this.hintsUsed = hintsUsed;
        this.puzzlesCompleted = puzzlesCompleted;
        this.timer = timer;
    }

    /**
     * Saves the character's current state.
     */
    public void saveCharacter() {

    }

    /**
     * Allows the character to interact with an object in the room.
     * @param interactable The object to interact with.
     */
    public void interact(Interactable interactable) {
        
    }

    /**
     * Adds an item to the character's inventory.
     * @param item The item to add.
     */
    public void addToInventory(Item item) {
        this.inventory.add(item);
    }

    /**
     * Removes an item from the character's inventory.
     * @param item The item to remove.
     */
    public void removeFromInventory(Item item) {
        this.inventory.remove(item);
    }

    /**
     * Requests a hint for the current puzzle or situation.
     * (This method is a stub and needs to be implemented.)
     * @return A Hint object if a hint is available, otherwise null.
     */
    public Hint requestHint() {

        // will have to hard code all hint scenarios
        switch(RoomList.getRoomByUUID(getCurrentRoom()).getName()) {
            
        }

        return null;
    }

    /**
     * Gets the name of the character.
     * @return The character's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the character's inventory.
     * @return The list of items in the inventory.
     */
    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    /**
     * Gets the ID of the character's current room.
     * @return The UUID of the current room.
     */
    public UUID getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Gets the number of hints the character has used.
     * @return The total number of hints used.
     */
    public int getNumHintsUsed() {
        return this.numHintsUsed;
    }

    /**
     * Gets the map of used hints.
     * @return A map where keys are hint UUIDs and values are booleans indicating if they've been used.
     */
    public HashMap<UUID, Boolean> getHintsUsed() {
        return this.hintsUsed;
    }

    /**
     * Gets the map of completed puzzles.
     * @return A map where keys are puzzle UUIDs and values are booleans indicating if they're completed.
     */
    public HashMap<UUID, Boolean> getPuzzlesCompleted() {
        return this.puzzlesCompleted;
    }

    /**
     * Gets the timer for the character's game session.
     * @return The Timer object.
     */
    public Timer getTimer() {
        return this.timer;
    }

    /**
     * Returns a string representation of the character.
     * @return A string containing the character's name and the number of hints used.
     */
    public String toString() {
        return "Character: " + name + " (Hints Used: " + hintsUsed + ")";
    }
}