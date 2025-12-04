package com.escape;

import java.util.UUID;

import com.model.EscapeRoom;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class BoxRoomController {

    @FXML
    private Button boxesAnswerButton;
    @FXML
    private TextField boxesAnswerText;
    @FXML
    private Button boxesBack;
    @FXML
    private Button boxesHint;
    @FXML
    private Button boxesInventory;
    @FXML
    private Button boxesPause;
    @FXML
    private Label boxesTimer;
    @FXML
    private Button closeInventoryButton;
    @FXML
    private Label hintLabel;
    @FXML
    private Label incorrectLabel;
    @FXML
    private Pane inventory;
    @FXML
    private Button inventorySlotOne;
    @FXML
    private Button inventorySlotTwo;
    @FXML
    private Button inventorySlotThree;
    @FXML
    private Label puzzleText;


    @FXML
    public void initialize() {
        inventory.setVisible(false);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.setRoom(UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a"));
        escapeRoom.setCurrentPuzzle(escapeRoom.getCurrentRoom().getPuzzles().get(0));
        puzzleText.setText(escapeRoom.getCurrentPuzzle().getClue().getText());  // this still needs to be styled
        hintLabel.setText("");
        incorrectLabel.setText("");
    }

    @FXML
    void openInventory() {
        inventory.setVisible(true);
    }

    @FXML
    void closeInventory() {
        inventory.setVisible(false);
    }

    @FXML
    void requestHint() {
        hintLabel.setText(EscapeRoom.getInstance().requestHint());
    }

    @FXML
    void submitAnswer() {
        if (EscapeRoom.getInstance().submitPuzzleAnswer(boxesAnswerText.getText())) {
            // add key to inventory
            // switch to correct answer screen
        } else {
            incorrectLabel.setText("incorrect!");
            // potentially deduct time -- should probably be done in puzzle classes
        }


    }

    @FXML
    void switchToHallway() throws IOException {
        App.setRoot("main_hallway");
    }

    @FXML
    void switchToPause() throws IOException {
        App.setRoot("pause");
    }

    @FXML
    void viewItemOne() {
        // check if there is an item in slot then change to its info screen
    }

    @FXML
    void viewItemTwo() {
        // check if there is an item in slot then change to its info screen
    }

    @FXML
    void viewItemThree() {
        // check if there is an item in slot then change to its info screen
    }

}
