package com.game.snakeladder;

import java.util.ArrayList;
import java.util.List;

import com.game.snakeladder.model.GameBoard;
import com.game.snakeladder.model.LadderPosition;
import com.game.snakeladder.model.SnakePosition;

/**
 * This class is used to run the game.
 * 
 * @author Devang.Ghugharawala
 *
 */
public class RunGame {
	
	public static void main(String[] args) {
		
		GameBoard gameBoard = new GameBoard(10, 10);
		
		List<String> playerNames = new ArrayList<String>();
		playerNames.add("Player1");
		playerNames.add("Player2");
	
		
		List<SnakePosition> snakePositions = new ArrayList<SnakePosition>();
		
		snakePositions.add(new SnakePosition(17, 7));
		snakePositions.add(new SnakePosition(54, 34));
		snakePositions.add(new SnakePosition(62, 19));
		snakePositions.add(new SnakePosition(64, 60));
		snakePositions.add(new SnakePosition(87, 24));
		snakePositions.add(new SnakePosition(93, 73));
		snakePositions.add(new SnakePosition(95, 75));
		
		
		List<LadderPosition> ladderPositions = new ArrayList<LadderPosition>();
		
		
		ladderPositions.add(new LadderPosition(4, 14));
		ladderPositions.add(new LadderPosition(9, 31));
		ladderPositions.add(new LadderPosition(20, 38));
		ladderPositions.add(new LadderPosition(28, 84));
		ladderPositions.add(new LadderPosition(40, 59));
		ladderPositions.add(new LadderPosition(51, 67));
		ladderPositions.add(new LadderPosition(71, 91));
		
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame(gameBoard, playerNames, snakePositions, ladderPositions);
		
	
		snakeLadderGame.playGame();
		
		
	}

}
