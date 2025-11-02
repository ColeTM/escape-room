package com.model;

import java.util.UUID;
import java.util.ArrayList;
import java.io.File;
/*
 * author: Nick Hippchen
 * Class that holds a list of rooms
 */
public class RoomList {
    private ArrayList<Room> rooms;
    private static RoomList roomList;
    
    /* 
     * private constructor for room list using singleton pattern
     */
    private RoomList() {
        rooms = DataLoader.getRooms();
    }

    /*
     * Accessor for the single instance of RoomList
     * @return RoomList instance of RoomList 
     */
    public static RoomList getInstance() {
        if (roomList == null) {
            roomList = new RoomList();
        }
        return roomList;
    }

    /*
     * Accessor for the list of rooms
     * @return ArrayList<Room> list of rooms
     */
    public static ArrayList<Room> getRooms() {
        getInstance();
        return roomList.rooms;
    }
    
    /*
     * Method to add a room to the list
     * @param id UUID of the room
     * @param name String name of the room
     * @param story String story/description of the room
     * @param background File image of the room
     * @param interactables ArrayList<Interactable> list of interactables in the room
     * @param puzzles ArrayList<Puzzle> list of puzzles in the room
     */
    public void addRoom(UUID id, String name, String story, File background, ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {
        Room room = new Room(id, name, story, background, interactables, puzzles);
        rooms.add(room);
    }

    /*
     * Method to get a room by its UUID
     * @param roomID UUID of the room
     * @return Room room with the given UUID, or null if not found
     */
    public static Room getRoomByUUID(UUID roomID) {
        for (Room room : roomList.rooms) {
            if (room.getRoomID().equals(roomID))
                return room;
        }
        return null;
    }

    
    /* 
    public void saveRoom() {
    
    }*/
}


