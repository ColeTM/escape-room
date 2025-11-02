package com.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item("Key", "key for a lock to a door.");
    }

    @Test
    public void testConstructorName() {
        assertEquals("Key", item.getName());
        }
    @Test
    public void testConstructorDescription() {
        assertEquals("key for a lock to a door.", item.getDescription());
    }

    @Test
    public void testSetName() {
        item.setName("Golden Key");
        assertEquals("Golden Key", item.getName());
    }

    @Test
    public void testSetDescription() {
        item.setDescription("Key to box");
        assertEquals("Key to box", item.getDescription());
    }

    @Test
    public void testToStringFormatsCorrectly() {
        String string = "Key: key for a lock to a door.";
        assertEquals(string, item.toString());
    }

    @Test
    public void testUseWillWork() {
        assertDoesNotThrow(() -> item.use());
    }
}
