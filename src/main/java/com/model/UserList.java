package com.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represensts the list of users for the game
 * @author Kelly Sullivan
 */
public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if(userList == null){
            userList = new UserList();
        } 
        return userList;
    }

    public void addUser(User newUser){
        users.add(newUser);
    }

    public static ArrayList<User> getUsers(){
        return userList.users;
    }

    public User getUserByUUID(UUID userID){
        for(User user : users){
            if(user.getUserID().equals(userID)){
                return user;
            }
        }
        return null;
    }

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
