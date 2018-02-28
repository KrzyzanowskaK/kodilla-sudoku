package com.kodilla.sudoku;

public class SudokuGame {
    public static void main(String[] args) {
        boolean gameFinished = false;

        while(!gameFinished) {
            SudokuGameProcessor theGame = new SudokuGameProcessor();
            gameFinished = theGame.resolveSudoku();
        }
    }
}