package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;
import com.model.EscapeRoom;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField loginUsername;
    @FXML
    private TextField loginPassword;
    @FXML
    private Label loginErrorLabel;

    @FXML
    private void loginButtonClicked() throws IOException {
        
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        try {
            if (escapeRoom.login(loginUsername.getText(), loginUsername.getText())){
                switchToMainMenu();
            }
        } catch (IllegalArgumentException e) {
            loginErrorLabel.setText("Username or password incorrect");
        }
    }

    @FXML
    private void switchToLanding() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchToEntry() throws IOException {
        App.setRoot("Entry");
    }
    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("main_menu");
    }
}