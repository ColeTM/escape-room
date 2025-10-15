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

    public ArrayList<User> addUser(UUID userID, String firstName,
    String lastName, String email, String username, String password){
        User newUser = new User(firstName, lastName, email, username, password);
        users.add(newUser);
        return users;
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
    
}
