package com.kodilla.sudoku;

public class SudokuBoard {
    private static final int BOARD_SIZE = 9;
    private static SudokuRow[] board = new SudokuRow[BOARD_SIZE];

    public SudokuBoard() {
        initBoad();
    }

    public static SudokuRow[] getBoard() {
        return board;
    }

    public int getCell(int rowIndex, int columnIndex) {
        return board[rowIndex].getSudokuElements().get(columnIndex).getValue();
    }

    public void setCellValue(int rowIndex, int columnIndex, int value) {
        board[rowIndex].getSudokuElements().get(columnIndex).setValue(value);
    }

    private void initBoad() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = new SudokuRow();
        }
    }

    @Override
    public String toString() {
        StringBuilder printBoard = new StringBuilder("    1   2   3   4   5   6   7   8   9" + "\n");

        for(int i = 0; i < BOARD_SIZE ; i++) {
            printBoard.append(1).append(i).append(" |");
            for(int n = 0; n < BOARD_SIZE; n++) {
                if(getCell(i, n) == -1) {
                    printBoard.append(" - ");
                } else {
                    printBoard.append(" ");
                    printBoard.append(getCell(i, n));
                    printBoard.append(" ");
                }
                printBoard.append("|");
            }
            printBoard.append("\n");
        }
        return printBoard.toString();
    }
}