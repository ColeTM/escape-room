package com.model;

import java.util.ArrayList;

public class UI {

    public void runScenarios() {
        successfulLogin();
        loginUserNotExist();
        unSuccessfulRegisterUser();
        successfulRegisterUser();
        successAnswerTextPuzzle();
        startEscapeRoom();
    }

    public void successfulLogin() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if(!escapeRoom.login("KingBobby51", "bbrown123")) {
            System.out.println("Error: You should have logged in but didn't");
            return;
        } 
    System.out.println(escapeRoom.getCurrentUser() + " has logged in successfully");
    }

    public void loginUserNotExist() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();

        if(escapeRoom.login("KingBilly11", "bbrown222")) {
            System.out.println("Error: A user not in the system managed to login");
            return;
        }

        System.out.println("The user couldn't login because they aren't in the system.");
    }

    public void unSuccessfulRegisterUser() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();

        if(escapeRoom.registerUser("Bobby", "Brown", "bbrown@gmail.com", "KingBobby51", "bbrown123")) {
            System.out.println("Error: Bobby shouldn't have been able to register");
            return;
        }

        System.out.println("Successfully couldn't register Bobby Brown");
    }

    public void successfulRegisterUser() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();

        if(!escapeRoom.registerUser("Timmy", "Sigg", "tsizzle@hotmail.com", "TommyKnowsBest", "ilovedogs234")) {
            System.out.println("Error: Timmy should have been able to register");
            return;
        }
        
        System.out.println("Successfully registered Timmy");
    }

    public void startEscapeRoom() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        SoundEffect.play("Fnaf-ambiance.wav", 0);
        escapeRoom.startNewGame("Leni");
        String intro = "You are trick-or-treating on Halloween when you pass by a house you don't recognize. \n"
                           + "When you enter the house, the door closes behind you; you're trapped! \n"
                           + "Solve the puzzles in each of the 4 open rooms to unlock the room at the end of the hallway. \n"
                           + "Solve the final challenge to leave! \n"
                           + "You have 30 minutes to escape this house of horrors before your soul is stuck here FOREVER!!! \n";
        System.out.println(intro);
        Speech.speak(intro);

        ArrayList<Room> rooms = RoomList.getInstance().getRooms();
        for(Room room : rooms){
            System.out.println(room.getName() + ": " + room.getStory());
        }
    }


    public void successAnswerTextPuzzle() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        successfulLogin();

        ArrayList<Character> characters = escapeRoom.getCharacters();

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

        Speech.speak("This is a test.");
    }
}
