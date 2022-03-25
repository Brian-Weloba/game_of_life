package me.bweloba.gameoflife.logic;

public class Algorithms {
    //calculate the number of neighbors to a cell
    public static int computeNeighbors(int[][] board, int row, int col) {
        int neighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col) continue;
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) continue;
                if (board[i][j] == 1) neighbors++;
            }
        }
        return neighbors;
    }

    /**
     * Conways'game of life rules
     * 1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
     * 2. Any live cell with two or three live neighbors lives on to the next generation.
     * 3. Any live cell with more than three live neighbors dies, as if by overpopulation.
     * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * @param board the current board
     * @return int[][] the next board
     */
    public static int[][] applyConwayRules(int[][] board) {
        //loop through the board
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                }
                if (board[i][j] == 0) {
                    if (neighbors == 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }
}
