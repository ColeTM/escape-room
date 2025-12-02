package com.escape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import com.model.EscapeRoom;
import com.model.Leaderboard;
import com.model.LeaderboardEntry;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.fxml.Initializable;

public class LeaderboardController implements Initializable {

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


    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        loadLeaderboard();
    }

    public void loadLeaderboard() {
        // Clear existing nodes and re-create header + rows
        grid_leaderboard.getChildren().clear();
        
        // Set spacing between grid cells
        grid_leaderboard.setHgap(20);  // Horizontal gap between columns
        grid_leaderboard.setVgap(15);  // Vertical gap between rows

        // Add headers
        Label rankHeader = new Label("Rank");
        Label userHeader = new Label("Username");
        Label dateHeader = new Label("Date");
        Label timeHeader = new Label("Time");
        Label hintsHeader = new Label("Hints");
        Label scoreHeader = new Label("Score");
        
        grid_leaderboard.add(rankHeader, 0, 0);
        grid_leaderboard.add(userHeader, 1, 0);
        grid_leaderboard.add(dateHeader, 2, 0);
        grid_leaderboard.add(timeHeader, 3, 0);
        grid_leaderboard.add(hintsHeader, 4, 0);
        grid_leaderboard.add(scoreHeader, 5, 0);

        ArrayList<LeaderboardEntry> entries = EscapeRoom.getInstance().getLeaderBoard();

        int row = 1;
        for (int i = 0; i < entries.size(); i++) {
            LeaderboardEntry entry = entries.get(i);
            
            // Skip null entries
            if (entry == null) {
                continue;
            }

            Label rankLabel = new Label(String.valueOf(i + 1));
            Label userLabel = new Label(entry.getUsername());                // getUsername()
            Label dateLabel = new Label(entry.getDate().toString());        // getDate()
            Label timeLabel = new Label(entry.getFormatDuration());         // getFormatDuration()
            Label hintsLabel = new Label(String.valueOf(entry.getHintsUsed())); // getHintsUsed()
            Label scoreLabel = new Label(String.valueOf(entry.getScore())); // getScore()

            grid_leaderboard.add(rankLabel, 0, row);
            grid_leaderboard.add(userLabel, 1, row);
            grid_leaderboard.add(dateLabel, 2, row);
            grid_leaderboard.add(timeLabel, 3, row);
            grid_leaderboard.add(hintsLabel, 4, row);
            grid_leaderboard.add(scoreLabel, 5, row);

            row++;
        }
    }

    
}
