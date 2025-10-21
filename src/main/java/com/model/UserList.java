package com.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represensts the list of users for the game
 * @author Kelly Sullivan
 */
public class UserList {
    /**
     * attributes
     * users- list of users
     * userlist- singleton instnace of userlist
     */
    private ArrayList<User> users;
    private static UserList userList;

    /**
     * constructor for userlist
     */
    private UserList() {
        users = DataLoader.getUsers();
    }

    /**
     * getter for userlist singleton instance
     * @returns instance of userlist
     */
    public static UserList getInstance() {
        if(userList == null){
            userList = new UserList();
        } 
        return userList;
    }

    /**
     * method to add a user to the userlist
     * @param newUser - the user to be added
     */
    public void addUser(User newUser){
        users.add(newUser);
    }

    /**
     * getter for the list of users
     * @return list of users
     */
    public static ArrayList<User> getUsers(){
        return userList.users;
    }

    /**
     * method to save the users to to the json files
     *  is this supposed to be static?
     */
    public static void saveUsers() {
        DataWriter.saveUsers();
    }

    /**
     * getter method to get user by UUID
     * @param userID - the UUID of the user to be found
     * @return user with the matching UUID
     */
    public User getUserByUUID(UUID userID){
        for(User user : users){
            if(user.getUserID().equals(userID)){
                return user;
            }
        }
        return null;
    }

    /**
     * getter method to get user by username and password
     * @param username - the username of the user to be found
     * @param password - the password of the user to be found
     * @return- user with the matching username and password
     */
    public User getUser(String username, String password) {
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        System.out.println("No user found!");
        return null;
    }
    
}
