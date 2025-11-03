package com.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EscapeRoomTests {
    private EscapeRoom escapeRoom;
    //private final ArrayList<User> users = UserList.getInstance().getUsers();

    @Before
    public void setup() {
        escapeRoom = EscapeRoom.getInstance();
    }

    @After
    public void tearDown() {

    }


    // startNewGame(String characterName)

    @Test
    public void validStartNewGame() {
        escapeRoom.login("hadenr61", "password61");
        assertTrue(escapeRoom.startNewGame("Haden2"));
    }

    @Test
    public void startNewGameEmptyCharacter() {
        escapeRoom.login("hadenr61", "password61");
        assertFalse(escapeRoom.startNewGame(""));
    }

    @Test
    public void startNewGameNullCharacter() {
        escapeRoom.login("hadenr61", "password61");
        assertFalse(escapeRoom.startNewGame(""));
    }

    @Test
    public void startNewGameExistingCharacter() {
        escapeRoom.login("hadenr61", "password61");
        assertFalse(escapeRoom.startNewGame("Haden"));
    }

    @Test
    public void startNewGameNullDifficulty() {
        escapeRoom.login("hadenr61", "password61");
        escapeRoom.setDifficulty(null);
        assertFalse(escapeRoom.startNewGame("Haden3"));
    }

    @Test
    public void startNewGameNotLoggedIn() {
        assertFalse(escapeRoom.startNewGame("Haden"));
    }


    // resumeGame(String characterName)

    @Test
    public void validResumeGame() {
        escapeRoom.login("hadenr61", "password61");
        assertTrue(escapeRoom.resumeGame("Haden"));
    }

    @Test
    public void resumeGameNotExist() {
        escapeRoom.login("hadenr61", "password61");
        assertFalse(escapeRoom.resumeGame("HADEN!!!"));
    }

    @Test
    public void resumeGameNotCaseSensitive() {
        escapeRoom.login("hadenr61", "password61");
        assertFalse(escapeRoom.resumeGame("haden"));
    }

    @Test
    public void resumeNullGame() {
        escapeRoom.login("hadenr61", "password61");
        assertFalse(escapeRoom.resumeGame(null));
    }

    @Test
    public void resumeGameNotLoggedIn() {
        assertFalse(escapeRoom.resumeGame("Haden"));
    }


    // endGame()

    @Test
    public void endGameNewRecord() {
        escapeRoom.login("markp3", "password3");
        escapeRoom.resumeGame("Mark");
        escapeRoom.endGame();
        boolean pass = escapeRoom.getCurrentUser().getSkillLevel().equals(Difficulty.Pro) &&
                        escapeRoom.getCurrentUser().getPersonalRecord().getScore() == 2440.0;
        assertTrue(pass);
    }

    @Test
    public void endGameNotNewRecord() {
        escapeRoom.login("hadenr61", "password61");
        escapeRoom.resumeGame("Haden");
        escapeRoom.endGame();
        assertEquals(693.6, escapeRoom.getCurrentUser().getPersonalRecord().getScore());
    }
    

    // login(String username, String password)

    @Test
    public void validLogin() {
        assertTrue(escapeRoom.login("markp3", "password3"));
    }

    @Test
    public void loginFirstUserInList() {
        assertTrue(escapeRoom.login("hadenr61", "password61"));
    }

    @Test
    public void loginLastUserInList() {
        assertTrue(escapeRoom.login("vicka59", "password59"));
    }

    @Test
    public void loginUsernameNotCaseSensitive() {
        assertTrue(escapeRoom.login("VICKA59", "password59"));
    }

    @Test
    public void loginNullUsername() {
        assertFalse(escapeRoom.login(null, "password61"));
    }

    @Test
    public void loginNullPassword() {
        assertFalse(escapeRoom.login("hadenr61", null));
    }

    @Test
    public void loginAlreadyLoggedIn() {
        escapeRoom.login("vicka59", "password59");
        escapeRoom.login("hadenr61", "password61");
        assertFalse(escapeRoom.getCurrentUser().getUsername().equals("hadenr61"));
    }

    
    // logout

    @Test
    public void testLogout() {
        escapeRoom.login("vicka59", "password59");
        assertTrue(escapeRoom.logout());
    }

    @Test
    public void logoutAlreadyLoggedOut() {
        assertTrue(escapeRoom.logout());
    }


    // submitPuzzleAnswer(Object solution)

    @Test
    public void correctPuzzleAnswer() {
        escapeRoom.login("vicka59", "password59");
        escapeRoom.resumeGame("Vick");
        escapeRoom.setCurrentPuzzle(RoomList.getRooms().get(5).getPuzzles().get(0));
        assertTrue(escapeRoom.submitPuzzleAnswer("echo"));
    }

    @Test
    public void incorrectPuzzleAnswer() {
        escapeRoom.login("vicka59", "password59");
        escapeRoom.resumeGame("Vick");
        escapeRoom.setCurrentPuzzle(RoomList.getRooms().get(5).getPuzzles().get(0));
        assertFalse(escapeRoom.submitPuzzleAnswer("your mom"));
    }

    @Test
    public void puzzleAnswerNotCaseSensitive() {
        escapeRoom.login("vicka59", "password59");
        escapeRoom.resumeGame("Vick");
        escapeRoom.setCurrentPuzzle(RoomList.getRooms().get(5).getPuzzles().get(0));
        assertTrue(escapeRoom.submitPuzzleAnswer("ECHO"));
    }

    @Test
    public void nullPuzzleAnswer() {
        escapeRoom.login("vicka59", "password59");
        escapeRoom.resumeGame("Vick");
        escapeRoom.setCurrentPuzzle(RoomList.getRooms().get(5).getPuzzles().get(0));
        assertFalse(escapeRoom.submitPuzzleAnswer(null));
    }

}
