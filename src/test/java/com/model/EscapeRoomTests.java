package com.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import java.util.ArrayList;

public class EscapeRoomTests {
    private EscapeRoom escapeRoom;
    private final ArrayList<User> users = UserList.getInstance().getUsers();

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

    }

    // resumeGame(String characterName)

    // saveCurrentGame()

    // endGame()

    // registerUser(...)
    
    // login(String username, String password)

    // logout

    // submitPuzzleAnswer(Object solution)

    // requestHint()

    // getTimeRemaining()

    // displayLeaderboard()

    // showProgress()

    // setRoom(UUID roomID)
}
