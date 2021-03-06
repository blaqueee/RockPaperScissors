package com;


import com.States.State;

public class User {
    private State choice;
    private String name = "User";
    private int amountOfWins = 0;
    private int amountOfLoses = 0;
    private int amountOfDraws = 0;

    public int getAmountOfWins() {
        return amountOfWins;
    }

    public void setAmountOfWins(int amountOfWins) {
        this.amountOfWins = amountOfWins;
    }

    public int getAmountOfLoses() {
        return amountOfLoses;
    }

    public void setAmountOfLoses(int amountOfLoses) {
        this.amountOfLoses = amountOfLoses;
    }

    public int getAmountOfDraws() {
        return amountOfDraws;
    }

    public void setAmountOfDraws(int amountOfDraws) {
        this.amountOfDraws = amountOfDraws;
    }

    public State getChoice() {
        return choice;
    }

    public void setChoice(State choice) {
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
