package me.bweloba.gameoflife.Grids;

//grid for game of life with 45 rows and 90 columns
public class Grid {
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
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = 0;
            }
        }
        return grid;
    }

    //method to generate random grid with a randomized factor x to determine the population density
    public int[][] generateRandomGrid(double x) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (Math.random() < x) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid;
    }

    // method to fill the grid with empty cells
    public static void clearGrid() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = 0;
            }
        }
    }

    //method to randomize grid on factor change
    public void onFactorChange(double x) {
        setGrid(generateRandomGrid(x));
    }

    //method to toggle cell on click
    public void toggleCell(int row, int col) {
        if (grid[row][col] == 0) {
            grid[row][col] = 1;
        } else {
            grid[row][col] = 0;
        }
    }

    //simulation
    public void simulate() {
        int[][] newGrid = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int numNeighbors = countNeighbors(i, j);
                if (grid[i][j] == 1) {
                    if (numNeighbors < 2 || numNeighbors > 3) {
                        newGrid[i][j] = 0;
                    } else {
                        newGrid[i][j] = 1;
                    }
                } else {
                    if (numNeighbors == 3) {
                        newGrid[i][j] = 1;
                    } else {
                        newGrid[i][j] = 0;
                    }
                }
            }
        }
        grid = newGrid;
    }

    //method to count neighbors
    public int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (row + i < 0 || row + i >= numRows || col + j < 0 || col + j >= numCols) {
                    continue;
                }
                if (grid[row + i][col + j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
//
//    //method to toggle running
//    public void toggleRunning() {
//        running = !running;
//    }
//
//    //method to get running
//    public boolean getRunning() {
//        return running;
//    }
//
//    //method to set running
//    public void setRunning(boolean running) {
//        this.running = running;
//    }
//
//    //method to get speedRef
//    public int getSpeedRef() {
//        return speedRef;
//    }
//
//    //method to set speedRef
//    public void setSpeedRef(int speedRef) {
//        this.speedRef = speedRef;
//    }
}
