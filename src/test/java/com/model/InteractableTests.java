package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class InteractableTests {

    private Interactable interactable;
    private UUID testID = UUID.randomUUID();

    @BeforeEach
    public void setUp() {
        interactable = new Interactable(testID, "A dusty old painting", null, false, "The signature is... a 'Z'?", false);
    }

    @Test
    public void testInteractableConstructor() {
        assertEquals(testID, interactable.getInteractableID());
        assertEquals("A dusty old painting", interactable.getDescription());
        assertFalse(interactable.getIsHighlighted());
        assertEquals("The signature is... a 'Z'?", interactable.getClueText());
        assertFalse(interactable.getIsItem(), "Interactable should not be an item by default.");
    }

    @Test
    public void testSetAndGetIsItemTrue() {
        interactable.setIsItem(true);
        assertTrue(interactable.getIsItem(), "getIsItem should return true after being set.");
    }

    @Test
    public void testSetAndGetIsItemFalse() {
        // First set to true
        interactable.setIsItem(true);
        assertTrue(interactable.getIsItem(), "Setup failed: getIsItem should return true.");
        
        // Then test setting back to false
        interactable.setIsItem(false);
        assertFalse(interactable.getIsItem(), "getIsItem should return false after being set.");
    }
}