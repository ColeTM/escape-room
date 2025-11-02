package com.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class RoomListTests {

    private RoomList roomList;
    private final String testRoomFile = "src/test/resources/testRooms.json";
    private UUID testRoomID1;
    private UUID testRoomID2;

    @BeforeEach
    public void setUp() {
        roomList = RoomList.getInstance();
        roomList.getRooms().clear();    

        testRoomID1 = UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85");
        testRoomID2 = UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171");

        roomList.addRoom(testRoomID1, "Hallway", "A long narrow hallway.", new File("hallway.png"), new ArrayList<>(), new ArrayList<>());
        roomList.addRoom(testRoomID2, "Library", "A quiet library filled with books.", new File("library.png"), new ArrayList<>(), new ArrayList<>());
    }

    @AfterEach
    public void tearDown() {
        roomList.getRooms().clear();
        roomList = null;
    }
    
    //Singleton Test
    @Test
    public void TestSingletonInstanceNotNull() {
        assertNotNull(roomList);
        assertSame(roomList, RoomList.getInstance());
    }

    @Test
    public void TestSingletonMultipleCallsReturnSameInstance() {
        RoomList firstInstance = RoomList.getInstance();
        RoomList secondInstance = RoomList.getInstance();

        assertSame(firstInstance, secondInstance);
    }


    //Test getRooms
    @Test 
    public void TestThatGetRoomsReturnList() {
        assertNotNull(RoomList.getRooms());
        assertTrue(RoomList.getRooms() instanceof ArrayList);
        
    }

    @Test
    public void TestGetRoomsSize() {
        assertEquals(2, RoomList.getRooms().size());
    }

    @Test 
    public void TestEmptyGetRooms() {
        roomList.getRooms().clear();
        assertEquals(0, RoomList.getRooms().size());
    }

    @Test
    public void TestGetRoomByUUIDWithValidID() {
        Room room = RoomList.getRoomByUUID(testRoomID1);
        assertNotNull(room);
        assertEquals("Hallway", room.getName());
    }

    //Test addRoom
    @Test
    public void TestAddRoomSuccessfully() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", "A room filled with boxes.", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        assertEquals(3, RoomList.getRooms().size());
    }

    @Test
    public void TestAddRoomVerifyNameAndStory() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", "A room filled with boxes.", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        Room addedRoom = RoomList.getRoomByUUID(newRoomID);

        assertEquals("Boxes", addedRoom.getName());
        assertEquals("A room filled with boxes.", addedRoom.getStory());
        assertEquals(3, RoomList.getRooms().size());
    }

    @Test
    public void TestAddRoomWithNullName() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, null, "A room filled with boxes.", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        Room addedRoom = RoomList.getRoomByUUID(newRoomID);

        assertNull(addedRoom.getName());
    }

    @Test
    public void TestAddRoomWithEmptyName() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "", "A room filled with boxes.", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        Room addedRoom = RoomList.getRoomByUUID(newRoomID);

        assertEquals("", addedRoom.getName());
    }   

    @Test 
    public void TestAddRoomWithNullStroy() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", null, new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        Room addedRoom = RoomList.getRoomByUUID(newRoomID);

        assertNull(addedRoom.getStory());
    }

    @Test 
    public void TestAddRoomWithEmptyStory() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", "", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        Room addedRoom = RoomList.getRoomByUUID(newRoomID);

        assertEquals("", addedRoom.getStory());
    }

    @Test 
    public void TestAddRoomWithNullBackground() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", "A room filled with boxes.", null, new ArrayList<>(), new ArrayList<>());

        Room addedRoom = RoomList.getRoomByUUID(newRoomID);

        assertNull(addedRoom.getBackground());
    }

    @Test
    public void TestAddRoomWithNullInteractablesAndPuzzles() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", "A room filled with boxes.", new File("BoxRoom.png"), null, null);

        Room addedRoom = RoomList.getRoomByUUID(newRoomID);

        assertNull(addedRoom.getInteractables());
        assertNull(addedRoom.getPuzzles());
    }

    @Test
    public void TestAddTwoRooms() {
        UUID newRoomID1 = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        UUID newRoomID2 = UUID.fromString("b12b9a37-d41d-4d93-b553-895ffd04723b");

        roomList.addRoom(newRoomID1, "Boxes", "A room filled with boxes.", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());
        roomList.addRoom(newRoomID2, "Garden", "A beautiful garden.", new File("HauntedHouse.png"), new ArrayList<>(), new ArrayList<>());

        assertEquals(4, RoomList.getRooms().size());
    }

    @Test 
    public void TestAddRoomToEmptyRoomList() {
        roomList.getRooms().clear();

        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", "A room filled with boxes.", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        assertEquals(1, RoomList.getRooms().size());
    }

    //Test getRoomByUUID
    @Test
    public void TestGetFirstRoomByUUID() {
        Room room = RoomList.getRoomByUUID(testRoomID1);
        assertNotNull(room);
        assertEquals("Hallway", room.getName());
        assertEquals(testRoomID1, room.getRoomID());
    }

    @Test 
    public void TestGetSecondRoomByUUID() {
        Room room = RoomList.getRoomByUUID(testRoomID2);
        assertNotNull(room);
        assertEquals("Library", room.getName());
        assertEquals(testRoomID2, room.getRoomID());
    }

    @Test
    public void TestGetRoomByUUIDWithInvalidID() {
        UUID invalidID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        Room room = RoomList.getRoomByUUID(invalidID);
        assertNull(room);
    }

    @Test
    public void TestGetRoomByUUIDWithNullID() {
        Room room = RoomList.getRoomByUUID(null);
        assertNull(room);
    }

    @Test
    public void TestGetRoomByUUIDAfterAddingNewRoom() {
        UUID newRoomID = UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a");
        roomList.addRoom(newRoomID, "Boxes", "A room filled with boxes.", new File("BoxRoom.png"), new ArrayList<>(), new ArrayList<>());

        Room room = RoomList.getRoomByUUID(newRoomID);
        assertNotNull(room);
        assertEquals("Boxes", room.getName());
     }

    
}
