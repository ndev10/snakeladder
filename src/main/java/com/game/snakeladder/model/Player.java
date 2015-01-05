package com.game.snakeladder.model;

/**
 * This class represents player of the game.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class Player {
	
	/**
	 * Represents name of the player.
	 */
	private String name;
	
	/**
	 * Represents the player's current position on the game board.
	 */
	private Integer currentPosition;
	
	/**
	 * Getter for name.
	
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name.
	 *
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for currentPosition.
	
	 * @return the currentPosition.
	 */
	public Integer getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * Setter for currentPosition.
	 *
	 * @param currentPosition the currentPosition to set.
	 */
	public void setCurrentPosition(Integer currentPosition) {
		this.currentPosition = currentPosition;
	}

	

}
