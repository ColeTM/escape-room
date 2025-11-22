package com.escape;

import com.model.EscapeRoom;

import java.io.IOException;

import com.model.Difficulty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewGameController {

    @FXML
    private Button beginButton;
    @FXML
    private Label newGameError;
    @FXML
    private Button newGameBack;
    @FXML
    private ChoiceBox<String> saveDifficulty;
    @FXML
    private TextField saveName;

    @FXML
    public void initialize() {
        ObservableList<String> difficulties = FXCollections.observableArrayList();
        difficulties.add("Beginner");
        if (EscapeRoom.getInstance().getCurrentUser().getSkillLevel() != Difficulty.Beginner)
            difficulties.add("Intermediate");
        if (EscapeRoom.getInstance().getCurrentUser().getSkillLevel() == Difficulty.Pro)
            difficulties.add("Pro");
        saveDifficulty.setItems(difficulties);
    }

    @FXML
    void beginButtonPressed() throws IOException {

        // check that fields are filled and then switch to intro screen

        if (saveDifficulty.getValue().equals("- select difficulty -")) {
            newGameError.setText("select a difficulty");
            return;
        }

        try {
            EscapeRoom.getInstance().startNewGame(saveName.getText(), Difficulty.valueOf(saveDifficulty.getValue()));
            switchToIntro();
        } catch (IllegalArgumentException e) {
            newGameError.setText(e.getMessage());
        } 

    }

    @FXML
    void switchToIntro() throws IOException {
        App.setRoot("intro");
    }

    @FXML
    void switchToMainMenu() throws IOException {
        App.setRoot("main_menu");
    }

}
