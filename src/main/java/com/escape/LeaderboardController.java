package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;

public class LeaderboardController {

    @FXML
    private void switchToLeaderboard() throws IOException {
        App.setRoot("leaderboard");
    }
    
}
