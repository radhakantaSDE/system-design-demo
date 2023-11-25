package com.learn.app.service;

import com.learn.app.exception.SnakeLadderException;
import com.learn.app.model.*;
import com.learn.app.play.Dice;
import com.learn.app.play.SimpleDice;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeLadderServiceImpl implements SnakeLadderService {

    private static final int BOARD_LENGTH = 100;
    private Board board;
    private final Dice dice;
    private final Queue<Player> playerQueue = new LinkedList<>();

    public SnakeLadderServiceImpl() {
        dice = new SimpleDice();
        initBoard();
    }

    private void initBoard() {

        Cell cellLadder1 = Cell.builder().cellNumber(7).specialMove(new LadderMove(28)).build();
        Cell cellLadder2 = Cell.builder().cellNumber(21).specialMove(new LadderMove(43)).build();
        Cell cellLadder3 = Cell.builder().cellNumber(33).specialMove(new LadderMove(69)).build();
        Cell cellLadder4 = Cell.builder().cellNumber(35).specialMove(new LadderMove(77)).build();
        Cell cellLadder5 = Cell.builder().cellNumber(59).specialMove(new LadderMove(84)).build();

        Cell cellSnake1 = Cell.builder().cellNumber(37).specialMove(new SnakeMove(15)).build();
        Cell cellSnake2 = Cell.builder().cellNumber(97).specialMove(new SnakeMove(68)).build();
        Cell cellSnake3 = Cell.builder().cellNumber(89).specialMove(new SnakeMove(54)).build();

        board = new Board(BOARD_LENGTH, List.of(cellLadder1,cellLadder2,cellLadder3, cellLadder4, cellLadder5, cellSnake1, cellSnake2, cellSnake3));
    }

    @Override
    public void registerPlayer(@NonNull String playerName) {

        playerQueue.offer(Player.builder().playerName(playerName).playerCellNumber(0).build());
    }

    @Override
    public Player getNextPlayer() {
        if (playerQueue.isEmpty()){
            throw new SnakeLadderException("Invalid player list");
        }
        return playerQueue.poll();
    }

    @Override
    public void rollDice(Player player) {

        int newPos = board.nextMove(player.getPlayerCellNumber(), dice.rollDice());
        player.setPlayerCellNumber(newPos);

        if (newPos == BOARD_LENGTH) {
            System.out.println(player.getPlayerName() + " win. Game finished.");
        }else {
            // Add the player to the queue
            playerQueue.offer(player);
        }
    }
}
