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

    public static void saveUsers() {

        // start test values

        ArrayList<User> userList = new ArrayList<>();
        User testUser = new User("bobby", "brown", "bobby@gmail.com",
                                    "kingbobby123", "strongpassword");
        userList.add(testUser);


        // end test values

        UserList users = UserList.getInstance();
        //ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();
        for(int i = 0; i < userList.size(); ++i) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(TEMP_USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static JSONObject getUserJSON(User user) {
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

    public static JSONArray writeCharacters(User user) {
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

    public static JSONArray writeInventory(Character character) {
        JSONArray inventoryJSON = new JSONArray();
        for(Item item : character.getInventory()) {
            JSONObject itemJSON = new JSONObject();
            itemJSON.put(ITEM_NAME, item.getName());
            itemJSON.put(ITEM_DESCRIPTION, item.getDescription());
            inventoryJSON.add(itemJSON);
        }
        return inventoryJSON;
    }

    public static JSONObject writePuzzlesCompleted(Character character) {
        JSONObject completedJSON = new JSONObject();
        HashMap<UUID, Boolean> puzzlesCompleted = character.getPuzzlesCompleted();
        for(HashMap.Entry<UUID, Boolean> entry : puzzlesCompleted.entrySet()) {
            String key = entry.getKey().toString();
            Boolean value = entry. getValue();
            completedJSON.put(key, value);
        }
        return completedJSON;
    }

    public static JSONObject writeTimer(Character character) {
        JSONObject timerJSON = new JSONObject();
        timerJSON.put(TIME_REMAINING, character.getTimer().getTimeRemaining());
        timerJSON.put(INITIAL_TIME, character.getTimer().getInitialTime());
        timerJSON.put(IS_RUNNING, character.getTimer().getIsRunning());
        return timerJSON;
    }

    public static JSONObject writePersonalRecord(User user) {
        if(user.getPersonalRecord() == null)
            return null;
        JSONObject recordJSON = new JSONObject();
        recordJSON.put(RECORD_USER_ID, user.getUserID().toString());
        recordJSON.put(TIME, user.getPersonalRecord().getTime().toString());
        recordJSON.put(DATE, user.getPersonalRecord().getDate().toString());
        recordJSON.put(RECORD_HINTS_USED, user.getPersonalRecord().getHintsUsed());
        recordJSON.put(RECORD_DIFFICULTY, user.getPersonalRecord().getDifficulty().toString());
        return recordJSON;
    }


    public static void main(String args[]) {
        saveUsers();
    }
    
}
