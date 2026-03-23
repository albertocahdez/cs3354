package edu.txst.midterm;

public class Board implements Cloneable {
	private final int COLUMNS = 10;
	private final int ROWS = 6;
	private Integer[][] grid;
	public StepCounter stepCounter;

	public Board() {
		this.grid = new Integer[ROWS][COLUMNS];
	}

	public void setStepCounter(int maxSteps) {
		stepCounter = new StepCounter(maxSteps);
	}

	// Define the value of a particular cell
	public void setCell(int row, int col, int value) {
		if (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS) {
			grid[row][col] = value;
		}
	}

	// Retrieve the integer value of a particular cell
	public int getCell(int row, int col) {
		if (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS) {
			return grid[row][col];
		}
		return -1; // Return -1 or throw exception for out of bounds
	}

	@Override
	public Board clone() {
		Board copy = new Board();
		copy.setStepCounter(stepCounter.getMaxSteps());
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				copy.setCell(r, c, this.grid[r][c]);
			}
		}
		return copy;
	}
}
