package com.escape;

import java.io.IOException;

import com.model.EscapeRoom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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
    private VBox inventoryList;


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
        flashlight.setVisible(false);
        flashlightButton.setVisible(false);
        closeInventoryButton.setVisible(false);
        inventoryBox.setVisible(false);
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
        flashlight.setVisible(true);
        flashlightButton.setVisible(true);
        closeInventoryButton.setVisible(true);
        inventoryBox.setVisible(true);
        finalAnswerButton.setVisible(false);
        finalAnswerText.setVisible(false);
        finalInventory.setVisible(false);
        inventoryList.setVisible(true);
        loadInventoryItems();
    }
    
    @FXML
    void closeInventory(ActionEvent event) {
        flashlight.setVisible(false);
        flashlightButton.setVisible(false);
        closeInventoryButton.setVisible(false);
        inventoryBox.setVisible(false);
        finalAnswerButton.setVisible(true);
        finalAnswerText.setVisible(true);
        finalInventory.setVisible(true);
        inventoryList.setVisible(false);
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
    inventoryList.getChildren().clear();

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
        inventoryList.getChildren().add(makeErrorText.apply("No user logged in."));
        return;
    }
    var character = escapeRoom.getCurrentUser().getCharacter("Leni");

    if (character == null) {
        inventoryList.getChildren().add(makeErrorText.apply("No character found."));
        return;
    }
    for (var item : character.getInventory()) {
        HBox row = new HBox(3);  
        row.setAlignment(Pos.CENTER_LEFT);
        ImageView imgView = new ImageView();
        if (item.getImagePath() != null) {
            try {
                imgView.setImage(new Image(item.getImagePath()));
                imgView.setFitWidth(40);
                imgView.setFitHeight(40);
                imgView.setPreserveRatio(true);
            } catch (Exception e) {
                System.out.println("Failed to load item image: " + item.getImagePath());
            }
        }
        row.getChildren().add(imgView);
        inventoryList.getChildren().add(row);
    }
    if (character.getInventory().isEmpty()) {
        inventoryList.getChildren().add(makeErrorText.apply("Inventory is empty."));
    }
}
}
