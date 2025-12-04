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
    private boolean isUsed;
    private String imagePath;

    /**
     * construtor for an item
     * @param name - name of the item
     * @param description - description of the item
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
        this.isUsed = false;

        switch (name) {
            case "flashlight" -> this.imagePath = "@../../images/flashlight.png";
            case "key 1" -> this.imagePath = "@../../images/key1.png";
            case "key 2" -> this.imagePath = "@../../images/key2.png";
        }
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
     * getter for is used
     * @return- boolean if used
     */
    public boolean getIsUsed() {
        return isUsed;
    }
    /**
     * getter for is used
     * param isUsed - boolean if used
     */
    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
    /**
     * getter for is used
     * @return- boolean if used
     */
    public String getImagePath() {
        return imagePath;
    }
    /**
     * getter for is used
     * param isUsed - boolean if used
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        
    }
    /**
     * method to handle the item usage
     */
    public void use(){
        isUsed = true;
        // wait until we have some items and make a switch case or something for use

    }

    /**
     * toString method for item
     * @return string rep of item
     */
    public String toString() {
        return name + ": " + description + "This item has " + (isUsed ? "been used." : "not been used.");
    }
    
}
