package com.escape;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BoxRoomController {

    @FXML
    private Button boxesAnswerButton;
    @FXML
    private TextField boxesAnswerText;
    @FXML
    private Button boxesBack;
    @FXML
    private Button boxesHint;
    @FXML
    private Button boxesInventory;
    @FXML
    private Button boxesPause;
    @FXML
    private Label boxesTimer;

    @FXML
    void openInventory(ActionEvent event) {
        // open inventory
    }

    @FXML
    void requestHint(ActionEvent event) {
        // request hint
    }

    @FXML
    void submitAnswer(ActionEvent event) {
        // submit answer
    }

    @FXML
    void switchToHallway(ActionEvent event) {
        // App.setRoot("hallway");
    }

    @FXML
    void switchToPause(ActionEvent event) {
        // App.setRoot("pause_menu");
    }

}
