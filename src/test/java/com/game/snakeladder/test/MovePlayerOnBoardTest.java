package com.game.snakeladder.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.LadderPosition;
import com.game.snakeladder.model.Player;
import com.game.snakeladder.model.SnakePosition;
import com.game.snakeladder.rule.SnakeLadderRules;

/**
 * This is JUNIT Test class to verify rules of moving player on the board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class MovePlayerOnBoardTest {

	/**
	 * Represents valid list of snake positions.
	 */
	private static List<SnakePosition> snakePositions;
	
	/**
	 * Represents valid list of ladder positions.
	 */
	private static List<LadderPosition> ladderPositions;
	
	/**
	 * This method is used to set up the valid snakes and ladders positions.
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
	 * Represents test case for verifying Dice value should be between 1 to 6 and not greater than 6.
	 */
	@Test
	public void movePlayerWithDiceValueUnExpected() {
		GameBoard gameBoard = new GameBoard(10, 10);
		
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(ladderPositions);
		
		final Integer  currentDiceValuue = 7;
		final Integer expectedValue =  94;
		
		final Player player = new Player();
		player.setName("John");
		player.setCurrentPosition(94);
		
		Integer resultedValue = SnakeLadderRules.movePlayerPositionOnBoard(currentDiceValuue, player, gameBoard);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying Moving player without any snake and ladder
	 */
	@Test
	public void movePlayerWithoutSnakeAndLadder() {
		
		GameBoard gameBoard = new GameBoard(10, 10);
		
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(ladderPositions);
		
		final Integer  currentDiceValuue = 3;
		final Integer currentPalyerValue = 8; 
		
		final Integer expectedValue =  currentDiceValuue + currentPalyerValue;
		
		final Player player = new Player();
		player.setName("John");
		player.setCurrentPosition(currentPalyerValue);
		
		Integer resultedValue = SnakeLadderRules.movePlayerPositionOnBoard(currentDiceValuue, player, gameBoard);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying When player’s dice value found  snake on any position, player will move the snake end point.
	 */
	@Test
	public void movePlayerWithSnake() {
		GameBoard gameBoard = new GameBoard(10, 10);
		
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(ladderPositions);
		
		final Integer  currentDiceValuue = 4;
		final Integer expectedValue =  24;
		
		final Player player = new Player();
		player.setName("John");
		player.setCurrentPosition(83);
		
		Integer resultedValue = SnakeLadderRules.movePlayerPositionOnBoard(currentDiceValuue, player, gameBoard);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying When player’s dice value found ladder on any position, player will move the snake end point.
	 */
	@Test
	public void movePlayerWithLadder() {
		GameBoard gameBoard = new GameBoard(10, 10);
		
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(ladderPositions);
		
		final Integer  currentDiceValuue = 5;
		final Integer expectedValue =  59;
		
		final Player player = new Player();
		player.setName("John");
		player.setCurrentPosition(35);
		
		Integer resultedValue = SnakeLadderRules.movePlayerPositionOnBoard(currentDiceValuue, player, gameBoard);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	/**
	 * Represents test case for verifying When player is close to winning point and get the higher position than winning point after adding 
	 * current dice value, player will remain on the same position.
	 */
	@Test
	public void movePlayerWithValueGreaterThanMaxValueOnBoard() {
		GameBoard gameBoard = new GameBoard(10, 10);
		
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(ladderPositions);
		
		final Integer  currentDiceValuue = 5;
		final Integer expectedValue =  98;
		
		final Player player = new Player();
		player.setName("John");
		player.setCurrentPosition(98);
		
		Integer resultedValue = SnakeLadderRules.movePlayerPositionOnBoard(currentDiceValuue, player, gameBoard);
		
		Assert.assertEquals(expectedValue, resultedValue);
			
	}
	
	
}
