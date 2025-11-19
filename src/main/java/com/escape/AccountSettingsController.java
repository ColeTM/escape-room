package com.escape;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class AccountSettingsController {

    @FXML
    private Button accountSettingsBack;
    @FXML
    private Text changeEmail;
    @FXML
    private Text changePassword;
    @FXML
    private Text changeUsername;
    @FXML
    private Text deleteAccount;
    @FXML
    private Label emailLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label usernameLabel;


    // need method to set all labels when screen opens

    @FXML
    void changeEmail() {
        // open dialog to change email
    }

    @FXML
    void changePassword() {
        // open dialog to change password
    }

    @FXML
    void changeUsername() {
        // open dialog to change username
    }

    @FXML
    void deleteAccount() {
        // open dialog to confirm account deletion
    }

    @FXML
    void switchToProfile() throws IOException {
        App.setRoot("profile");
    }

}
