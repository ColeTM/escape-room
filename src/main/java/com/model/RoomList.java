package com.model;

import java.util.UUID;
import java.util.ArrayList;
//import java.awt.image.BufferedImage;
/*
 * author: Nick Hippchen
 * Class that holds a list of rooms
 */
public class RoomList {
    private ArrayList<Room> rooms;
    private static RoomList roomList;
    
    private RoomList() {
        rooms = new ArrayList<Room>();
    }

    public static RoomList getInstance() {
        if (roomList == null) {
            roomList = new RoomList();
        }
        return roomList;
    }
    
    /*public void addRoom(UUID id, BufferedImage background, ArrayList<Interactable> interactables, ArrayList<Puzzle> puzzles) {
        Room room = new Room(id, background, interactables, puzzles);
        rooms.add(room);
    }*/
    
    //Testing the uuid for the rooms
    public void addRoom(Room room) {
        rooms.add(room);
    }

    

    public void saveRoom() {
        //save room to datawriter
    }


    public static void main(String[] args) {
    RoomList roomList = RoomList.getInstance();

    Interactable inter1 = new Interactable("A desk", "desk.jpg", "This is a desk");
    Interactable inter2 = new Interactable("A chair", "chair.jpg", "This is a chair");

    Room room1 = new Room("A spooky room", "roomOne.jpg", );
    Room room2 = new Room("A abandoned pool");
    
    roomList.addRoom(room1);
    roomList.addRoom(room2);    

    System.out.println("Room 1 UUID: " + roomList.getRoomUUID(room1));
    System.out.println("Room 2 UUID: " + roomList.getRoomUUID(room2));
    }
}


