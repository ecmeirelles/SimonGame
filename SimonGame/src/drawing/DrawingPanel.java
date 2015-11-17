package drawing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import application.Game;

public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		
		if (Game.simonSays != null) {
			Game.simonSays.paint(g2);
		}
	}
}
