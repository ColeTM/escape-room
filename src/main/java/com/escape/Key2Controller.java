package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Key2Controller {

    @FXML
    private Button backButton;
    @FXML
    private Button useButton;
    @FXML
    private Label errorLabel;

    @FXML
    void exitItemScreen() throws IOException {
        switch (EscapeRoom.getInstance().getCurrentRoom().getRoomID().toString()) {
                case "26767fe2-e8b1-47c4-b4eb-5f9aec77fb85" -> App.setRoot("main_hallway");
                case "9aae693f-83a4-427e-9822-b150f44ba171" -> App.setRoot("library");
                case "a91b9a37-d41d-4d93-b553-895ffd04723a" -> App.setRoot("box_room");
                case "1030c684-0ceb-4f2b-a71e-f5846697d8d7" -> App.setRoot("final_puzzle");
        }
    }

    @FXML
    void useItem() throws IOException {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if (!escapeRoom.getCurrentRoom().getRoomID().toString().equals("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85")) {
            errorLabel.setText("this item has no use here");
            return;
        }
        escapeRoom.getCurrentCharacter().getPuzzlesCompleted().put(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"), true);
        escapeRoom.getCurrentCharacter().removeFromInventory("key 2");
        App.setRoot("main_hallway");
    }

}
