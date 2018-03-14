package com.kodilla.sudoku;

import static com.kodilla.sudoku.SudokuBoard.getBoard;

public class CheckSudoku {

    private static final int[] START_ROWS_INDEX_TAB = new int[]{0,0,0,3,3,3,6,6,6};
    private static final int RANGE = 3;

    private static boolean checkRow(int y, int value, SudokuBoard board){
        for (int i=0; i<9; i++) {
            if (value == board.getCell(y, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumn(int x, int value, SudokuBoard board){
        for (int i=0; i<9; i++) {
            if (value == board.getCell(i, x)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSquare(int number, int value, SudokuBoard board){
        int startRow = START_ROWS_INDEX_TAB[number];
        int endRow = startRow + RANGE;

        int startColumn = (number % 3) * 3;
        int endColumn = startColumn + RANGE;

        for (; startRow < endRow; startRow++) {
            for (; startColumn < endColumn; startColumn++) {
                if (board.getCell(startRow, startColumn) == value) {
                    return true; //FIXME
                }
            }
        }
        return false;
    }

    public static boolean setValue(int x, int y, int value){
        getBoard()[y].getSudokuElements().get(x).setValue(value);
        return true;
    }

    public static int countNumbersInLine(int numberOfLine) {
        int count = 0;
        for (int i=0; i<9; i++) {
            if (getBoard()[numberOfLine].getSudokuElements().get(i).getValue() != -1) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkBoardSetValue(int x, int y, int value, SudokuBoard board){
        boolean isPositionEmpty = getBoard()[y].getSudokuElements().get(x).getValue() == -1;

        if(isPositionEmpty) {
            return false;
            if(!checkRow(y, value, board)) {
                if(!checkColumn(x, value, board)) {
                    if (x <= 2 && y <= 2) {
                        if (!checkSquare(0, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 2 && x <= 5 && y <= 2) {
                        if (!checkSquare(1, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && x <= 8 && y <= 2) {
                        if (!checkSquare(2, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x <= 2 && y <= 5 && y > 2) {
                        if (!checkSquare(3, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 2 && x <= 5 && y <= 5 && y > 2) {
                        if (!checkSquare(4, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && y <= 5 && y > 2) {
                        if (!checkSquare(5, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x <= 2 && y > 5) {
                        if (!checkSquare(6, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 2 && x <= 5 && y > 5) {
                        if (!checkSquare(7, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && y > 5) {
                        if (!checkSquare(8, value, board)) {
                            setValue(x, y, value);
                        }
                    }
                }
            }
        }
        return true;
    }
}