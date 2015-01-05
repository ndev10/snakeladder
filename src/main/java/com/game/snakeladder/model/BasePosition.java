package com.game.snakeladder.model;

import com.game.snakeladder.exception.SnakeLadderException;

/**
 * This class represents the positions of the Snakes and Ladders on the game board. 
 * @see SnakePosition
 * @see LadderPosition
 * 
 * @author Devang.Ghugharawala
 *
 */
public class BasePosition {

	/**
	 * Represents the start point of the snake or ladder.
	 */
	private Integer startPoint;
	
	/**
	 * Represents the end point of the snake or ladder.
	 */
	private Integer endPoint;
	
	
	/**
	 * Constructs BasePoint with statr point and end point.
	 * 
	 * @param startPoint start point of the snake or ladder.
	 * @param endPoint end point of the snake or ladder.
	 */
	public BasePosition(Integer startPoint, Integer endPoint) {

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
	 * Setter for startPoint.
	 *
	 * @param startPoint the startPoint to set.
	 */
	public void setStartPoint(Integer startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * Getter for endPoint.
	
	 * @return the endPoint.
	 */
	public Integer getEndPoint() {
		return endPoint;
	}

	/**
	 * Setter for endPoint.
	 *
	 * @param endPoint the endPoint to set.
	 */
	public void setEndPoint(Integer endPoint) {
		this.endPoint = endPoint;
	}
	
	/**
	 * Represents validation of the coordinates.
	 * 
	 *  @throws SnakeLadderException Thrown when start and end points are null or negative.
	 */
	public void validateBasePoint() throws SnakeLadderException  {
		if (startPoint == null || endPoint == null) {
			throw new SnakeLadderException("Start Or End Points should not be NULL.");
		}
		
		if (startPoint < 0 || endPoint < 0) {
			throw new SnakeLadderException("Start Or End Points should not be Negative.");
		}
	}
	
	/**
	 * Represents String representation of the BasePosition object.
	 */
	@Override
	public String toString() {
		return "(" + getStartPoint() + "," + getEndPoint() +")";
	}
}
