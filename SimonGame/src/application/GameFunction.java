package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import drawing.DrawingPanel;

/* Class that represents the logic of the game */
public class GameFunction implements ActionListener {
	/* SimonSays attributes */
	public Game game;
	public DrawingPanel area;

	private int tick = 0;
	private Random randomColors = new Random();
	
	/* Constructor to receive instances of Game and DrawingPanel */
	public GameFunction(Game simonGame, DrawingPanel drawingSimon) {
		this.game = simonGame;
		this.area = drawingSimon;
	}
	
	// Get and set methods to access and modify, respectively, the tick attribute
	public int getTick() {
		return tick;
	}

	public void setTick(int tick) {
		this.tick = tick;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tick = tick + 1;
		
		// Every second
		if(tick % 20 == 0) {
			// Set active color as zero. It means every color is darker
			game.activeColor = 0;
			// Set active color as a random number (from 1 to 4)
			game.activeColor = randomColors.nextInt(4) + 1;
			// Add the number to the gameSequence ArrayList
			game.gameSequence.add(game.activeColor);
		}
		
		/* The drawing is repainted to implement the new settings */
		area.repaint();
	}
}
