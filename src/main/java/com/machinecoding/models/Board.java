package com.machinecoding.models;

public class Board {
    private final int size;
    private final String[][] board;

    public Board(int size) {
        if(size < 3){
            throw new IllegalArgumentException("Board size must be greater than or equal to 3");
        }
        this.size = size;
        this.board = new String[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = "-";
            }
        }
    }

    public int getSize() {
        return size;
    }

    public String[][] getBoard() {
        return board;
    }

    public void printBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] == null ? "-" : board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
