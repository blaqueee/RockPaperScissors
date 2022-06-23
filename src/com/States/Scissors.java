package com.States;

import com.Computer;
import com.Game;
import com.User;

public class Scissors extends Choice{
    @Override
    public String getWinner(Game game) {
        User user = game.getUser();
        Computer computer = game.getComputer();

        if (computer.getChoice().getClass().getName().equals(Paper.class.getName())) {
            System.out.println("Scissors VS Paper: User wins!");
            return user.getName();
        } else if (computer.getChoice().getClass().getName().equals(Scissors.class.getName())) {
            System.out.println("Scissors VS Scissors: Draw!");
            return "Draw";
        } else {
            System.out.println("Scissors VS Rock: Computer wins!");
            return computer.getName();
        }
    }
}
