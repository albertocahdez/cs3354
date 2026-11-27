
package edu.txst.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Provides the graphical user interface for the maze game.
 */
public class MazeGUI extends JFrame {

    private Board originalBoard;
    private Board currentBoard;
    private GameEngine engine;
    private GamePanel gamePanel;
    private InfoPanel infoPanel;
    private JMenuItem resetItem;

    /**
     * Creates and initializes the maze game window.
     */
    public MazeGUI() {
        setTitle("16-Bit Maze");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMenu();

        infoPanel = new InfoPanel();
        gamePanel = new GamePanel();

        add(infoPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (engine == null) {
                    return;
                }

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP ->
                        engine.movePlayer(-1, 0);

                    case KeyEvent.VK_DOWN ->
                        engine.movePlayer(1, 0);

                    case KeyEvent.VK_LEFT ->
                        engine.movePlayer(0, -1);

                    case KeyEvent.VK_RIGHT ->
                        engine.movePlayer(0, 1);
                }

                infoPanel.setInfoSteps(engine.getSteps());
                infoPanel.setInfoCoins(engine.getCoins());

                gamePanel.repaint();

                if (engine.playerWins()) {

                    int steps = engine.getSteps();
                    int coins = engine.getCoins();
                    int score = (steps * -1) + (coins * 5);

                    JOptionPane.showMessageDialog(
                        MazeGUI.this,
                        "Congratulations! You found the exit.\n"
                        + "Steps: " + steps
                        + "\nCoins: " + coins
                        + "\nFinal Score: " + score,
                        "Level Complete",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    engine = null;
                    resetItem.setEnabled(false);
                }
            }
        });

        addWindowFocusListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowGainedFocus(
                    java.awt.event.WindowEvent e) {
                requestFocusInWindow();
            }
        });
    }

    /**
     * Initializes the game menu.
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
     * Opens a CSV maze file.
     */
    private void openFile() {

        JFileChooser fileChooser =
            new JFileChooser(System.getProperty("user.dir"));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();

            CSVBoardLoader loader = new CSVBoardLoader();

            originalBoard =
                loader.load(selectedFile.getAbsolutePath());

            currentBoard = originalBoard.clone();

            engine = new GameEngine(currentBoard);

            infoPanel.setInfoSteps(0);
            infoPanel.setInfoCoins(0);

            resetItem.setEnabled(true);

            gamePanel.setBoard(currentBoard);
            gamePanel.repaint();

            requestFocusInWindow();
        }
    }

    /**
     * Resets the current game.
     */
    private void resetGame() {

        if (originalBoard != null) {

            currentBoard = originalBoard.clone();

            engine = new GameEngine(currentBoard);

            infoPanel.setInfoSteps(0);
            infoPanel.setInfoCoins(0);

            gamePanel.setBoard(currentBoard);
            gamePanel.repaint();

            resetItem.setEnabled(true);

            requestFocusInWindow();
        }
    }

    /**
     * Displays step and coin counters.
     */
    private class InfoPanel extends JPanel {

        private JLabel infoSteps;
        private JLabel infoCoins;

        /**
         * Creates the information panel.
         */
        public InfoPanel() {

            setLayout(new FlowLayout());

            add(new JLabel("Steps: "));

            infoSteps = new JLabel("0");
            add(infoSteps);

            add(new JLabel("Coins: "));

            infoCoins = new JLabel("0");
            add(infoCoins);
        }

        /**
         * Updates the step counter.
         *
         * @param remainingSteps current steps
         */
        public void setInfoSteps(int remainingSteps) {
            infoSteps.setText(Integer.toString(remainingSteps));
        }

        /**
         * Returns the displayed step count.
         *
         * @return current steps
         */
        public int getInfoSteps() {
            return Integer.parseInt(infoSteps.getText());
        }

        /**
         * Updates the coin counter.
         *
         * @param coins current coins
         */
        public void setInfoCoins(int coins) {
            infoCoins.setText(Integer.toString(coins));
        }

        /**
         * Returns the displayed coin count.
         *
         * @return current coins
         */
        public int getInfoCoins() {
            return Integer.parseInt(infoCoins.getText());
        }
    }

    /**
     * Displays and draws the maze board.
     */
    private class GamePanel extends JPanel {

        private Board board;
        private final int TILE_SIZE = 64;

        /**
         * Sets the board to display.
         *
         * @param board maze board
         */
        public void setBoard(Board board) {
            this.board = board;
            setPreferredSize(new Dimension(640, 384));
            revalidate();
        }

        /**
         * Draws the maze board.
         *
         * @param g graphics context
         */
        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            if (board == null) {
                return;
            }

            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 10; c++) {

                    int cell = board.getCell(r, c);

                    drawTile(
                        g,
                        cell,
                        c * TILE_SIZE,
                        r * TILE_SIZE
                    );
                }
            }
        }

        /**
         * Draws an individual maze tile.
         *
         * @param g graphics context
         * @param type tile type
         * @param x horizontal position
         * @param y vertical position
         */
        private void drawTile(
                Graphics g, int type, int x, int y) {

            String arrow = "";

            switch (type) {

                case 0 ->
                    g.setColor(Color.LIGHT_GRAY);

                case 1 ->
                    g.setColor(Color.DARK_GRAY);

                case 2 ->
                    g.setColor(Color.YELLOW);

                case 3 -> {
                    g.setColor(Color.CYAN);
                    arrow = "→";
                }

                case 4 -> {
                    g.setColor(Color.CYAN);
                    arrow = "↓";
                }

                case 5 ->
                    g.setColor(Color.MAGENTA);

                case 6 ->
                    g.setColor(Color.BLUE);

                case 7 -> {
                    g.setColor(Color.CYAN);
                    arrow = "←";
                }

                case 8 -> {
                    g.setColor(Color.CYAN);
                    arrow = "↑";
                }

                default ->
                    g.setColor(Color.BLACK);
            }

            g.fillRect(x, y, TILE_SIZE, TILE_SIZE);

            if (!arrow.isEmpty()) {

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 28));

                FontMetrics metrics = g.getFontMetrics();

                int arrowX = x + (TILE_SIZE
                    - metrics.stringWidth(arrow)) / 2;

                int arrowY = y + (TILE_SIZE
                    - metrics.getHeight()) / 2
                    + metrics.getAscent();

                g.drawString(arrow, arrowX, arrowY);
            }

            g.setColor(Color.WHITE);

            g.drawRect(x, y, TILE_SIZE, TILE_SIZE);
        }
    }

    /**
     * Starts the maze application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
            new MazeGUI().setVisible(true)
        );
    }
}
