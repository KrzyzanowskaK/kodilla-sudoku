package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Random;

public class FillSudoku {
    private final SudokuBoard board;
    private CheckSudoku checkSudoku = new CheckSudoku();
    private int randomValue;
    Random random = new Random();

    public FillSudoku(SudokuBoard board) {
        this.board = board;
    }

    public void resetBoard() {
        for (int i=0; i<9; i++) {
            for (int n=0; n<9; n++) {
                checkSudoku.setValue(n, i, -1);
            }
        }
    }

    public boolean fillBoard(ArrayList<Integer> shoot) {
        boolean isRepeated;
        isRepeated = CheckSudoku.checkBoardSetValue(shoot.get(0), shoot.get(1), shoot.get(2), board);
        if(shoot.size()>3 && shoot.size()<7) {
            isRepeated = CheckSudoku.checkBoardSetValue(shoot.get(3), shoot.get(4), shoot.get(5), board);
        }
        return isRepeated;
    }

    public boolean fillWholeSudoku(int number) {
        boolean isRepeated = false;

        for (int numberOfLine = 0; numberOfLine < 9; numberOfLine++) {
            int count = 0;
            levelLoop:
            while (CheckSudoku.countNumbersInLine(numberOfLine) <= number) {
                for (int numberOfColumns = 0; numberOfColumns < 9; numberOfColumns++) {
                    randomValue = random.nextInt(10);
                    while (randomValue < 1) {
                        randomValue = random.nextInt(10);
                    }
                    for (int i=0; i<100; i++) {
                        isRepeated = CheckSudoku.checkBoardSetValue(numberOfColumns, numberOfLine, randomValue, board);
                        if (isRepeated) {
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (isRepeated) {
                        count++;
                    }
                    if (CheckSudoku.countNumbersInLine(numberOfLine) == number) {
                        break levelLoop;
                    }
                }
                if (count > 100) {
                    for (int n=0; n<9; n++) {
                        CheckSudoku.setValue(n, numberOfLine, -1);
                    }
                    count = 0;
                }
            }
        }
        return true;
    }
}