package com.escape;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;


public class FinalPuzzleController {
    private static final double MIN_X = 167;
    private static final double MAX_X = 443;
    @FXML
    private Pane finalPane;
    @FXML
    private Button finalAnswerButton;
    @FXML
    private TextField finalAnswerText;
    @FXML
    private Button finalBack;
    @FXML
    private Button finalHint;
    @FXML
    private Rectangle finalHintBox;
    @FXML
    private Text finalHintText;
    @FXML
    private Button finalInventory;
    @FXML
    private Button finalPause;
    @FXML
    private Label finalTimer;
    @FXML
    private Button finalMoveLightLeft;
    @FXML
    private Button finalMoveLightRight;
    @FXML
    private Circle cutoutCircle;
    @FXML
    private Rectangle coverRectangle;

    private Shape currentCutout;


    @FXML
    public void initialize() {
        coverRectangle.setLayoutX(0);
        coverRectangle.setLayoutY(0);
        cutoutCircle.setLayoutX(167);
        cutoutCircle.setLayoutY(166);
        cutoutCircle.setOpacity(0.0); 
        coverRectangle.setOpacity(0.0);
        finalHintBox.setVisible(false);
        finalHintText.setVisible(false);
        updateCutout();
    }

    private void updateCutout() {
        if (currentCutout != null) {
            finalPane.getChildren().remove(currentCutout);
        }
        Shape newCutout = Shape.subtract(coverRectangle, cutoutCircle);
        newCutout.setFill(Color.BLACK);
        finalPane.getChildren().add(1, newCutout); 
        currentCutout = newCutout;
        updateButtonVisibile();    
    }
    
    private void updateButtonVisibile() {
        if (cutoutCircle.getLayoutX() <= MIN_X) {
            finalMoveLightLeft.setVisible(false);
        } else {
            finalMoveLightLeft.setVisible(true);
        }
        if (cutoutCircle.getLayoutX() >= MAX_X) {
            finalMoveLightRight.setVisible(false);
        } else {
            finalMoveLightRight.setVisible(true);
        }
    }
    @FXML
    private void handleMoveLeft(ActionEvent event) {
        if(cutoutCircle.getLayoutX() > MIN_X) {
        cutoutCircle.setLayoutX(cutoutCircle.getLayoutX() - 50);
        updateCutout();

        }
    }
    @FXML
    private void handleMoveRight(ActionEvent event) {
        if(cutoutCircle.getLayoutX() < MAX_X) {
        cutoutCircle.setLayoutX(cutoutCircle.getLayoutX() + 50);
        updateCutout();
        }
    }

    @FXML
    void openInventory(ActionEvent event) {
        // open inventory
    }

    @FXML
    void requestHint(ActionEvent event) {
        finalHintBox.setVisible(true);
        finalHintText.setVisible(true);
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
