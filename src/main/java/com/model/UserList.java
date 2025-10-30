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
     * userlist- singleton instance of userlist
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
     * @return instance of userlist
     */
    public static UserList getInstance() {
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    /**
     * method to add a user to the userlist if username is not taken
     * @param firstName String -- user's first name
     * @param lastName String -- user's last name
     * @param email String -- email linked to account
     * @param username String -- account's username
     * @param password String -- account's password
     */
    public boolean addUser(String firstName, String lastName, String email, 
                                    String username, String password) {
        if(usernameTaken(username))
            return false;
        users.add(new User(firstName, lastName, email, username, password));
        return true;
    }

    /**
     * getter for the list of users
     * @return list of users
     */
    public ArrayList<User> getUsers(){
        return userList.users;
    }

    /**
     * method to save the users to to the json files
     */
    public void saveUsers() {
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
        return null;
    }

    /**
     * method to check whether a username is alrerady taken by an existing account
     * @return boolean -- true if the username is taken
     * @param username String -- the username to check
     */
    public boolean usernameTaken(String username) {
        for(User user : users) {
            if(user.getUsername().equalsIgnoreCase(username))
                return true;
        }
        return false;
    }

    public void clear() {
        DataLoader.
    }
    
}
