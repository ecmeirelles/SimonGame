package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import drawing.DrawingPanel;

/* Class that represents the logic of the game */
public class GameFunction implements ActionListener {
	/* SimonSays attributes */
	public Game game;
	public DrawingPanel area;

	private int tick = 0;
	private int delay = 2;
	private boolean gameOn = true;
	private Random randomColors = new Random();
	
	private ArrayList<Integer> gameSequence = new ArrayList<Integer>();
	
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
				/* Set a random color (from 1 to 4) to be brighter */
				game.activeColor = randomColors.nextInt(4)+ 1;
				/* Add this number to the game sequence */
				gameSequence.add(game.activeColor);
				/* Wait for all necessary clicks */
				gameOn = false;
				
				/* Set delay again to 2 */
				delay = 2;
			}
		}
	
		/* The drawing is repainted to implement the new settings */
		area.repaint();
	}
}
