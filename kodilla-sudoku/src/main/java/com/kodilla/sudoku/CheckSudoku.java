package com.kodilla.sudoku;

import static com.kodilla.sudoku.SudokuBoard.getBoard;

public class CheckSudoku {
    private boolean isValueRepeated = false;

    public boolean checkRow(int y, int value){
        for (int i=0; i<9; i++) {
            if (value == getBoard()[y].getSudokuElements().get(i).getValue()) {
                isValueRepeated = true;
                break;
            }
        }
        return isValueRepeated;
    }

    public boolean checkColumn(int x, int value){
        for (int i=0; i<9; i++) {
            if (value == getBoard()[i].getSudokuElements().get(x).getValue()) {
                isValueRepeated = true;
                break;
            }
        }
        return isValueRepeated;
    }

    public boolean checkSquare(int number, int value){
        switch(number){
            case 0: {
                for(int i=0; i<3; i++){
                    for(int n=0; n<3; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 1: {
                for(int i=0; i<3; i++){
                    for(int n=3; n<6; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 2: {
                for(int i=0; i<3; i++){
                    for(int n=6; n<9; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 3: {
                for(int i=3; i<6; i++){
                    for(int n=0; n<3; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 4: {
                for(int i=3; i<6; i++){
                    for(int n=3; n<6; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 5: {
                for(int i=3; i<6; i++){
                    for(int n=6; n<9; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 6: {
                for(int i=6; i<9; i++){
                    for(int n=0; n<3; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 7: {
                for(int i=6; i<9; i++){
                    for(int n=3; n<6; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 8: {
                for(int i=6; i<9; i++){
                    for(int n=6; n<9; n++){
                        if(getBoard()[i].getSudokuElements().get(n).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
        }
        return isValueRepeated = false;
    }

    public boolean setValue(int x, int y, int value){
        getBoard()[y].getSudokuElements().get(x).setValue(value);
        return true;
    }

    public int countNumbersInLine(int numberOfLine) {
        int count = 0;
        for (int i=0; i<9; i++) {
            if (getBoard()[numberOfLine].getSudokuElements().get(i).getValue() != -1) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBoardSetValue(int x, int y, int value){
        isValueRepeated = true;
        boolean isPositionEmpty = getBoard()[y].getSudokuElements().get(x).getValue() == -1;

        if(isPositionEmpty) {
            isValueRepeated = false;
            if(!checkRow(y, value)) {
                if(!checkColumn(x, value)) {
                    if (x <= 2 && y <= 2) {
                        if (!checkSquare(0, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 2 && x <= 5 && y <= 2) {
                        if (!checkSquare(1, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && x <= 8 && y <= 2) {
                        if (!checkSquare(2, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x <= 2 && y <= 5 && y > 2) {
                        if (!checkSquare(3, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 2 && x <= 5 && y <= 5 && y > 2) {
                        if (!checkSquare(4, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && y <= 5 && y > 2) {
                        if (!checkSquare(5, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x <= 2 && y > 5) {
                        if (!checkSquare(6, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 2 && x <= 5 && y > 5) {
                        if (!checkSquare(7, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && y > 5) {
                        if (!checkSquare(8, value)) {
                            setValue(x, y, value);
                        }
                    }
                }
            }
        }
        return isValueRepeated;
    }
}