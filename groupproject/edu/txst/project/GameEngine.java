
package edu.txst.project;

/**
 * Controls player movement and game logic for the maze.
 */
public class GameEngine {
    private Board board;
    private int playerRow;
    private int playerCol;
    private int exitRow;
    private int exitCol;
    private int coins;
    private int playerPreviousCell;

    // Cell Type Constants
    private static final int FLOOR = 0;
    private static final int WALL = 1;
    private static final int COIN = 2;
    private static final int BELT_RIGHT = 3;
    private static final int BELT_DOWN = 4;
    private static final int EXIT = 5;
    private static final int PLAYER = 6;
    private static final int BELT_LEFT = 7;
    private static final int BELT_UP = 8;

    /**
     * Creates a game engine for the given board.
     *
     * @param board the game board
     */
    public GameEngine(Board board) {
        this.board = board;
        this.coins = 0;
        this.playerRow = -1;
        this.playerCol = -1;
        this.exitRow = -1;
        this.exitCol = -1;
        this.playerPreviousCell = FLOOR;

        if (board.stepCounter == null) {
            board.setStepCounter();
        }

        findPlayer();
        findExit();
    }

    /**
     * Checks whether the player has reached the exit.
     *
     * @return true if the player has reached the exit
     */
    public boolean playerWins() {
        return exitRow != -1 && playerRow == exitRow
                && playerCol == exitCol;
    }

    /**
     * Finds the player's starting position.
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
     * Finds the exit position.
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
     * Attempts to move the player.
     * Conveyor belts automatically move the player.
     *
     * @param dRow change in row
     * @param dCol change in column
     */
    public void movePlayer(int dRow, int dCol) {

        if (playerWins() || playerRow == -1) {
            return;
        }

        if (Math.abs(dRow) + Math.abs(dCol) != 1) {
            return;
        }

        int targetRow = playerRow + dRow;
        int targetCol = playerCol + dCol;

        if (!moveOneCell(targetRow, targetCol)) {
            return;
        }

        boolean[][] visited = new boolean[6][10];

        while (!playerWins() && isConveyor(playerPreviousCell)) {

            visited[playerRow][playerCol] = true;

            int beltRow = 0;
            int beltCol = 0;

            switch (playerPreviousCell) {
                case BELT_RIGHT -> beltCol = 1;
                case BELT_DOWN -> beltRow = 1;
                case BELT_LEFT -> beltCol = -1;
                case BELT_UP -> beltRow = -1;
                default -> {
                    return;
                }
            }

            int nextRow = playerRow + beltRow;
            int nextCol = playerCol + beltCol;

            if (nextRow < 0 || nextRow >= 6
                    || nextCol < 0 || nextCol >= 10) {
                break;
            }

            if (board.getCell(nextRow, nextCol) == WALL
                    || visited[nextRow][nextCol]) {
                break;
            }

            if (!moveOneCell(nextRow, nextCol)) {
                break;
            }
        }
    }

    /**
     * Moves the player one cell and collects coins if present.
     *
     * @param targetRow destination row
     * @param targetCol destination column
     * @return true if movement succeeds
     */
    private boolean moveOneCell(int targetRow, int targetCol) {

        int targetCell = board.getCell(targetRow, targetCol);

        if (targetCell == WALL || targetCell == -1) {
            return false;
        }

        int oldPlayerCell = playerPreviousCell;

        if (targetCell == COIN) {
            coins++;
            playerPreviousCell = FLOOR;
        } else {
            playerPreviousCell = targetCell;
        }

        board.setCell(playerRow, playerCol, oldPlayerCell);

        playerRow = targetRow;
        playerCol = targetCol;

        board.setCell(playerRow, playerCol, PLAYER);

        board.stepCounter.increaseSteps();

        return true;
    }

    /**
     * Checks whether a cell contains a conveyor belt.
     *
     * @param cell cell value
     * @return true if the cell is a conveyor belt
     */
    private boolean isConveyor(int cell) {
        return cell == BELT_RIGHT || cell == BELT_DOWN
                || cell == BELT_LEFT || cell == BELT_UP;
    }

    /**
     * Returns the number of collected coins.
     *
     * @return number of coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Returns the number of steps taken.
     *
     * @return current step count
     */
    public int getSteps() {
        return board.stepCounter.getSteps();
    }
}
