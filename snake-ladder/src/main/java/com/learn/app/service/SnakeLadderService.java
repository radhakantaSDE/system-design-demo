package com.learn.app.service;

import com.learn.app.model.Player;

public interface SnakeLadderService {

    void registerPlayer(String playerName);
    Player getNextPlayer();
    void rollDice(Player player);
}
