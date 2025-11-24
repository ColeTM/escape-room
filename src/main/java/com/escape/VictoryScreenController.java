package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VictoryScreenController {

    @FXML
    private Button downloadButton;
    @FXML
    private Button mainMenuButton;
    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        String name = EscapeRoom.getInstance().getCurrentCharacter().getName();
        messageLabel.setText("The Halloween ghosts hereby begrudgingly congratulate " +  name +
                                " for evading their clutches... but they ask that you do not " +
                                "dare to return. Escaping alive won't be as easy next time.");
    }

    @FXML
    void downloadCertificate() {

    }

    @FXML
    void switchToMainMenu() throws IOException {
        App.setRoot("Main_menu");
    }

}
