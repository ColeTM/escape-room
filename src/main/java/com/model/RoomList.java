package com.model;

import java.util.UUID;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
/*
 * author: Nick Hippchen
 * Class that holds a list of rooms
 */
public class RoomList {
    private ArrayList<Room> rooms;
    private static RoomList roomList;
    
    public RoomList() {
        rooms = new ArrayList<Room>();
    }

    public static RoomList getInstance() {
        if (roomList == null) {
            roomList = new RoomList();
        }
        return roomList;
    }

    public void addRoom(UUID id, BufferedImage background, ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {
        Room room = new Room(id, background, interactables, puzzles);
        rooms.add(room);
    }

    public void saveRoom() {
        //save room to datawriter
    }
}
