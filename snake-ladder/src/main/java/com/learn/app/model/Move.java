package com.learn.app.model;


import lombok.Data;

@Data
public abstract class Move {

    private int nextPosition;
    protected Move(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    public abstract int move();
}
