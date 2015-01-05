package com.game.snakeladder.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.snakeladder.exception.SnakeLadderException;
import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.LadderPosition;

/**
 * This is JUNIT Test class to verify rules for adding ladder to the game board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class LadderPositionTest {
	
	/**
	 * Represents valid list of ladder positions.
	 */
	private static List<LadderPosition> ladderPositions;
	
	/**
	 * This method is used to set up the valid ladder positions.
	 */
	@BeforeClass
	public static void setLadderPositons() {
		ladderPositions = new ArrayList<LadderPosition>();
		
		ladderPositions.add(new LadderPosition(4, 14));
		ladderPositions.add(new LadderPosition(9, 31));
		ladderPositions.add(new LadderPosition(20, 38));
		ladderPositions.add(new LadderPosition(28, 84));
		ladderPositions.add(new LadderPosition(40, 59));
		ladderPositions.add(new LadderPosition(51, 67));
		ladderPositions.add(new LadderPosition(71, 91));
	}
	
	
	/**
	 * Represents test case of adding valid ladder positions to the game board.
	 */
	@Test
	public void testLadderPositions() {
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setLaddersToGameBoard(ladderPositions);
		
		Assert.assertNotNull(gameBoard.checkLadderPositionExistsOnCurrentPosition(4));
		Assert.assertNotNull(gameBoard.checkLadderPositionExistsOnCurrentPosition(9));
		Assert.assertNotNull(gameBoard.checkLadderPositionExistsOnCurrentPosition(20));
		Assert.assertNotNull(gameBoard.checkLadderPositionExistsOnCurrentPosition(28));
		Assert.assertNotNull(gameBoard.checkLadderPositionExistsOnCurrentPosition(40));
		Assert.assertNotNull(gameBoard.checkLadderPositionExistsOnCurrentPosition(51));
		Assert.assertNotNull(gameBoard.checkLadderPositionExistsOnCurrentPosition(71));
	}
	
	/**
	 * Represents test case for verifying Ladder should not have start point greater than end point.
	 */
	
	@Test(expected=SnakeLadderException.class)
	public void testLadderStartPointGraterThanEndPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
		
		invalidLadderPositions.add(new LadderPosition(14, 14));
		
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	}
	
	/**
	 * Represents test case for verifying Ladder should not have same start point and end point.
	 */
	
	@Test(expected=SnakeLadderException.class)
	public void testLadderHaveSameStartPointAsEndPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
		
		invalidLadderPositions.add(new LadderPosition(4, 4));
		
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	}
	
	/**
	 * Represents test case for verifying Two ladders should not have same start point.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testTwoLaddersWithSameStartPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
		
		invalidLadderPositions.add(new LadderPosition(4, 14));
		invalidLadderPositions.add(new LadderPosition(4, 31));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	}
	
	/**
	 * Represents test case for verifying Two ladder could have same end point.
	 */
	@Test
	public void testTwoLaddersWithSameEndPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
		
		invalidLadderPositions.add(new LadderPosition(4, 56));
		invalidLadderPositions.add(new LadderPosition(14, 56));
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	}
	
	/**
	 * Represents test case for verifying Ladder should not have start or end point greater than winning point on board.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testLadderHaveStartPointGreaterThanWinningBoardPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
		
		invalidLadderPositions.add(new LadderPosition(104, 56));
		
		
		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	}
	
	/**
	 * Represents test case for verifying One Ladder start point should not be equal to other Ladder end point.
	 */
	@Test(expected=SnakeLadderException.class)
	public void testLadderStartPointNotEqualToOtherLadderEndPoint() {
		List<LadderPosition> invalidLadderPositions = new ArrayList<LadderPosition>();
		
		invalidLadderPositions.add(new LadderPosition(4, 56));
		invalidLadderPositions.add(new LadderPosition(56, 80));
		

		GameBoard gameBoard = new GameBoard(10, 10);
		gameBoard.setLaddersToGameBoard(invalidLadderPositions);
	}
}
