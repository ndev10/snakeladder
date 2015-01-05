package com.game.snakeladder.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.snakeladder.exception.SnakeLadderException;
import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.SnakePosition;

/**
 * This is JUNIT Test class to verify rules of adding snakes to the game board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakePositionTest {

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
	 * Represents test case of adding valid snake positions to the game board.
	 */
	@Test
	public void testSnakePositions() {
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(snakePositions);
		
		Assert.assertNotNull(gameBoard.checkSnakePositionExistsOnCurrentPosition(17));
		Assert.assertNotNull(gameBoard.checkSnakePositionExistsOnCurrentPosition(54));
		Assert.assertNotNull(gameBoard.checkSnakePositionExistsOnCurrentPosition(62));
		Assert.assertNotNull(gameBoard.checkSnakePositionExistsOnCurrentPosition(64));
		Assert.assertNotNull(gameBoard.checkSnakePositionExistsOnCurrentPosition(87));
		Assert.assertNotNull(gameBoard.checkSnakePositionExistsOnCurrentPosition(93));
		Assert.assertNotNull(gameBoard.checkSnakePositionExistsOnCurrentPosition(95));
	}
	

	/**
	 * Represents test case for verifying Snake should not have same start point and end point.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testSnakeHaveSameStartPointAsEndPoint() {
		List<SnakePosition> invalidSnakePositions = new ArrayList<SnakePosition>();
		
		invalidSnakePositions.add(new SnakePosition(22, 22));
		
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(invalidSnakePositions);
	}
	
	/**
	 * Represents test case for verifying Snake should not have start Point less than end Point
	 */
	@Test(expected=SnakeLadderException.class)
	public void testSnakeHaveStartPointLessThanEndPoint() {
		List<SnakePosition> invalidSnakePositions = new ArrayList<SnakePosition>();
		
		invalidSnakePositions.add(new SnakePosition(22, 65));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(invalidSnakePositions);
	}
	
	/**
	 * Represents test case for verifying Two snakes should not have same start point.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testTwoSnakesHaveSameStartPoint() {
		List<SnakePosition> invalidSnakePositions = new ArrayList<SnakePosition>();
		
		invalidSnakePositions.add(new SnakePosition(17, 7));
		invalidSnakePositions.add(new SnakePosition(17, 5));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(invalidSnakePositions);
	}
	
	/**
	 * Represents test case for verifying Two snakes should have same end point.
	 */
	@Test
	public void testTwoSnakesHaveSameEndPoint() {
		List<SnakePosition> invalidSnakePositions = new ArrayList<SnakePosition>();
		
		invalidSnakePositions.add(new SnakePosition(44, 22));
		invalidSnakePositions.add(new SnakePosition(31, 22));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(invalidSnakePositions);
	}
	
	/**
	 * Represents test case for verifying Snake should not have start or end point greater than winning point on the board.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testSnakeHaveStartPointGreaterThanWinningBoardPoint() {
		List<SnakePosition> invalidSnakePositions = new ArrayList<SnakePosition>();
		
		invalidSnakePositions.add(new SnakePosition(103, 55));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(invalidSnakePositions);
	}
	
	/**
	 * Represents test case for verifying One snake start point should not be equal to other snake end point.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testSnakeStartPointNotEqualToOtherSnakeEndPoint() {
		List<SnakePosition> invalidSnakePositions = new ArrayList<SnakePosition>();
		
		invalidSnakePositions.add(new SnakePosition(88, 55));
		invalidSnakePositions.add(new SnakePosition(55, 44));
	
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setSnakesToGameBoard(invalidSnakePositions);
	}
}
