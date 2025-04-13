package com.machinecoding.util;

import com.machinecoding.models.Board;

public class WinChecker implements IWinChecker {


    @Override
    public boolean checkDraw(Board board) {
        for (int x = 0; x < board.getBoard().length; x++) {
            for (int y = 0; y < board.getBoard().length; y++) {
                if (board.getBoard()[x][y] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean checkWin(Board board) {

        for(int i = 0; i < board.getSize(); i++) {
            // Check rows
            if (checkRow(board, i) || checkColumn(board, i) || checkDiagonal(board)) {
                return true;
            }
        }

        return false;

    }

    private boolean checkDiagonal(Board board) {

        // Check main diagonal
        for(int i = 1; i < board.getSize(); i++) {
            if(board.getBoard()[i][i].equals("-")) return false;
            if(!board.getBoard()[i][i].equals(board.getBoard()[i - 1][ i - 1])) return false;
        }

        // Check anti diagonal
        for(int i = 1; i < board.getSize(); i++) {
            if(board.getBoard()[i][board.getSize() - 1 - i] == null) return false;
            if(!board.getBoard()[i][board.getSize() - 1 - i].equals(board.getBoard()[i - 1][board.getSize() - 1 - (i - 1)])) return false;
        }

        return true;
    }

    private boolean checkColumn(Board board, int i) {
        for(int j = 1; j < board.getSize(); j++) {
            if(board.getBoard()[i][j].equals("-")) return false;
            if(!board.getBoard()[j][i].equals(board.getBoard()[j - 1][i])) return false;
        }
        return true;
    }

    private boolean checkRow(Board board, int i) {

        for(int j = 1; j < board.getSize(); j++) {
            if(board.getBoard()[i][j].equals("-")) return false;
            if(!board.getBoard()[i][j].equals(board.getBoard()[i][j - 1])) return false;
        }
        return true;
    }


}
