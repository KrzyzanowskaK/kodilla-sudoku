package com.kodilla.sudoku;

import java.util.Scanner;

public class Menu {

    public String menuText() {
        return "SUDOKU\n" +
                "Type 3 numbers: crv, where:\n" +
                "c is column, r is row, v is value, example: 123\n" +
                "Other options:\n" +
                "sudoku - will solve Sudoku\n" +
                "n - will start a new game\n" +
                "x - will exit the game";
    }

    public void makeChoice() {
        System.out.println(menuText());
        Scanner reading = new Scanner(System.in);
        System.out.println("\n");
        String choice = reading.next();
        UserChoice userChoice = new UserChoice();

        switch (choice) {
            case "sudoku":
                userChoice.sudoku();
                break;

            case "n":
                System.out.println("Do you want to start a new game?  \n y/n");
                choice = reading.next();
                if(choice.equals("y")){
                    userChoice.resetBoard();
                } else {
                    userChoice.showMenu();
                }

                break;

            case "x":
                System.out.println("Do you want exit the game?  \n y/n");
                choice = reading.next();
                if(choice.equals("y")){
                    userChoice.exit();
                } else {
                    userChoice.showMenu();
                }
                break;

            default:
                userChoice.getUserChoice().clear();
                for (int i=0; i<choice.length(); i++) {
                    int j=0;
                    if(i!=2 && i!=5) {
                        j = Character.digit(choice.charAt(i), 10)-1;
                    } else {
                        j = Character.digit(choice.charAt(i), 10);
                    }
                    if (j>=0 && j<=9) {
                        userChoice.getUserChoice().add(j);
                    } else {
                        userChoice.showMenu();
                    }
                }
                userChoice.setChoice();
                userChoice.createBoard();
        }
    }
}