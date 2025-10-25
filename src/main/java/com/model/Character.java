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
        this.numHintsUsed = 0;
        // need to individually initialize all values for these two hash maps
        this.hintsUsed = initializeHints();
        this.puzzlesCompleted = initializePuzzles();
        this.timer = new Timer();
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

    public Hint requestHint() {

        // will have to hard code all hint scenarios
        switch(RoomList.getRoomByUUID(getCurrentRoom()).getName()) {
            
        }

        return null;
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

    public void setCurrentRoom(UUID roomID) {
        this.currentRoom = roomID;
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

    private HashMap<UUID, Boolean> initializeHints() {
        HashMap<UUID, Boolean> hintsUsed = new HashMap<>();
        hintsUsed.put(UUID.fromString("b18be69b-be68-4fb5-9bc4-2641bd58ce68"), false);
        hintsUsed.put(UUID.fromString("e24d25e1-ee56-47e5-8b8d-d4effbd18d23"), false);
        hintsUsed.put(UUID.fromString("0b63808f-20c5-4755-9cdf-72396bfe205e"), false);
        hintsUsed.put(UUID.fromString("be0a15dc-bfdb-49f4-807f-bd679a7f5dbd"), false);
        hintsUsed.put(UUID.fromString("9345822d-d48e-4f13-9d8c-dfbd70094050"), false);
        hintsUsed.put(UUID.fromString("6ad175b8-c795-4184-9602-5b347d7e0d31"), false);
        hintsUsed.put(UUID.fromString("298792c8-0160-4c5a-bb16-ca13199c22e6"), false);
        hintsUsed.put(UUID.fromString("e759b895-2cd7-4418-a6f2-53bdb3e2a4dc"), false);
        hintsUsed.put(UUID.fromString("10d91414-0424-43d1-825e-1a9f095685fd"), false);
        hintsUsed.put(UUID.fromString("e95d1da8-4444-4750-be49-630a5772f98b"), false);
        hintsUsed.put(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586"), false);
        hintsUsed.put(UUID.fromString("c2d4454b-8ce9-48d4-9734-49eee6168b23"), false);
        return hintsUsed;
    }

    private HashMap<UUID, Boolean> initializePuzzles() {
        HashMap<UUID, Boolean> puzzleMap = new HashMap<>();
        puzzleMap.put(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3"), false);
        puzzleMap.put(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"), false);
        puzzleMap.put(UUID.fromString("f6a8b2fa-a3f7-41ef-a622-dc116aa4a9bd"), false);
        puzzleMap.put(UUID.fromString("bee765a8-d881-4d3f-809b-9a91b8ace119"), false);
        puzzleMap.put(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379"), false);
        puzzleMap.put(UUID.fromString("0d5e7f35-f314-425d-9c0c-072295edee1e"), false);
        return puzzleMap;
    }
}