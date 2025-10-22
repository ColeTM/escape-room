package com.model;

public class UI {

    public void runScenarios() {
        successfulLogin();
        loginUserNotExist();
        unSuccessfulRegisterUser();
        successfulRegisterUser();
    }

    public void successfulLogin() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        if(!escapeRoom.login("KingBobby51", "bbrown123")) {
            System.out.println("Error: You should have logged in but didn't");
            return;
        } 

        //System.out.println(escapeRoom.getCurrentUser() + " has logged in successfully");
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
