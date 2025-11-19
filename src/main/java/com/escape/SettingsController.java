package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class SettingsController {

    @FXML
    private Button settingsBack;
    @FXML
    private Button ttsButton;
    @FXML
    private Label volumeLabel;
    @FXML
    private Slider volumeSlider;

    @FXML
    void btnBackPressed() throws IOException {
        
        // this method will have to be updated to be able to take user
        // back to pause menu while accessing settings mid-game

        App.setRoot("main_menu");
    }

    @FXML
    void toggleTTS() {

    }

    @FXML
    void updateVolume(MouseEvent event) {

    }

}
