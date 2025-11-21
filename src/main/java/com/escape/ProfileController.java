package com.escape;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProfileController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        usernameLabel.setText(escapeRoom.getCurrentUser().getUsername());
        if (escapeRoom.getCurrentUser().getPersonalRecord() == null) {
            scoreLabel.setText("score: N/A");
            timeLabel.setText("time: N/A");
            difficultyLabel.setText("difficulty: N/A");
            hintsLabel.setText("hints: N/A");
        } else {
            scoreLabel.setText("score: " + escapeRoom.getCurrentUser().getPersonalRecord().getScore());
            timeLabel.setText("time: " + escapeRoom.getCurrentUser().getPersonalRecord().getFormatDuration());
            difficultyLabel.setText("difficulty: " + escapeRoom.getCurrentUser().getPersonalRecord().getDifficulty());
            hintsLabel.setText("hints: " + escapeRoom.getCurrentUser().getPersonalRecord().getHintsUsed());
        }
    }

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

