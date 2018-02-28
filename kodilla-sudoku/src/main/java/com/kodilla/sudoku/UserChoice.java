package com.kodilla.sudoku;

import java.util.ArrayList;

import static com.kodilla.sudoku.SudokuGameProcessor.setUserChoice;

public class UserChoice {
    private ArrayList<Integer> userChoiceList = new ArrayList<>();

    public ArrayList<Integer> getUserChoice() {
        return userChoiceList;
    }

    public void setChoice(){
        SudokuGameProcessor.setChoice(userChoiceList);
    }

    public void exit(){
        setUserChoice(0);
    }

    public  void resetBoard(){
        setUserChoice(1);
    }

    public  void showMenu(){
        setUserChoice(2);
    }

    public void sudoku(){
        setUserChoice(3);
    }

    public void createBoard(){
        setUserChoice(4);
    }
}