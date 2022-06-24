package com.States;

import com.*;

public enum State {
    PAPER(){
        public String getWinner(Game game) {
            User user = game.getUser();
            Computer computer = game.getComputer();

            if (computer.getChoice() == State.PAPER) {
                System.out.println("Paper VS Paper: Draw!");
                return "Draw";
            } else if (computer.getChoice() == State.SCISSORS) {
                System.out.println("Paper VS Scissors: Computer wins!");
                return computer.getName();
            } else {
                if (computer.getChoice() == State.ROCK)
                    System.out.println("Paper VS Rock: User wins!");
                else
                    System.out.println("Paper VS Spock: User wins!");
                return user.getName();
            }
        }
    },
    ROCK(){
        public String getWinner(Game game) {
            User user = game.getUser();
            Computer computer = game.getComputer();

            if (computer.getChoice() == State.PAPER) {
                System.out.println("Rock VS Paper: Computer wins!");
                return computer.getName();
            } else if (computer.getChoice() == State.ROCK) {
                System.out.println("Rock VS Rock: Draw!");
                return "Draw";
            } else {
                if (computer.getChoice() == State.SCISSORS)
                    System.out.println("Rock VS Scissors: User wins!");
                else
                    System.out.println("Rock VS Lizard: User wins!");
                return user.getName();
            }
        }
    },
    SCISSORS(){
        public String getWinner(Game game) {
            User user = game.getUser();
            Computer computer = game.getComputer();

            if (computer.getChoice() == State.ROCK) {
                System.out.println("Scissors VS Rock: Computer wins!");
                return computer.getName();
            } else if (computer.getChoice() == State.SCISSORS) {
                System.out.println("Scissors VS Scissors: Draw!");
                return "Draw";
            } else {
                if (computer.getChoice() == State.PAPER)
                    System.out.println("Scissors VS Paper: User wins!");
                else
                    System.out.println("Scissors VS Lizard: User wins!");
                return user.getName();
            }
        }
    },
    LIZARD(){
        public String getWinner(Game game) {
            User user = game.getUser();
            Computer computer = game.getComputer();

            if (computer.getChoice() == State.ROCK) {
                System.out.println("Lizard VS Rock: Computer wins!");
                return computer.getName();
            } else if (computer.getChoice() == State.SCISSORS) {
                System.out.println("Lizard VS Scissors: Computer wins!");
                return computer.getName();
            } else if (computer.getChoice() == State.LIZARD) {
                System.out.println("Lizard VS Lizard: Draw!");
                return "Draw";
            } else {
                if (computer.getChoice() == State.PAPER)
                    System.out.println("Lizard VS Paper: User wins!");
                else
                    System.out.println("Lizard VS Spock: User wins!");
                return user.getName();
            }
        }
    },
    SPOCK(){
        public String getWinner(Game game) {
            User user = game.getUser();
            Computer computer = game.getComputer();

            if (computer.getChoice() == State.PAPER) {
                System.out.println("Spock VS Paper: Computer wins!");
                return computer.getName();
            } else if (computer.getChoice() == State.LIZARD) {
                System.out.println("Spock VS Lizard: Computer wins!");
                return computer.getName();
            } else if (computer.getChoice() == State.SPOCK) {
                System.out.println("Spock VS Spock: Draw!");
                return "Draw";
            } else {
                if (computer.getChoice() == State.ROCK)
                    System.out.println("Spock VS Rock: User wins!");
                else
                    System.out.println("Spock VS Scissors: User wins!");
                return user.getName();
            }
        }
    };

    public String getWinner(Game game) {
        State[] states = State.values();
        for (State state : states) {
            if (game.getUser().getChoice() == state)
                return state.getWinner(game);
        }
        return null;
    }
}
