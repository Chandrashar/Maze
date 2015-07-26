Maze Test Program
=================================

This program uses a recursive backtracking strategy to traverse from START to EXIT in a maze. This uses backtracking to find out all possible move between START and EXIT point

Maze Test Program is writen based on a N*N Matrix handled bt two Dimensional Array. 
The array contain One START('S') point, one EXIT('F') point, many WALLs('W') and Empty Spaces(' ') for possible moov on Maze.

Following assumptions made to complete the Possible moov:

Recursive backtracking algorithm for finding a possible move on the maze. 
Given a location in the maze, tries all possible move for NEXT location. Possible moves are going up, down, left and right by one square from current position

If any of those moves it valid, it makes the move, and makes a recursive call to calculate the next move to make. 
	
	If the recursive call backtracks, it tries a different move.
	If there are no more legal moves from the current location, it returns false to tell the previous position that it needs to make a different decision for its move. 
	The movement finishes when we either reach the finish square or exhaust all possible positions.

How to Build
==============================

Run the goal "mvn clean install" on the root of your project it should build and test all of your code.
