package com.game.snakeladder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.game.snakeladder.exception.SnakeLadderException;
import com.game.snakeladder.model.Dice;
import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.LadderPosition;
import com.game.snakeladder.model.Player;
import com.game.snakeladder.model.SnakePosition;
import com.game.snakeladder.rule.SnakeLadderRules;

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
	private Deque<Player> players;
	
	/**
	 * Represents the winner of the game.
	 */
	private Player winner = null;
	
	/**
	 * Represents the snake positions on the board.
	 */
	private List<SnakePosition> snakePositions;
	
	/**
	 * Represents the ladder positions on the board.
	 */
	private List<LadderPosition> ladderPositions;
	
	/**
	 * Represents the default position of the player when game starts.
	 */
	private final static Integer DEFAULT_POSITON_ON_BOARD = 1;
	
	/**
	 * Represents whether players present to play the game or not.
	 */
	private boolean playersArrived = false;
	
	/**
	 * Constructs the Game.
	 * 
	 * @param gameBoard       Represents the game board.
	 * @param playerNames	  Represents the player names.
	 * @param snakePositions  Represents the snake positions on the board.
	 * @param ladderPositions Represents the ladder positions on the board.
	 */
	public SnakeLadderGame(GameBoard gameBoard, List<String> playerNames,List<SnakePosition> snakePositions,
						   List<LadderPosition> ladderPositions) {
		this.gameBoard = gameBoard;
		this.snakePositions = snakePositions;
		this.ladderPositions = ladderPositions;
		
		createPlayers(playerNames);
	}
	
	/**
	 * This method is used to play the game.
	 */
	public void playGame() {
		if (playersArrived) {
			try {
				if (gameBoard == null) {
					System.out.println("Default Game board will be used.");
					gameBoard = new GameBoard(10,10);
				}
				
				System.out.println("Loading Game.........");
				buildGame();
				System.out.println("\nGet Ready For Action ..............");
				Thread.sleep(3000);
				
				Dice dice = new Dice();
				while (!gameOver()) {
					int currentDiceValue = dice.rollDice();
					
					Player currentPlayer = players.remove();
					String currentPlayerName =  currentPlayer.getName();
					
					System.out.println("\n \n");
					System.out.println("Player  : " + currentPlayerName + " Current Position " + currentPlayer.getCurrentPosition());
					System.out.println("Player  : " + currentPlayerName + " has Dice Number " + currentDiceValue);
					
					Integer newPosition = SnakeLadderRules.movePlayerPositionOnBoard(currentDiceValue,currentPlayer, gameBoard);
					currentPlayer.setCurrentPosition(newPosition);
				
					if (playerWins(newPosition,gameBoard.getWinningPointOnBoard())) {
						winner = currentPlayer;
						System.out.println(currentPlayerName +  " WINS !!!!!!!!!!!!!!!!!!!!!!!!!! Congratulations.");
						players.clear();
					} else {
						players.add(currentPlayer);
						gameBoard.printGameBoard(currentPlayer.getCurrentPosition());
					}
					
					Thread.sleep(5000);
				}
			} catch (SnakeLadderException snakeLadderException) {
				System.out.println("\n\n\n ################################## Alert ############################# ");
				System.out.println(snakeLadderException.getExceptionMessage());
			} catch(Exception exception) {
				System.out.println("\n\n\n ################################## Error ############################# ");
				System.out.println("Error in game.");
			}
			
		} else {
			System.out.println("No players are present to play the game.");
		}
		
	}
	
	/**
	 * this method is used to build the game.
	 */
	private void buildGame() {
		gameBoard.validateGameBoard();
		gameBoard.printGameBoard(DEFAULT_POSITON_ON_BOARD);
		gameBoard.setSnakesToGameBoard(snakePositions);
		gameBoard.setLaddersToGameBoard(ladderPositions);
	}
	
	/**
	 * This method is used to create players.
	 * 
	 * @param playerNames Represents the player names.
	 */
	private void createPlayers(List<String> playerNames) {
		if (null != playerNames && playerNames.size() > 0) {
			players = new LinkedList<Player>();
			int unknownPlayerIndex = 1;
			for (String playerName : playerNames ) {
				
				System.out.println("\nWelcome Player : " +  playerName);
				Player player = new Player();
				if (playerName != null) {
					player.setName(playerName);
				} else {
					player.setName("Unknow Player" + unknownPlayerIndex);
					unknownPlayerIndex = unknownPlayerIndex + 1;
				}
				player.setCurrentPosition(DEFAULT_POSITON_ON_BOARD);
				players.add(player);
				playersArrived = true;
			}
		} 
	}
	
	/**
	 * This method is used to check whether game is over or not.
	 * 
	 * @return boolean true if game over otherwise false.
	 */
	private boolean gameOver() {
		return winner != null ;
	}


	/**
	 * This method is used to check whether player wins the game or not by comparing current position with the
	 * max position of the board.
	 * 
	 * @param maxPosition represents the max position on the board.
	 * 
	 * @return boolean indicates player wins or not.
	 */
	private boolean playerWins(Integer currentPosition,Integer winningPosition) {
		
		return currentPosition.equals(winningPosition);
	}
	
	

}
