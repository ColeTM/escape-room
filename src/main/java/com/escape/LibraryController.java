package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;

public class LibraryController {

    @FXML
    private Button backLibrary;
    @FXML
    private Button backOnBook;
    @FXML
    private Rectangle blackBook;
    @FXML
    private Rectangle blueBook;
    @FXML
    private Button closeInventoryButton;
    @FXML
    private Rectangle greenBook;
    @FXML
    private Label hintLabel;
    @FXML
    private Button hintLibrary;
    @FXML
    private Button inventoryLibrary;
    @FXML
    private Label libraryTimer;
    @FXML
    private Pane inventory;
    @FXML
    private Pane bookPane;
    @FXML
    private Button pauseLibrary;
    @FXML
    private Rectangle puzzleLibrary;
    @FXML
    private Rectangle redBook;
    @FXML
    private GridPane gridInventory;
    @FXML
    private ImageView inventoryImage1;
    @FXML
    private ImageView inventoryImage2;
    @FXML
    private ImageView inventoryImage3;
    @FXML
    private Button inventorySlot1;
    @FXML
    private Button inventorySlot2;
    @FXML
    private Button inventorySlot3;


    @FXML
    public void initialize() {
        inventory.setVisible(false);
        bookPane.setVisible(false);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.setRoom(UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171"));
        escapeRoom.setCurrentPuzzle(escapeRoom.getCurrentRoom().getPuzzles().get(0));
    }

    @FXML
    void backToLibrary() throws IOException {
        bookPane.setVisible(false);

    }

    @FXML
    void goToHallwayFromLibrary() throws IOException {
        App.setRoot("main_hallway");
    }
    @FXML
    void flashlightPage(ActionEvent event) throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getItem("flashlight") == null) {
            return;
        }
        App.setRoot("flashlight");
    }

    @FXML
    void key1Page(ActionEvent event) throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getItem("key 1") == null) {
            return;
        }
        App.setRoot("key1");
    }

    @FXML
    void key2Page(ActionEvent event) throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getItem("key 2") == null) {
            return;
        }
        App.setRoot("key2");
    }

    @FXML
    void goToInventory() {
        inventory.setVisible(true);
        loadInventoryItems();
    }

    @FXML
    void closeInventory() {
        inventory.setVisible(false);
    }

    @FXML
    void goToPause() throws IOException {
        App.setRoot("pause");
    }

    @FXML
    void goToPuzzle() {

    }

    @FXML
    void highlightBlack() {
        blackBook.setOpacity(0.75);
    }

    @FXML
    void highlightBlue() {
        blueBook.setOpacity(0.6);
    }

    @FXML
    void highlightDesk() {
        puzzleLibrary.setOpacity(0.4);
    }

    @FXML
    void highlightGreen() {
        greenBook.setOpacity(0.5);
    }

    @FXML
    void highlightRed() {
        redBook.setOpacity(0.5);
    }

    @FXML
    void requestHint() {
        hintLabel.setText(EscapeRoom.getInstance().requestHint());
    }

    @FXML
    void showBlackBook() {
        bookPane.setVisible(true);
    }

    @FXML
    void showBlueBook() {
        bookPane.setVisible(true);
    }

    @FXML
    void showGreenBook() {
        bookPane.setVisible(true);
    }

    @FXML
    void showRedBook() {
        bookPane.setVisible(true);
    }

    @FXML
    void unhighlightBlack() {
        blackBook.setOpacity(0.0);
    }

    @FXML
    void unhighlightBlue() {
        blueBook.setOpacity(0.0);
    }

    @FXML
    void unhighlightDesk() {
        puzzleLibrary.setOpacity(0.0);
    }

    @FXML
    void unhighlightGreen() {
        greenBook.setOpacity(0.0);
    }

    @FXML
    void unhighlightRed() {
        redBook.setOpacity(0.0);
    }
    
    private void loadInventoryItems() {
        inventoryImage1.setImage(null);
        inventoryImage2.setImage(null);
        inventoryImage3.setImage(null);
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
                        case 0 -> inventoryImage1.setImage(img);
                        case 1 -> inventoryImage2.setImage(img);
                        case 2 -> inventoryImage3.setImage(img);
                    }
                } catch (Exception e) {
                    System.out.println("Failed to load: " + item.getImagePath());
                }
            }
        }
    }

}
