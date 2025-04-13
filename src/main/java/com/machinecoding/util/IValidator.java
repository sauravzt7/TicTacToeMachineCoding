package com.machinecoding.util;

import com.machinecoding.models.Board;

public interface IValidator {
    boolean isValidMove(int x, int y, Board board);
}
