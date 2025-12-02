package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class LibraryController {

    @FXML
    private Button backLibrary;
    @FXML
    private Rectangle blackBook;
    @FXML
    private Rectangle blueBook;
    @FXML
    private Rectangle greenBook;
    @FXML
    private Button hintLibrary;
    @FXML
    private Button inventoryLibrary;
    @FXML
    private Label libraryTimer;
    @FXML
    private Button pauseLibrary;
    @FXML
    private Rectangle puzzleLibrary;
    @FXML
    private Rectangle redBook;

    @FXML
    void goToHallwayFromLibrary() throws IOException {
        EscapeRoom.getInstance().setRoom(UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85"));
        App.setRoot("main_hallway");
    }

    @FXML
    void goToInventory() {

    }

    @FXML
    void goToPause() {

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
    void openClue() {

    }

    @FXML
    void showBlackBook() {

    }

    @FXML
    void showBlueBook() {

    }

    @FXML
    void showGreenBook() {

    }

    @FXML
    void showRedBook() {

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

}
