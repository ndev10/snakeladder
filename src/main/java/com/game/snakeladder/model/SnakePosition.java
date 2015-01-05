package com.game.snakeladder.model;

import com.game.snakeladder.exception.SnakeLadderException;

/**
 * This class represents the Position of the snake on the game board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakePosition extends BasePosition {
	
	/**
	 * Construct snake position on the board with start and end point
	 * 
	 * @param startPoint start point of the snake.
	 * @param endPoint  end point of the snake.
	 */
	public SnakePosition(Integer startPoint, Integer endPoint) {
		super(startPoint, endPoint);
	}

	/**
	 * Represents String representation of the SnakePosition object.
	 */
	@Override
	public String toString() {
		return "Snake Position : (" + getStartPoint() + "," + getEndPoint() +")";
	}
	
	/**
	 * This method validate the snake position with the rule end point should not be greater than start point.
	 * 
	 * @throws SnakeLadderException thrown when end point is greater than start point.
	 */
	public void validateSnakeStartAndEndPoints() throws SnakeLadderException {
		validateBasePoint();
		if (getEndPoint() > getStartPoint()) {
			throw new SnakeLadderException("Start Positon should not be less than End Position For " + this);
		}
	}
	
	

}
