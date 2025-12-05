package com.escape;

import java.io.IOException;
import com.model.EscapeRoom;
import com.model.UserList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passField;
    @FXML
    private TextField emailField;
    @FXML
    private Text deleteFailsafe;


    // need method to set all labels when screen opens

    @FXML
    public void initialize() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        firstNameLabel.setText("first name: " + escapeRoom.getCurrentUser().getFirstName());
        lastNameLabel.setText("last name: " + escapeRoom.getCurrentUser().getLastName());
        usernameLabel.setText("username: " + escapeRoom.getCurrentUser().getUsername());
        emailLabel.setText("email: " + escapeRoom.getCurrentUser().getEmail());
    }

    @FXML
    void changeEmail() {
       EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.getCurrentUser().setEmail(emailField.getText());
        emailField.clear();
    }

    @FXML
    void changePassword() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.getCurrentUser().setPassword(passField.getText());
        passField.clear();
    }

    @FXML
    void changeUsername() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.getCurrentUser().setUsername(usernameField.getText());
        usernameField.clear();
    }

    @FXML
    void deleteAccount() throws IOException {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        UserList users = UserList.getInstance();
        if(deleteFailsafe.getOpacity() == 0) {
            deleteFailsafe.setOpacity(1);
        } else {
            users.removeUser(escapeRoom.getCurrentUser());
            escapeRoom.logout();
            App.setRoot("landing");
        }
    }

    @FXML
    void switchToProfile() throws IOException {
        App.setRoot("profile");
    }

}
