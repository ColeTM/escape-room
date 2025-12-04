package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;
import com.model.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.fx.scene.control.Label;

public class LosingScreenController {
    
    @FXML
    private Button mainMenuButton;

    @FXML
    public void initialize() {
        Character ch = EscapeRoom.getInstance().getCurrentCharacter();
        EscapeRoom.getInstance().endGame();
    }

    @FXML
    void switchToMainMenu() throws IOException {
        EscapeRoom.getInstance();
        App.setRoot("Main_menu");
    }
}

