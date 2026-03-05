package edu.txst.midterm;

public class GameEngine {
	private Board board;
	private int playerRow;
	private int playerCol;

	// Cell Type Constants
	private static final int FLOOR = 0;
	private static final int WALL = 1;
	private static final int BOX = 2;
	private static final int GOAL = 3;
	private static final int PLAYER = 4;
	private static final int BOX_ON_GOAL = 5;

	public GameEngine(Board board) {
		this.board = board;
		findPlayer();
	}

	public boolean isGameOver() {
		return false;
	}

	public boolean isGameStuck() {
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

		// 2. Check for Boxes (Normal Box or Box on Goal)
		if (targetCell == BOX || targetCell == BOX_ON_GOAL) {
			int nextRow = targetRow + dRow;
			int nextCol = targetCol + dCol;
			int nextCell = board.getCell(nextRow, nextCol);

			// Can only push if the space behind the box is Floor or Goal
			if (nextCell == FLOOR || nextCell == GOAL) {
				// Move the box
				int newBoxType = (nextCell == GOAL) ? BOX_ON_GOAL : BOX;
				board.setCell(nextRow, nextCol, newBoxType);

				// Clear the box's old position (it becomes a floor or remains a goal)
				int oldBoxPosType = (targetCell == BOX_ON_GOAL) ? GOAL : FLOOR;
				board.setCell(targetRow, targetCol, oldBoxPosType);
			} else {
				return; // Box is blocked
			}
		}

		// 3. Move the Player
		// Current position becomes Floor (or Goal if player was standing on one)
		// Note: For simplicity, this engine assumes player replaces the cell.
		// If you want "Player on Goal", you'd add a 6th constant.
		board.setCell(playerRow, playerCol, FLOOR);

		playerRow = targetRow;
		playerCol = targetCol;
		board.setCell(playerRow, playerCol, PLAYER);
	}
}
