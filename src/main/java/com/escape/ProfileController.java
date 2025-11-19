package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfileController {

    @FXML
    private Button accountSettingsButton;
    @FXML
    private Label difficultyLabel;
    @FXML
    private Label gameCompletionsLabel;
    @FXML
    private Label hintsLabel;
    @FXML
    private Button logOutButton;
    @FXML
    private Button profileBack;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label usernameLabel;

    @FXML
    void switchToMainMenu() throws IOException {
        App.setRoot("main_menu");
    }

    @FXML
    void switchToAccountSettings() throws IOException {
        App.setRoot("account_settings");
    }

    @FXML
    void switchToLanding() throws IOException {

        // should probably add a dialog to confirm logout

        App.setRoot("landing");
    }

    // will need more methods for setting labels

}

