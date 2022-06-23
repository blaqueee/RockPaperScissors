package com;

import com.States.Paper;
import com.States.Rock;
import com.States.Scissors;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private User user = new User();
    private Computer computer = new Computer();

    public void initializeCompChoice(){
        Random rnd = new Random();
        int choice = rnd.nextInt(3) + 1;
        switch (choice){
            case 1:
                computer.setChoice(new Rock());
                break;
            case 2:
                computer.setChoice(new Paper());
                break;
            case 3:
                computer.setChoice(new Scissors());
                break;
        }
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
