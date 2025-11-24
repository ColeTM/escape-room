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
        EscapeRoom.getInstance().endGame();
        messageLabel.setText("The Halloween ghosts hereby begrudgingly congratulate " + ch.getName() +
                                " for evading their clutches... but they ask that you do not " +
                                "dare to return. Escaping alive won't be as easy next time.");
        hintsUsedLabel.setText("Hints Used: " + ch.getHintsUsed());
        difficultyLabel.setText("Difficulty: " + ch.getDifficulty());
        finalScoreLabel.setText("Final Score: " + ch.calculateScore());
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
