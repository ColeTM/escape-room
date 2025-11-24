package com.escape;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LibraryController {

    @FXML
    private Button backLibrary;

    @FXML
    private Button blackBook;

    @FXML
    private Button blueBook;

    @FXML
    private Button greenBook;

    @FXML
    private Button hintLibrary;

    @FXML
    private Button inventoryLibrary;

    @FXML
    private Button pauseLibrary;

    @FXML
    private Button puzzleLibrary;

    @FXML
    private Button redBook;

     @FXML
    public void goToHallwayFromLibrary() throws IOException {
        App.setRoot("hallway");

    }

    @FXML
    public void goToInventory() throws IOException {
        //App.setRoot("inventory");

    }

    @FXML
    public void goToPause() throws IOException {
        //App.setRoot("pause_menu");

    }

    @FXML
    public void goToPuzzle() throws IOException {
        //App.setRoot("puzzle");

    }

    @FXML
    public void openClue() throws IOException {
        //App.setRoot("livrary_clue");

    }

    @FXML
    public void showBlueBook() throws IOException {
        //App.setRoot("blue_book");
    }

    @FXML
    public void showGreenBook() throws IOException {
        //App.setRoot("_book");
    }

    @FXML
    public void showRedBook() throws IOException {
        //App.setRoot("_book");
    }

    @FXML
    public void showBlackBook() throws IOException {
        //App.setRoot("_book");
    }
    
}
