package com.model;

/**
 * this class represents an item in a character's inventory
 * @author Kelly Sullivan
 */
public class Item {
    private String name;
    private String description;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void use(){
        // wait until we have some items and make a switch case or something for use

    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return name + ": " + description;
    }
    
}
