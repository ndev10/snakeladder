package com.game.snakeladder.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.snakeladder.SnakeLadderGame;
import com.game.snakeladder.model.SnakeLadderPosition;

/**
 * This is JUNIT Test class to verify rules of moving player on the board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakeLadderTest {

	/**
	 * Represents valid list of snake positions.
	 */
	private static List<SnakeLadderPosition> snakeLadderPositions = new ArrayList<SnakeLadderPosition>();
	
	private static Set<String> playerNames = new HashSet<String>();

	/**
	 * This method is used to set up the valid snakes and ladders positions.
	 */
	@BeforeClass
	public static void setGameBoard() {
		
		snakeLadderPositions.add(new SnakeLadderPosition(17, 7));
		snakeLadderPositions.add(new SnakeLadderPosition(54, 34));
		snakeLadderPositions.add(new SnakeLadderPosition(62, 19));
		snakeLadderPositions.add(new SnakeLadderPosition(64, 60));
		snakeLadderPositions.add(new SnakeLadderPosition(87, 24));
		snakeLadderPositions.add(new SnakeLadderPosition(93, 73));
		snakeLadderPositions.add(new SnakeLadderPosition(95, 75));
		
		snakeLadderPositions.add(new SnakeLadderPosition(4,14));
		snakeLadderPositions.add(new SnakeLadderPosition(9,31));
		snakeLadderPositions.add(new SnakeLadderPosition(20,38));
		snakeLadderPositions.add(new SnakeLadderPosition(28,84));
		snakeLadderPositions.add(new SnakeLadderPosition(40,59));
		snakeLadderPositions.add(new SnakeLadderPosition(51,67));
		snakeLadderPositions.add(new SnakeLadderPosition(71,91));
		
		playerNames.add("John");
		playerNames.add("Smith");
	}
	
	

	
	
	/**
	 * Represents test case for verifying Moving player without any snake and ladder
	 */
	@Test
	public void testMovePlayerWithoutSnakeAndLadder() {
		
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositions);
		final Integer  currentDiceValuue = 4;
		final Integer currentPlayerPosition = 15;
		final Integer expectedValue =  19;
		
		Integer resultedValue = snakeLadderGame.movePlayerToNextPosition(currentPlayerPosition, currentDiceValuue);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying When player’s dice value found  snake on any position, player will move the snake end point.
	 */
	@Test
	public void testMovePlayerWithSnake() {
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositions);
		final Integer  currentDiceValuue = 2;
		final Integer currentPlayerPosition = 15;
		final Integer expectedValue =  7;
		
		Integer resultedValue = snakeLadderGame.movePlayerToNextPosition(currentPlayerPosition, currentDiceValuue);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying When player’s dice value found ladder on any position, player will move the snake end point.
	 */
	@Test
	public void testMovePlayerWithLadder() {
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositions);
		final Integer  currentDiceValuue = 5;
		final Integer currentPlayerPosition = 15;
		final Integer expectedValue =  38;
		
		Integer resultedValue = snakeLadderGame.movePlayerToNextPosition(currentPlayerPosition, currentDiceValuue);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying When player is close to winning point and get the higher position than winning point after adding 
	 * current dice value, player will remain on the same position.
	 */
	@Test
	public void testMovePlayerWithNextPositionGreaterThanWinningPosition() {
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositions);
		final Integer  currentDiceValuue = 5;
		final Integer currentPlayerPosition = 99;
		final Integer expectedValue =  99;
		
		Integer resultedValue = snakeLadderGame.movePlayerToNextPosition(currentPlayerPosition, currentDiceValuue);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying two or more than two players requried.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRequriedNumberOfPlayers() {
		Set<String> players = new HashSet<String>();
		players.add("John");
		new SnakeLadderGame(10, 10, players, snakeLadderPositions);
	}
	
	
}
