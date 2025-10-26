package com.model;

import java.util.ArrayList;

public class UI {

    public void runScenarios() {
        //duplicateUser();
        //successfulRegister();
        //enterEscapeRoom();
        //completingPuzzles();
        //dataPersistence();
        finishGame();

        //loginUserNotExist();
        //unSuccessfulRegisterUser();
        //successfulRegisterUser();
        //successAnswerTextPuzzle();
    }

    public void duplicateUser() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if (!escapeRoom.registerUser("Leni", "Rivers", "lenirivers@gmail.com", 
                            "lrivers123", "ihopethisworks")) {
            System.out.println("Account creation failed -- this username is already taken!");
            return;
        }
        System.out.println("Account creation success (this should not have worked)");
    }

    public void successfulRegister() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if (!escapeRoom.registerUser("Leni", "Rivers", "lenirivers@gmail.com", 
                            "leniriv123", "mybrotherisannoying")) {
            System.out.println("Error: You should have been able to register but couldn't");
            return;
        }
        System.out.println("Successfully registered!");
        if (!escapeRoom.login("leniriv123", "mybrotherisannoying")){
            System.out.println("Error: you should have been able to log in but couldn't");
            return;
        }
        System.out.println(escapeRoom.getCurrentUser().getUsername() + " has logged in successfully");
    }
    
    public void enterEscapeRoom() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        successfulLogin();
        SoundEffect.play("Fnaf-ambiance.wav", 1000);
        escapeRoom.startNewGame("Leni");

        

        ArrayList<Room> rooms = RoomList.getRooms();
        for(Room room : rooms){
            System.out.println(room.getName() + ": " + room.getStory());
        }
    }

    public void solvingPuzzles() {

    }

    public void dataPersistence() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.login("AliceInChains", "Ozzysmith454");
        if (!escapeRoom.logout()) {
            System.out.println("Error: Failed to log out!");
            return;
        }
        escapeRoom.login("AliceInChains", "Ozzysmith454");
        escapeRoom.resumeGame("Ozzy");
        escapeRoom.showProgress();
    }

    public void finishGame() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.login("leniriv123", "mybrotherisannoying");
        
    }



    public void successfulLogin() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        escapeRoom.login("leniriv123", "mybrotherisannoying");
        System.out.println(escapeRoom.getCurrentUser().getUsername() + " has logged in successfully");
    }

    public void loginUserNotExist() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();

        if(escapeRoom.login("KingBilly11", "bbrown222")) {
            System.out.println("Error: A user not in the system managed to login");
            return;
        }

        System.out.println("The user couldn't login because they aren't in the system.");
    }

    public void successfulRegisterUser() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();

        if(!escapeRoom.registerUser("Timmy", "Sigg", "tsizzle@hotmail.com", "TommyKnowsBest", "ilovedogs234")) {
            System.out.println("Error: Timmy should have been able to register");
            return;
        }
        
        System.out.println("Successfully registered Timmy");
    }



    public void successAnswerTextPuzzle() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        successfulLogin();

        ArrayList<Character> characters = escapeRoom.getCurrentUser().getCharacters();

        //loop through and display characters
        for(Character character : characters) {
            System.out.println((character));
        }

        //pick character
        //escapeRoom.setCurrentCharacter(character(1));

        //ArrayList<Room> rooms = escapeRoom.getRooms();

        //display rooms

        //pick the room

        //display puzzles

        //answer puzzle

        //show new progress

    }

    public void logoutAndShowData(){
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        
        System.out.println("Tommy decides he needs a break and logs out.");

        escapeRoom.logout();
    }

    public static void main(String[] args) {
        
        (new UI()).runScenarios();
             

        /*if(scenario.submitPuzzleAnswer("teapot")){
            System.out.println("correct answer!");
            System.out.println("You have earned your first key!");
        } else {
            System.out.println("wrong answer.");
        }*/
    }
}
