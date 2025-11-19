package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button continueGameButton;
    @FXML
    private Button leaderboardButton;
    @FXML
    private Button newGameButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button settingsButton;

    @FXML
    public void switchToNew() throws IOException {
        App.setRoot("new_game");
    }

    @FXML
    public void switchToContinue() throws IOException {
        App.setRoot("continue_game");
    }

    @FXML
    public void switchToSettings() throws IOException {
        App.setRoot("settings");
    }

     @FXML
    void switchToLeaderboard() throws IOException {
        App.setRoot("leaderboard");
    }

    @FXML
    void switchToProfile() throws IOException {
        App.setRoot("profile");
    }
}
