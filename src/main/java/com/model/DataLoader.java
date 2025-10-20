package com.model;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * creates all of the user and room classes for the escape room
 * @author coletm
 */
public class DataLoader extends DataConstants {
    
    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

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
                Difficulty skillLevel = Difficulty.valueOf((String)userJSON.get(SKILL_LEVEL));
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
        ArrayList<Character> characters = new ArrayList<>();

        for(int i = 0; i < charactersJSON.size(); ++i) {
            JSONObject characterJSON = (JSONObject)charactersJSON.get(i);

            String name = (String)characterJSON.get(CHARACTER_NAME);
            ArrayList<Item> inventory = getInventory((JSONArray)characterJSON.get(INVENTORY));
            UUID currentRoom = UUID.fromString((String)characterJSON.get(CURRENT_ROOM));
            int hintsUsed = ((Long)characterJSON.get(USER_HINTS_USED)).intValue();
            HashMap<UUID, Boolean> puzzlesCompleted 
                        = getPuzzlesCompleted((JSONObject)characterJSON.get(PUZZLES_COMPLETED));
            Timer timer = getTimer((JSONObject)characterJSON.get(TIMER));

            characters.add(new Character(name, inventory, currentRoom,
                                        hintsUsed, puzzlesCompleted, timer));
        }
        return characters;        
    }

    private static ArrayList<Item> getInventory(JSONArray inventoryJSON) {
        ArrayList<Item> inventory = new ArrayList<>();

        for(int i = 0; i < inventoryJSON.size(); ++i) {
            JSONObject itemJSON = (JSONObject)inventoryJSON.get(i);

            String name = (String)itemJSON.get(ITEM_NAME);
            String description = (String)itemJSON.get(ITEM_DESCRIPTION);

            inventory.add(new Item(name, description));
        }
        return inventory;
    }

    private static Timer getTimer(JSONObject timerJSON) {
        double timeRemaining = ((Double)timerJSON.get(TIME_REMAINING));
        boolean isRunning = (boolean)timerJSON.get(IS_RUNNING);
        
        return new Timer(timeRemaining, isRunning);
    }

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static LeaderboardEntry getPersonalRecord(JSONObject recordJSON) {
        if(recordJSON == null)
            return null;
        String username = (String)recordJSON.get(USERNAME);
        Duration time = Duration.parse((String)recordJSON.get(TIME));
        LocalDate date = LocalDate.parse((String)recordJSON.get(DATE), formatter);
        int hintsUsed = ((Long)recordJSON.get(RECORD_HINTS_USED)).intValue();
        Difficulty difficulty = Difficulty.valueOf((String)recordJSON.get(RECORD_DIFFICULTY));

        return new LeaderboardEntry(username, time, date, hintsUsed, difficulty);
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


    @SuppressWarnings({"UseSpecificCatch", "CallToPrintStackTrace"})
    public static ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<>();

        try {
            FileReader reader = new FileReader(SAMPLE_ROOM_FILE_NAME);
            JSONArray roomsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < roomsJSON.size(); ++i) {
                JSONObject roomJSON = (JSONObject)roomsJSON.get(i);

                UUID roomID = UUID.fromString((String)roomJSON.get(ROOM_ID));
                String story = (String)roomJSON.get(STORY);
                File background = new File((String)roomJSON.get(BACKGROUND));
                ArrayList<Interactable> interactables = getInteractables((JSONArray)roomJSON.get(INTERACTABLES));
                ArrayList<Puzzle> puzzles = getPuzzles((JSONArray)roomJSON.get(PUZZLES));

                rooms.add(new Room(roomID, story, background, interactables, puzzles));
            }
            return rooms;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    private static ArrayList<Interactable> getInteractables(JSONArray interactablesJSON) {
        ArrayList<Interactable> interactables = new ArrayList<>();

        for(int i = 0; i < interactablesJSON.size(); ++i) {
            JSONObject interactableJSON = (JSONObject)interactablesJSON.get(i);

            UUID interactableID = UUID.fromString((String)interactableJSON.get(INTERACTABLE_ID));
            String description = (String)interactableJSON.get(INTERACTABLE_DESCRIPTION);
            boolean isHighlighted = (boolean)interactableJSON.get(IS_HIGHLIGHTED);
            String clue = (String)interactableJSON.get(INTERACTABLE_CLUE);

            interactables.add(new Interactable(interactableID, description, isHighlighted, clue));
        }
        return interactables;
    }

    private static ArrayList<Puzzle> getPuzzles(JSONArray puzzlesJSON) {
        ArrayList<Puzzle> puzzles = new ArrayList<>();

        for(int i = 0; i < puzzlesJSON.size(); ++i) {
            JSONObject puzzleJSON = (JSONObject)puzzlesJSON.get(i);

            UUID puzzleID = UUID.fromString((String)puzzleJSON.get(PUZZLE_ID));
            Difficulty difficulty = Difficulty.valueOf((String)puzzleJSON.get(PUZZLE_DIFFICULTY));
            int attempts = ((Long)puzzleJSON.get(ATTEMPTS)).intValue();
            Clue clue = getClue((JSONObject)puzzleJSON.get(CLUE));
            ArrayList<Hint> hints = getHints((JSONArray)puzzleJSON.get(HINTS));
            HashMap<UUID, Boolean> hintsUsed = getHintsUsed((JSONObject)puzzleJSON.get(ROOM_HINTS_USED));
            boolean isSequential = (boolean)puzzleJSON.get(IS_SEQUENTIAL);
            Type type = Type.valueOf((String)puzzleJSON.get(TYPE));

            switch(type) {
                case Text:
                    String textContent = (String)puzzleJSON.get(TEXT_CONTENT);
                    String textSolution = (String)puzzleJSON.get(TEXT_SOLUTION);
                    puzzles.add(new TextPuzzle(puzzleID, difficulty, attempts, clue, hints,
                                            hintsUsed, isSequential, textContent, textSolution));
                    break;
                case Audio:
                    String audioContent = (String)puzzleJSON.get(AUDIO_CONTENT);
                    int audioSolution = ((Long)puzzleJSON.get(AUDIO_SOLUTION)).intValue();
                    puzzles.add(new AudioPuzzle(puzzleID, difficulty, attempts, clue, hints,
                                            hintsUsed, isSequential, audioContent, audioSolution));
                    break;
                case Picture:
                    File pictureContent = new File((String)puzzleJSON.get(PICTURE_CONTENT));
                    char pictureSolution = (char)puzzleJSON.get(PICTURE_SOLUTION);
                    puzzles.add(new PicturePuzzle(puzzleID, difficulty, attempts, clue, hints,
                                            hintsUsed, isSequential, pictureContent, pictureSolution));
            }
        }
        return puzzles;
    }

    private static Clue getClue(JSONObject clueJSON) {
        UUID clueID = UUID.fromString((String)clueJSON.get(CLUE_ID));
        String text = (String)clueJSON.get(CLUE_TEXT);
        File picture = new File((String)clueJSON.get(CLUE_PICTURE));

        return new Clue(clueID, text, picture);    
    }

    private static ArrayList<Hint> getHints(JSONArray hintsJSON) {
        ArrayList<Hint> hints = new ArrayList<>();

        for(int i = 0; i < hintsJSON.size(); ++i) {
            JSONObject hintJSON = (JSONObject)hintsJSON.get(i);

            UUID hintID = UUID.fromString((String)hintJSON.get(HINT_ID));
            String text = (String)hintJSON.get(HINT_TEXT);
            boolean hasPicture = (boolean)hintJSON.get(HAS_PICTURE);
            File picture;
            if(hasPicture)
                picture = new File((String)hintJSON.get(HINT_PICTURE));
            else
                picture = null;
            HintLevel level = HintLevel.valueOf((String)hintJSON.get(HINT_LEVEL));
            double timePenalty = (Double)hintJSON.get(TIME_PENALTY);

            hints.add(new Hint(hintID, text, hasPicture, picture, level, timePenalty));
        }
        return hints;
    }

    private static HashMap<UUID, Boolean> getHintsUsed(JSONObject hintsUsedJSON) {
        HashMap<UUID, Boolean> hintsUsed = new HashMap<>();
        for(Object keyObject : hintsUsedJSON.keySet()) {
            String key = (String)keyObject;
            UUID hintID = UUID.fromString(key);
            Boolean used = (Boolean)hintsUsedJSON.get(key);
            hintsUsed.put(hintID, used);
        }
        return hintsUsed;
    }

    

    public static void main(String args[]) {
        ArrayList<User> users = getUsers();
        for(User user : users)
            System.out.println(user + "\n");

        ArrayList<Room> rooms = getRooms();
        for(Room room : rooms)
            System.out.println(room);
    }


}