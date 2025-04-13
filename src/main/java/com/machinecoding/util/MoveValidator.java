package com.machinecoding.util;

import com.machinecoding.models.Board;

public class MoveValidator implements IValidator{


    @Override
    public boolean isValidMove(int x, int y, Board board) {

        // Check if the coordinates are within the bounds of the board
        if (x < 0 || x >= board.getSize() || y < 0 || y >= board.getSize()) {
            return false;
        }

        // Check if the cell is already occupied
        return board.getBoard()[x][y].equals("-");

    }
}
