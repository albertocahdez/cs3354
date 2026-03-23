package edu.txst.midterm;

/**
 * Controls the core game logic for the maze, including player movement,
 * coin collection, exit detection, and win condition evaluation.
 */
public class GameEngine {
	private Board board;
	private int playerRow;
	private int playerCol;
	private int exitRow;
	private int exitCol;
	private int coinCount;

	// Cell Type Constants
	private static final int FLOOR = 0;
	private static final int WALL = 1;
	private static final int COIN = 2;
	private static final int EXIT = 5;
	private static final int PLAYER = 6;

	/**
	 * Constructs a GameEngine with the given board.
	 * Locates the player and exit positions on initialization.
	 *
	 * @param board The game board to operate on
	 */
	public GameEngine(Board board) {
		this.board = board;
		this.coinCount = 0;
		findPlayer();
		findExit();
	}

	/**
	 * Returns whether the player has reached the exit cell.
	 *
	 * @return true if the player is on the exit, false otherwise
	 */
	public boolean playerWins() {
		return playerRow == exitRow && playerCol == exitCol;
	}

	/**
	 * Returns the total number of coins collected by the player so far.
	 *
	 * @return the coin count
	 */
	public int getCoinCount() {
		return coinCount;
	}

	/**
	 * Scans the board to locate the player's starting position.
	 * Sets playerRow and playerCol when the player cell is found.
	 */
	private void findPlayer() {
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 10; c++) {
				if (board.getCell(r, c) == PLAYER) {
					playerRow = r;
					playerCol = c;
					return;
				}
			}
		}
	}

	/**
	 * Scans the board to locate the exit cell position.
	 * Sets exitRow and exitCol when the exit cell is found.
	 */
	private void findExit() {
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 10; c++) {
				if (board.getCell(r, c) == EXIT) {
					exitRow = r;
					exitCol = c;
					return;
				}
			}
		}
	}

	/**
	 * Attempts to move the player in the specified direction.
	 * Movement is blocked by walls and out-of-bounds cells.
	 * If the target cell contains a coin, the coin count is incremented.
	 * The step counter is incremented on every successful move.
	 *
	 * @param dRow Change in row (-1 = up, 1 = down, 0 = no vertical movement)
	 * @param dCol Change in column (-1 = left, 1 = right, 0 = no horizontal movement)
	 */
	public void movePlayer(int dRow, int dCol) {
		int targetRow = playerRow + dRow;
		int targetCol = playerCol + dCol;
		int targetCell = board.getCell(targetRow, targetCol);

		// Check for Walls or Out of Bounds
		if (targetCell == WALL || targetCell == -1) {
			return; // Movement blocked
		}

		// Collect coin if present
		if (targetCell == COIN) {
			coinCount++;
		}

		// Move the Player
		board.setCell(playerRow, playerCol, FLOOR);
		playerRow = targetRow;
		playerCol = targetCol;
		board.setCell(playerRow, playerCol, PLAYER);

		// Increment step counter
		board.stepCounter.increaseSteps();
	}
}