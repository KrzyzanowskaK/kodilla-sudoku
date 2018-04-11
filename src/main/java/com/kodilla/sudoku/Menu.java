package com.kodilla.sudoku;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    private static String menuText() {
        return "SUDOKU\n" +
                "Type 3 numbers: rcv, where:\n" +
                "r is row, c is column, v is value, example: 123\n" +
                "Other options:\n" +
                "sudoku - will solve Sudoku\n" +
                "n - will start a new game\n" +
                "x - will exit the game";
    }

    public static UserChoice getUserChoice() {
        System.out.println(menuText());
        System.out.println();

        String input = scanner.next();
        boolean isDigits = input.chars().allMatch(Character::isDigit);
        boolean digitsCorrectLength = input.length() == 3;

        switch (input.toLowerCase()) {
            case "sudoku":
                return new UserChoice(UserChoiceType.RESOLVE);
            case "n" :
                return startNewGame();
            case "x" :
                return exitGame();
            default:
                if(isDigits && digitsCorrectLength) {
                    char[] inputTab = input.toCharArray();
                    int column = Character.getNumericValue(inputTab[0]);
                    int row = Character.getNumericValue(inputTab[1]);
                    int value = Character.getNumericValue(inputTab[2]);
                    return new UserChoice(column, row, value);
                } else {
                    return new UserChoice(UserChoiceType.NONE);
                }
        }
    }

    private static UserChoice startNewGame() {
        boolean correctInput = false;
        do {
            System.out.println("Do you want to start a new game? y/n");
            String input = scanner.next();
            if(input.equalsIgnoreCase("y")) {
                correctInput = true;
                return new UserChoice(UserChoiceType.NEW_GAME);
            }
            if(input.equalsIgnoreCase("n")) {
                correctInput = true;
                return new UserChoice(UserChoiceType.NONE);
            }
        } while (!correctInput);
        return new UserChoice(UserChoiceType.NONE);
    }

    public static UserChoice gameAgain() {
        boolean correctInput = false;
        do {
            System.out.println("Do you want to play again? y/n");
            String input = scanner.next();
            if(input.equalsIgnoreCase("y")) {
                correctInput = true;
                return new UserChoice(UserChoiceType.NEW_GAME);
            }
            if(input.equalsIgnoreCase("n")) {
                correctInput = true;
                return new UserChoice(UserChoiceType.EXIT);
            }
        } while (!correctInput);
        return new UserChoice(UserChoiceType.NONE);
    }

    private static UserChoice exitGame() {
        boolean correctInput = false;
        do {
            System.out.println("Do you want exit? y/n");
            String input = scanner.next();
            if(input.equalsIgnoreCase("y")) {
                correctInput = true;
                return new UserChoice(UserChoiceType.EXIT);
            }
            if(input.equalsIgnoreCase("n")) {
                correctInput = true;
                return new UserChoice(UserChoiceType.NONE);
            }
        } while (!correctInput);
        return new UserChoice(UserChoiceType.NONE);
    }

    public static void printIncorrectValueToSet(UserChoice choice) {
        System.out.println("Incorrect value: " + choice);
    }

    public static void show(String text) {
        System.out.println(text);
    }
}