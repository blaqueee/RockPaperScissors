package com;

import com.Exceptions.ChoiceNotFoundException;
import com.Exceptions.EmptyChoiceException;
import com.States.State;

import java.util.Random;
import java.util.Scanner;

public class NormalGame extends Game {
    @Override
    public void initializeCompChoice(){
        Random rnd = new Random();
        int choice = rnd.nextInt(3) + 1;
        switch (choice){
            case 1:
                computer.setChoice(State.ROCK);
                break;
            case 2:
                computer.setChoice(State.PAPER);
                break;
            case 3:
                computer.setChoice(State.SCISSORS);
                break;
        }
    }

    @Override
    public void initializeUserChoice(){
        Scanner sc = new Scanner(System.in);
        while(true){
            printChoices();
            System.out.print("Enter your choice: ");
            try {
                String str = sc.nextLine().replaceAll("\\s+", "");
                System.out.println();
                int choice = parseAndCheckChoice(str);

                switch(choice){
                    case 1:
                        user.setChoice(State.ROCK);
                        break;
                    case 2:
                        user.setChoice(State.PAPER);
                        break;
                    case 3:
                        user.setChoice(State.SCISSORS);
                        break;
                }
                return;
            } catch (EmptyChoiceException | NumberFormatException | ChoiceNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    protected int parseAndCheckChoice(String str) throws EmptyChoiceException, ChoiceNotFoundException{
        if (str.equals(""))
            throw new EmptyChoiceException("Choice can't be empty!");
        int choice = Integer.parseInt(str);
        if (choice < 1 || choice > 3)
            throw new ChoiceNotFoundException("Non-existent choice! Try again!");
        return choice;
    }

    @Override
    protected void printChoices(){
        System.out.println("""
                
                Choice list:
                1 -> Rock
                2 -> Paper
                3 -> Scissors
                """);
    }

    @Override
    public void printUserResults(int rounds){
        System.out.println("\n   <------------- USER -------------->\n");
        System.out.println("+-----+------+------+--------+----------+");
        System.out.println("| WIN | LOSE | DRAW | ROUNDS | WIN RATE |");
        System.out.println("+-----+------+------+--------+----------+");
        System.out.printf( "| %3s | %4s | %4s | %6s | %7.2f%% |%n", user.getAmountOfWins(),
                user.getAmountOfLoses(),
                user.getAmountOfDraws(),
                rounds,
                100.0 / rounds * user.getAmountOfWins()
        );
        System.out.println("+-----+------+------+--------+----------+\n");
    }

    @Override
    public void printComputerResults(int rounds){
        System.out.println("  <------------ COMPUTER ------------->\n");
        System.out.println("+-----+------+------+--------+----------+");
        System.out.println("| WIN | LOSE | DRAW | ROUNDS | WIN RATE |");
        System.out.println("+-----+------+------+--------+----------+");
        System.out.printf( "| %3s | %4s | %4s | %6s | %7.2f%% |%n", computer.getAmountOfWins(),
                computer.getAmountOfLoses(),
                computer.getAmountOfDraws(),
                rounds,
                100.0 / rounds * computer.getAmountOfWins()
        );
        System.out.println("+-----+------+------+--------+----------+");
    }
}