/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chan.maze;

import java.awt.Point;
/**
 *
 * @author asus
 */
public class MazeProject {

	private char[][] mazeTable; // Maze table 2 Dimensional Array 15*15

	private int totalPosition;

	private Point startPoint;
	private Point endPoint;

	public static final char WALL = 'X'; // Wall
	public static final char EMPTY_SPACE = ' '; // Empty Posion on Maze
	public static final char POSITION = '.'; // Position for Movement
	public static final char START = 'S'; // Start from Here
	public static final char EXIT = 'F'; // End From Here

	public MazeProject(char[][] newMaze) {
		mazeTable = newMaze;
		totalPosition = 0;
		startPoint = findStatPosition();
		endPoint = calculateExitPosition();
	}

	/**
     * 
     */
	public void solveMazeProblem() {
		totalPosition = 0;
		if (findMazePossiblePath(startPoint)) {
			System.out.println("Maze covered in " + totalPosition + " steps.");
		} else {
			System.out.println("Problem in solving the Maze this time.:)");
		}
	}

	public Point[] getNeighbourPosition(Point location) {
		Point[] adjacentPositions = new Point[4];

		adjacentPositions[0] = new Point(location.x + 1, location.y);
		adjacentPositions[1] = new Point(location.x, location.y + 1);
		adjacentPositions[2] = new Point(location.x - 1, location.y);
		adjacentPositions[3] = new Point(location.x, location.y - 1);

		return adjacentPositions;
	}

	public Point findStatPosition() {
		Point startPoint = findPositionMarker(START);
		if (startPoint == null) {
			throw new IllegalStateException("No Start Position Found!!");
		}

		return startPoint;
	}

	/**
	 * @param square
	 */
	private void enterPosition(Point square) {
		mazeTable[square.x][square.y] = POSITION;
		totalPosition++;
	}

	private void exitSquare(Point square) {
		mazeTable[square.x][square.y] = EMPTY_SPACE;
		totalPosition--;
	}

	/**
	 * @param location
	 * @return
	 */
	public boolean findMazePossiblePath(Point location) {

		if (mazeCompleted(location)) {
			printMazeTraversing();
			return true;
		}

		Point[] adjacentPositions = getNeighbourPosition(location);

		for (Point possibleStep : adjacentPositions) {

			if (checkNeighbourPositionFree(possibleStep)) {
				enterPosition(possibleStep);

				if (findMazePossiblePath(possibleStep)) {
					return true;
				}

				exitSquare(possibleStep);
			}
		}

		return false;
	}

	/**
	 * @param location
	 * @return
	 */
	public boolean mazeCompleted(Point location) {
		return location.equals(endPoint);
	}

	public void printMazeTraversing() {
		for (int i = 0; i < mazeTable.length; i++) {
			for (int j = 0; j < mazeTable[i].length; j++) {
				System.out.print(mazeTable[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * @param c
	 * @return
	 */
	public Point findPositionMarker(char c) {
		for (int i = 0; i < mazeTable.length; i++) {
			for (int j = 0; j < mazeTable[i].length; j++) {
				if (mazeTable[i][j] == c) {
					return new Point(i, j);
				}
			}
		}

		return null;
	}

	/**
	 * @param square
	 * @return
	 */
	public boolean checkNeighbourPositionFree(Point square) {
		if (square.x < 0 || square.x >= mazeTable.length || square.y < 0
				|| square.y >= mazeTable[square.x].length) {

			return false;
		}

		return (mazeTable[square.x][square.y] == EMPTY_SPACE || mazeTable[square.x][square.y] == EXIT);
	}

	/**
	 * @return
	 */
	public Point calculateExitPosition() {
		Point endPoint = findPositionMarker(EXIT);
		if (endPoint == null) {
			throw new IllegalStateException("No Finish Position Found!!");
		}

		return endPoint;
	}

	// Fixed Maze Structure

	/**
	 * @param args
	 */
	public static void main(String[] args) {

                char[][] easyMaze = {                    
                    { WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL },
                    { WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, START, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL  },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL  },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL },
                    { WALL, EXIT, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL }                   
                };
		MazeProject s = new MazeProject(easyMaze);
		System.out.println("The Maze Table looks as Follows..");
		s.printMazeTraversing();

		s.solveMazeProblem();
	}
}
