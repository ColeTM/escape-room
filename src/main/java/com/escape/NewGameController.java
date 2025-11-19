package com.escape;

import java.io.IOException;
import javafx.fxml.FXML;

public class NewGameController {

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("Main_menu");
    }
    
}
