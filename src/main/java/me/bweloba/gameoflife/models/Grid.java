package me.bweloba.gameoflife.models;

//grid for game of life
public class Grid extends Thread {
    private static int numRows = 30;
    private static int numCols = 63;
    private static int[][] grid;

    //constructor
    public Grid() {
        grid = new int[numRows][numCols];
    }

    //getter for grid
    public int[][] getGrid() {
        return grid;
    }

    //setter for grid
    public void setGrid(int[][] grid) {
        Grid.grid = grid;
    }

    //getter for numRows
    public int getNumRows() {
        return numRows;
    }

    //getter for numCols
    public int getNumCols() {
        return numCols;
    }

    //setter for numRows
    public void setNumRows(int numRows) {
        Grid.numRows = numRows;
    }

    //setter for numCols
    public void setNumCols(int numCols) {
        Grid.numCols = numCols;
    }

    //method to generate empty grid
    public int[][] generateEmptyGrid() {
        new Thread(() -> {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    grid[i][j] = 0;
                }
            }
        }).start();
        return grid;
    }

    //method to generate random grid with a randomized factor x to determine the population density
    public int[][] generateRandomGrid(double x) {
        new Thread(() -> {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if (Math.random() < x) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;
                    }
                }
            }
        }).start();
        return grid;
    }
}
