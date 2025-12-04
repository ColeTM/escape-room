package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;

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
        if (EscapeRoom.getInstance().getCurrentCharacter() == null)
            App.setRoot("main_menu");
        else
            App.setRoot("pause");
    }

    @FXML
    void toggleTTS() {

    }

    @FXML
    void updateVolume(MouseEvent event) {

    }

}
