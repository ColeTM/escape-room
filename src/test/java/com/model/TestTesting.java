package com.model;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertTrue;
public class TestTesting {

    @BeforeEach
    public void setup() {
        System.out.println("cool");
    }

    @Test
    public void testTrue() {
        assertTrue(true);
    }
    
}
