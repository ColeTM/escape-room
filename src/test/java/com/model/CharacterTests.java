package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CharacterTests {
    private final ArrayList<Character> testCharacters = new ArrayList<>();
    private final ArrayList<Room> rooms = RoomList.getRooms();
    //private final ArrayList<Item> testItems = new ArrayList<>();

    @Before
    public void setup() {
        testCharacters.add(new Character("Mike", Difficulty.Intermediate));
    }

    @After
    public void tearDown() {
        testCharacters.clear();
    }

    // new constructor -- Character(String name, Difficulty difficulty)

    @Test
    public void emptyCharacterName() {
        Character ch = new Character("", Difficulty.Beginner);
        assertNotEquals("", ch.getName());
    }



    // interact(Interactable interactable)

    // addToInventory(Item item)

    @Test
    public void validAddItem() {
        Item item = new Item("banana", "a banana!");
        testCharacters.get(0).addToInventory(item);
        assertEquals(item, testCharacters.get(0).getInventory().get(0));
    }

    // removeFromInventory(Item item)

    @Test
    public void removeFirstItem() {
        Item key = new Item("key", "a gold key!");
        Item map = new Item("map", "a map of the house");
        Item flashlight = new Item("flashlight", "a bright flashlight");
        testCharacters.get(0).addToInventory(key);
        testCharacters.get(0).addToInventory(map);
        testCharacters.get(0).addToInventory(flashlight);
        testCharacters.get(0).removeFromInventory(key);
        assertFalse(testCharacters.get(0).getInventory().contains(key));
    }

    @Test
    public void removeMiddleItem() {
        Item key = new Item("key", "a gold key!");
        Item map = new Item("map", "a map of the house");
        Item flashlight = new Item("flashlight", "a bright flashlight");
        testCharacters.get(0).addToInventory(key);
        testCharacters.get(0).addToInventory(map);
        testCharacters.get(0).addToInventory(flashlight);
        testCharacters.get(0).removeFromInventory(map);
        assertFalse(testCharacters.get(0).getInventory().contains(map));
    }

    @Test
    public void removeLastItem() {
        Item key = new Item("key", "a gold key!");
        Item map = new Item("map", "a map of the house");
        Item flashlight = new Item("flashlight", "a bright flashlight");
        testCharacters.get(0).addToInventory(key);
        testCharacters.get(0).addToInventory(map);
        testCharacters.get(0).addToInventory(flashlight);
        testCharacters.get(0).removeFromInventory(flashlight);
        assertFalse(testCharacters.get(0).getInventory().contains(flashlight));
    }

    @Test
    public void removeItemNotInList() {
        Item key = new Item("key", "a gold key!");
        Item map = new Item("map", "a map of the house");
        Item flashlight = new Item("flashlight", "a bright flashlight");
        testCharacters.get(0).addToInventory(key);
        testCharacters.get(0).addToInventory(map);
        testCharacters.get(0).removeFromInventory(flashlight);
        assertEquals(testCharacters.get(0).getInventory().size(), 2);
    }

    @Test
    public void removeNullItem() {
        Item key = new Item("key", "a gold key!");
        Item map = new Item("map", "a map of the house");
        Item flashlight = new Item("flashlight", "a bright flashlight");
        testCharacters.get(0).addToInventory(key);
        testCharacters.get(0).addToInventory(map);
        testCharacters.get(0).addToInventory(flashlight);
        testCharacters.get(0).removeFromInventory(null);
        assertEquals(testCharacters.get(0).getInventory().size(), 3);
    }


    // requestHint()

    @Test
    public void getHintInHallway() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85"));
        testCharacters.get(0).requestHint();
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("b18be69b-be68-4fb5-9bc4-2641bd58ce68")));
    }

    @Test
    public void getFirstLibraryHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171"));
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("b18be69b-be68-4fb5-9bc4-2641bd58ce68")));
    }

    @Test
    public void getSecondLibraryHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171"));
        testCharacters.get(0).requestHint();
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("e24d25e1-ee56-47e5-8b8d-d4effbd18d23")));
    }

    @Test
    public void getFirstBoxesHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a"));
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("0b63808f-20c5-4755-9cdf-72396bfe205e")));
    }

    @Test
    public void getSecondBoxesHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a"));
        testCharacters.get(0).requestHint();
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("be0a15dc-bfdb-49f4-807f-bd679a7f5dbd")));
    }

    @Test
    public void getJigsawHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("c6b98566-e4e9-445c-8da2-9ef6b92ce815"));
        testCharacters.get(0).requestHint();
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586")));
    }

    @Test
    public void getMinesweeperHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("150c985e-0e90-4c28-bd96-e658b4bc1c20"));
        testCharacters.get(0).requestHint();
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586")));
    }

    @Test
    public void getFirstMorseCodeHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("150c985e-0e90-4c28-bd96-e658b4bc1c20"));
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379"), true);
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586")));
    }

    @Test
    public void getSecondMorseCodeHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("150c985e-0e90-4c28-bd96-e658b4bc1c20"));
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379"), true);
        testCharacters.get(0).requestHint();
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("c2d4454b-8ce9-48d4-9734-49eee6168b23")));
    }

    @Test
    public void getFirstWallMessageHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("1030c684-0ceb-4f2b-a71e-f5846697d8d7"));
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("9345822d-d48e-4f13-9d8c-dfbd70094050")));
    }

    @Test
    public void getSecondWallMessageHint() {
        testCharacters.get(0).setCurrentRoom(UUID.fromString("1030c684-0ceb-4f2b-a71e-f5846697d8d7"));
        testCharacters.get(0).requestHint();
        testCharacters.get(0).requestHint();
        assertTrue(testCharacters.get(0).getHintsUsed().get(UUID.fromString("6ad175b8-c795-4184-9602-5b347d7e0d31")));
    }


    // initializeHints()

    @Test
    public void checkFirstLibraryHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("b18be69b-be68-4fb5-9bc4-2641bd58ce68")));
    }

    @Test
    public void checkSecondLibraryHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("e24d25e1-ee56-47e5-8b8d-d4effbd18d23")));
    }

    @Test
    public void checkFirstBoxesHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("0b63808f-20c5-4755-9cdf-72396bfe205e")));
    }

    @Test
    public void checkSecondBoxesHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("be0a15dc-bfdb-49f4-807f-bd679a7f5dbd")));
    }

    @Test
    public void checkFirstMorseCodeHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("a40f6444-51e6-46da-bf39-f7d86c730586")));
    }

    @Test
    public void checkSecondMorseCodeHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("c2d4454b-8ce9-48d4-9734-49eee6168b23")));
    }

    @Test
    public void checkFirstWallMessageHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("9345822d-d48e-4f13-9d8c-dfbd70094050")));
    }

    @Test
    public void checkSecondWallMessageHint() {
        assertFalse(testCharacters.get(0).getHintsUsed().get(UUID.fromString("6ad175b8-c795-4184-9602-5b347d7e0d31")));
    }


    // initializePuzzles()

    @Test
    public void checkLibraryPuzzle() {
        assertFalse(testCharacters.get(0).getPuzzlesCompleted().get(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3")));
    }

    @Test
    public void checkBoxesPuzzle() {
        assertFalse(testCharacters.get(0).getPuzzlesCompleted().get(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82")));
    }

    @Test
    public void checkJigsawPuzzle() {
        assertFalse(testCharacters.get(0).getPuzzlesCompleted().get(UUID.fromString("bee765a8-d881-4d3f-809b-9a91b8ace119")));
    }

    @Test
    public void checkMinesweeperPuzzle() {
        assertFalse(testCharacters.get(0).getPuzzlesCompleted().get(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379")));
    }

    @Test
    public void checkMorseCodePuzzle() {
        assertFalse(testCharacters.get(0).getPuzzlesCompleted().get(UUID.fromString("0d5e7f35-f314-425d-9c0c-072295edee1e")));
    }

    @Test
    public void checkWallMessagePuzzle() {
        assertFalse(testCharacters.get(0).getPuzzlesCompleted().get(UUID.fromString("f6a8b2fa-a3f7-41ef-a622-dc116aa4a9bd")));
    }

    // getPercentage()

    @Test
    public void percentageNoPuzzlesCompleted() {
        assertEquals(0.0, testCharacters.get(0).getPercentage(), 0);
    }

    @Test
    public void percentageOnePuzzleCompleted() {
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3"), true);
        assertEquals((1.0 / 6.0) * 100.0, testCharacters.get(0).getPercentage(), 0);
    }

    @Test
    public void percentageTwoPuzzlesCompleted() {
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"), true);
        assertEquals((2.0 / 6.0) * 100.0, testCharacters.get(0).getPercentage(), 0);
    }

    @Test
    public void percentageThreePuzzlesCompleted() {
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("bee765a8-d881-4d3f-809b-9a91b8ace119"), true);
        assertEquals(50.0, testCharacters.get(0).getPercentage(), 0);
    }

    @Test
    public void PercentageFourPuzzlesCompleted() {
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("bee765a8-d881-4d3f-809b-9a91b8ace119"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379"), true);
        assertEquals((4.0 / 6.0) * 100.0, testCharacters.get(0).getPercentage(), 0);
    }

    @Test
    public void PercentageFivePuzzlesCompleted() {
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("bee765a8-d881-4d3f-809b-9a91b8ace119"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("0d5e7f35-f314-425d-9c0c-072295edee1e"), true);
        assertEquals((5.0 / 6.0) * 100.0, testCharacters.get(0).getPercentage(), 0);
    }

    @Test
    public void PercentageAllPuzzlesCompeted() {
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("bee765a8-d881-4d3f-809b-9a91b8ace119"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("56e5af6b-0295-48a9-b57e-b0670e025379"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("0d5e7f35-f314-425d-9c0c-072295edee1e"), true);
        testCharacters.get(0).getPuzzlesCompleted().put(UUID.fromString("f6a8b2fa-a3f7-41ef-a622-dc116aa4a9bd"), true);
        assertEquals(100.0, testCharacters.get(0).getPercentage(), 0);
    }

    
    // questionsAnswered()

    // hintsUsed()

    // calculateScore(Difficulty difficulty)

    // certificateOfCompletion(Difficulty difficulty)


    
}
