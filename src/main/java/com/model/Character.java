package com.model;

import java.io.File;
import java.io.FileWriter;
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
    private Difficulty difficulty;

    /**
     * Constructs a new character with a given name.
     * Initializes inventory, hints used, and puzzles completed to empty states.
     * @param name The name of the character.
     * @param difficulty The difficulty level of the game.
     */    
    public Character(String name, Difficulty difficulty) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.numHintsUsed = 0;
        this.hintsUsed = initializeHints();
        this.puzzlesCompleted = initializePuzzles();
        this.timer = new Timer();
        this.difficulty = difficulty;
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
     * @param difficulty The difficulty level of the game.
     */
    public Character(String name, ArrayList<Item> inventory, UUID currentRoom, int numHintsUsed, 
                HashMap<UUID, Boolean> hintsUsed, HashMap<UUID, Boolean> puzzlesCompleted, Timer timer, Difficulty difficulty) {
        this.name = name;
        this.inventory = inventory;
        this.currentRoom = currentRoom;
        this.numHintsUsed = numHintsUsed;
        this.hintsUsed = hintsUsed;
        this.puzzlesCompleted = puzzlesCompleted;
        this.timer = timer;
        this.difficulty = difficulty;
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
     * Gets and returns the difficulty of the character's game.
     * @return The difficulty level of the game
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * Sets the difficulty of the character's game.
     * @param difficulty The difficulty level to set
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
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
    public void requestHint() {

        // will have to hard code all hint scenarios
        switch(RoomList.getRoomByUUID(getCurrentRoom()).getName()) {
            case "Hallway":
                System.out.println("no hint available!");
                break;
            case "Library":
                if (!hintsUsed.get(UUID.fromString("205642bd-8cfc-458d-8bc4-d5ff7886e1f4"))) {
                    System.out.println("You'll have to use the stories to piece together a message");
                    hintsUsed.put(UUID.fromString("205642bd-8cfc-458d-8bc4-d5ff7886e1f4"), true);
                } else if (!hintsUsed.get(UUID.fromString("e24d25e1-ee56-47e5-8b8d-d4effbd18d23"))) {
                    System.out.println("[book color, page number, line number, word number]");
                    hintsUsed.put(UUID.fromString("e24d25e1-ee56-47e5-8b8d-d4effbd18d23"), true);
                } else {
                    System.out.println("no hints available!");
                }
                break;
            case "Boxes":
                if (!hintsUsed.get(UUID.fromString("0b63808f-20c5-4755-9cdf-72396bfe205e"))) {
                    System.out.println("Box #2 is not empty");
                    hintsUsed.put(UUID.fromString("0b63808f-20c5-4755-9cdf-72396bfe205e"), true);
                } else if (!hintsUsed.get(UUID.fromString("be0a15dc-bfdb-49f4-807f-bd679a7f5dbd"))) {
                    System.out.println("The doll is in box #1");
                    hintsUsed.put(UUID.fromString("be0a15dc-bfdb-49f4-807f-bd679a7f5dbd"), true);
                } else {
                    System.out.println("no hints available!");
                }
                break;
            case "Jigsaw":
                System.out.println("no hints available!");
                break;
            case "Minesweeper and Morse Code":
                if (!puzzlesCompleted.get(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379"))) {
                    System.out.println("no hints available!");
                } else {
                    if (!hintsUsed.get(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586"))) {
                        System.out.println("dots are short; dashes are long");
                        hintsUsed.put(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586"), true);
                    } else if (!hintsUsed.get(UUID.fromString("c2d4454b-8ce9-48d4-9734-49eee6168b23"))) {
                        System.out.println("the gramophone is playing a message in Morse code");
                        hintsUsed.put(UUID.fromString("c2d4454b-8ce9-48d4-9734-49eee6168b23"), true);
                    } else {
                        System.out.println("no hints available!");
                    }
                }
                break;
            case "Wall Message":
                if (!hintsUsed.get(UUID.fromString("9345822d-d48e-4f13-9d8c-dfbd70094050"))) {
                    System.out.println("What can you hear in an empty room?");
                    hintsUsed.put(UUID.fromString("9345822d-d48e-4f13-9d8c-dfbd70094050"), true);
                } else if (!hintsUsed.get(UUID.fromString("6ad175b8-c795-4184-9602-5b347d7e0d31"))) {
                    System.out.println("It repeats what you say!");
                    hintsUsed.put(UUID.fromString("6ad175b8-c795-4184-9602-5b347d7e0d31"), true);
                } else {
                    System.out.println("no hints available!");
                }
                break;
        }
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

    public void setCurrentRoom(UUID roomID) {
        this.currentRoom = roomID;
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

    /**
     * initializes the hints used hash map with all false values for a new character
     */
    private HashMap<UUID, Boolean> initializeHints() {
        HashMap<UUID, Boolean> hintsUsed = new HashMap<>();
        hintsUsed.put(UUID.fromString("b18be69b-be68-4fb5-9bc4-2641bd58ce68"), false);
        hintsUsed.put(UUID.fromString("e24d25e1-ee56-47e5-8b8d-d4effbd18d23"), false);
        hintsUsed.put(UUID.fromString("0b63808f-20c5-4755-9cdf-72396bfe205e"), false);
        hintsUsed.put(UUID.fromString("be0a15dc-bfdb-49f4-807f-bd679a7f5dbd"), false);
        hintsUsed.put(UUID.fromString("9345822d-d48e-4f13-9d8c-dfbd70094050"), false);
        hintsUsed.put(UUID.fromString("6ad175b8-c795-4184-9602-5b347d7e0d31"), false);
        hintsUsed.put(UUID.fromString("10d91414-0424-43d1-825e-1a9f095685fd"), false);
        hintsUsed.put(UUID.fromString("e95d1da8-4444-4750-be49-630a5772f98b"), false);
        hintsUsed.put(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586"), false);
        hintsUsed.put(UUID.fromString("c2d4454b-8ce9-48d4-9734-49eee6168b23"), false);
        return hintsUsed;
    }

    /**
     * initializes the puzzles completed hash map with all false values for a new character
     */
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

    /**
     * gives game progress as a percentage based on how many puzzles have been completed
     * @return double -- the percentage fo the game completed
     */
    public double getPercentage() {
        int completed = 0;
        for (HashMap.Entry<UUID, Boolean> entry : this.puzzlesCompleted.entrySet()) {
            if (entry.getValue())
                completed++;
        }
        return (completed / 6.0) * 100.0;
    }

    /**
     * creates a string saying which puzzles have been completed
     * @return String -- each puzzle per room and whether it has been completed
     */
    public String questionsAnswered() {
        String ret = "Puzzles Completed:\n";
        for (Room room : RoomList.getRooms()) {
            for (Puzzle puzzle : room.getPuzzles()) {
                ret += puzzle.getName() + ": ";
                if (getPuzzlesCompleted().get(puzzle.getPuzzleID()))
                    ret += "Complete\n";
                else
                    ret += "Incomplete\n";
            }
        }
        return ret;
    }

    /**
     * creates a string saying which hints have been used
     * @return String -- a list of how many hints have been used for each puzzle
     */
    public String hintsUsed() {
        String ret = "Hints used:\n";
        for (Room room : RoomList.getRooms()) {
            for (Puzzle puzzle : room.getPuzzles()) {
                int completed = 0;
                for (Hint hint : puzzle.getHints()) {
                    if (getHintsUsed().get(hint.getHintID()))
                        completed++;
                }
                ret += puzzle.getName() + ": " + completed + "/" + puzzle.getHints().size() + " used\n";
            }
        }
        return ret;
    }

    /**
     * calculates the score for a completed game. 
     * score is time remaining in seconds, times 2 or 3 if the game difficulty
     * is intermediate or pro respectively, minus 5% for each hint used.
     * @param difficulty Difficulty -- the difficulty the game was beaten in
     * @return double -- the final score
     */
    public double calculateScore(Difficulty difficulty) {
        double score = timer.getTimeRemaining();
        if (difficulty.equals(Difficulty.Intermediate))
            score *= 2;
        else if (difficulty.equals(Difficulty.Pro))
            score *= 3;
        score *= 1 - (numHintsUsed * 0.05);
        return score;
    }

    /**
     * creates a certificate of completion for the player when they complete the game.
     * certificate is printed to a file called "certificate.txt"
     * @param difficulty Difficulty - the difficulty at which the game was completed
     */
    public void certificateOfCompletion(Difficulty difficulty) {
        try {
            FileWriter output = new FileWriter(new File("certificate.txt"));
            output.write("Escape Room - Certificate of Completion\n");
            output.write("\nThe Halloween ghosts hereby begrudgingly congratulate\n" + getName()  
                            + " for evading their clutches...\nbut they ask that you do not"
                            + " dare to return.\nEscaping alive won't be as easy next time.\n");
            output.write("\nHints Used: " + getNumHintsUsed());
            output.write("\nDifficulty: " + difficulty.toString());
            output.write("\nFinal Score: " + calculateScore(difficulty));
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}