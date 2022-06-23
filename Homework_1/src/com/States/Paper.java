package com.States;

import com.Computer;
import com.Game;
import com.User;

public class Paper extends Choice{
    @Override
    public String getWinner(Game game) {
        User user = game.getUser();
        Computer computer = game.getComputer();

        if (computer.getChoice().getClass().getName().equals(Paper.class.getName())) {
            System.out.println("Paper VS Paper: Draw!");
            return "Draw";
        } else if (computer.getChoice().getClass().getName().equals(Scissors.class.getName())) {
            System.out.println("Paper VS Scissors: Computer wins!");
            return computer.getName();
        } else {
            System.out.println("Paper VS Rock: User wins!");
            return user.getName();
        }
    }
}
