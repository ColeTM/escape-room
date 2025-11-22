package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;
import com.model.Character;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ContinueGameController {

    @FXML
    private Button continueBack;
    @FXML
    private Button continueButton;
    @FXML
    private ChoiceBox<String> continueDropDown;
    @FXML
    private Label continueErrorLabel;

    @FXML
    public void initialize() {
        ObservableList<String> saves = FXCollections.observableArrayList();
        for (Character ch : EscapeRoom.getInstance().getCurrentUser().getCharacters())
            saves.add(ch.getName() + " - " + ch.getDifficulty());
        continueDropDown.setItems(saves);
    }

    @FXML
    void continueGame() throws IOException {

        if (continueDropDown.getValue().equals("- select save -")) {
            continueErrorLabel.setText("select a save");
            return;
        }

        if (EscapeRoom.getInstance().resumeGame(continueDropDown.getValue().substring(0, continueDropDown.getValue().indexOf(" - ")))) {
            // set screen to appropriate screen based on current room
            String roomID = EscapeRoom.getInstance().getCurrentCharacter().getCurrentRoom().toString();
            switch (roomID) {
                case "26767fe2-e8b1-47c4-b4eb-5f9aec77fb85" -> switchToLibrary();
                case "9aae693f-83a4-427e-9822-b150f44ba171" -> switchToHallway();
                case "a91b9a37-d41d-4d93-b553-895ffd04723a" -> switchToBoxRoom();
                case "c6b98566-e4e9-445c-8da2-9ef6b92ce815" -> switchToJigsawRoom();
                case "150c985e-0e90-4c28-bd96-e658b4bc1c20" -> switchToMinesweeper();
                case "1030c684-0ceb-4f2b-a71e-f5846697d8d7" -> switchToFinalRoom();
            }
        }

    }

    @FXML
    void switchToMainMenu() throws IOException {
        App.setRoot("main_menu");
    }

    @FXML
    void switchToHallway() throws IOException {
        // App.setRoot("hallway");
    }

    @FXML
    void switchToLibrary() throws IOException {
        App.setRoot("library_start");
    }

    @FXML
    void switchToBoxRoom() throws IOException {
        App.setRoot("box_room");
    }

    @FXML
    void switchToMinesweeper() throws IOException {
        // App.setRoot("minesweeper_room");
    }

    @FXML
    void switchToJigsawRoom() throws IOException {
        // App.setRoot("jigsaw_room");
    }

    @FXML
    void switchToFinalRoom() throws IOException {
        // App.setRoot("final_room")
    }

}
