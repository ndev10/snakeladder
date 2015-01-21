package com.game.snakeladder.model;


/**
 * This class represents the positions of the Snakes and Ladders on the game board. 
 * @see SnakePosition
 * @see LadderPosition
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakeLadderPosition {
	
	/**
	 * Represents the start point of the snake or ladder.
	 */
	private Integer startPoint;
	
	/**
	 * Represents the end point of the snake or ladder.
	 */
	private Integer endPoint;
	
	/**
	 * Constructs Snake or Ladder Positions.
	 * 
	 * @param startPoint start point of the snake or ladder.
	 * @param endPoint end point of the snake or ladder.
	 */
	public SnakeLadderPosition(final Integer startPoint, final Integer endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}


	/**
	 * Getter for startPoint.
	
	 * @return the startPoint.
	 */
	public Integer getStartPoint() {
		return startPoint;
	}


	/**
	 * Getter for endPoint.
	
	 * @return the endPoint.
	 */
	public Integer getEndPoint() {
		return endPoint;
	}

	
}
