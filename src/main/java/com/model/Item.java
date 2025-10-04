package com.model;
import java.util.UUID;

/**
 * this class represents an item in a character's inventory
 * @author Kelly Sullivan
 */
public class Item {
    private UUID itemID;
    private String name;
    private String description;

    public Item(String name, String description){
        this.itemID = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public void use(){

    }
    
}
