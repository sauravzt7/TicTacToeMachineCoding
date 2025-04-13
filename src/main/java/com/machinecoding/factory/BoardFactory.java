package com.machinecoding.factory;

import com.machinecoding.models.Board;

public class BoardFactory {

    public static Board createBoard(int size) {
        return new Board(size);
    }
}
