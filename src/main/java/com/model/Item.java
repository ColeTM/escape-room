package com.model;

/**
 * this class represents an item in a character's inventory
 * @author Kelly Sullivan
 */
public class Item {
    private String name;
    private String description;

    /**
     * construtor for an item
     * @param name
     * @param description
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }
    /**
     * getter for name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * setter for name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for description
     * @return
     */
    public String getDescription() {
        return description;
    }
    /**
     * setter for description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * method to handle the item usage
     */
    public void use(){
        // wait until we have some items and make a switch case or something for use

    }

    public String toString() {
        return name + ": " + description;
    }
    
}
