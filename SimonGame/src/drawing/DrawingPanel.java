package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import application.Game;
import internationalization.Internationalization;

/* Class that represents the drawing of the game, where all rectangles, colors and strings are painted */
public class DrawingPanel extends JPanel {
	/* DrawingPanel attributes */
	private static final long serialVersionUID = 1L;
	private Internationalization internationalization = new Internationalization();
	
	public Game game;
	
	/* Constructor to receive an instance of Game */
	public DrawingPanel(Game simonGame) {
		this.game = simonGame;
	}

	/* Function to draw the game's design */
	@Override
	protected void paintComponent(Graphics g) {
		/* Cast to use Graphics as Graphics2D */
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		
		
		/* If the game's attribute activeColor is equal to 1 */
		if (game.activeColor == 1) {
			/* If theme chosen is Green/Red/Blue/Yellow */
			if(game.getThemeChosen() == 0) {
				/* Set color as green */
				g2.setColor(Color.GREEN);
			}
			/* If theme chosen is Pink/Purple/Orange/Gray */
			else if(game.getThemeChosen() == 1) {
				/* Set color as magenta */
				g2.setColor(Color.MAGENTA);
			}
			
		}
		/* Otherwise, the colors are the same, but darker */
		else {
			if(game.getThemeChosen() == 0) {
				g2.setColor(Color.GREEN.darker());
			}
			
			else if(game.getThemeChosen() == 1) {
				g2.setColor(Color.MAGENTA.darker());
			}
		}
		/* Create a rectangle sized 1/4 of the screen */
		g2.fillRect(0, 0, 450, 450);
		
		/* If the game's attribute activeColor is equal to 2 */
		if (game.activeColor == 2) {
			/* If theme chosen is Green/Red/Blue/Yellow */
			if(game.getThemeChosen() == 0) {
				/* Set color as red */
				g2.setColor(Color.RED);
			}
			/* If theme chosen is Magenta/Cyan/Orange/Gray */
			else if(game.getThemeChosen() == 1) {
				/* Set color as cyan */
				g2.setColor(Color.CYAN);
			}
			
		}
		/* Otherwise, the colors are the same, but darker */
		else {
			if(game.getThemeChosen() == 0) {
				g2.setColor(Color.RED.darker());
			}
			
			else if(game.getThemeChosen() == 1) {
				g2.setColor(Color.CYAN.darker());
			}
		}
		/* Create a rectangle sized 1/4 of the screen */
		g2.fillRect(450, 0, 450, 450);
		
		/* If the game's attribute activeColor is equal to 3 */
		if (game.activeColor == 3) {
			/* If theme chosen is Green/Red/Blue/Yellow */
			if(game.getThemeChosen() == 0) {
				/* Set color as yellow */
				g2.setColor(Color.YELLOW);
			}
			/* If theme chosen is Magenta/Cyan/Orange/Gray */
			else if(game.getThemeChosen() == 1) {
				/* Set color as orange */
				g2.setColor(Color.ORANGE);
			}
			
		}
		/* Otherwise, the colors are the same, but darker */
		else {
			if(game.getThemeChosen() == 0) {
				g2.setColor(Color.YELLOW.darker());
			}
			
			else if(game.getThemeChosen() == 1) {
				g2.setColor(Color.ORANGE.darker());
			}
		}
		/* Create a rectangle sized 1/4 of the screen */
		g2.fillRect(0, 450, 450, 450);
		
		/* If the game's attribute activeColor is equal to 4 */
		if (game.activeColor == 4) {
			/* If theme chosen is Green/Red/Blue/Yellow */
			if(game.getThemeChosen() == 0) {
				/* Set color as blue */
				g2.setColor(Color.BLUE);
			}
			/* If theme chosen is Magenta/Cyan/Orange/Gray */
			else if(game.getThemeChosen() == 1) {
				/* Set color as gray */
				g2.setColor(Color.GRAY);
			}
			
		}
		/* Otherwise, the colors are the same, but darker */
		else {
			if(game.getThemeChosen() == 0) {
				g2.setColor(Color.BLUE.darker());
			}
			
			else if(game.getThemeChosen() == 1) {
				g2.setColor(Color.GRAY.darker());
			}
		}
		/* Create a rectangle sized 1/4 of the screen */
		g2.fillRect(450, 450, 450, 450);
		
		/* Create a gray border of size 200 to "erase" the overflow rectangle */
		g2.setColor(Color.GRAY);
		g2.setStroke(new BasicStroke(200));
		g2.drawOval(-100, -100, 895 + 200, 830 + 200);
		
		/* Create a black border of size 10 to mark the used circle */
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(10));
		g2.drawOval(0, 0, 895, 830);
		
		/* Create the circle and the rectangles in the middle */
		g2.fillOval(322, 290, 250, 250);
		g2.fillRect(422, 0, 50, 830);
		g2.fillRect(0, 400, 895, 50);
		
		/* Create a string in the middle to show the level of the player */
		g2.setColor(Color.WHITE);
		g2.setFont(new Font("Verdana", Font.BOLD, 23));
		g2.drawString(internationalization.getTranslation(game.getLanguage(), "BestScore") + ": " + game.getBestScore(), 365, 450);
		
		/* If the game ends */
		if(game.getGameOver()) {
			g2.drawString(internationalization.getTranslation(game.getLanguage(), "GameOver").toUpperCase(), 370, 415);
			game.timer.stop();
		}
		/* While game is running */
		else {
			g2.drawString(internationalization.getTranslation(game.getLanguage(), "Level").toUpperCase() + game.getLevel(), 400, 415);
		}
	}
}