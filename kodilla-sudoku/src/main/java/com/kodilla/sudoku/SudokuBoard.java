package com.kodilla.sudoku;

public class SudokuBoard {
    protected static SudokuRow[] board = new SudokuRow[10];

    public SudokuBoard() {
        for (int n = 0; n < 9; n++) {
            board[n] = new SudokuRow();

        }
    }

    public static SudokuRow[] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String printBoard = "    1   2   3   4   5   6   7   8   9" + "\n";

        for(int i=0; i<9; i++) {
            printBoard += 1 + i +" |";
            for(int n=0; n<9; n++) {
                if(getBoard()[i].getSudokuElements().get(n).getValue() == -1) {
                    printBoard += " - ";
                } else {
                    printBoard += " ";
                    printBoard += getBoard()[i].getSudokuElements().get(n).getValue();
                    printBoard += " ";
                }
                printBoard += "|";
            }
            printBoard += "\n";
        }
        return printBoard;
    }
}