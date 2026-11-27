# MAZE GAME

## Game overview
A player (represented by a blue square) navigates a grid-based board (light gray squares). 
* Obstacles: The player cannot pass through walls (dark gray squares).
* Collectibles: The player can collect coins (yellow squares).
* Objective: Move the player to the exit goal (magenta square).
* Scoring Formula: Upon reaching the exit, final score is calculated as:

score = steps * -1 + coins * 5

## Issues & Base Features

Fix the following bugs and complete the required standard features:

* Fix Step Counter: The step counter stays at zero. Update the text property of the corresponding JLabel using setText().

* Fix Coin Counter: The coin counter stays at zero. Update the text property of the corresponding JLabel using setText().

* Fix Win Condition: The engine checks playerWins, but win detection fails. Fix logic so the game detects when the player reaches the goal.

* Fix Score Calculation: Correct the end-of-game score calculation to use: (steps * -1) + (coins * 5).

* Code Documentation: Add standard Javadoc comments (/** ... */) to all classes and public methods in GameEngine.java and MazeGUI.java.

* Generate Javadoc: Export the HTML Javadoc documentation files into a /javadoc directory within your project.

* Custom Levels: Create 2 additional solvable maze levels saved as .csv files using the project's standard grid format.

## Unique Custom Feature

Each team must design and implement one unique feature not selected by any other team across all sections of the course.

### Potential Feature Ideas

* Step Limit: Impose a maximum step count before game over.

* Trap Tile: Add a freeze trap that costs 3 steps without moving the player.

* Bomb Item: Add an item that destroys one (or more) wall(s) adjacent to the player.

* Step Saver: Add an item that refunds consumed steps.

* Super Coin: Add a special coin worth 3 standard coins.

* Pathfinding Hint: Add an item that highlights the shortest path to the exit.

### Selection Procedure & Penalties

- Reserve Your Idea: Post your feature concept in the dedicated Canvas Discussion thread.
- Duplicate Rule: Check existing posts before posting. If your idea is already claimed by another team, you must design a different one
- Penalties: 
** Duplicate Claim: Penalty of 10 * (n - 1) points applies if n teams implement the same feature (only the first team to post gets full credit).
** Failure to Post: -20 point penalty if a team submits a feature without posting it to the discussion thread first.
 

# SUBMISSION
Compress your completed project into a single .zip file and submit it via Canvas. Ensure your .zip archive contains:

* All .java source code files (including bug fixes and new feature logic).
* The 2 newly created .csv level files.
* Generated /javadoc folder.
* A brief README.txt describing your custom feature and how to test it.

# Grading
Total: 50 points
(10 points) Bugs fixed
(5 points) Unique feature
(20 points) Feature Implementation
(5 points each) CSV level file
(5 points) javadoc folder
(5 points) README describing the feature and how to test the game