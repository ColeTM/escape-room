package com.model;

public abstract class DataConstants {

    // data constants for user
    protected static final String TEMP_USER_FILE_NAME = "src/main/java/com/json/users_temp.json";
    protected static final String USER_FILE_NAME = "src/main/java/com/json/users.json";
    protected static final String USER_ID = "userID";
    protected static final String FIRST_NAME = "firstName";
    protected static final String LAST_NAME = "lastName";
    protected static final String EMAIL = "email";
    protected static final String USERNAME = "username";
    protected static final String PASSWORD = "password";
    protected static final String SKILL_LEVEL = "skillLevel";
    protected static final String CHARACTERS = "characters";
        // data constants for nested characters JSON
        protected static final String CHARACTER_NAME = "name";
        protected static final String INVENTORY = "inventory";
            // data constants for nested inventory JSON
            protected static final String ITEM_NAME = "name";
            protected static final String ITEM_DESCRIPTION = "description";
        protected static final String CURRENT_ROOM = "currentRoom";
        protected static final String USER_HINTS_USED = "hintsUsed";
        protected static final String PUZZLES_COMPLETED = "puzzlesCompleted";
        protected static final String TIMER = "timer";
            // data constants for nested timer JSON
            protected static final String TIME_REMAINING = "timeRemaining";
            protected static final String INITIAL_TIME = "initialTime";
            protected static final String IS_RUNNING = "isRunning";
    protected static final String RECORD = "personalRecord";
        // data constants for nested personal record JSON
        protected static final String RECORD_USER_ID = "userID";
        protected static final String TIME = "time";
        protected static final String DATE = "date";
        protected static final String RECORD_HINTS_USED = "hintsUsed";
        protected static final String RECORD_DIFFICULTY = "difficulty";

    // data constants for room
    protected static final String TEMP_ROOM_FILE_NAME = "src/main/java/com/json/rooms_temp.json";
    protected static final String SAMPLE_ROOM_FILE_NAME = "src/main/java/com/json/sample_rooms.json";
    protected static final String ROOM_FILE_NAME = "src/main/java/com/json/rooms.json";
    protected static final String ROOM_ID = "roomID";
    protected static final String STORY = "story";
    protected static final String BACKGROUND = "background";
    protected static final String INTERACTABLES = "interactables";
        // data constants for nested interactables JSON
        protected static final String INTERACTABLE_ID = "interactableID";
        protected static final String INTERACTABLE_NAME = "interactableName";
        protected static final String INTERACTABLE_DESCRIPTION = "description";
        protected static final String IS_HIGHLIGHTED = "isHighlighted";
        protected static final String SOUND_EFFECT = "soundEffect";
        protected static final String INTERACTABLE_CLUE = "clueText";
    protected static final String PUZZLES = "puzzles";
        // data constants for nested puzzles JSON
        protected static final String TYPE = "type";
        protected static final String PUZZLE_ID = "puzzleID";
        protected static final String PUZZLE_DIFFICULTY = "difficulty";
        protected static final String ATTEMPTS = "attempts";
        protected static final String CLUE = "clue";
            // data constants for nested clue JSON
            protected static final String CLUE_ID = "clueID";
            protected static final String CLUE_TEXT = "text";
            protected static final String CLUE_PICTURE = "picture";
        protected static final String HINTS = "hints";
            // data constants for nested hints JSON
            protected static final String HINT_ID = "hintID";
            protected static final String HINT_TEXT = "text";
            protected static final String HAS_PICTURE = "hasPicture";
            protected static final String HINT_PICTURE = "picture";
            protected static final String HINT_LEVEL = "level";
            protected static final String TIME_PENALTY = "timePenalty";
        protected static final String ROOM_HINTS_USED = "hintsUsed";
        protected static final String IS_SEQUENTIAL = "isSequential";
        // different content and solution attributes for child classes of puzzle
        protected static final String TEXT_CONTENT = "textContent";
        protected static final String TEXT_SOLUTION = "textSolution";
        protected static final String AUDIO_CONTENT = "audioContent";
        protected static final String AUDIO_SOLUTION = "audioSolution";
        protected static final String PICTURE_CONTENT = "pictureContent";
        protected static final String PICTURE_SOLUTION = "pictureSolution";
}
