package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents the user's character inside the game
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

    //Constructor for a new character
    public Character(String name)
    {
        this.name = name;
        this.inventory = new ArrayList<>();
        // need to individually initialize all values for these hash maps
        this.numHintsUsed = 0;
        this.hintsUsed = new HashMap<>();
        this.puzzlesCompleted = new HashMap<>();
    }

    public Character(String name, ArrayList<Item> inventory, UUID currentRoom, int numHintsUsed, 
                HashMap<UUID, Boolean> hintsUsed, HashMap<UUID, Boolean> puzzlesCompleted, Timer timer)
    {
        this.name = name;
        this.inventory = inventory;
        this.currentRoom = currentRoom;
        this.numHintsUsed = numHintsUsed;
        this.hintsUsed = hintsUsed;
        this.puzzlesCompleted = puzzlesCompleted;
        this.timer = timer;
    }

    public void saveCharacter()
    {

    }

    public void interact(Interactable interactable)
    {
        
    }

    public void addToInventory(Item item)
    {
        this.inventory.add(item);
    }

    public void removeFromInventory(Item item)
    {
        this.inventory.remove(item);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public UUID getCurrentRoom() {
        return this.currentRoom;
    }

    public int getNumHintsUsed() {
        return this.numHintsUsed;
    }

    public HashMap<UUID, Boolean> getHintsUsed() {
        return this.hintsUsed;
    }

    public HashMap<UUID, Boolean> getPuzzlesCompleted() {
        return this.puzzlesCompleted;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public String toString()
    {
        return "Character: " + name + " (Hints Used: " + hintsUsed + ")";
    }
}