package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import drawing.DrawingPanel;

/* Class that represents the logic of the game */
public class GameFunction implements ActionListener {
	/* GameFunction attributes */
	public Game game;
	public DrawingPanel area;

	private int tick = 0;
	private int delay = 2;
	private boolean gameOver = false;
	private boolean gameOn = true;
	private Random randomColors = new Random();
	
	private ArrayList<Integer> gameSequence = new ArrayList<Integer>();
	private int movements = 0;
	
	/* Constructor to receive instances of Game and DrawingPanel */
	public GameFunction(Game simonGame, DrawingPanel drawingSimon) {
		this.game = simonGame;
		this.area = drawingSimon;
	}
	
	/* Get method to access the gameSequence attribute */
	public ArrayList<Integer> getGameSequence() {
		return gameSequence;
	}
	
	/* Set method to modify the tick attribute */
	public void setTick(int tick) {
		this.tick = tick;
	}
	
	/* Get and Set methods to access and modify, respectively, the movements attribute */
	public int getMovements() {
		return movements;
	}
	
	public void setMovements(int movements) {
		this.movements = movements;
	}
	
	/* Get and Set methods to access and modify, respectively, the gameOver attribute */
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tick = tick + 1;
		
		/* Every second active color is setted as zero, to make it delay again */
		if(tick % 20 == 0) {
			game.activeColor = 0;
			/* If delay still exists */
			if (delay >= 0) {
				/* Delay needs to be decreased */
				delay--;
			}
		}
		
		/* If game is running */
		if(gameOn) {
			/* If delay does not exist */
			if (delay <= 0) {
				/* If the number of movements is equal to the size of the current sequence */
				if (movements == gameSequence.size()) {
					/* Set a random color (from 1 to 4) to be brighter */
					game.activeColor = randomColors.nextInt(4)+ 1;
					/* Add this number to the game sequence */
					gameSequence.add(game.activeColor);
					/* Set movements as zero */
					movements = 0;
					/* Wait for all necessary clicks */
					gameOn = false;
				}
				/* If the number of clicks is fewer than the size of the current sequence*/
				else {
					/* Set color to be brighter again. It means, repeat the previous sequence */
					game.activeColor = gameSequence.get(movements);
					movements++;
				}
				/* Set delay again to 2 */
				delay = 2;
			}
		}
		
		/* If movements is equal to the size of the current sequence */
		else if (movements == gameSequence.size()) {
			/* Reset everything */
			gameOn = true;
			movements = 0;
			delay = 2;
		}
	
		/* The drawing is repainted to implement the new settings */
		area.repaint();
	}
}
