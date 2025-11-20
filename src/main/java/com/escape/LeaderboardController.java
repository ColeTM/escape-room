package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;
import com.model.EscapeRoom;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LeaderboardController {

    @FXML
    private GridPane grid_leaderboard;

    @FXML
    private Button returnFromLeaderboard;

    @FXML
    private void switchToLeaderboard() throws IOException {
        App.setRoot("leaderboard");
    }

    @FXML
    void switchToMain() throws IOException {
       App.setRoot("main_menu");
    }
    
}
