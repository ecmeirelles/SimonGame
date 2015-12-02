package functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import application.Game;
import drawing.DrawingPanel;

/* Class that represents the logic of the game */
public class GameFunction implements ActionListener {
	/* GameFunction attributes */
	public Game game;
	public DrawingPanel area;

	private int tick = 0;
	private int delay = 2;
	private boolean gameOn = true;
	private Random randomColors = new Random();
	private int movements = 0;
	
	/* Constructor to receive instances of Game and DrawingPanel */
	public GameFunction(Game simonGame, DrawingPanel drawingSimon) {
		this.game = simonGame;
		this.area = drawingSimon;
	}
	
	/* Set methods to modify tick, gameOn and delay attributes */
	public void setTick(int tick) {
		this.tick = tick;
	}
	
	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	/* Get and Set methods to access and modify, respectively, the movements attribute */
	public int getMovements() {
		return movements;
	}
	
	public void setMovements(int movements) {
		this.movements = movements;
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
				/* If the number of movements is equal to the size of the current sequence 
				 * Or the size is equal to 1 (so the game starts with 2 colors) */
				if (movements == game.getGameSequence().size() || game.getGameSequence().size() == 1) {
					if(game.getGameSequence().size() == 0) {
						/* Set a random color (from 1 to 4) to be brighter */
						game.activeColor = randomColors.nextInt(4)+ 1;
						/* Add this number to the game sequence */
						game.getGameSequence().add(game.activeColor);
					}
					
					else {
						/* Set a random color (from 1 to 4) to be brighter */
						game.activeColor = randomColors.nextInt(4)+ 1;
						/* Add this number to the game sequence */
						game.getGameSequence().add(game.activeColor);
						game.setLevel(game.getLevel() + 1);
						/* Set movements as zero */
						movements = 0;
						/* Wait for all necessary clicks */
						gameOn = false;
					}
				}
				/* If the number of clicks is fewer than the size of the current sequence*/
				else {
					/* Set color to be brighter again. It means, repeat the previous sequence */
					game.activeColor = game.getGameSequence().get(movements);
					movements++;
				}
				/* Set delay again to 2 */
				delay = 2;
			}
		}
		
		/* If movements is equal to the size of the current sequence */
		else if (movements == game.getGameSequence().size()) {
			/* Reset everything */
			gameOn = true;
			movements = 0;
			delay = 2;
		}
		
		if (game.getLevel() >= game.getBestScore()) {
			game.setBestScore(game.getLevel());
		}
	
		/* The drawing is repainted to implement the new settings */
		area.repaint();
	}
}
