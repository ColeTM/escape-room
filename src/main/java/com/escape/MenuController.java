package com.escape;

import java.io.IOException;

import javafx.fxml.FXML;

public class MenuController {
    @FXML
    public void switchToNew() throws IOException {
        App.setRoot("new_game");
    }

    @FXML
    public void switchToContinue() throws IOException {
        App.setRoot("Continue");
    }

    @FXML
    public void switchToSettings() throws IOException {
        App.setRoot("Settings");
    }
}
