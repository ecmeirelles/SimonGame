package functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Game;

/* Class that represents the functions regarding difficulty of the game */
public class DifficultyFunctions implements ActionListener {
	/* DifficultyFunctions attributes */
	Game game;
	
	/* Constructor to receive current information of Game*/
	public DifficultyFunctions(Game simonGame) {
		this.game = simonGame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/* First of all, it is needed to restart the game */
		game.restartGame();
		
		/* If difficulty chosen (by the menu) is easy */
		if(game.getEasyDifficulty().isSelected()) {
			/* Change timer to 0.03 seconds */
			game.timer.setDelay(30);
			/* Restart timer */
			game.timer.restart();
		}
		/* If difficulty chosen (by the menu) is medium */
		else if(game.getMediumDifficulty().isSelected()) {
			/* Change timer to 0.02 seconds */
			game.timer.setDelay(20);
			/* Restart timer */
			game.timer.restart();
		}
		/* If difficulty chosen (by the menu) is hard */
		else if(game.getHardDifficulty().isSelected()) {
			/* Change timer to 0.01 seconds */
			game.timer.setDelay(10);
			/* Restart timer */
			game.timer.restart();
		}
		
		/* Start asking for the ActionListener */
		game.timer.start();
	}

}
