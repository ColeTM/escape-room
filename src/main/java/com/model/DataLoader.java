package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < usersJSON.size(); ++i) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);

                UUID userID = UUID.fromString((String)userJSON.get(USER_ID));
                String firstName = (String)userJSON.get(FIRST_NAME);
                String lastName = (String)userJSON.get(LAST_NAME);
                String email = (String)userJSON.get(EMAIL);
                String username = (String)userJSON.get(USERNAME);
                String password = (String)userJSON.get(PASSWORD);
                Difficulty skillLevel = (Difficulty)userJSON.get(SKILL_LEVEL);
                ArrayList<Character> characters = getCharacters((JSONArray)userJSON.get(CHARACTERS));
                LeaderboardEntry personalRecord = getPersonalRecord((JSONObject)userJSON.get(RECORD));

                users.add(new User(userID, firstName, lastName, email, username, password,
                                    skillLevel, characters, personalRecord));
            }
            return users;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    private static ArrayList<Character> getCharacters(JSONArray charactersJSON) {
        ArrayList<Character> characters = new ArrayList<Character>();

        for(int i = 0; i < charactersJSON.size(); ++i) {
            JSONObject characterJSON = (JSONObject)charactersJSON.get(i);

            UUID characterID = UUID.fromString((String)characterJSON.get(CHARACTER_ID));
            ArrayList<Item> inventory = getInventory((JSONArray)characterJSON.get(INVENTORY));
            UUID currentRoom = UUID.fromString((String)characterJSON.get(CURRENT_ROOM));
            int hintsUsed = ((Long)characterJSON.get(USER_HINTS_USED)).intValue();
            HashMap<UUID, Boolean> puzzlesCompleted 
                        = getPuzzlesCompleted((JSONObject)characterJSON.get(PUZZLES_COMPLETED));
            Timer timer = getTimer((JSONObject)characterJSON.get(TIMER));

            characters.add(new Character(characterID, inventory, currentRoom,
                                        hintsUsed, puzzlesCompleted, timer));
        }
        return characters;        
    }

    private static ArrayList<Item> getInventory(JSONArray inventoryJSON) {
        ArrayList<Item> inventory = new ArrayList<Item>();

        for(int i = 0; i < inventoryJSON.size(); ++i) {
            JSONObject itemJSON = (JSONObject)inventoryJSON.get(i);

            UUID itemID = UUID.fromString((String)itemJSON.get(ITEM_ID));
            String name = (String)itemJSON.get(ITEM_NAME);
            String description = (String)itemJSON.get(ITEM_DESCRIPTION);

            inventory.add(new Item(itemID, name, description));
        }
        return inventory;
    }

    private static Timer getTimer(JSONObject timerJSON) {
        double timeRemaining = ((Double)timerJSON.get(TIME_REMAINING)).doubleValue();
        double initialTime = ((Double)timerJSON.get(INITIAL_TIME)).doubleValue();
        boolean isRunning = (boolean)timerJSON.get(IS_RUNNING);
        
        return new Timer(timeRemaining, initialTime, isRunning);
    }
    
    private static LeaderboardEntry getPersonalRecord(JSONObject recordJSON) {
        UUID userID = UUID.fromString((String)recordJSON.get(RECORD_USER_ID));
        String time = (String)recordJSON.get(TIME);
        String date = (String)recordJSON.get(DATE);
        int hintsUsed = ((Long)recordJSON.get(RECORD_HINTS_USED)).intValue();
        Difficulty difficulty = (Difficulty)recordJSON.get(RECORD_DIFFICULTY);

        return new LeaderboardEntry(userID, time, date, hintsUsed, difficulty);
    }

    private static HashMap<UUID, Boolean> getPuzzlesCompleted(JSONObject completedJSON) {
        HashMap<UUID, Boolean> puzzlesCompleted = new HashMap<>();
        for(Object keyObject : completedJSON.keySet()) {
            String key = (String)keyObject;
            UUID puzzleID = UUID.fromString(key);
            Boolean completed = (Boolean)completedJSON.get(key);
            puzzlesCompleted.put(puzzleID, completed);
        }
        return puzzlesCompleted;
    }
}
