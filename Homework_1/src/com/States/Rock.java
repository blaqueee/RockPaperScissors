package com.States;

import com.Computer;
import com.Game;
import com.User;

public class Rock extends Choice{

    @Override
    public String getWinner(Game game) {
        User user = game.getUser();
        Computer computer = game.getComputer();

        if (computer.getChoice().getClass().getName().equals(Paper.class.getName()))
            return computer.getName();
        else if (computer.getChoice().getClass().getName().equals(Scissors.class.getName()))
            return user.getName();
        else
            return "Draw";
    }
}
