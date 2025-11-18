package com.escape;

import java.io.IOException;

import javafx.fxml.FXML;

public class SignUpController {

    @FXML
    private void register() throws IOException {
        // check for valid registration info
        
        switchToMainMenu();
    }

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("Main_menu");
    }

}