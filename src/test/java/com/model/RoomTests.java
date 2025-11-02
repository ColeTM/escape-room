package com.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach; 
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class RoomTests {
    private Room testRoom;
    private UUID testRoomID;
    private String testRoomName;
    private String testStory;
    private File testBackground;
    private ArrayList<Interactable> testInteractables;
    private ArrayList<Puzzle> testPuzzles;

    public void setup() {
        testRoomID = UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85");
        testRoomName = "Hallway";
        testStory = "You find yourself in a long, narrow hallway.";
        testBackground = new File("scr/docs/Hallway.png");
        testInteractables = new ArrayList<>();
        testPuzzles = new ArrayList<>();
        testRoom = new Room(testRoomID, testRoomName, testStory, testBackground, testInteractables, testPuzzles);
    }

    public void tearDown() {
        testRoom = null;
        testInteractables = null;
        testPuzzles = null;
    }

    //Test Constructor

    @Test
    public void TestCorrectConstructor(){
        Room room = new Room(testRoomID, "Library", "A dusty library", testBackground, testInteractables, testPuzzles);
        assertNotNull(room);
        assertEquals("Library", room.getName());
        assertEquals("A dusty library", room.getStory());
        assertEquals(testRoomID, room.getRoomID());
    }
    
    @Test
    public void TestRoomNameWithNull() {
        Room room = new Room(testRoomID, null, testStory, testBackground, testInteractables, testPuzzles);
        assertNull(room.getName());
    }

    @Test
    public void TestEmptyName() {
        Room room = new Room(testRoomID, "", testStory, testBackground, testInteractables, testPuzzles);
        assertEquals("", room.getName());
    }

    @Test 
    public void TestNullBackground() {
        Room room = new Room(testRoomID, testRoomName, testStory, null, testInteractables, testPuzzles);
        assertNull(room.getBackground());
    }

    @Test
    public void TestNullInteractables() {
        Room room = new Room(testRoomID, testRoomName, testStory, testBackground, null, testPuzzles);
        assertNull(room.getInteractables());
    }

    @Test
    public void TestNullPuzzles() {
        Room room = new Room(testRoomID, testRoomName, testStory, testBackground, testInteractables, null);
        assertNull(room.getPuzzles());
    }   

    @Test 
    public void TestConstructorWithPuzzlesAndInteractables() {
        ArrayList<Interactable> interactables = new ArrayList<>();
        ArrayList<Puzzle> puzzles = new ArrayList<>();
        Room room = new Room(testRoomID, testRoomName, testStory, testBackground, interactables, puzzles);
        assertNotNull(room);
        assertEquals(0, room.getInteractables().size());
        assertEquals(0, room.getPuzzles().size());
    }

    //Test on Name 

    @Test 
    public void testValidName(){
        testRoom.setName("Boxes");
        assertEquals("Boxes", testRoom.getName());
    }

    @Test 
    public void TestNameWithNull(){
        testRoom.setName(null);
        assertNull(testRoom.getName());
    }

    @Test 
    public void TestNameWithEmptyString(){
        testRoom.setName("");
        assertEquals("", testRoom.getName());
    }

    @Test 
    public void TestNameWithSpaces(){
        testRoom.setName("   ");
        assertEquals("   ", testRoom.getName());
    }
    //Test RoomID

    @Test
    public void TestValidRoomID(){
        UUID newID = UUID.randomUUID();
        testRoom.setRoomID(newID);
        assertEquals(newID, testRoom.getRoomID());
    }

    @Test
    public void TestRoomIDWithNull(){
        testRoom.setRoomID(null);
        assertNull(testRoom.getRoomID());
    }

    //Test MoveRoom
    @Test
    public void MoveRoomWithValidID(){
        UUID validRoomID = UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171");
        boolean result = testRoom.moveRoom(validRoomID);
        assertTrue(result);
    }

    @Test
    public void MoveRoomWithInvalidID(){
        UUID invalidRoomID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        boolean result = testRoom.moveRoom(invalidRoomID);
        assertFalse(result);
    }

    @Test 
    public void MoveRoomWithNullID(){
        boolean result = testRoom.moveRoom(null);
        assertFalse(result);
    }

    @Test 
    public void MoveMultipleRooms(){
        UUID firstRoomID = UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171");
        UUID secondRoomID = UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85");

        testRoom.moveRoom(firstRoomID);
        boolean result = testRoom.moveRoom(secondRoomID);
        assertTrue(result);
    }


}
