package com.learn.app.model;

public class LadderMove extends Move {

    public LadderMove(int nextPosition) {
        super(nextPosition);
    }

    @Override
    public int move() {
        return this.getNextPosition();
    }
}
