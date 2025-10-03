package com.model;

import java.util.ArrayList;
import java.io.FileReader;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < usersJSON.size(); ++i) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);

                UUID userID = UUID.fromString((String)userJSON.get(USER_ID));
                String firstName = (String)userJSON.get(FIRST_NAME);
                String lastName = (String)userJSON.get(LAST_NAME);
                String email = (String)userJSON.get(EMAIL);
                String username = (String)userJSON.get(USERNAME);
                String password = (String)userJSON.get(PASSWORD);
                Difficulty skillLevel = (Difficulty)userJSON.get(SKILL_LEVEL);
                // characters
                // personal record

                //users.add(new User(userID, firstName, lastName, email, username, password,
                //                    skillLevel, characters, personalRecord));
            }
            return users;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
}
