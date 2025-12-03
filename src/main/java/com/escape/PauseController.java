package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PauseController {

    
    @FXML
    private Button resumeButton;
    @FXML
    private Button saveandquit;
    @FXML
    private Button settingsButton;

    @FXML
    public void initialize() {
        // pause timer
    }

    @FXML
    void goToSettings() throws IOException {
        App.setRoot("Settings");
    }

    @FXML
    void resumeGame() throws IOException{
        if (EscapeRoom.getInstance().getCurrentCharacter().getCurrentRoom().equals(UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85")))
            App.setRoot("main_hallway");
        else if (EscapeRoom.getInstance().getCurrentCharacter().getCurrentRoom().equals(UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171")))
            App.setRoot("library");
        else if (EscapeRoom.getInstance().getCurrentCharacter().getCurrentRoom().equals(UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a")))
            App.setRoot("box_room");
        else if (EscapeRoom.getInstance().getCurrentCharacter().getCurrentRoom().equals(UUID.fromString("1030c684-0ceb-4f2b-a71e-f5846697d8d7")))
            App.setRoot("final_puzzle");

        // resume timer

    }

    @FXML
    void saveThenQuit() throws IOException {
        EscapeRoom.getInstance().saveCurrentGame();
        App.setRoot("Main_menu");
    }
    
}
