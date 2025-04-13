package com.machinecoding.util;

import com.machinecoding.models.Board;

public interface IWinChecker {
    boolean checkWin(Board board);
    boolean checkDraw(Board board);
}
