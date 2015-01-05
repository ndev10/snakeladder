package com.game.snakeladder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.snakeladder.constant.GameEntityEnum;
import com.game.snakeladder.exception.SnakeLadderException;
import com.game.snakeladder.rule.SnakeLadderRules;

/**
 * This class represents  the Snake and Ladder Game Board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class GameBoard {
	
	/**
	 * Represents the number of rows on the game board.
	 */
	private Integer rows;
	
	/**
	 * Represents the number of columns on the game board.
	 */
	private Integer columns;
	
	/**
	 * Represents the all snake positions on the board.
	 */
	private Map<Integer,SnakePosition> snakePositionMap = new HashMap<Integer, SnakePosition>();
	
	/**
	 * Represents the all ladder positions on the board.
	 */
	private Map<Integer,LadderPosition> ladderPositionMap = new HashMap<Integer, LadderPosition>();
	
	/**
	 * This list is used to validate that snake end point is already defined as a start point or end point.
	 */
	private List<Integer> snakeEndPoints = new ArrayList<Integer>();
	
	/**
	 * This list is used to validate that ladder end point is already defined as a start point or end point.
	 */
	private List<Integer> ladderEndpPoints = new ArrayList<Integer>();

	/**
	 * Constructs Game board.
	 * 
	 * @param rows represents number of rows in game board.
	 * @param columns represents number of columns in game board.
	 */
	
	public GameBoard(final Integer rows, final Integer columns) {
		this.rows = rows;
		this.columns = columns;
	}

	
	/**
	 * Getter for rows.
	
	 * @return the rows.
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * Getter for columns.
	
	 * @return the columns.
	 */
	public Integer getColumns() {
		return columns;
	}

	/**
	 * Represents the winning point on the board.
	 * 
	 * @return Integer represents winning point.
	 */
	public Integer getWinningPointOnBoard() {
		return rows * columns;
	}
	
	/**
	 * This method is used to print Game board.The current position of the player will be identified by [@].
	 * 
	 * @param currentLocation represents the current position of the player.
	 */
	public void printGameBoard(int currentLocation) {
		
		int totalRows = getRows();
		int totalColumns = getColumns();
		
		int maxCount = getWinningPointOnBoard();

		boolean notFirstRun = false;
		int iterationCount = -1;
		
		System.out.println("\nGameBaord Current State :::: \n ");
		while (maxCount > 0) {
			for (int row = totalRows ; row > 0 ; row--) {
				if (maxCount % totalColumns  == 0 && notFirstRun) {
					System.out.print("\n"); 
					 if (iterationCount == -1) {
						 maxCount = maxCount - (totalColumns - 1);
						 iterationCount = 1;
					 } else {
						 maxCount = maxCount - totalColumns;
						 iterationCount = -1;
					 }
				}
				for (int column = totalColumns; column > 0 ; column--) {
					 if (maxCount == currentLocation) {
						 System.out.print("[@]\t");
					 } else {
						 System.out.print(maxCount + "\t");
					 }
					 maxCount = maxCount + iterationCount;
				}
				 if (iterationCount == 1) {
					 maxCount = maxCount - 1;
				 }
				notFirstRun = true;
				
			}
			
			maxCount = 0;
		}
	}
	
	/**
	 * This method is used put the snakes on the board.
	 * 
	 * @param snakePositions 		Represents list of the snakes position on the board
	 * @throws SnakeLadderException Thrown when snake position already exists.
	 */
	public void setSnakesToGameBoard(List<SnakePosition> snakePositions) throws SnakeLadderException {
		if (snakePositions != null && snakePositions.size() > 0) {
			System.out.println("\n\n @~~~~~~~~~~~~~~ Start Setting Snakes on Board ~~~~~~~~~~~~~~@ ");
			for (SnakePosition snakePosition : snakePositions) {
				SnakeLadderRules.validateSnakePosition(snakePosition, getWinningPointOnBoard());
				SnakeLadderRules.checkPositionAlreadyExistsOnGameBoard(snakePosition, ladderPositionMap, ladderEndpPoints, GameEntityEnum.LADDER);
				SnakeLadderRules.checkPositionAlreadyExistsOnGameBoard(snakePosition, snakePositionMap,snakeEndPoints, GameEntityEnum.SNAKE);
				
				snakePositionMap.put(snakePosition.getStartPoint(), snakePosition);
				snakeEndPoints.add(snakePosition.getEndPoint());
				
				System.out.println(snakePosition);
			}
			System.out.println("@~~~~~~~~~~~~~~ End Setting Snakes on Board ~~~~~~~~~~~~~~@");
		} else {
			System.out.println("\n\n No Snakes has been added to Game");
		}
	}
	
	/**
	 * This method is used to check snake exists or not on the current position. If it does not it will return null.
	 * 
	 * @param currentPosition Represents the current position of the player.
	 * 
	 * @return SnakePosition if snake exits at current position it will return SnakePosition object otherwise it will return null.
	 */
	public SnakePosition checkSnakePositionExistsOnCurrentPosition (Integer currentPosition) {
		return snakePositionMap.get(currentPosition);
	}
	
	/**
	 * This method is used to set the Ladders on the Game board.
	 * 
	 * @param ladderPositions 		Represents the list of ladders position on the board.
	 * @throws SnakeLadderException Thrown when ladder position already exists.
	 */
	public void setLaddersToGameBoard(List<LadderPosition> ladderPositions) throws SnakeLadderException {
		if (ladderPositions != null && ladderPositions.size() > 0) {
			System.out.println("\n\n |-------------| Start Setting Ladders on Board |-------------|");
			for (LadderPosition ladderPositon : ladderPositions) {
				SnakeLadderRules.validateLadderPosition(ladderPositon, getWinningPointOnBoard());
				SnakeLadderRules.checkPositionAlreadyExistsOnGameBoard(ladderPositon, snakePositionMap, snakeEndPoints, GameEntityEnum.SNAKE);
				SnakeLadderRules.checkPositionAlreadyExistsOnGameBoard(ladderPositon, ladderPositionMap, ladderEndpPoints, GameEntityEnum.LADDER);
				
				ladderPositionMap.put(ladderPositon.getStartPoint(), ladderPositon);
				ladderEndpPoints.add(ladderPositon.getEndPoint());
				
				System.out.println(ladderPositon);
			}
			System.out.println("|-------------| End Setting Ladders on Board |-------------| \n\n");
		} else {
			System.out.println("\n No Ladders has been added to Game");
		}
	}
	
	/**
	 *  This method is used to check ladder exists or not on the current position. If it does not it will return null.
	 *  
	 * @param currentPosition Represents the current position of the player.
	 * 
	 * @return LadderPosition If snake exits at current position it will return LadderPosition object otherwise it will return null.
	 */
	public LadderPosition checkLadderPositionExistsOnCurrentPosition(Integer currentPosition) {
		return ladderPositionMap.get(currentPosition);
	}
	
	/**
	 * Validation for game board rows and columns.
	 * 
	 *  @throws SnakeLadderException Thrown when rows and columns  are null or negative.
	 */
	public void validateGameBoard() throws SnakeLadderException {
		if (rows == null || columns == null) {
			throw new SnakeLadderException("Game Boadr Metrices should not be NULL.");
		}
		
		if (rows < 0 || columns < 0) {
			throw new SnakeLadderException("Gme Board Metrices should not be Negative.");
		}
	}

}
