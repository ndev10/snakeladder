package com.game.snakeladder.model;

import java.util.HashMap;
import java.util.Map;

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
	 * Represents the  snake and ladder positions on the board.
	 */
	private Map<Integer,Integer> snakeLadderPositionMap ;
	
	/**
	 * Constructs default game board.
	 */
	public GameBoard() {
		this.rows = 10;
		this.columns = 10;
		setDefaultSnakeAndLadderPositions();
	}
	
	/**
	 * Constructs Game board with configuration.
	 * 
	 * @param rows 				     Represents number of rows in game board.
	 * @param columns 			     Represents number of columns in game board.
	 * @param snakeLadderPositionMap Represents the snake and ladder position on the game board.
	 */
	
	public GameBoard(final Integer rows, final Integer columns,Map<Integer,Integer> snakeLadderPositionMap) {
		this.rows = rows;
		this.columns = columns;
		this.snakeLadderPositionMap = snakeLadderPositionMap;
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
	 * @return Integer represents winning position.
	 */
	public Integer getWinningPosition() {
		return rows * columns;
	}
	
	/**
	 * This method is used to check snake or ladder exists or not on the current position. If it does not it will return null.
	 * 
	 * @param currentPosition Represents the current position of the player.
	 * 
	 * @return Integer end point of snake and ladder.
	 */
	public Integer checkSnakeOrLadderExistsOnCurrentPosition (Integer currentPosition) {
		return snakeLadderPositionMap.get(currentPosition);
	}
	
	/**
	 * This method is used to set the default snakes and ladder to the game board.
	 * 
	 */
	private void setDefaultSnakeAndLadderPositions() {
		snakeLadderPositionMap = new HashMap<Integer, Integer>();
		
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
	}

}
