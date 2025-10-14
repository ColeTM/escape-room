package com.model;

import java.awt.image.BufferedImage;
/*
 * @author: Nick Hippchen 
 * A clue object that contains a text clue and an image clue
 */
public class Clue {
    
    private String text;
    private BufferedImage picture;
    
    public Clue(String text, BufferedImage picture) {
        this.text = text;
        this.picture = picture;
    }

}
