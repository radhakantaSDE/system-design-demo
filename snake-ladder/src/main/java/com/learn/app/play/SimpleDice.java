package com.learn.app.play;

import java.util.Random;

public class SimpleDice implements Dice {

    Random ran = new Random();

    @Override
    public int rollDice() {
        return ran.nextInt(6) + 1;
    }
}
