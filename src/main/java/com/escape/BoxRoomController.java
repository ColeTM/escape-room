package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView inventorySlotOnePicture;
    @FXML
    private ImageView inventorySlotTwoPicture;
    @FXML
    private ImageView inventorySlotThreePicture;


    @FXML
    public void initialize() {
        inventory.setVisible(false);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.setRoom(UUID.fromString("a91b9a37-d41d-4d93-b553-895ffd04723a"));
        escapeRoom.setCurrentPuzzle(escapeRoom.getCurrentRoom().getPuzzles().get(0));
        puzzleText.setText(escapeRoom.getCurrentPuzzle().getClue().getText());  // this still needs to be styled
        hintLabel.setText("");
        incorrectLabel.setText("");

        if (!escapeRoom.getCurrentCharacter().getInventory().isEmpty()) {
            inventorySlotOnePicture.setImage(new Image(getClass().getResource(escapeRoom.getCurrentCharacter().getInventory().get(0).getImagePath()).toExternalForm()));
            if (escapeRoom.getCurrentCharacter().getInventory().size() > 1) {
                inventorySlotTwoPicture.setImage(new Image(getClass().getResource(escapeRoom.getCurrentCharacter().getInventory().get(1).getImagePath()).toExternalForm()));
                if (escapeRoom.getCurrentCharacter().getInventory().size() > 2)
                    inventorySlotThreePicture.setImage(new Image(getClass().getResource(escapeRoom.getCurrentCharacter().getInventory().get(2).getImagePath()).toExternalForm()));
            }
        }
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
    void submitAnswer() throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getPuzzlesCompleted().get(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82"))) {
            incorrectLabel.setText("you've already solved this puzzle!");
        } else if (EscapeRoom.getInstance().submitPuzzleAnswer(boxesAnswerText.getText())) {
            EscapeRoom.getInstance().getCurrentCharacter().addToInventory(new com.model.Item("key 2", "key obtained from completing the box room puzzle"));
            App.setRoot("correct_answer");
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
    void viewItemOne() throws IOException {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if (!escapeRoom.getCurrentCharacter().getInventory().isEmpty()) {
            switch (escapeRoom.getCurrentCharacter().getInventory().get(0).getName()) {
                case "flashlight" -> App.setRoot("flashlight");
                case "key 1" -> App.setRoot("key1");
                case "key 2" -> App.setRoot("key2");
            }
        }
    }

    @FXML
    void viewItemTwo() throws IOException {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if (escapeRoom.getCurrentCharacter().getInventory().size() > 1) {
            switch (escapeRoom.getCurrentCharacter().getInventory().get(1).getName()) {
                case "flashlight" -> App.setRoot("flashlight");
                case "key 1" -> App.setRoot("key1");
                case "key 2" -> App.setRoot("key2");
            }
        }
    }

    @FXML
    void viewItemThree() throws IOException{
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if (escapeRoom.getCurrentCharacter().getInventory().size() > 2) {
            switch (escapeRoom.getCurrentCharacter().getInventory().get(2).getName()) {
                case "flashlight" -> App.setRoot("flashlight");
                case "key 1" -> App.setRoot("key1");
                case "key 2" -> App.setRoot("key2");
            }
        }
    }

    
}
