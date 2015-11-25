package application;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/* Class that represents a explanation of the game. It appears when the player clicks in About */
public class About extends JFrame {
	/* About attributes */
	private static final long serialVersionUID = 1L;
	
	private JPanel howToPlayPanel;
	private JPanel historyPanel;
	private JPanel curiositiesPanel;
	private JTabbedPane tabbedPane;

	public About() {
		/* Create the window - size = 500x400 and start = (600, 400) */
		setBounds(600, 400, 500, 400);
		setTitle("About Simon");
		/* Disable resize */
		setResizable(false);
		
		/* Create a JTabbedPane and add in the frame */
		tabbedPane = new JTabbedPane();
		add(tabbedPane);
		
		/* Create a panel to be the body of one of the tabs */
		howToPlayPanel = new JPanel();
		/* Add panel into JTabbedPane */
		tabbedPane.addTab("HOW TO PLAY", null, howToPlayPanel, null);
		
		/* Create a panel to be the body of one of the tabs */
		historyPanel = new JPanel();
		/* Add panel into JTabbedPane */
		tabbedPane.addTab("HISTORY", null, historyPanel, null);
		
		/* Create a panel to be the body of one of the tabs */
		curiositiesPanel = new JPanel();
		/* Add panel into JTabbedPane */
		tabbedPane.addTab("CURIOSITIES", null, curiositiesPanel, null);
	}
}
