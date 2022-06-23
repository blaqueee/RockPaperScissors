package com;

import com.States.Choice;

public class Computer {
    private Choice choice;
    private String name = "Computer";

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public void setName(String gamerName) {
        this.name = gamerName;
    }
}
