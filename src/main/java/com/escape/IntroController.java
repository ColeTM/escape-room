package com.escape;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IntroController {

    @FXML
    private Button enterButton;
    @FXML
    private Text introText; 



    @FXML
    void switchToHallway() throws IOException {
        EscapeRoom.getInstance().setRoom(UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85"));
        App.setRoot("main_hallway");
    }

}
