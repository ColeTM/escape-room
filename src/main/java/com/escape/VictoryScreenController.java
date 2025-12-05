package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;
import com.model.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VictoryScreenController {

    @FXML
    private Label difficultyLabel;
    @FXML
    private Button downloadButton;
    @FXML
    private Label finalScoreLabel;
    @FXML
    private Label hintsUsedLabel;
    @FXML
    private Button mainMenuButton;
    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        Character ch = EscapeRoom.getInstance().getCurrentCharacter();
        
        String text = """
                The Halloween ghosts hereby begrudgingly congratulate %s
                for evading their clutches... but they ask that you do not
                dare to return. Escaping alive won't be as easy next time.
                """.formatted(ch.getName());
        messageLabel.setText(text);
        hintsUsedLabel.setText("Hints Used: " + ch.getNumHintsUsed());
        difficultyLabel.setText("Difficulty: " + ch.getDifficulty());
        finalScoreLabel.setText("Final Score: " + ch.calculateScore());

        EscapeRoom.getInstance().endGame();
    }

    @FXML
    void downloadCertificate() {

    }

    @FXML
    void switchToMainMenu() throws IOException {
        EscapeRoom.getInstance();
        App.setRoot("Main_menu");
    }

}
