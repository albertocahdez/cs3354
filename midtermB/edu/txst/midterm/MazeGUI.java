package edu.txst.midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * The main GUI class for the 16-Bit Maze game.
 * Manages the game window, menu bar, keyboard input, and rendering.
 * Coordinates between the GameEngine, Board, and display panels.
 */
public class MazeGUI extends JFrame {
	private Board originalBoard;
	private Board currentBoard;
	private GameEngine engine;
	private GamePanel gamePanel;
	private InfoPanel infoPanel;
	private JMenuItem resetItem;

	/**
	 * Constructs the MazeGUI window, sets up the layout, menu bar,
	 * and keyboard listener for player movement.
	 */
	public MazeGUI() {
		setTitle("16-Bit Maze");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		initMenu();

		infoPanel = new InfoPanel();
		gamePanel = new GamePanel();
		add(infoPanel, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);

		// Handle Keyboard Input
		addKeyListener(new KeyAdapter() {
			/**
			 * Handles arrow key presses to move the player.
			 * Updates the step and coin counters after each move.
			 * Checks for a win condition and displays the score if the player wins.
			 *
			 * @param e The key event triggered by the user
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				if (engine == null)
					return;

				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP -> engine.movePlayer(-1, 0);
					case KeyEvent.VK_DOWN -> engine.movePlayer(1, 0);
					case KeyEvent.VK_LEFT -> engine.movePlayer(0, -1);
					case KeyEvent.VK_RIGHT -> engine.movePlayer(0, 1);
				}

				// Update step and coin display
				infoPanel.setInfoSteps(currentBoard.stepCounter.getSteps());
				infoPanel.setInfoCoins(engine.getCoinCount());

				gamePanel.repaint();

				// Check for victory
				if (engine.playerWins()) {
					int steps = infoPanel.getInfoSteps();
					int coins = infoPanel.getInfoCoins();
					int score = steps * -1 + coins * 5;

					JOptionPane.showMessageDialog(MazeGUI.this,
							"Congratulations! You found the exit.\nYour score: " + score + " points",
							"Level Complete", JOptionPane.INFORMATION_MESSAGE);

					// Disable engine to prevent movement after win
					engine = null;
					resetItem.setEnabled(false);
				}
			}
		});
	}

	/**
	 * Initializes the menu bar with Open and Reset menu items.
	 * Open loads a CSV level file. Reset restores the board to its original state.
	 */
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");

		JMenuItem openItem = new JMenuItem("Open");
		resetItem = new JMenuItem("Reset");
		resetItem.setEnabled(false);

		openItem.addActionListener(e -> openFile());
		resetItem.addActionListener(e -> resetGame());

		gameMenu.add(openItem);
		gameMenu.add(resetItem);
		menuBar.add(gameMenu);
		setJMenuBar(menuBar);
	}

	/**
	 * Opens a file chooser dialog for the user to select a CSV level file.
	 * Loads the selected file into the board, initializes the game engine,
	 * and enables the Reset menu item.
	 */
	private void openFile() {
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			CSVBoardLoader loader = new CSVBoardLoader();

			originalBoard = loader.load(selectedFile.getAbsolutePath());
			currentBoard = originalBoard.clone();
			engine = new GameEngine(currentBoard);

			resetItem.setEnabled(true);
			gamePanel.setBoard(currentBoard);
			infoPanel.setInfoSteps(0);
			infoPanel.setInfoCoins(0);
			gamePanel.repaint();
		}
	}

	/**
	 * Resets the current game to the original board state.
	 * Reinitializes the game engine and clears the step and coin counters.
	 */
	private void resetGame() {
		if (originalBoard != null) {
			currentBoard = originalBoard.clone();
			engine = new GameEngine(currentBoard);
			gamePanel.setBoard(currentBoard);
			infoPanel.setInfoSteps(0);
			infoPanel.setInfoCoins(0);
			gamePanel.repaint();
		}
	}

	/**
	 * Inner panel class that displays the current step count and coin count
	 * at the top of the game window.
	 */
	private class InfoPanel extends JPanel {
		private JLabel infoSteps;
		private JLabel infoCoins;

		/**
		 * Constructs the InfoPanel with labeled step and coin counters.
		 */
		public InfoPanel() {
			this.setLayout(new FlowLayout());
			this.add(new JLabel("Steps: "));
			infoSteps = new JLabel("0");
			this.add(infoSteps);
			this.add(new JLabel("Coins: "));
			infoCoins = new JLabel("0");
			this.add(infoCoins);
		}

		/**
		 * Updates the displayed step count.
		 *
		 * @param steps The current number of steps taken
		 */
		public void setInfoSteps(int steps) {
			this.infoSteps.setText(Integer.toString(steps));
		}

		/**
		 * Returns the currently displayed step count.
		 *
		 * @return The number of steps shown in the label
		 */
		public int getInfoSteps() {
			return Integer.parseInt(this.infoSteps.getText());
		}

		/**
		 * Updates the displayed coin count.
		 *
		 * @param coins The current number of coins collected
		 */
		public void setInfoCoins(int coins) {
			this.infoCoins.setText(Integer.toString(coins));
		}

		/**
		 * Returns the currently displayed coin count.
		 *
		 * @return The number of coins shown in the label
		 */
		public int getInfoCoins() {
			return Integer.parseInt(this.infoCoins.getText());
		}
	}

	/**
	 * Inner panel class responsible for rendering the game board.
	 * Each cell is drawn as a colored tile based on its type.
	 */
	private class GamePanel extends JPanel {
		private Board board;
		private final int TILE_SIZE = 64;

		/**
		 * Sets the board to be rendered by this panel.
		 *
		 * @param board The board to display
		 */
		public void setBoard(Board board) {
			this.board = board;
		}

		/**
		 * Paints all cells of the board as colored tiles.
		 *
		 * @param g The Graphics context used for rendering
		 */
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (board == null)
				return;

			for (int r = 0; r < 6; r++) {
				for (int c = 0; c < 10; c++) {
					int cell = board.getCell(r, c);
					drawTile(g, cell, c * TILE_SIZE, r * TILE_SIZE);
				}
			}
		}

		/**
		 * Draws a single tile at the given pixel coordinates using a color
		 * determined by the cell type.
		 *
		 * @param g    The Graphics context
		 * @param type The cell type constant (0=floor, 1=wall, 2=coin, 5=exit, 6=player)
		 * @param x    The x pixel coordinate
		 * @param y    The y pixel coordinate
		 */
		private void drawTile(Graphics g, int type, int x, int y) {
			switch (type) {
				case 0 -> g.setColor(Color.LIGHT_GRAY); // Floor
				case 1 -> g.setColor(Color.DARK_GRAY);  // Wall
				case 2 -> g.setColor(Color.YELLOW);     // Coin
				case 5 -> g.setColor(Color.MAGENTA);    // Exit
				case 6 -> g.setColor(Color.BLUE);       // Player
				default -> g.setColor(Color.BLACK);
			}
			g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
			g.setColor(Color.WHITE);
			g.drawRect(x, y, TILE_SIZE, TILE_SIZE);
		}
	}

	/**
	 * Entry point for the MazeGUI application.
	 * Launches the game window on the Swing event dispatch thread.
	 *
	 * @param args Command-line arguments (not used)
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MazeGUI().setVisible(true));
	}
}