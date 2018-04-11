package com.kodilla.sudoku;

public class SudokuGameProcessor {

    private SudokuBoard board;
    private FillSudoku fillSudoku;

    public boolean resolveSudoku() {
        board = new SudokuBoard();
        fillSudoku = new FillSudoku(board);

        boolean finishGame = false;
        do {
            UserChoice choice = Menu.getUserChoice();
            switch (choice.getChoiceType()) {
                case EXIT:
                    finishGame = true;
                    break;
                case NONE:
                    break;
                case NEW_GAME:
                    board = new SudokuBoard();
                    fillSudoku = new FillSudoku(board);
                case SET_VALUE:
                    setValue(choice);
                    Menu.show(board.toString());
                    break;
                case RESOLVE:
                    fillSudoku.fillBoard();
                    Menu.show(board.toString());
                    Menu.gameAgain(); // FIXME: ponowna gra -> Menu.gameAgain() - dorobić
                    break;
            }
        } while (!finishGame);
        return true;
    }

    private void setValue(UserChoice choice) {
        try {
            board.setValueToCell(choice.getColumn() - 1, choice.getRow() - 1, choice.getValue());
        } catch (Exception e) {
            Menu.printIncorrectValueToSet(choice);
        }
    }

}
