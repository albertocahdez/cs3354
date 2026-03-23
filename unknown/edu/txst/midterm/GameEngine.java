package edu.txst.midterm;

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


	public GameEngine(Board board) {
		this.board = board;
		findPlayer();
		findExit();
	}

	public boolean playerWins() {
		return false;
	}

	public boolean isGameOver() {
		return false;
	}

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

	private void removeHidden() {

	}

	/**
	 * Attempts to move the player.
	 * 
	 * @param dRow Change in row (-1, 0, 1)
	 * @param dCol Change in column (-1, 0, 1)
	 */
	public void movePlayer(int dRow, int dCol) {
		int targetRow = playerRow + dRow;
		int targetCol = playerCol + dCol;
		int targetCell = board.getCell(targetRow, targetCol);

		// 1. Check for Walls or Out of Bounds
		if (targetCell == WALL || targetCell == -1) {
			return; // Movement blocked
		}

		if (targetCell == HIDDEN_WALL) {
			board.setCell(targetRow, targetCol, HIDDEN_WALL - REMOVE_HIDDEN);
			return;
		}

		// 2. Check for Map
		if (targetCell == HIDDEN_MAP) {
			removeHidden();
		}

		// 3. Check for First Aid Kit
		if (targetCell == FIRST_AID_KIT) {
			board.stepCounter.decreaseSteps(FIRST_AID_KIT_BONUS);
		} else if (targetCell == HIDDEN_FIRST_AID_KIT) {
			board.setCell(targetRow, targetCol, HIDDEN_FIRST_AID_KIT - REMOVE_HIDDEN);
			board.stepCounter.decreaseSteps(FIRST_AID_KIT_BONUS);
		}

		// 4. Move the Player
		// Current position becomes Floor (or Goal if player was standing on one)
		// Note: For simplicity, this engine assumes player replaces the cell.
		// If you want "Player on Goal", you'd add a 6th constant.
		board.setCell(playerRow, playerCol, FLOOR);

		playerRow = targetRow;
		playerCol = targetCol;
		board.setCell(playerRow, playerCol, PLAYER);
	}
}
