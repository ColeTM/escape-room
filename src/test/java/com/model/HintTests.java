package com.model;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class HintTests {



    @Test
    public void testText() {
        Hint h = new Hint(UUID.randomUUID(),"test",false,null,HintLevel.Direct);
        assertEquals("test", h.getText());
    }

    @Test
    public void testPicture() {
        Hint h = new Hint(UUID.randomUUID(),"test",false,null,HintLevel.Direct);
        assertEquals(null,h.getPicture());
    }

    @Test
    public void testToString() {
        Hint h = new Hint(UUID.randomUUID(),"test",false,null,HintLevel.Direct);
        assertEquals("Hint: test (Level: Direct)", h.toString());
    }

    @Test
    public void testNullText() {
        Hint h = new Hint(UUID.randomUUID(),null,false,null,HintLevel.Direct);
        assertNotEquals(null,h.getText());
    }

    @Test
    public void testEmptyText() {
        Hint h = new Hint(UUID.randomUUID()," ",false,null,HintLevel.Direct);
        assertNotEquals(" ",h.getText());
    }
}
