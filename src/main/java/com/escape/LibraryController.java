package com.escape;

import java.io.IOException;
import java.util.UUID;

import com.model.EscapeRoom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;

public class LibraryController {

    @FXML
    private Button backLibrary;
    @FXML
    private Button backOnBook;
    @FXML
    private Rectangle blackBook;
    @FXML
    private Rectangle blueBook;
    @FXML
    private Button closeInventoryButton;
    @FXML
    private Rectangle greenBook;
    @FXML
    private Label hintLabel;
    @FXML
    private Button hintLibrary;
    @FXML
    private Button inventoryLibrary;
    @FXML
    private Label libraryTimer;
    @FXML
    private Pane inventory;
    @FXML
    private Pane bookPane;
    @FXML
    private Pane answerPane;
    @FXML
    private Button backOnAnswer;
    @FXML
    private Button bookAnswerButton;
    @FXML
    private TextField bookAnswerText;
    @FXML
    private Button pauseLibrary;
    @FXML
    private Rectangle puzzleLibrary;
    @FXML
    private Rectangle redBook;
    @FXML
    private GridPane gridInventory;
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
    @FXML
    private Label bookText;
    @FXML
    private Label incorrectLabel;


    @FXML
    public void initialize() {
        inventory.setVisible(false);
        bookPane.setVisible(false);
        answerPane.setVisible(false);
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.setRoom(UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171"));
        escapeRoom.setCurrentPuzzle(escapeRoom.getCurrentRoom().getPuzzles().get(0));
        bookText.setText("");
        incorrectLabel.setText("");
    }

    @FXML
    void backToLibrary() throws IOException {
        bookPane.setVisible(false);
        answerPane.setVisible(false);

    }

    @FXML
    void goToHallwayFromLibrary() throws IOException {
        App.setRoot("main_hallway");
    }
    @FXML
    void flashlightPage(ActionEvent event) throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getItem("flashlight") == null) {
            return;
        }
        App.setRoot("flashlight");
    }

    @FXML
    void key1Page(ActionEvent event) throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getItem("key 1") == null) {
            return;
        }
        App.setRoot("key1");
    }

    @FXML
    void key2Page(ActionEvent event) throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getItem("key 2") == null) {
            return;
        }
        App.setRoot("key2");
    }

    @FXML
    void goToInventory() {
        inventory.setVisible(true);
        loadInventoryItems();
    }

    @FXML
    void closeInventory() {
        inventory.setVisible(false);
    }

    @FXML
    void goToPause() throws IOException {
        App.setRoot("pause");
    }

    @FXML
    void goToPuzzle() {
        answerPane.setVisible(true);

    }

    @FXML
    void submitAnswer() throws IOException {
        if (EscapeRoom.getInstance().getCurrentCharacter().getPuzzlesCompleted().get(UUID.fromString("9aae693f-83a4-427e-9822-b150f44ba171"))) {
            incorrectLabel.setText("you've already solved this puzzle!");
        } else if (EscapeRoom.getInstance().submitPuzzleAnswer(bookAnswerText.getText())) {
            EscapeRoom.getInstance().getCurrentCharacter().addToInventory(new com.model.Item("key 1", "key obtained from completing the library puzzle"));
            App.setRoot("correct_answer");
        } else {
            incorrectLabel.setText("incorrect!");
            // potentially deduct time -- should probably be done in puzzle classes
        }


    }

    @FXML
    void highlightBlack() {
        blackBook.setOpacity(0.75);
    }

    @FXML
    void highlightBlue() {
        blueBook.setOpacity(0.6);
    }

    @FXML
    void highlightDesk() {
        puzzleLibrary.setOpacity(0.4);
    }

    @FXML
    void highlightGreen() {
        greenBook.setOpacity(0.5);
    }

    @FXML
    void highlightRed() {
        redBook.setOpacity(0.5);
    }

    @FXML
    void requestHint() {
        hintLabel.setText(EscapeRoom.getInstance().requestHint());
    }

    @FXML
    void showBlackBook() {
        bookPane.setVisible(true);
        bookText.setText("The old house stood on the hill, silhouetted by the moon.We pushed open the creaking door, dust motes dancing in our lights.Every portrait on the wall seemed to follow us with its eyes.The library was quiet, filled with the scent of leather and age.A small, ornate box sat upon the central desk, locked tight.We searched for hours, looking for the one, single, intricate, hidden key.It wasn't in the drawer, nor under the heavy velvet curtain.Finally, behind a loose brick in the fireplace, we felt it.A cold piece of metal, promising to unlock the final secret.The mystery was almost solved; the answer was within reach.");
    }

    @FXML
    void showBlueBook() {
        bookPane.setVisible(true);
        bookText.setText("The vessel cut through the midnight sea, leaving a phosphorescent trail.A cold wind whipped the sails, threatening to tear the canvas apart.We hadn't seen land in seven days, just endless, shifting waves.The captain checked his charts again, frowning at the complex readings.All the instruments were unreliable after the sudden electrical storm.Our only hope was to rely on celestial navigation, old methods.We desperately searched for a single star to guide us back home.Through a momentary gap in the clouds, a brilliant point appeared.It was low on the horizon, but it was enough to correct our course.With renewed purpose, the crew adjusted the rudder, aiming east.");
    }

    @FXML
    void showGreenBook() {
        bookPane.setVisible(true);
        bookText.setText("The air grew thick and humid as we crossed the final paved road.Ahead of us lay a dense, unexplored jungle, the vast, silent forest.We consulted the weathered map, marking the start of our journey.Giant ferns towered over us, blocking out the sun's warm, golden light.Every sound was muffled by hanging vines and mossy trees.The ground beneath our boots was soft and damp, smelling of rich earth.We followed the barely visible tracks of an animal, moving deeper inside.This place was completely untamed, a world untouched by humanity.Our mission was simple: find the hidden temple and document its ruins.The canopy above was an unbroken roof of leaves, beautiful yet strange.");
    }

    @FXML
    void showRedBook() {
        bookPane.setVisible(true);
        bookText.setText("The bunker door slammed shut with a heavy sound, sealing us inside.All light vanished instantly, plunging the room into absolute shadow.The air grew stale, thick with the smell of damp concrete and fear.Darkness was total; you couldn't tell if your eyes were open or closed.I fumbled for the lantern, my hands shaking violently with unease.A small, distant scratching sound echoed, making the silence feel deeper.We held our breath, waiting for the battery to kick in and light the room.This ancient refuge was supposed to be safe, but it felt like a grave.A single click, and then a weak yellow beam pierced the oppressive void.We had found the switch, but the terror of the unknown lingered close.");
    }

    @FXML
    void unhighlightBlack() {
        blackBook.setOpacity(0.0);
    }

    @FXML
    void unhighlightBlue() {
        blueBook.setOpacity(0.0);
    }

    @FXML
    void unhighlightDesk() {
        puzzleLibrary.setOpacity(0.0);
    }

    @FXML
    void unhighlightGreen() {
        greenBook.setOpacity(0.0);
    }

    @FXML
    void unhighlightRed() {
        redBook.setOpacity(0.0);
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
