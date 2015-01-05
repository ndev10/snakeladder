package com.game.snakeladder.rule;

import java.util.List;
import java.util.Map;

import com.game.snakeladder.constant.GameEntityEnum;
import com.game.snakeladder.exception.SnakeLadderException;
import com.game.snakeladder.model.BasePosition;
import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.LadderPosition;
import com.game.snakeladder.model.Player;
import com.game.snakeladder.model.SnakePosition;

/**
 * This class defines the rules of the Snake Ladder Game.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakeLadderRules {
	
	/**
	 * This method is used to move the player on the board based on dice number.
	 *
	 * @param currentDiceValue Represents the current dice values.
	 * @param player 		   Represents the player for which the movement needs to done.
	 * @param gameBoard 	   Represent the game board.
	 * 
	 * @return Integer represents the new position of the player.
	 */
	public static Integer movePlayerPositionOnBoard (final Integer currentDiceValue, final Player player,GameBoard gameBoard) {
		
		Integer currentPosition = player.getCurrentPosition();
		
		if (currentDiceValue > 6) {
			System.out.println("Cheating........... Dice value should not be greater than 6");
			return currentPosition;
		}
		Integer newPosition = currentPosition + currentDiceValue;
		
		SnakePosition snakePosition = gameBoard.checkSnakePositionExistsOnCurrentPosition(newPosition);
		
		if (snakePosition != null) {
			newPosition = snakePosition.getEndPoint();
			System.out.println("OH NOOOOOOOO You got the " + snakePosition + " @~~~~~~~~~~~~~~~~~~~~");
		}
		
		LadderPosition ladderPosition = gameBoard.checkLadderPositionExistsOnCurrentPosition(newPosition);
		
		if (ladderPosition != null) {
			newPosition = ladderPosition.getEndPoint();
			System.out.println("You are Lucky. You got the " + ladderPosition + " |---------------------|");
		}
		System.out.println(player.getName() + " has get next Position " + newPosition);
		
		if (newPosition > 100) {
			Integer countRemainingToWin = 100 - currentPosition;
			System.out.println("Unlucky!!! You need exact "  + countRemainingToWin  + " dice Count to Win the Game");
			
			newPosition = currentPosition;
		}
		return newPosition;
	}
	
	/**
	 * This method is used to validate snake position on the game board.
	 * 
	 * @param snakePosition 	    Represents the snake position.
	 * @param winningNumberOnBoard	Represents the winning point on the board.
	 * 
	 * @throws SnakeLadderException thrown when snake position is invalid.
	 */

	public static void validateSnakePosition(SnakePosition snakePosition,Integer winningNumberOnBoard) throws SnakeLadderException {
		snakePosition.validateSnakeStartAndEndPoints();
		checkVlaidPositionOnBoard(snakePosition, winningNumberOnBoard, GameEntityEnum.SNAKE);
	}
	
	/**
	 * This method is used to validate ladder position on the game board.
	 * 
	 * @param ladderPositon         Represents the ladder position.
	 * @param winningNumberOnBoard	Represents the winning point on the board.
	 * 
	 * @throws SnakeLadderException thrown when ladder position is invalid.
	 */
	public static void validateLadderPosition(LadderPosition ladderPositon,Integer winningNumberOnBoard) throws SnakeLadderException {
		ladderPositon.validateLadderStartAndEndPoint();
		checkVlaidPositionOnBoard(ladderPositon, winningNumberOnBoard, GameEntityEnum.LADDER);
	}
	
	/**
	 * This method is used to check whether snake or ladder position are already exists on the board.
	 * 
	 * @param basePosition        Represents the snake or ladder position to add on the board.
	 * @param existingPositionMap Represents existing snake or ladder positions map. It will be used 
	 * 							  for checking start point already exists or not.
	 * @param endPointsList       Represents snake or ladder end points to validate end point already exists or not.
	 * @param gameEntityEnum      Represents the entity ENUM to identify snake or ladder.
	 * 
	 * @throws SnakeLadderException thrown when snake or ladder position is invalid.
	 */
	public static void checkPositionAlreadyExistsOnGameBoard(BasePosition basePosition, Map<Integer,? extends BasePosition> existingPositionMap,
												  List<Integer> endPointsList, GameEntityEnum gameEntityEnum) throws SnakeLadderException {
		
		Integer startPoint = basePosition.getStartPoint();
		Integer endPoint = basePosition.getEndPoint();
		
		BasePosition existingBasePositionWithStartPoint = existingPositionMap.get(startPoint);
		if (existingBasePositionWithStartPoint != null ) {
		
			throw new SnakeLadderException(gameEntityEnum.name() + " alerady Exists for the start point " + existingBasePositionWithStartPoint);
		}
		
		BasePosition existingBasePositionWithEndPoint = existingPositionMap.get(endPoint);
		if (existingBasePositionWithEndPoint != null ) {
		
			throw new SnakeLadderException(gameEntityEnum.name() + " alerady Exists for the start point " + existingBasePositionWithEndPoint);
		}
		
		if (endPointsList.contains(startPoint)) {
			throw new SnakeLadderException(gameEntityEnum.name() + " alerady Exists for the end point " + startPoint);
		}
	}
	
	/**
	 * This method is used to validate snake and ladder position on board. It will check whether the start and end points are same
	 * or not. It will also validate whether start or end point should not be greater than winning number on the board. 
	 * 
	 * @param basePosition			Represents the snake or ladder position.
	 * @param winningNumberOnBoard  Represents the winning number on the board.				
	 * @param gameEntityEnum		Represents the ENUM indicates whether it is snake or ladder.
	 * 
	 * @throws SnakeLadderException thrown when invalid position of snake or ladder found.
	 */
	private static void checkVlaidPositionOnBoard(BasePosition basePosition,Integer winningNumberOnBoard,GameEntityEnum gameEntityEnum) 
																											 throws SnakeLadderException {
		final Integer startPoint = basePosition.getStartPoint();
		final Integer endPoint  = basePosition.getEndPoint();
		
		if (startPoint.equals(endPoint)) {
			throw new SnakeLadderException("Start Points and End Points should not be same For " 
											+ gameEntityEnum.name() + " : " + basePosition);
		}
		
		if (startPoint > winningNumberOnBoard || endPoint > winningNumberOnBoard) {
			throw new SnakeLadderException("Start or End Positon should not be Greater than Max Positon on the board For " 
											+ gameEntityEnum.name() + " : " + basePosition);
		}
	}
	
	
}
