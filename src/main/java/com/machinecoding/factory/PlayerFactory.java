package com.machinecoding.factory;

import com.machinecoding.models.Player;

public class PlayerFactory {

    public static Player createPlayer(String name, Character symbol) {
        return new Player(name, symbol);
    }
}
