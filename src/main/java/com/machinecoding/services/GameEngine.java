package com.machinecoding.services;

import com.machinecoding.factory.BoardFactory;
import com.machinecoding.factory.PlayerFactory;
import com.machinecoding.models.Board;
import com.machinecoding.models.Player;
import com.machinecoding.util.IValidator;
import com.machinecoding.util.IWinChecker;
import com.machinecoding.util.MoveValidator;
import com.machinecoding.util.WinChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine implements IGameEngine {

    private final List<Player> players;
    private Board board;
    private final IValidator moveValidator;
    private final IWinChecker checker;

    public GameEngine() {
        this.players = new ArrayList<>();
        this.moveValidator = new MoveValidator();
        this.checker = new WinChecker();
    }

    @Override
    public void initGame(int size) {
        this.board = BoardFactory.createBoard(size);
        System.out.println("Game initialized with " + size + "x" + size + " board.");
    }

    public void startGame() {
        Player currentPlayer = players.get(0);
        // Logic to start the game

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(currentPlayer.getName() + "'s" + "[" +currentPlayer.getSymbol() + "]:" + " Enter row and column: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Validate move
            if (moveValidator.isValidMove(row, col, board)) {
                // Update board
                board.getBoard()[row][col] = currentPlayer.getSymbol().toString();
            } else {
                System.out.println("Invalid move. Try again.");
            }

            // Print board
            board.printBoard();

            // Check for win condition
            if (checker.checkWin(board)) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }


            // Check for draw condition
            if(checker.checkDraw(board)) {
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());

            // Repeat until game over
        }
    }

    public void addPlayer(String playerName, Character symbol){
        // Logic to add player
        Player player = PlayerFactory.createPlayer(playerName, symbol);
        players.add(player);
        System.out.println("Player " + playerName + " added with symbol " + symbol);

    }

    public void removePlayer(String playerName){
        // Logic to remove player
        players.removeIf(player -> player.getName().equals(playerName));
    }
}
