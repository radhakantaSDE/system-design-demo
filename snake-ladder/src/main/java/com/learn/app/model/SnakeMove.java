package com.learn.app.model;

public class SnakeMove extends Move {

    public SnakeMove(int nextPosition) {
        super(nextPosition);
    }

    @Override
    public int move() {
        return this.getNextPosition();
    }
}
