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
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillOval(180, 130, 640, 640);
		/* Drawing the rectangles and the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillRect(470, 130, 50, 640);
		g2.fillRect(180, 420, 640, 50);
		g2.fillOval(395, 345, 200, 200);
	}
}
