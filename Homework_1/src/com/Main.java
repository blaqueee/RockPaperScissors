package com;

import com.Exceptions.ChoiceNotFoundException;
import com.Exceptions.EmptyChoiceException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int rounds = 1;
        Game game = null;
        switch (chooseGame()){
            case 1:
                game = new NormalGame();
                break;
            case 2:
                game = new HardGame();
                break;
        }
        while (rounds != 6) {
            System.out.printf("%n+------> ROUND %s <------+%n", rounds);
            game.initializeUserChoice();
            game.initializeCompChoice();

            writeResults(game);
            rounds++;
        }
        game.printUserResults(rounds - 1);
        game.printComputerResults(rounds - 1);
    }

    private static void writeResults(Game game){
        String result = game.getUser().getChoice().getWinner(game);

        switch (result){
            case "Computer":
                game.getComputer().setAmountOfWins(game.getComputer().getAmountOfWins() + 1);
                game.getUser().setAmountOfLoses(game.getUser().getAmountOfLoses() + 1);
                break;
            case "User":
                game.getUser().setAmountOfWins(game.getUser().getAmountOfWins() + 1);
                game.getComputer().setAmountOfLoses(game.getComputer().getAmountOfLoses() + 1);
                break;
            case "Draw":
                game.getUser().setAmountOfDraws(game.getUser().getAmountOfDraws() + 1);
                game.getComputer().setAmountOfDraws(game.getComputer().getAmountOfDraws() + 1);
                break;
        }

    }

    private static int chooseGame(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("""
                1 -> Normal Game
                2 -> Hard Game
                Choose mode:\s""");
            try {
                String str = sc.nextLine().replaceAll("\\s+", "");
                return parseAndCheckChoice(str);
            } catch (ChoiceNotFoundException | NumberFormatException | EmptyChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseAndCheckChoice(String str) throws EmptyChoiceException, ChoiceNotFoundException {
        if (str.equals(""))
            throw new EmptyChoiceException("Choice can't be empty!");
        int choice = Integer.parseInt(str);
        if (choice < 1 || choice > 2)
            throw new ChoiceNotFoundException("Non-existent choice! Try again!");
        return choice;
    }

}
