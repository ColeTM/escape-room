package com.escape;

import java.io.IOException;
import com.model.EscapeRoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;


public class FinalPuzzleController {
    private static final double MIN_X = 217;
    private static final double MAX_X = 443;
    @FXML
    private Button closeInventoryButton;
    @FXML
    private Rectangle coverRectangle;
    @FXML
    private Circle cutoutCircle;
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
    private Button finalMoveLightLeft;
    @FXML
    private Button finalMoveLightRight;
    @FXML
    private Pane finalPane;
    @FXML
    private Button finalPause;
    @FXML
    private Label finalTimer;
    @FXML
    private GridPane gridInventory;
    @FXML
    private Rectangle inventoryBox;
    @FXML
    private ImageView inventoryImage1;
    @FXML
    private ImageView inventoryImage2;
    @FXML
    private ImageView inventoryImage3;
    @FXML
    private Button inventorySlot1;
    @FXML
    private Button inventorySlot2;
    @FXML
    private Button inventorySlot3;

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
    void closeInventory(ActionEvent event) {
        closeInventoryButton.setVisible(false);
        inventoryBox.setVisible(false);
        finalAnswerButton.setVisible(true);
        finalAnswerText.setVisible(true);
        finalInventory.setVisible(true);
        gridInventory.setVisible(false);
    }

    @FXML
    void flashlightPage(ActionEvent event) throws IOException {
        App.setRoot("flashlight");
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
    void requestHint(ActionEvent event) {
        finalHintBox.setVisible(true);
        finalHintText.setVisible(true);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        finalHintText.setText(escapeRoom.requestHint());
    }

    @FXML
    void submitAnswer(ActionEvent event) {
        //sub
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
        inventoryImage1.setImage(null);
        inventoryImage2.setImage(null);
        inventoryImage3.setImage(null);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        var character = escapeRoom.getCurrentCharacter();

        if (character == null) return;
        var items = character.getInventory();
        int size = items.size();
        System.out.println(getClass().getResource("/images/flashlight.png"));

        for (int i = 0; i < size; i++) {
            var item = items.get(i);

            if (item.getImagePath() != null) {
                try {
                    Image img = new Image(getClass().getResourceAsStream(item.getImagePath()));
                    switch (i) {
                        case 0 -> inventoryImage1.setImage(img);
                        case 1 -> inventoryImage2.setImage(img);
                        case 2 -> inventoryImage3.setImage(img);
                    }
                } catch (Exception e) {
                    System.out.println("Failed to load: " + item.getImagePath());
                }
            }
        }
    }
    

}
