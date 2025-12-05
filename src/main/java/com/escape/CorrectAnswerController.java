package com.escape;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CorrectAnswerController {

    @FXML
    private Button continueButton;

    @FXML
    void goToHallway() throws IOException {
        App.setRoot("main_hallway");
    }

}
