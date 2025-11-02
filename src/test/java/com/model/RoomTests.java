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

    @BeforeEach
    public void setup() {
        testRoomID = UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85");
        testRoomName = "Hallway";
        testStory = "You find yourself in a long, narrow hallway.";
        testBackground = new File("src/docs/Hallway.png");
        testInteractables = new ArrayList<>();
        testPuzzles = new ArrayList<>();
        testRoom = new Room(testRoomID, testRoomName, testStory, testBackground, testInteractables, testPuzzles);
    }

    @AfterEach
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

    @Test 
    public void TestNameWithSpecialCharacters(){
        testRoom.setName("Room#&$&$*@");
        assertEquals("Room#&$&$*@", testRoom.getName());
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

    //Test Story 

    @Test
    public void TestValidStory(){
        testRoom.setStory("This is a test story for the room.");
        assertEquals("This is a test story for the room.", testRoom.getStory());
    }

    @Test
    public void TestStoryWithNull(){
        testRoom.setStory(null);
        assertNull(testRoom.getStory());
    }   

    @Test
    public void TestStoryWithEmptyString(){
        testRoom.setStory("");
        assertEquals("", testRoom.getStory());
    }

    @Test
    public void TestStoryWithSpaces(){
        testRoom.setStory("     ");
        assertEquals("     ", testRoom.getStory());
    }

    @Test
    public void TestStoryWithSpecialCharacters(){
        testRoom.setStory("Story!@#$%^&*()_+");
        assertEquals("Story!@#$%^&*()_+", testRoom.getStory());
    }

    @Test
    public void TestStoryLongerThanExpected(){
        String longStory = "This is a very long story. ".repeat(50);
        testRoom.setStory(longStory);
        assertEquals(longStory, testRoom.getStory());
    }

    @Test 
    public void TestStoryWithNewLines(){
        String storyWithNewLines = "This is line one.\nThis is line two.\nThis is line three.";
        testRoom.setStory(storyWithNewLines);
        assertEquals(storyWithNewLines, testRoom.getStory());
    }

    //Test Background

    @Test
    public void TestValidBackground(){
        File newBackground = new File("src/docs/Library.png");
        testRoom.setBackground(newBackground);
        assertEquals(newBackground, testRoom.getBackground());
    }

    @Test
    public void TestBackgroundWithNull(){
        testRoom.setBackground(null);
        assertNull(testRoom.getBackground());
    }

    @Test 
    public void TestBackgroundWithNonExistentFile(){
        File nonExistentFile = new File("src/docs/NonExistent.png");
        testRoom.setBackground(nonExistentFile);
        assertEquals(nonExistentFile, testRoom.getBackground());
    }

    @Test 
    public void TestMultipleBackgroundChanges(){
        File firstBackground = new File("src/docs/First.png");
        File secondBackground = new File("src/docs/Second.png");
        testRoom.setBackground(firstBackground);
        assertEquals(firstBackground, testRoom.getBackground());
        testRoom.setBackground(secondBackground);
        assertEquals(secondBackground, testRoom.getBackground());
    }

    //Test Interactables
    @Test
    public void TestInteractablesWithValidList(){
        ArrayList<Interactable> interactables = new ArrayList<>();
        UUID interactableID = UUID.randomUUID();
        Interactable item = new Interactable(interactableID, "key", "A golden key", true, null, true);
        interactables.add(item);
        testRoom.setInteractables(interactables);
        assertEquals(1, testRoom.getInteractables().size());
    }

    @Test
    public void TestInteractablesWithNull(){
        testRoom.setInteractables(null);
        assertNull(testRoom.getInteractables());
    }

    @Test
    public void TestInteractablesWithEmptyList(){
        ArrayList<Interactable> interactables = new ArrayList<>();
        testRoom.setInteractables(interactables);
        assertEquals(0, testRoom.getInteractables().size());
    }

    @Test
    public void TestInteractablesWithMultipleItems(){
        ArrayList<Interactable> interactables = new ArrayList<>();
        interactables.add(new Interactable(UUID.randomUUID(), "key", "A golden key", true, null, true));
        interactables.add(new Interactable(UUID.randomUUID(), "book", "An old book", false,"The book seems ancient.", false));
        testRoom.setInteractables(interactables);
        assertEquals(2, testRoom.getInteractables().size());
    }

    //Test Puzzles
    @Test
    public void TestPuzzlesWithValidList(){
        ArrayList<Puzzle> puzzles = new ArrayList<>();
        Puzzle puzzle = new TextPuzzle(UUID.randomUUID(), "Test Puzzle", Difficulty.Beginner, 0, null, new ArrayList<>(), true, "What is 2+2?", "4"); 
        puzzles.add(puzzle);
        testRoom.setPuzzles(puzzles);
        assertEquals(1, testRoom.getPuzzles().size());

    }

    @Test
    public void TestPuzzlesWithNull(){
        testRoom.setPuzzles(null);
        assertNull(testRoom.getPuzzles());
    }

    @Test
    public void TestPuzzlesWithEmptyList(){
        ArrayList<Puzzle> puzzles = new ArrayList<>();
        testRoom.setPuzzles(puzzles);
        assertEquals(0, testRoom.getPuzzles().size());
    }

    //Test MoveRoom
    //Running into NullPointerException error when testing moveRoom
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
