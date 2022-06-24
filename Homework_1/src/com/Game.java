package com;

import com.Exceptions.ChoiceNotFoundException;
import com.Exceptions.EmptyChoiceException;

public abstract class Game {
    protected User user = new User();
    protected Computer computer = new Computer();
    public abstract void initializeCompChoice();
    public abstract void initializeUserChoice();
    protected abstract int parseAndCheckChoice(String str) throws EmptyChoiceException, ChoiceNotFoundException;
    protected abstract void printChoices();
    public abstract void printUserResults(int rounds);
    public abstract void printComputerResults(int rounds);

    public User getUser() {
        return user;
    }

    public Computer getComputer() {
        return computer;
    }
}
