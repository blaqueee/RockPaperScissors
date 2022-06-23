package com;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        int rounds = 1;

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

}
