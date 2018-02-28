package com.kodilla.sudoku;

import java.util.ArrayList;

public class SudokuGameProcessor {
    protected static int userChoice = 1;
    protected static ArrayList<Integer> userChoiceList;

    public static ArrayList<Integer> getUserChoiceList() {
        return userChoiceList;
    }

    public static void setChoice(ArrayList<Integer> userChoiceList) {
        SudokuGameProcessor.userChoiceList = userChoiceList;
    }

    public static void setUserChoice(int userChoice) {
        SudokuGameProcessor.userChoice = userChoice;
    }

    public static int getUserChoice() {
        return userChoice;
    }

    public boolean resolveSudoku() {
        Menu menu = new Menu();
        SudokuBoard board = new SudokuBoard();
        FillSudoku fillSudoku = new FillSudoku();
        boolean result = true;

        menu.makeChoice();

        while (getUserChoice() != 0) {
            switch (getUserChoice()) {
                case 0:
                    return true;
                case 1:
                    fillSudoku.resetBoard();
                    setUserChoice(2);
                    break;
                case 2:
                    while (getUserChoice() == 2) {
                        System.out.println(board.toString());
                        menu.makeChoice();
                    }
                    break;
                case 3:
                    fillSudoku.fillWholeSudoku(9);
                    setUserChoice(2);
                    break;
                default:
                    boolean isSucces = fillSudoku.fillBoard(getUserChoiceList());
                    setUserChoice(2);
            }
        }
        return result;
    }
}
