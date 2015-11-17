package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/* Class that represents the design of the game */
public class Drawing {
	
	/* Function to draw the base */
	public void drawBase(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		/* Drawing the main circle */
		g2.fillOval(150, 100, 700, 700);
		/* Drawing the rectangles in the middle */
		g2.setColor(Color.BLACK);
		g2.fillRect(470, 130, 50, 640);
		g2.fillRect(180, 420, 640, 50);
	}
	
	/* Function to draw the green area */
	public void drawGreenArea(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.GREEN);
		g2.fillArc(180, 130, 580, 580, 90, 90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
	}
	
	/* Function to draw the red area */
	public void drawRedArea(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.RED);
		g2.fillArc(220, 130, 600, 580, 0, 90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
	}
	
	/* Function to draw the yellow area */
	public void drawYellowArea(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.YELLOW);
		g2.fillArc(180, 170, 580, 600, 180, 90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
	}
	
	/* Function to draw the blue area */
	public void drawBlueArea(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLUE);
		g2.fillArc(220, 170, 600, 600, 0, -90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
	}
}
