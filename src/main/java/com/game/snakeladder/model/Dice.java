package com.game.snakeladder.model;

/**
 * This class represents dice for the snake and ladder game. 
 * 
 * @author Devang.Ghugharawala
 *
 */
public class Dice {
	
	/**
	 * It is used to decide minimum value on the dice.
	 */
	private static final int MINIMUM_DICE_VALUE = 1;
	
	/**
	 * It is used to decide maximum value on the dice.
	 */
	private static final int MAXIMUM_DICE_VALUE = 6;

	/**
	 * This method will return random value between 1 to 6.
	 * 
	 * @return int between 1 to 6.
	 */
	public int rollDice () {
		return generateRandomDiceNumber ( MINIMUM_DICE_VALUE , MAXIMUM_DICE_VALUE );
	}
	
	/**
	 * This method will generate random value between 1 to 6 
	 * 
	 * @param min minimum value on dice.
	 * @param max maximum value on dice.
	 * 
	 * @return int between 1 to 6.
	 */
	private int generateRandomDiceNumber (int min , int max ) {
		 return ( int) ( min + Math . round (( max - min ) * Math . random ()));
	}
}
