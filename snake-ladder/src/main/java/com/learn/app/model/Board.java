package com.learn.app.model;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Board {

    // Total number of cells (100, 120, etc.)
    private int boardLength;
    // cellPosition -> Cell
    private Map<Integer, Cell> boardCell;

    public Board(int boardLength, List<Cell> specialCell) {
        this.boardLength = boardLength;
        this.boardCell = specialCell.stream().collect(Collectors.toMap(Cell::getCellNumber, e->e));
    }

    public int nextMove(int currentPosition, int diceRollValue) {

        // 1. Validate new position
        if (currentPosition+diceRollValue > boardLength) {

            // If going out of range then, don't move
            return currentPosition;
        }

        Cell nextCell = boardCell.get(currentPosition + diceRollValue);

        // 2. Check new cell special move
        if (nextCell != null && nextCell.getSpecialMove() != null) {
            return nextCell.getSpecialMove().getNextPosition();
        }
        return currentPosition + diceRollValue;
    }
}
