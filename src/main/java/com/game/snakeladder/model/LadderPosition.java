package com.game.snakeladder.model;

import com.game.snakeladder.exception.SnakeLadderException;

/**
 * This class represents the Position of the ladder on the game board.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class LadderPosition extends BasePosition {
	
	/**
	 * Construct ladder position on the board with start and end point
	 * 
	 * @param startPoint start point of the ladder.
	 * @param endPoint   end point of the ladder.
	 */
	public LadderPosition(Integer startPoint, Integer endPoint) {
		super(startPoint,endPoint);
	}

	/**
	 * Represents String representation of the LadderPosition object.
	 */
	@Override
	public String toString() {
		return "Ladder Position : (" + getStartPoint() + "," + getEndPoint() +")";
	}
	
	/**
	 * This method validate the snake position with the rule start point should not be greater than end point.
	 * 
	 * @throws SnakeLadderException Thrown when start point is greater than end point.
	 */
	public void validateLadderStartAndEndPoint() throws SnakeLadderException {
		validateBasePoint();
		if (getStartPoint() > getEndPoint()) {
			throw new SnakeLadderException("Start Positon should not be greater than End Position For " + this);
		}
	}
	
	

}
