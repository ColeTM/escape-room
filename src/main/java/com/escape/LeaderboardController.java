package com.escape;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LeaderboardController {

    @FXML
    private void switchToLeaderboard() throws IOException {
        App.setRoot("leaderboard");
    }

    @FXML
    private Button returnFromLeaderboard;

    @FXML
    void switchToMain(ActionEvent event) {

    }
    
}
