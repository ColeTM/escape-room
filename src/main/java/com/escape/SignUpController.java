package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpController {
    
    @FXML
    private TextField registerFirstName;
    @FXML
    private TextField registerLastName;
    @FXML
    private TextField registerUsername;
    @FXML
    private TextField registerPassword;
    @FXML
    private TextField registerEmail;
    @FXML
    private TextField registerConfirmPassword;
    @FXML
    private Label registerErrorLabel;

    @FXML
    private void btnRegisterClicked() throws IOException {
        
        if(!passwordsMatch())
            return;
        
        EscapeRoom escapeRoom = EscapeRoom.getInstance();

        try {
            escapeRoom.registerUser(registerFirstName.getText(), registerLastName.getText(), registerEmail.getText(), registerUsername.getText(), registerPassword.getText());
        
            switchToMainMenu();
        } catch (IllegalArgumentException e) {
            registerErrorLabel.setText(e.getMessage());
        }
    }

    @FXML
    private boolean passwordsMatch() {
        if (!registerPassword.getText().equals(registerConfirmPassword.getText())) {
            registerErrorLabel.setText("passwords don't match");
            return false;
        }
        return true;
    }

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("Main_menu");
    }

}