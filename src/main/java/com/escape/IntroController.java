package com.escape;

import java.io.IOException;
import java.lang.classfile.Label;

import java.util.UUID;

import com.model.EscapeRoom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IntroController {

    @FXML
    private Button enterButton;
    @FXML
    private Label introText; 



    @FXML
    void switchToHallway() throws IOException {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.setRoom(UUID.fromString("26767fe2-e8b1-47c4-b4eb-5f9aec77fb85"));
        App.setRoot("hallway");
    }

}
