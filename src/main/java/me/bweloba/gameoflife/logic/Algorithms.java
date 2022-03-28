package me.bweloba.gameoflife.logic;

import me.bweloba.gameoflife.models.Grid;

public class Algorithms {
    int numRows = new Grid().getNumRows();


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
     * Conway's game of life rules
     * B3/S23
     * 1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
     * 2. Any live cell with two or three live neighbors lives on to the next generation.
     * 3. Any live cell with more than three live neighbors dies, as if by overpopulation.
     * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     *
     * @param board the current board
     * @return int[][] the next board
     */
    public static int[][] applyConwayRules(int[][] board) {
        //loop through the board\
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

    //High Life Algorithm

    /**
     * High Life Rules
     * B36/S23
     * 1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
     * 2. Any live cell with two or three live neighbors lives on to the next generation.
     * 3. Any live cell with more than three live neighbors dies, as if by overpopulation.
     * 4. Any dead cell with exactly three or six live neighbors becomes a live cell, as if by reproduction.
     *
     * @param board the current board
     * @return int[][] the next board
     */
    public static int[][] applyHighLifeRules(int[][] board) {
        //loop through the board\
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
                    if (neighbors == 3 || neighbors == 6) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }

    //Day & Night Algorithm

    /**
     * Day & Night Rules
     * B3678/S34678
     * 1. Any cell with 3,4,6,7,8 live neighbors survives.
     * 2. Any dead cell with exactly 3,6,7,8 live neighbors becomes a live cell, as if by reproduction.
     * 3 Any cell with less than 3 live neighbors, exactly 5 live neighbors, or more than 8 live neighbors dies, as if by overpopulation.
     *
     * @return int[][] the next board
     * @param board the current board
     */
    public static int[][] applyDayNightRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (neighbors < 3 || neighbors > 8 || neighbors == 5) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                }
                if (board[i][j] == 0) {
                    if (neighbors == 3 || neighbors == 6 || neighbors == 7 || neighbors == 8) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }

    //Diamoeba Algorithm

    /**
     * Diamoeba Rules
     * B35678/S5678
     * 1. Any live cell with fewer than 5 live neighbors dies, as if by underpopulation.
     * 2. Any live cell with more than 8 live neighbors dies, as if by overpopulation.
     * 3. Any dead cell with exactly 3,5,6,7,8 live neighbors becomes a live cell, as if by reproduction.
     * 4. Any cell with 5 to 8 live neighbors lives on to the next generation.
     */
    public static int[][] applyDiamoebaRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (neighbors < 5 || neighbors > 8) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                }
                if (board[i][j] == 0) {
                    if (neighbors == 3 || neighbors == 5 || neighbors == 6 || neighbors == 7 || neighbors == 8) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }

    //Replicator Algorithm

    /**
     * Replicator Rules
     * B1357/S1357
     * 1. Any live cell with more than 7 live neighbors dies, as if by overpopulation.
     * 2. Any live cell with exactly 2,4,or 6 neighbors dies as if by underpopulation.
     * 3. Any live cell with exactly 1, 3, 5, or 7 live neighbors lives on to the next generation.
     * 4. Any dead cell with exactly 1, 3, 5, or 7 live neighbors becomes a live cell, as if by reproduction.
     *
     * @return int[][] the next board
     * @param board the current board
     */
    public static int[][] applyReplicatorRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (neighbors > 7 || neighbors == 2 || neighbors == 4 || neighbors == 6) {
                        newBoard[i][j] = 0;
                    } else {
                        newBoard[i][j] = 1;
                    }
                }
                if (board[i][j] == 0) {
                    if (neighbors == 1 || neighbors == 3 || neighbors == 5 || neighbors == 7) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }

    //Seeds Algorithm

    /**
     * Seeds Algorithm rules
     * b2/s
     * 1. Any dead cell with exactly 2 live neighbors becomes a live cell, as if by reproduction.
     * 2. Any live cell dies due to underpopulation or overpopulation.
     *
     * @return int[][] the next board
     * @param board the current board
     */
    public static int[][] applySeedsRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (neighbors == 2) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                }
            }
        }
        return newBoard;
    }

    //2x2

    /**
     * 2x2 rules
     * B36/S125
     * 1. Any dead cell with exactly 3 or 6 live neighbors becomes a live cell, as if by reproduction.
     * 2 Any live cell with 2, 3, or 5 live neighbors lives on to the next generation.
     * 3. Any live cell with fewer than 2, 3, 4 or more than 6 live neighbors dies, as if by underpopulation or overpopulation.
     *
     * @return int[][] the next board
     * @param board the current board
     */
    public static int[][] apply2x2Rules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (neighbors == 3 || neighbors == 6) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
                if (board[i][j] == 1) {
                    if (neighbors == 1 || neighbors == 3 || neighbors == 5) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }

    //Life without Death

    /**
     * Life without Death rules
     * B3/S012345678
     * 1. Any dead cell with exactly 3 live neighbors becomes a live cell, as if by reproduction.
     * 2. All live cells survive.
     *
     * @return int[][] the next board
     * @param board the current board
     */
    public static int[][] applyLifeWithoutDeathRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (neighbors == 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
                if (board[i][j] == 1) {
                    newBoard[i][j] = 1;
                }
            }
        }
        return newBoard;
    }

    //Morley's GOL

    /**
     * Morley's GOL rules
     * B368/S245
     * 1. Any dead cell with exactly 3 or 6 or 8 live neighbors becomes a live cell, as if by reproduction.
     * 2 Any live cell with 2, 3, or 5 live neighbors lives on to the next generation.
     * 3. Any live cell with fewer than 2, 3, or more than 6 live neighbors dies, as if by underpopulation or overpopulation.
     *
     * @return int[][] the next board
     * @param board the current board
     */
    public static int[][] applyMorleyGOLRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (neighbors == 3 || neighbors == 6 || neighbors == 8) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
                if (board[i][j] == 1) {
                    if (neighbors == 2 || neighbors == 4 || neighbors == 5) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }

    //Anneal
    /**
     * Anneal rules
     * B4678/S35678
     * 1. Any dead cell with exactly 4, 6, 7 or 8 live neighbors becomes a live cell, as if by reproduction.
     * 2. Any live cell with 3, 5, 6, 7 or 8 live neighbors lives on to the next generation.
     * 3. Any live cell with fewer than 3, 4, or more than 8 live neighbors dies, as if by underpopulation or overpopulation.
     *
     *  @return int[][] the next board
     *  @param board the current board
     */
    public static int[][] applyAnnealRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (neighbors == 4 || neighbors == 6 || neighbors == 7 || neighbors == 8) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
                if (board[i][j] == 1) {
                    if (neighbors == 3 || neighbors == 5 || neighbors == 6 || neighbors == 7 || neighbors == 8) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }
        return newBoard;
    }

    //34 Life
    /**
     * 34 Life rules
     * B34/S34
     * 1. Any dead cell with exactly 3 or 4 live neighbors becomes a live cell, as if by reproduction.
     * 2. Any live cell with 3 or 4 live neighbors lives on to the next generation.
     * 3. Any live cell with fewer than 3 or more than 4 live neighbors dies, as if by underpopulation or overpopulation.
     * @return int[][] the next board
     * @param board the current board
     */
    public static int[][] apply34LifeRules(int[][] board) {
        //loop through the board\
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = computeNeighbors(board, i, j);
                if (board[i][j] == 0) {
                    if (neighbors == 3 || neighbors == 4) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
                if (board[i][j] == 1) {
                    if (neighbors == 3 || neighbors == 4) {
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
