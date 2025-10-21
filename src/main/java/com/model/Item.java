package com.model;

/**
 * this class represents an item in a character's inventory
 * @author Kelly Sullivan
 */
public class Item {
    /**
     * attributes
     * name- name of the item
     * description- description of the item
     */
    private String name; 
    private String description;

    /**
     * construtor for an item
     * @param name - name of the item
     * @param description - description of the item
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }
    /**
     * getter for name
     * @return- string name
     */
    public String getName() {
        return name;
    }
    /**
     * setter for name
     * @param name - string name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for description
     * @return - string description
     */
    public String getDescription() {
        return description;
    }
    /**
     * setter for description
     * @param description - string description
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

    /**
     * toString method for item
     * @return string rep of item
     */
    public String toString() {
        return name + ": " + description;
    }
    
}
