package com.model;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * a specific room in the escape room *needs documentation*
 * @author coletm
 */
public class Room {

    private UUID roomID;
    private String name;
    private String story;
    private File background;
    private ArrayList<Interactable> interactables;
    private ArrayList<Puzzle> puzzles;
    /**
     * constuctor for a room
     * @param roomID UUID - UUID of the room
     * @param name String - name of the room
     * @param story String - story/description of the room
     * @param background File - background of the room 
     * @param interactables ArrrayList<Interactable> - list of interactables in the room
     * @param puzzles ArrayList<Puzzle> - list of puzzles in the room
     */
    public Room(UUID roomID, String name, String story, File background,
                ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {

        this.roomID = roomID;
        this.story = story;
        this.background = background;
        this.interactables = interactables;
        this.puzzles = puzzles;
    }

    /**
     * Accessor for user's name 
     * @return String name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator for user's name
     * @param name String name of the user
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Accessor for room's UUID
     * @return UUID of the room
     */
    public UUID getRoomID() {
        return roomID;
    }

    /**
     * Mutator for room's UUID
     * @param id UUID of the room
     */
    public void setRoomID(UUID id) {
        this.roomID = id;
    }

    /**
     * Accessor for room's story/description
     * @return String story/description of the room
     */
    public String getStory() {
        return story;
    }

    /**
     * Mutator for room's story/description
     * @param story String story/description of the room
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * Accessor for room's background image
     * @return File background image of the room
     */
    public File getBackground() {
        return background;
    }

    /**
     * Mutator for room's background image
     * @param background File background image of the room
     */
    public void setBackground(File background) {
        this.background = background;
    }

    /**
     * Accessor for room's interactables
     * @return ArrayList<Interactable> list of interactables in the room
     */
    public ArrayList<Interactable> getInteractables() {
        return interactables;
    }

    /**
     * Mutator for room's interactables
     * @param interactables ArrayList<Interactable> list of interactables in the room
     */
    public void setInteractables(ArrayList<Interactable> interactables) {
        this.interactables = interactables;
    }

    /**
     * Accessor for room's puzzles
     * @return ArrayList<Puzzle> list of puzzles in the room
     */
    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    /**
     * Mutator for room's puzzles
     * @param puzzles ArrayList<Puzzle> list of puzzles in the room
     */
    public void setPuzzles(ArrayList<Puzzle> puzzles) {
        this.puzzles = puzzles;
    }

    /**
     * method to move to another room
     * @param roomID UUID of the room to move to
     * @return boolean true if the room was changed successfully, false otherwise
     */
    public boolean moveRoom(UUID roomID) {
        Room nextRoom = RoomList.getRoomByUUID(roomID);
        if (nextRoom != null) {
            //this.setRoomID = nextRoom;
            return true;
        }
        return false;
    }

    /**
     * to-string method printing the name and story for a room
     */
    public String toString() {
        return "Name: " + name +
                "\nstory: " + story;
    }
    
}
