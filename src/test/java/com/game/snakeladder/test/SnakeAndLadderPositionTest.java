package com.game.snakeladder.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.snakeladder.exception.SnakeLadderException;
import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.LadderPosition;
import com.game.snakeladder.model.SnakePosition;

/**
 * This is JUNIT Test class to verify rules while adding both snakes and ladders to the game board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakeAndLadderPositionTest {
	

	/**
	 * Represents valid list of snake positions.
	 */
	private static List<SnakePosition> snakePositions;
	
	/**
	 * This method is used to set up the valid snake positions.
	 */
	@BeforeClass
	public static void setGameBoard() {

		
		snakePositions = new ArrayList<SnakePosition>();
		
		snakePositions.add(new SnakePosition(17, 7));
		snakePositions.add(new SnakePosition(54, 34));
		snakePositions.add(new SnakePosition(62, 19));
		snakePositions.add(new SnakePosition(64, 60));
		snakePositions.add(new SnakePosition(87, 24));
		snakePositions.add(new SnakePosition(93, 73));
		snakePositions.add(new SnakePosition(95, 75));
		
	}
	
	/**
	 * Represents test case for verifying Snake Should not have same end point as ladder start point.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testSnakeEndPointEqualToLadderStartPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
	
		invalidLadderPositions.add(new LadderPosition(73, 80));
		
		GameBoard gameBoard = new GameBoard(10, 10);
	
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	
	}
	
	/**
	 * Represents test case for verifying Snake should not have same start point as ladder start point.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testSnakeStartPointEqualToLadderStartPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
	
		invalidLadderPositions.add(new LadderPosition(17, 50));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);

		
	}
	
	/**
	 * Represents test case for verifying Snake should have same end point as ladder point.
	 */
	@Test
	public void testSnakeEndPointEqualToLadderEndPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
	
		invalidLadderPositions.add(new LadderPosition(4, 19));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	}
}
