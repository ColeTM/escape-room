package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class HallwayController {
    
    @FXML
    private Button puzzleLight;
    @FXML
    private Button puzzleLibrary;
    @FXML
    private Button puzzleBox;
    @FXML
    private Button inventoryButton;
    @FXML
    private Pane inventory;
    @FXML
    private Button pause;
    @FXML
    private Text lockedText;
    @FXML
    private ImageView lock1;
    @FXML
    private ImageView lock2;
    @FXML
    private Button closeInventoryButton;
    @FXML
    private Button inventorySlotOne;
    @FXML
    private Button inventorySlotTwo;
    @FXML
    private Button inventorySlotThree;
    @FXML
    private ImageView inventorySlotOnePicture;
    @FXML
    private ImageView inventorySlotTwoPicture;
    @FXML
    private ImageView inventorySlotThreePicture;

    @FXML
    public void initialize() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.setRoom(UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85"));
        escapeRoom.setCurrentPuzzle(null);
        lock1.setVisible(escapeRoom.getCurrentCharacter().getItem("key 1") == null || !escapeRoom.getCurrentCharacter().getItem("key 1").getIsUsed());
        lock2.setVisible(escapeRoom.getCurrentCharacter().getItem("key 2") == null || !escapeRoom.getCurrentCharacter().getItem("key 2").getIsUsed());
        lockedText.setVisible(false);
        inventory.setVisible(false);

        /*if (!escapeRoom.getCurrentCharacter().getInventory().isEmpty()) {
            inventorySlotOnePicture.setImage(new Image(getClass().getResource(escapeRoom.getCurrentCharacter().getInventory().get(0).getImagePath()).toExternalForm()));
            if (escapeRoom.getCurrentCharacter().getInventory().size() > 1) {
                inventorySlotTwoPicture.setImage(new Image(getClass().getResource(escapeRoom.getCurrentCharacter().getInventory().get(1).getImagePath()).toExternalForm()));
                if (escapeRoom.getCurrentCharacter().getInventory().size() > 2)
                    inventorySlotThreePicture.setImage(new Image(getClass().getResource(escapeRoom.getCurrentCharacter().getInventory().get(2).getImagePath()).toExternalForm()));
            }
        }*/
       loadInventoryItems();
    }

    @FXML
    void goToLibraryPuzzle() throws IOException {
        App.setRoot("library");
    }

    @FXML
    void goToBoxPuzzle() throws IOException {
        App.setRoot("box_room");
    }

    @FXML
    void goToFinalPuzzle() throws IOException {
        /* commenting out for ease of testing
        
        if (lock1.isVisible() || lock2.isVisible())
            lockedText.setVisible(true);
        else
        */
            App.setRoot("final_puzzle");
    }
    @FXML
    void switchToPause() throws IOException {
        App.setRoot("pause");
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
    private void loadInventoryItems() {
        inventorySlotOnePicture.setImage(null);
        inventorySlotTwoPicture.setImage(null);
        inventorySlotThreePicture.setImage(null);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        var character = escapeRoom.getCurrentCharacter();

        if (character == null) return;
        var items = character.getInventory();
        int size = items.size();
        for (int i = 0; i < size; i++) {
            var item = items.get(i);

            if (item.getImagePath() != null) {
                try {
                    Image img = new Image(getClass().getResourceAsStream(item.getImagePath()));
                    switch (i) {
                        case 0 -> inventorySlotOnePicture.setImage(img);
                        case 1 -> inventorySlotTwoPicture.setImage(img);
                        case 2 -> inventorySlotThreePicture.setImage(img);
                    }
                } catch (Exception e) {
                    System.out.println("Failed to load: " + item.getImagePath());
                }
            }
        }
    }
}
