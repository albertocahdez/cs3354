
package edu.txst.project;

public class Board implements Cloneable {
    private final int COLUMNS = 10;
    private final int ROWS = 6;
    private Integer[][] grid;
    public StepCounter stepCounter;

    public Board() {
        grid = new Integer[ROWS][COLUMNS];

        // Initialize every cell as floor.
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                grid[r][c] = 0;
            }
        }

        stepCounter = new StepCounter();
    }

    public void setStepCounter() {
        stepCounter = new StepCounter();
    }

    public void setCell(int row, int col, int value) {
        if (row >= 0 && row < ROWS &&
            col >= 0 && col < COLUMNS) {
            grid[row][col] = value;
        }
    }

    public int getCell(int row, int col) {
        if (row >= 0 && row < ROWS &&
            col >= 0 && col < COLUMNS) {
            return grid[row][col];
        }

        return -1;
    }

    @Override
    public Board clone() {
        Board copy = new Board();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                copy.setCell(r, c, this.grid[r][c]);
            }
        }

        return copy;
    }
}
