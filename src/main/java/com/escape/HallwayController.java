package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button inventory;
    @FXML
    private Button pause;
    @FXML
    private Text lockedText;
    @FXML
    private ImageView lock1;
    @FXML
    private ImageView lock2;

    @FXML
    public void initialize() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        lock1.setVisible(!escapeRoom.getCurrentCharacter().getPuzzlesCompleted().get(UUID.fromString("e50b53c7-6bbf-4849-af1a-350adb9afcf3")));
        lock2.setVisible(!escapeRoom.getCurrentCharacter().getPuzzlesCompleted().get(UUID.fromString("6c9f6273-be95-470d-8d43-5792c7737c82")));
        lockedText.setVisible(false);
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
    void goToPause() throws IOException {
        App.setRoot("pause");
    }
}
