package com;

import com.Exceptions.ChoiceNotFoundException;
import com.Exceptions.EmptyChoiceException;
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

    public void initializeUserChoice(){
        Scanner sc = new Scanner(System.in);
        while(true){
            printChoices();
            System.out.print("Enter your choice: ");
            try {
                String str = sc.nextLine().replaceAll("\\s+", "");
                int choice = parseAndCheckChoice(str);

                switch(choice){
                    case 1:
                        user.setChoice(new Rock());
                        break;
                    case 2:
                        user.setChoice(new Paper());
                        break;
                    case 3:
                        user.setChoice(new Scissors());
                        break;
                }
                return;
            } catch (EmptyChoiceException | NumberFormatException | ChoiceNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private int parseAndCheckChoice(String str) throws EmptyChoiceException, ChoiceNotFoundException{
        if (str.equals(""))
            throw new EmptyChoiceException("Choice can't be empty!");
        int choice = Integer.parseInt(str);
        if (choice < 1 || choice > 3)
            throw new ChoiceNotFoundException("Non-existent choice! Try again!");
        return choice;
    }

    private void printChoices(){
        System.out.println("""
                Choice list:
                1 -> Rock
                2 -> Paper
                3 -> Scissors\n
                """);
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
