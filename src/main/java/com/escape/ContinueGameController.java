package com.escape;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ContinueGameController {

    @FXML
    private Button continueBack;
    @FXML
    private Button continueButton;
    @FXML
    private ChoiceBox<?> continueDropDown;
    @FXML
    private Label continueErrorLabel;

    @FXML
    void switchToIntro() {

        // make sure save has been selected, load it, and switch to intro

    }

    @FXML
    void switchToMainMenu() throws IOException {
        App.setRoot("main_menu");
    }

}
