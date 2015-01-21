package com.game.snakeladder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	private Map<Integer,SnakeLadderPosition> snakeLadderPositionMap = new HashMap<Integer, SnakeLadderPosition>();
	
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
	 * @param rows 				   Represents number of rows in game board.
	 * @param columns 			   Represents number of columns in game board.
	 * @param snakeLadderPositions Represents the snake and ladder position on the map.
	 */
	
	public GameBoard(final Integer rows, final Integer columns,List<SnakeLadderPosition> snakeLadderPositions) {
		this.rows = rows;
		this.columns = columns;
		setSnakeAndLadderPosition(snakeLadderPositions);
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
	public Integer getWinningPosition() {
		return rows * columns;
	}
	
	/**
	 * This method is used to check snake exists or not on the current position. If it does not it will return null.
	 * 
	 * @param currentPosition Represents the current position of the player.
	 * 
	 * @return SnakePosition if snake exits at current position it will return SnakePosition object otherwise it will return null.
	 */
	public SnakeLadderPosition checkSnakeOrLadderExistsOnCurrentPosition (Integer currentPosition) {
		return snakeLadderPositionMap.get(currentPosition);
	}
	
	/**
	 * This method is used put the snakes on the board.
	 * 
	 * @param snakeLadderPositions 	Represents list of the snakes and ladder position on the board
	 */
	private void setSnakeAndLadderPosition(List<SnakeLadderPosition> snakeLadderPositions) {
		if (snakeLadderPositions != null && snakeLadderPositions.size() > 0) {
			for (SnakeLadderPosition snakeLadderPosition : snakeLadderPositions) {
				snakeLadderPositionMap.put(snakeLadderPosition.getStartPoint(), snakeLadderPosition);
			}
		}
	}
	
	/**
	 * This method is used to set the default snakes and ladder to the gameboard.
	 * 
	 */
	private void setDefaultSnakeAndLadderPositions() {
		List<SnakeLadderPosition> snakeLadderPositions = new ArrayList<SnakeLadderPosition>();
		
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
		
		setSnakeAndLadderPosition(snakeLadderPositions);
	}

}
