package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewGameController {

    @FXML
    private Button beginButton;
    @FXML
    private Label difficultyError;
    @FXML
    private Button newGameBack;
    @FXML
    private ChoiceBox<?> saveDifficulty;
    @FXML
    private TextField saveName;
    @FXML
    private Label saveNameError;

    @FXML
    void beginButtonPressed() {

        // check that fields are filled and then switch to intro screen

    }

    @FXML
    void switchToMainMenu() throws IOException {
        App.setRoot("main_menu");
    }

}
