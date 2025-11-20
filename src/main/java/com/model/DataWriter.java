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

        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();
        for(int i = 0; i < userList.size(); ++i)
            jsonUsers.add(getUserJSON(userList.get(i)));

        try (FileWriter file = new FileWriter(TEMP_USER_FILE_NAME)) {
            file.append(jsonUsers.toJSONString());
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
            characterJSON.put(NUM_HINTS_USED, character.getNumHintsUsed());
            characterJSON.put(HINTS_USED, writeHintsUsed(character));
            characterJSON.put(PUZZLES_COMPLETED, writePuzzlesCompleted(character));
            characterJSON.put(TIMER, writeTimer(character));
            characterJSON.put(CHARACTER_DIFFICULTY, character.getDifficulty().toString());
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
    private static JSONObject writeHintsUsed(Character character) {
        JSONObject hintsUsedJSON = new JSONObject();
        HashMap<UUID, Boolean> hintsUsed = character.getHintsUsed();
        for(HashMap.Entry<UUID, Boolean> entry : hintsUsed.entrySet()) {
            String key = entry.getKey().toString();
            Boolean value = entry.getValue();
            hintsUsedJSON.put(key, value);
        }
        return hintsUsedJSON;
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
        recordJSON.put(SCORE, user.getPersonalRecord().getScore());
        return recordJSON;
    }



    public static void main(String args[]) {
        
       DataLoader.getUsers();
        /*
        for(User user : users)
        System.out.println(user + "\n");
        
        ArrayList<Room> rooms = DataLoader.getRooms();
        for(Room room : rooms)
            System.out.println(room);
        */

        saveUsers();
    }
    
}
