package com.model;

import java.util.UUID;
import javax.sound.sampled.*;

/**
 * Represents an object in a room that the user can interact with
 * @author ndmcginnis21
 */

public class Interactable
{
    private String name;
    private String description;
    private boolean isHighlighted;
    private static SoundEffect soundEffect;
    private String clueText;

    //Constructor for creating a new Interactable object
    public Interactable(String name, String description,
                        boolean isHighlighted, String clueText)
    {
        this.name = name;
        this.description = description;
        this.isHighlighted = isHighlighted;
        this.clueText = clueText;
    }

    public void highlight()
    {
    
    }

    public void interact()
    {

    }

    public void playSoundEffect(int num)
    {
        SoundEffect.play(num);
    }

    public String getClueText()
    {
        return this.clueText;
    }

    public String toString()
    {
        return name + ": " + description;
    }

    public static void main(String[] args)
    {
        Interactable i = new Interactable("a","a",true,"a");
        i.playSoundEffect(2);
    }
}