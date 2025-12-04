package com.escape;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HallwayController {
    
    @FXML
    private Button puzzleLight;

    @FXML
    private Button puzzleLibrary;

    @FXML
    private Button puzzleBox;

    @FXML
    private Button inventory;

    @FXML
    private Button pause;

    @FXML
    private Label lockedText;

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
        App.setRoot("final_puzzle");
    }
    @FXML
    void goToPause() throws IOException {
        App.setRoot("pause");
    }
}
