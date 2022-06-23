package com.States;

import com.Computer;
import com.Game;
import com.User;

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
                System.out.println("Paper VS Rock: User wins!");
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
            } else if (computer.getChoice() == State.SCISSORS) {
                System.out.println("Rock VS Scissors: User wins!");
                return user.getName();
            } else {
                System.out.println("Rock VS Rock: Draw!");
                return "Draw";
            }
        }
    },
    SCISSORS(){
        public String getWinner(Game game) {
            User user = game.getUser();
            Computer computer = game.getComputer();

            if (computer.getChoice() == State.PAPER) {
                System.out.println("Scissors VS Paper: User wins!");
                return user.getName();
            } else if (computer.getChoice() == State.SCISSORS) {
                System.out.println("Scissors VS Scissors: Draw!");
                return "Draw";
            } else {
                System.out.println("Scissors VS Rock: Computer wins!");
                return computer.getName();
            }
        }
    };

    public String getWinner(Game game) {
        State[] states = State.values();
        for (int i = 0; i < states.length; i++){
            if (game.getUser().getChoice() == states[i])
                return states[i].getWinner(game);
        }
        return null;
    }
}
