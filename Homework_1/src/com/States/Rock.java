package com.States;

import com.Computer;
import com.Game;
import com.User;

public class Rock extends Choice{

    @Override
    public String getWinner(Game game) {
        User user = game.getUser();
        Computer computer = game.getComputer();

        if (computer.getChoice().getClass().getName().equals(Paper.class.getName())) {
            System.out.println("Rock VS Paper: Computer wins!");
            return computer.getName();
        } else if (computer.getChoice().getClass().getName().equals(Scissors.class.getName())) {
            System.out.println("Rock VS Scissors: User wins!");
            return user.getName();
        } else {
            System.out.println("Rock VS Rock: Draw!");
            return "Draw";
        }
    }
}
