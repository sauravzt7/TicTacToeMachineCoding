package com.machinecoding;

import com.machinecoding.services.GameEngine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        gameEngine.initGame(3);


        gameEngine.addPlayer("Alice", 'X');
        gameEngine.addPlayer("Bob", 'O');
        gameEngine.startGame();





    }
}