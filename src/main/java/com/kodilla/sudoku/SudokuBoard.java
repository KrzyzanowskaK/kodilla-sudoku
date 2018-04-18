package com.kodilla.sudoku;

import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {

    private static final int[] START_ROWS_INDEX_TAB = new int[]{0,0,0,3,3,3,6,6,6};
    private static final int RANGE = 3;
    private static final int MAX_COLUMN = 9;
    private static final int MIN_COLUMN = 0;
    private static final int MAX_ROWS = 9;
    private static final int MIN_ROWS = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private SudokuRow[] board = new SudokuRow[MAX_ROWS + 1];

    public SudokuBoard() {
        for (int i = 0; i < MAX_ROWS; i++) {
            board[i] = new SudokuRow();
        }
    }

    public SudokuRow[] getBoard() {
        return board;
    }

    public void setValueToCell(int row, int column, int value) throws IncorrectValueException {
        if(!canSetValue(row, column, value)) {
            throw new IncorrectValueException("Incorrect value " + value + " in row " + row + " column " + column);
        }
        board[column].getSudokuElements().get(row).setValue(value);
    }

    public int getValue(int row, int column) throws IncorrectValueException {
        if(!correctColumnAndRow(row, column)) {
            throw new IncorrectValueException("Number for row and column must be between 1 and 9.");
        }
        return board[column].getSudokuElements().get(row).getValue();
    }

    public boolean canResolve() {
        return true; // FIXME
    }

    private boolean checkSquare(int squareNumber, int value) throws Exception {
        int startRow = START_ROWS_INDEX_TAB[squareNumber];
        int endRow = startRow + RANGE;

        int startColumn = (squareNumber % 3) * 3;
        int endColumn = startColumn + RANGE;

        for (; startRow < endRow; startRow++) {
            for(; startColumn < endColumn; startColumn++) {
                if(getValue(startRow, startColumn) == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRow(int row, int value) throws Exception {
        for (int i=0; i<MAX_ROWS; i++) {
            if(value == getValue(i, row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int column, int value) throws Exception {
        for (int i=0; i<MAX_COLUMN; i++) {
            if(value == getValue(column, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean canSetValue(int column, int row, int value) {
        boolean correctValue = value >= MIN_VALUE && value <= MAX_VALUE;
        return correctValue && correctColumnAndRow(column, row);
    }

    private boolean correctColumnAndRow(int column, int row) {
        boolean correctColumn = column >= MIN_COLUMN && column <= MAX_COLUMN;
        boolean correctRow = row >= MIN_ROWS && row <= MAX_ROWS;
        return correctColumn && correctRow;
    }

    @Override
    protected SudokuBoard clone() throws CloneNotSupportedException {
        SudokuBoard sudokuBoard = this.clone();
        sudokuBoard.board = new SudokuRow[MAX_ROWS + 1];
        for(int i = 0; i < MAX_ROWS; i++) {
            List<SudokuElement> elements = board[i].getSudokuElements();
            for (int j = 0; j < elements.size(); j++) {
                sudokuBoard.board[i].getSudokuElements().get(j).setValue(elements.get(j).getValue());
            }
        }
        return sudokuBoard;
    }

    @Override
    public String toString() {
        StringBuilder printBoard = new StringBuilder("    1   2   3   4   5   6   7   8   9" + "\n");

        for(int i=0; i<MAX_ROWS; i++) {
            printBoard.append(1 + i).append(" |");
            for(int n=0; n<MAX_ROWS; n++) {
                if(getBoard()[i].getSudokuElements().get(n).getValue() == -1) {
                    printBoard.append(" - ");
                } else {
                    printBoard.append(" ");
                    printBoard.append(getBoard()[i].getSudokuElements().get(n).getValue());
                    printBoard.append(" ");
                }
                printBoard.append("|");
            }
            printBoard.append("\n");
        }
        return printBoard.toString();
    }
}