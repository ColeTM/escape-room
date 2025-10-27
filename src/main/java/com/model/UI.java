package com.model;

import java.util.ArrayList;

public class UI {

    public void runScenarios() {
        duplicateUser();
        //successfulRegister();
        //enterEscapeRoom();
        //solvingPuzzles();
        //dataPersistence();
        //finishGame();
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
        escapeRoom.saveCurrentGame();
    }
    
    public void enterEscapeRoom() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        successfulLogin();
        SoundEffect.play("Fnaf-ambiance.wav", 5000);
        if(!escapeRoom.startNewGame("Leni")) {
            System.out.println("Error: unable to create new save");
            return;
        }
        
        ArrayList<Room> rooms = RoomList.getRooms();
        escapeRoom.setRoom(rooms.get(0).getRoomID());
        escapeRoom.saveCurrentGame();
    }

    public void solvingPuzzles() {
        EscapeRoom escapeRoom = EscapeRoom.getInstance();
        successfulLogin();
        escapeRoom.resumeGame("Leni");
        ArrayList<Room> rooms = RoomList.getRooms();
        int i = 0;
        escapeRoom.setRoom(rooms.get(i).getRoomID());
        ArrayList<Interactable> interactables = rooms.get(i).getInteractables();
        for(Interactable interactable : interactables) {
                System.out.println(interactable.getDescription());
                interactable.interact();
            }
        escapeRoom.setRoom(rooms.get(i+1).getRoomID());
        ArrayList<Interactable> interactables1 = rooms.get(i+1).getInteractables();
        for(Interactable interactable : interactables1) {
                System.out.println(interactable.getDescription());
                interactable.interact();
            }
        Puzzle puzzle1 = rooms.get(i+1).getPuzzles().get(0);
        escapeRoom.setCurrentPuzzle(puzzle1);
        puzzle1.getContent();
        puzzle1.getClue().getText();
        escapeRoom.requestHint();
        escapeRoom.submitPuzzleAnswer("this is a puzzle answer");
        if(escapeRoom.submitPuzzleAnswer("this is a puzzle answer")) {
            for(Interactable interactable : interactables) {
                if(interactable.getIsItem()){
                    escapeRoom.getCurrentUser().getCharacter("leni").addToInventory(new Item(interactable.getName(), interactable.getDescription()));
                }
            }
        }
        //next puzzle 
        escapeRoom.setRoom(rooms.get(i+2).getRoomID());
        ArrayList<Interactable> interactables2 = rooms.get(i+2).getInteractables();
        for(Interactable interactable : interactables2) {
                System.out.println(interactable.getDescription());
                interactable.interact();
            }
        Puzzle puzzle2 = rooms.get(i+2).getPuzzles().get(0);
        puzzle2.getContent();
        puzzle2.getClue().getText();
        escapeRoom.requestHint();
        escapeRoom.submitPuzzleAnswer("this is a puzzle answer");
        if(escapeRoom.submitPuzzleAnswer("this is a puzzle answer")) {
            for(Interactable interactable : interactables) {
                if(interactable.getIsItem()){
                    escapeRoom.getCurrentUser().getCharacter("leni").addToInventory(new Item(interactable.getName(), interactable.getDescription()));
                }
            }
        }
        //next puzzle
        escapeRoom.setRoom(rooms.get(i+3).getRoomID());
        ArrayList<Interactable> interactables3 = rooms.get(i+3).getInteractables();
        for(Interactable interactable : interactables3) {
                System.out.println(interactable.getDescription());
                interactable.interact();
            }
        Puzzle puzzle3 = rooms.get(i+3).getPuzzles().get(0);
        puzzle3.getContent();
        puzzle3.getClue().getText();
        escapeRoom.requestHint();
        escapeRoom.submitPuzzleAnswer("this is a puzzle answer");
        if(escapeRoom.submitPuzzleAnswer("this is a puzzle answer")) {
            for(Interactable interactable : interactables) {
                if(interactable.getIsItem()){
                    escapeRoom.getCurrentUser().getCharacter("leni").addToInventory(new Item(interactable.getName(), interactable.getDescription()));
                }
            }
        }


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
        escapeRoom.resumeGame("Leni");

        escapeRoom.endGame();
        System.out.println("Leni has finished the game!");

        Leaderboard leaderboard = Leaderboard.getInstance();

        for(User user : UserList.getUsers()) {
            if(user.getPersonalRecord() != null) {
                leaderboard.addEntry(user.getPersonalRecord());
            }
        }

        ArrayList<LeaderboardEntry> entries = leaderboard.displayGlobal();
        
        int rank = 1;
        for(LeaderboardEntry entry : entries) {
            System.out.println(rank + ". " + entry.getUsername() + 
                               " | Time: " + entry.getScore() + 
                               " | Hints: " + entry.getHintsUsed() + 
                               " | Difficulty: " + entry.getDifficulty());
            rank++;
        }

        Character character = escapeRoom.getCurrentUser().getCharacter("Leni");

        if(character != null){
            Difficulty difficulty = character.getDifficulty();
            character.certificateOfCompletion(difficulty);
        }else{
            System.out.println("Error: Certificate did not generate!");
        }

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

        //pick character
        //escapeRoom.setCurrentCharacter(character(1));

        //ArrayList<Room> rooms = escapeRoom.getRooms();

        //display rooms

        //pick the room

        //display puzzles

        //answer puzzle

        //show new progress
        

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
