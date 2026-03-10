package edu.txst.midterm;

/**
 * Controls the maze game logic, including player movement,
 * win conditions, and interactions with special cells.
 */
public class GameEngine {
	private Board board;
	private int playerRow;
	private int playerCol;
	private int exitRow;
	private int exitCol;

	// Cell Type Constants
	private static final int FLOOR = 0;
	private static final int WALL = 1;
	private static final int COIN = 2;
	private static final int MAP = 3;
	private static final int FIRST_AID_KIT = 4;
	private static final int EXIT = 5;
	private static final int PLAYER = 6;
	private static final int HIDDEN_FLOOR = 10;
	private static final int HIDDEN_WALL = 11;
	private static final int HIDDEN_COIN = 12;
	private static final int HIDDEN_MAP = 13;
	private static final int HIDDEN_FIRST_AID_KIT = 14;
	private static final int HIDDEN_EXIT = 15;
	private static final int REMOVE_HIDDEN = 10;
	private static final int FIRST_AID_KIT_BONUS = 10;

	/**
	 * Creates a new game engine for the given board.
	 *
	 * @param board the board used for the maze game
	 */
	public GameEngine(Board board) {
		this.board = board;
		findPlayer();
		findExit();
	}

	/**
	 * Checks whether the player has reached the exit.
	 *
	 * @return true if the player is on the exit cell, false otherwise
	 */
	public boolean playerWins() {
		return playerRow == exitRow && playerCol == exitCol;
	}

	/**
	 * Checks whether the game is over because the player has no remaining steps.
	 *
	 * @return true if there are no remaining steps, false otherwise
	 */
	public boolean isGameOver() {
		return board.stepCounter.getRemainingSteps() <= 0;
	}

	/**
	 * Finds the player's starting position on the board.
	 */
	private void findPlayer() {
		for (int r = 0; r < 5; r++) {
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
	 * Finds the exit position on the board.
	 */
	private void findExit() {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				if (board.getCell(r, c) == EXIT || board.getCell(r, c) == HIDDEN_EXIT) {
					exitRow = r;
					exitCol = c;
					return;
				}
			}
		}
	}

	/**
	 * Reveals all hidden cells on the board.
	 */
	private void removeHidden() {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				int cell = board.getCell(r, c);

				if (cell >= HIDDEN_FLOOR && cell <= HIDDEN_EXIT) {
					board.setCell(r, c, cell - REMOVE_HIDDEN);
				}
			}
		}
	}

	/**
	 * Attempts to move the player by the given row and column change.
	 *
	 * @param dRow change in row
	 * @param dCol change in column
	 */
	public void movePlayer(int dRow, int dCol) {
		int targetRow = playerRow + dRow;
		int targetCol = playerCol + dCol;
		int targetCell = board.getCell(targetRow, targetCol);

		// 1. Check for Walls or Out of Bounds
		if (targetCell == WALL || targetCell == -1) {
			return;
		}

		if (targetCell == HIDDEN_WALL) {
			board.setCell(targetRow, targetCol, HIDDEN_WALL - REMOVE_HIDDEN);
			return;
		}

		// 2. Check for Map
		if (targetCell == MAP || targetCell == HIDDEN_MAP) {
			removeHidden();
			targetCell = board.getCell(targetRow, targetCol);
		}

		// 3. Check for First Aid Kit
		if (targetCell == FIRST_AID_KIT) {
			board.stepCounter.decreaseSteps(FIRST_AID_KIT_BONUS);
		} else if (targetCell == HIDDEN_FIRST_AID_KIT) {
			board.setCell(targetRow, targetCol, HIDDEN_FIRST_AID_KIT - REMOVE_HIDDEN);
			board.stepCounter.decreaseSteps(FIRST_AID_KIT_BONUS);
		}

		// 4. Move the Player
		board.setCell(playerRow, playerCol, FLOOR);

		playerRow = targetRow;
		playerCol = targetCol;
		board.setCell(playerRow, playerCol, PLAYER);
	}
}
