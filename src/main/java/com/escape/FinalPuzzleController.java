package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;

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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class FinalPuzzleController {
    private static final double MIN_X = 217;
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
    @FXML
    private Rectangle inventoryBox;
    @FXML
    private Button closeInventoryButton;
    @FXML
    private ImageView flashlight;
    @FXML
    private Button flashlightButton;
    @FXML
    private Button inventorySlot1;
    @FXML
    private Button inventorySlot2;
    @FXML
    private Button inventorySlot3;
    @FXML
    private ImageView inventoryImage1;
    @FXML
    private ImageView inventoryImage2;
    @FXML
    private ImageView inventoryImage3;
    @FXML
    private GridPane gridInventory;

    private Shape currentCutout;


    @FXML
    public void initialize() {
        coverRectangle.setLayoutX(0);
        coverRectangle.setLayoutY(0);
        cutoutCircle.setLayoutX(320);
        cutoutCircle.setLayoutY(166);
        cutoutCircle.setOpacity(1.0); 
        coverRectangle.setOpacity(1.0);
        finalHintBox.setVisible(false);
        finalHintText.setVisible(false);
        closeInventoryButton.setVisible(false);
        inventoryBox.setVisible(false);
        gridInventory.setVisible(false);
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
        closeInventoryButton.setVisible(true);
        inventoryBox.setVisible(true);
        finalAnswerButton.setVisible(false);
        finalAnswerText.setVisible(false);
        finalInventory.setVisible(false);
        gridInventory.setVisible(true);
        loadInventoryItems();
    }
    
    @FXML
    void closeInventory(ActionEvent event) {
        closeInventoryButton.setVisible(false);
        inventoryBox.setVisible(false);
        finalAnswerButton.setVisible(true);
        finalAnswerText.setVisible(true);
        finalInventory.setVisible(true);
    }

    @FXML
    void flashlightPage(ActionEvent event) throws IOException {
        App.setRoot("flashlight");
    }

    @FXML
    void requestHint(ActionEvent event) {
        finalHintBox.setVisible(true);
        finalHintText.setVisible(true);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        finalHintText.setText(escapeRoom.requestHint());
    }

    @FXML
    void submitAnswer(ActionEvent event) {
        // submit answer
    }

    @FXML
    void switchToHallway(ActionEvent event) throws IOException {
        App.setRoot("hallway");
    }

    @FXML
    void switchToPause(ActionEvent event) throws IOException {
        App.setRoot("pause_menu");
    }

    private void loadInventoryItems() {
    gridInventory.getChildren().clear();

    EscapeRoom escapeRoom = EscapeRoom.getInstance();
    java.util.function.Function<String, Text> makeErrorText = msg -> {
        Text t = new Text(msg);
        t.setFill(Color.web("#641013")); 
        t.setWrappingWidth(401);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setFont(Font.font("Caveat Brush", 24));
        return t;
    };
    if (escapeRoom.getCurrentUser() == null) {
        gridInventory.getChildren().add(makeErrorText.apply("No user logged in."));
        return;
    }
    var character = escapeRoom.getCurrentCharacter();

    if (character == null) {
        gridInventory.getChildren().add(makeErrorText.apply("No character found."));
        return;
    }
    for (var item : character.getInventory()) {
        
        if (item.getImagePath() != null) {
            try {
                inventoryImage1.setImage(new Image(item.getImagePath()));
                inventoryImage1.setFitWidth(212);
                inventoryImage1.setFitHeight(172);
                inventoryImage1.setPreserveRatio(true);
            } catch (Exception e) {
                System.out.println("Failed to load item image: " + item.getImagePath());
            }
        }
        //row.getChildren().add(inventoryImage1);
        //gridInventory.getChildren().add(row);
    }
    if (character.getInventory().isEmpty()) {
        gridInventory.getChildren().add(makeErrorText.apply("Inventory is empty."));
    }
}

}