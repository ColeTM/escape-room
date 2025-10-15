package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * writes the data to a json file
 * @author coletm
 */
public class DataWriter extends DataConstants{

    @SuppressWarnings("unchecked")
    public static void saveUsers() {

        /* start test values

        ArrayList<User> userList = new ArrayList<>();
        User testUser = new User("bobby", "brown", "bobby@gmail.com",
                                    "kingbobby123", "strongpassword");
        userList.add(testUser);


        end test values */

        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();
        for(int i = 0; i < userList.size(); ++i)
            jsonUsers.add(getUserJSON(userList.get(i)));

        try (FileWriter file = new FileWriter(TEMP_USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    private static JSONObject getUserJSON(User user) {
        JSONObject userJSON = new JSONObject();
        userJSON.put(USER_ID, user.getUserID().toString());
        userJSON.put(FIRST_NAME, user.getFirstName());
        userJSON.put(LAST_NAME, user.getLastName());
        userJSON.put(EMAIL, user.getEmail());
        userJSON.put(USERNAME, user.getUsername());
        userJSON.put(PASSWORD, user.getPassword());
        userJSON.put(SKILL_LEVEL, user.getSkillLevel().toString());
        userJSON.put(CHARACTERS, writeCharacters(user));
        userJSON.put(RECORD, writePersonalRecord(user));

        return userJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONArray writeCharacters(User user) {
        JSONArray charactersJSON = new JSONArray();
        for(Character character : user.getCharacters()) {
            JSONObject characterJSON = new JSONObject();
            characterJSON.put(CHARACTER_NAME, character.getName());
            characterJSON.put(INVENTORY, writeInventory(character));
            characterJSON.put(CURRENT_ROOM, character.getCurrentRoom().toString());
            characterJSON.put(USER_HINTS_USED, character.getHintsUsed());
            characterJSON.put(PUZZLES_COMPLETED, writePuzzlesCompleted(character));
            characterJSON.put(TIMER, writeTimer(character));
            charactersJSON.add(characterJSON);
        }
        return charactersJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONArray writeInventory(Character character) {
        JSONArray inventoryJSON = new JSONArray();
        for(Item item : character.getInventory()) {
            JSONObject itemJSON = new JSONObject();
            itemJSON.put(ITEM_NAME, item.getName());
            itemJSON.put(ITEM_DESCRIPTION, item.getDescription());
            inventoryJSON.add(itemJSON);
        }
        return inventoryJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONObject writePuzzlesCompleted(Character character) {
        JSONObject completedJSON = new JSONObject();
        HashMap<UUID, Boolean> puzzlesCompleted = character.getPuzzlesCompleted();
        for(HashMap.Entry<UUID, Boolean> entry : puzzlesCompleted.entrySet()) {
            String key = entry.getKey().toString();
            Boolean value = entry.getValue();
            completedJSON.put(key, value);
        }
        return completedJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONObject writeTimer(Character character) {
        JSONObject timerJSON = new JSONObject();
        timerJSON.put(TIME_REMAINING, character.getTimer().getTimeRemaining());
        timerJSON.put(INITIAL_TIME, character.getTimer().getInitialTime());
        timerJSON.put(IS_RUNNING, character.getTimer().getIsRunning());
        return timerJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONObject writePersonalRecord(User user) {
        if(user.getPersonalRecord() == null)
            return null;
        JSONObject recordJSON = new JSONObject();
        recordJSON.put(USERNAME, user.getUsername());
        recordJSON.put(TIME, user.getPersonalRecord().getTime().toString());
        recordJSON.put(DATE, user.getPersonalRecord().getDate().toString());
        recordJSON.put(RECORD_HINTS_USED, user.getPersonalRecord().getHintsUsed());
        recordJSON.put(RECORD_DIFFICULTY, user.getPersonalRecord().getDifficulty().toString());
        return recordJSON;
    }


    @SuppressWarnings("unchecked")
    public static void saveRooms() {

        RoomList rooms = RoomList.getInstance();
        ArrayList<Room> roomList = rooms.getRooms();
        JSONArray jsonRooms = new JSONArray();
        for (int i = 0; i < roomList.size(); ++i)
            jsonRooms.add(getRoomJSON(roomList.get(i)));

        try (FileWriter file = new FileWriter(TEMP_ROOM_FILE_NAME)) {
            file.write(jsonRooms.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static JSONObject getRoomJSON(Room room) {
        JSONObject roomJSON = new JSONObject();
        roomJSON.put(ROOM_ID, room.getRoomID().toString());
        roomJSON.put(STORY, room.getStory());
        roomJSON.put(BACKGROUND, room.getBackground().getName());
        roomJSON.put(INTERACTABLES, writeInteractables(room));
        roomJSON.put(PUZZLES, writePuzzles(room));
        return roomJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONArray writeInteractables(Room room) {
        JSONArray interactablesJSON = new JSONArray();
        for (Interactable interactable : room.getInteractables()) {
            JSONObject interactableJSON = new JSONObject();
            interactableJSON.put(INTERACTABLE_ID, interactable.getInteractableID().toString());
            interactableJSON.put(INTERACTABLE_DESCRIPTION, interactable.getDescription());
            interactableJSON.put(IS_HIGHLIGHTED, interactable.getIsHighlighted());
            interactableJSON.put(INTERACTABLE_CLUE, interactable.getClueText());
            interactablesJSON.add(interactableJSON);
        }
        return interactablesJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONArray writePuzzles(Room room) {
        JSONArray puzzlesJSON = new JSONArray();
        for (Puzzle puzzle : room.getPuzzles()) {
            JSONObject puzzleJSON = new JSONObject();
            String type = puzzle.getType();
            puzzleJSON.put(TYPE, type);
            puzzleJSON.put(PUZZLE_ID, puzzle.getPuzzleID().toString());
            puzzleJSON.put(PUZZLE_DIFFICULTY, puzzle.getDifficulty().toString());
            puzzleJSON.put(ATTEMPTS, puzzle.getAttempts());
            puzzleJSON.put(CLUE, writeClue(puzzle));
            puzzleJSON.put(HINTS, writeHints(puzzle));
            puzzleJSON.put(ROOM_HINTS_USED, writeHintsUsed(puzzle));
            puzzleJSON.put(IS_SEQUENTIAL, puzzle.getIsSequential());
            switch(type) {
                case "text":
                    puzzleJSON.put(TEXT_CONTENT, puzzle.getContent());
                    puzzleJSON.put(TEXT_SOLUTION, puzzle.getSolution());
                    break;
                case "audio":
                    puzzleJSON.put(AUDIO_CONTENT, puzzle.getContent());
                    puzzleJSON.put(AUDIO_SOLUTION, (int)puzzle.getSolution());
                    break;
                case "picture":
                    puzzleJSON.put(PICTURE_CONTENT, puzzle.getContent());
                    puzzleJSON.put(PICTURE_SOLUTION, (char)puzzle.getSolution());
            }
            puzzlesJSON.add(puzzleJSON);
        }
        return puzzlesJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONObject writeClue(Puzzle puzzle) {
        JSONObject clueJSON = new JSONObject();
        clueJSON.put(CLUE_ID, puzzle.getClue().getClueID().toString());
        clueJSON.put(CLUE_TEXT, puzzle.getClue().getText());
        clueJSON.put(CLUE_PICTURE, puzzle.getClue().getPicture().getName());
        return clueJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONArray writeHints(Puzzle puzzle) {
        JSONArray hintsJSON = new JSONArray();
        for(Hint hint : puzzle.getHints()) {
            JSONObject hintJSON = new JSONObject();
            hintJSON.put(HINT_ID, hint.getHintID().toString());
            hintJSON.put(HINT_TEXT, hint.getText());
            hintJSON.put(HAS_PICTURE, hint.getHasPicture());
            if(hint.getHasPicture())
                hintJSON.put(HINT_PICTURE, hint.getPicture().getName());
            else
                hintJSON.put(HINT_PICTURE, null);
            hintJSON.put(HINT_LEVEL, hint.getLevel().toString());
            hintJSON.put(TIME_PENALTY, hint.getText());
            hintsJSON.add(hintJSON);
        }
        return hintsJSON;
    }

    @SuppressWarnings("unchecked")
    private static JSONObject writeHintsUsed(Puzzle puzzle) {
        JSONObject hintsUsedJSON = new JSONObject();
        HashMap<UUID, Boolean> hintsUsed = puzzle.getHintsUsed();
        for(HashMap.Entry<UUID, Boolean> entry : hintsUsed.entrySet()) {
            String key = entry.getKey().toString();
            Boolean value = entry.getValue();
            hintsUsedJSON.put(key, value);
        }
        return hintsUsedJSON;
    }


    public static void main(String args[]) {

        ArrayList<User> users = DataLoader.getUsers();
        for(User user : users)
            System.out.println(user + "\n");

        ArrayList<Room> rooms = DataLoader.getRooms();
        for(Room room : rooms)
            System.out.println(room);

        saveUsers();
        saveRooms();
    }
    
}
