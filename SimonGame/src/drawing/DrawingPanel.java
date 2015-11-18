package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import application.Game;

public class DrawingPanel extends JPanel {
	/* DrawingPanel attributes */
	private static final long serialVersionUID = 1L;
	
	public Game game;
	
	/* Constructor to receive an instance of SimonSays */
	public DrawingPanel(Game simonGame) {
		this.game = simonGame;
	}

	/* Function to draw the game's design */
	@Override
	protected void paintComponent(Graphics g) {
		/* Cast to use Graphics as Graphics2D */
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		
		/* If the game's attribute activeColor is equal to 1, then color is set as green */
		if (game.activeColor == 1) {
			g2.setColor(Color.GREEN);
		}
		/* Otherwise, it is set as green, but darker */
		else {
			g2.setColor(Color.GREEN.darker());
		}
		/* Create a rectangle sized 1/4 of the screen */
		g2.fillRect(0, 0, 450, 450);
		
		/* If the game's attribute activeColor is equal to 2, then color is set as red */
		if (game.activeColor == 2) {
			g2.setColor(Color.RED);
		}
		/* Otherwise, it is set as red, but darker */
		else {
			g2.setColor(Color.RED.darker());
		}
		/* Create a rectangle sized 1/4 of the screen */
		g2.fillRect(450, 0, 450, 450);
		
		/* If the game's attribute activeColor is equal to 3, then color is set as yellow */
		if (game.activeColor == 3) {
			g2.setColor(Color.YELLOW);
		}
		/* Otherwise, it is set as yellow, but darker */
		else {
			g2.setColor(Color.YELLOW.darker());
		}
		/* Create a rectangle sized 1/4 of the screen */
		g2.fillRect(0, 450, 450, 450);
		
		/* If the game's attribute activeColor is equal to 4, then color is set as blue */
		if (game.activeColor == 4) {
			g2.setColor(Color.BLUE);
		}
		/* Otherwise, it is set as blue, but darker */
		else {
			g2.setColor(Color.BLUE.darker());
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
	}
}