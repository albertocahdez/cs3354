# MAZE GAME

## Game description
A player (blue square) moves in a board (light gray squares). Player cannot move through a wall (dark gray square). 
Player can collect coins (yellow squares). The objective of the game is to move the player to the goal (magenta square).
When the game ends, a score is computed using the following formula:
> steps * -1 + coins * 5

## List of issues and features
* Issue: The counter for steps is always zero. Update the text property of the JLabel object by using setText method.
* Issue: The counter for coins is always zero. Update the text property of the JLabel object by using setText method.
* Issue: Determine when the player wins (player reaches the exit). System already checks for playerWins but it is not working.
* Issue: Currently the formula that computes the number of points obtained by the player (after winning) shows an incorrect value.
	* The correct formula is
		* steps * -1 + coins * 5
* Issue: Missing documentation for methods and classes in GameEngine.java and MazeGUI.java
* Feature: Generate javadoc documentation
* Feature: Design 2 additional CSV files with solvable Maze levels

# SUBMISSION
Submit your project in a ZIP folder in the corresponding assignment on Canvas.