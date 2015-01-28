package com.game.snakeladder.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.snakeladder.SnakeLadderGame;

/**
 * This is JUNIT Test class to verify rules of moving player on the board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakeLadderTest {

	/**
	 * Represents valid list of snake or ladder positions.
	 */
	private static Map<Integer,Integer> snakeLadderPositionMap = new HashMap<Integer, Integer>() ;
	
	/**
	 * Represents the player names.
	 */
	private static Set<String> playerNames = new HashSet<String>();

	/**
	 * This method is used to set up the valid snakes and ladders positions.
	 */
	@BeforeClass
	public static void setGameBoard() {
	
		
		snakeLadderPositionMap.put(17, 7);
		snakeLadderPositionMap.put(54, 34);
		snakeLadderPositionMap.put(62, 19);
		snakeLadderPositionMap.put(64, 60);
		snakeLadderPositionMap.put(87, 24);
		snakeLadderPositionMap.put(93, 73);
		snakeLadderPositionMap.put(95, 75);
		
		snakeLadderPositionMap.put(4,14);
		snakeLadderPositionMap.put(9,31);
		snakeLadderPositionMap.put(20,38);
		snakeLadderPositionMap.put(28,84);
		snakeLadderPositionMap.put(40,59);
		snakeLadderPositionMap.put(51,67);
		snakeLadderPositionMap.put(71,91);
		
		playerNames.add("John");
		playerNames.add("Smith");
	}
	
	/**
	 * Represents test case for verifying Moving player without any snake and ladder
	 */
	@Test
	public void testMovePlayerWithoutSnakeAndLadder() {
		
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositionMap);
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
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositionMap);
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
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositionMap);
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
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(10, 10, playerNames, snakeLadderPositionMap);
		final Integer  currentDiceValuue = 5;
		final Integer currentPlayerPosition = 99;
		final Integer expectedValue =  99;
		
		Integer resultedValue = snakeLadderGame.movePlayerToNextPosition(currentPlayerPosition, currentDiceValuue);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying two or more than two players required.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRequriedNumberOfPlayers() {
		Set<String> players = new HashSet<String>();
		players.add("John");
		new SnakeLadderGame(10, 10, players, snakeLadderPositionMap);
	}
	
	
}
