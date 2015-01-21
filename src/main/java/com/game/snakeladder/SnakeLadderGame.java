package com.game.snakeladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.SnakeLadderPosition;

/**
 * This class represents the Game of the Snake and Ladder.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakeLadderGame {
	
	/**
	 * Represents the game board for the game.
	 */
	private GameBoard gameBoard;
	
	/**
	 * Represents the players of the game.
	 */
	private List<String> players  = new ArrayList<String>();
	
	/**
	 * Represents the current position of the players on the game board.
	 */
	private Map<String,Integer> playerCurrentPositionMap = new HashMap<String, Integer>();
	
	/**
	 * Represents the default position of the player when game starts.
	 */
	private final static Integer DEFAULT_POSITON_ON_BOARD = 0;
	
	/**
	 * Constructs the Game with configuration.
	 * 
	 * @param gameBoard       Represents the game board.
	 * @param playerNames	  Represents the player names.
	 * @param snakePositions  Represents the snake positions on the board.
	 * @param ladderPositions Represents the ladder positions on the board.
	 */
	public SnakeLadderGame(Integer rows,Integer columns, Set<String> playerNames,List<SnakeLadderPosition> snakeLadderPositions) {
		gameBoard = new GameBoard(rows,columns,snakeLadderPositions);
		intializePlayerPositions(playerNames);

	}
	
	/**
	 * Constructs the default game.
	 * 
	 * @param playerNames	  Represents the player names.
	 */
	public SnakeLadderGame(Set<String> playerNames) {
		gameBoard = new GameBoard();
		intializePlayerPositions(playerNames);
	}
	
	/**
	 * This method is used to play the game.
	 */
	public void playGame() {
		boolean isGameOver = false;
		while (!isGameOver) {
			for(String currentPlayerName : players){
				int currentDiceValue = generateRandomDiceNumber(1,6);
				
				Integer currentPlayerPosition = playerCurrentPositionMap.get(currentPlayerName);
				
				Integer newPlayerPosition = movePlayerToNextPosition(currentPlayerPosition, currentDiceValue);
				playerCurrentPositionMap.put(currentPlayerName,newPlayerPosition);
			
				if (newPlayerPosition.equals(gameBoard.getWinningPosition())) {
					isGameOver = true;
					break;
				} 
			}
		}
	}
	
	/**
	 * This method is used to move the player on the board based on dice number.
	 * 
	 * @param gameBoard  	   Represent the game board.
	 * @param playerName	   Represents the player name.
	 * @param currentDiceValue Represents the current dice values.
	 * 
	 * @return new position of the player.
	 */
	
	public Integer movePlayerToNextPosition (final Integer currentPlayerPosition, final Integer currentDiceValue) {
		
		Integer newPlayerPosition = currentPlayerPosition + currentDiceValue;
		
		Integer winningPositonOnBoard = gameBoard.getWinningPosition();
		if (newPlayerPosition > winningPositonOnBoard) {
			return currentPlayerPosition;
		}
		
		SnakeLadderPosition snakeLadderPosition = gameBoard.checkSnakeOrLadderExistsOnCurrentPosition(newPlayerPosition);
		
		if (snakeLadderPosition != null) {
			newPlayerPosition = snakeLadderPosition.getEndPoint();
		}
		
		return newPlayerPosition;
	}
	
	/**
	 * This method is used to create the players with their current position.
	 * 
	 * @param playerNames
	 */
	private void intializePlayerPositions(Set<String> playerNames){
		if (playerNames == null || playerNames.size() < 2) {
			throw new IllegalArgumentException("Atleast Two Players Requried for the game");
		}
		for (String playerName: playerNames) {
			players.add(playerName);
			playerCurrentPositionMap.put(playerName, DEFAULT_POSITON_ON_BOARD);
		}
	}
	
	
	/**
	 * This method will generate random value between min and max. 
	 * 
	 * @param min minimum value on dice.
	 * @param max maximum value on dice.
	 * 
	 * @return dice value.
	 */
	private int generateRandomDiceNumber (final int min , final int max ) {
		 return (int) ( min + Math.round (( max - min ) * Math.random ()));
	}
	
}
