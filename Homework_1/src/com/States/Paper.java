package com.States;

import com.Computer;
import com.Game;
import com.User;

public class Paper extends Choice{
    @Override
    public String getWinner(Game game) {
        User user = game.getUser();
        Computer computer = game.getComputer();

        if (computer.getChoice().getClass().getName().equals(Paper.class.getName()))
            return "Draw";
        else if (computer.getChoice().getClass().getName().equals(Scissors.class.getName()))
            return computer.getName();
        else
            return user.getName();
    }
}
