package com.model;

public class UI {
    public static void main(String[] args) {
        EscapeRoom scenario = new EscapeRoom();
        if(scenario.login("KingBobby51", "bbrown123")) {
            System.out.println("successful login!");
        }
        if(!scenario.login("KingBilly11", "bbrown222")) {
            System.out.println("unsuccessful login.");
        }

        if(!scenario.registerUser("Bobby", "Brown", "bbrown@gmail.com", "KingBobby51", "bbrown123")) {
            System.out.println("unsuccessful registration.");
        }
        if(scenario.registerUser("Timmy", "Sigg", "tsizzle@hotmail.com", "TommyKnowsBest", "ilovedogs234")) {
            System.out.println("successful registration!");
        }

        

        /*if(scenario.submitPuzzleAnswer("teapot")){
            System.out.println("correct answer!");
            System.out.println("You have earned your first key!");
        } else {
            System.out.println("wrong answer.");
        }*/

        Speech.speak("This is a test.");
    }
}
