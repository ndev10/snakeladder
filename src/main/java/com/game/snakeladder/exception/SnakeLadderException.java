package com.game.snakeladder.exception;

/**
 * This is an exception class for Snake and Ladder. Throws when game rule is violated.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class SnakeLadderException extends RuntimeException  {
	

	private static final long serialVersionUID = 5198886131510132858L;
	
	/**
	 * Represents the detailed message to be shown to the user.
	 */
	private String exceptionMessage;
	
	/**
	 * Constructs exception with detailed message.
	 * 
	 * @param exceptionMessage Represents the detailed message for Exception.
	 */
	public SnakeLadderException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	/**
	 * Getter for exceptionMessage.
	
	 * @return the exceptionMessage.
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * Setter for exceptionMessage.
	 *
	 * @param exceptionMessage the exceptionMessage to set.
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	

}
