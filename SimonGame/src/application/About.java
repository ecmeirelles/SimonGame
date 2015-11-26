package application;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/* Class that represents a explanation of the game. It appears when the player clicks in About */
public class About extends JFrame {
	/* About attributes */
	private static final long serialVersionUID = 1L;
	
	private JPanel howToPlayPanel;
	private JPanel historyPanel;
	private JPanel curiositiesPanel;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JLabel howToPlayLabel;
	private JLabel historyLabel;
	private JLabel curiositiesLabel;
	private JTextArea gameDescription;
	private JTextArea gameHistory;
	private JTextArea gameCuriosities;
	
	/* Constants to standardize all fonts */
	public final String FONT_TITLE = "Andalus";
	public final String FONT_BODY = "Sylfaen";

	public About() {
		/* Create the window - size = 500x400 and start = (600, 400) */
		setBounds(600, 400, 500, 400);
		setTitle("Simon | About");
		/* Disable resize */
		setResizable(false);
		
		/* Create a JTabbedPane and add in the frame */
		tabbedPane = new JTabbedPane();
		add(tabbedPane);
		
		/* Create a panel to be the body of one of the tabs */
		howToPlayPanel = new JPanel();
		howToPlayPanel.setLayout(null);
		/* Add panel into JTabbedPane */
		tabbedPane.addTab("HOW TO PLAY", null, howToPlayPanel, null);
		
		howToPlayLabel = new JLabel("How to play");
		howToPlayLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		howToPlayLabel.setBounds(30, 40, 200, 30);
		howToPlayPanel.add(howToPlayLabel);
		
		gameDescription = new JTextArea("The game has four colored buttons, each producing a specific\n"
				                      + "sound when it is pressed or activated by the computer. A round\n"
				                      + "in the game consists of the computer lighting up one or more\n"
				                      + "buttons in a random order, after which the player must reproduce\n"
				                      + "that order by pressing the buttons. As the game progresses, the\n"
				                      + "number of buttons to be pressed increases.");
		gameDescription.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		gameDescription.setBounds(30, 100, 440, 200);
		gameDescription.setEditable(false);
		gameDescription.setBackground(getBackground());
		howToPlayPanel.add(gameDescription);
		
		/* Create a panel to be the body of one of the tabs */
		historyPanel = new JPanel();
		historyPanel.setLayout(null);
		/* Add panel into JTabbedPane */
		tabbedPane.addTab("HISTORY", null, historyPanel, null);
		
		historyLabel = new JLabel("History");
		historyLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		historyLabel.setBounds(30, 40, 200, 30);
		historyPanel.add(historyLabel);
		
		gameHistory = new JTextArea("Simon is an electronic game of memory skill invented by Ralph\n"
				                  + "H.Baer and Howard J. Morrison, with software programming by\n"
				                  + "Lenny Cope. Much of the assembly language was written by Dr.\n"
				                  + "Charles Kapps, who taught computer science in university and\n"
				                  + "also wrote one of the first books on the theory of computer\n"
				                  + "programming. Simon was launched in 1978 at Studio 54 in NYC\n"
				                  + "and was an immediate success, becoming a pop culture symbol\n"
				                  + "of the 1970s and 1980s.");
		gameHistory.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		gameHistory.setBounds(30, 100, 440, 200);
		gameHistory.setEditable(false);
		gameHistory.setBackground(getBackground());
		historyPanel.add(gameHistory);
		
		/* Create a panel to be the body of one of the tabs */
		curiositiesPanel = new JPanel();
		curiositiesPanel.setLayout(null);
		/* Add panel into JTabbedPane */
		tabbedPane.addTab("CURIOSITIES", null, curiositiesPanel, null);
		
		curiositiesLabel = new JLabel("Curiosities");
		curiositiesLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		curiositiesLabel.setBounds(30, 40, 200, 30);
		curiositiesPanel.add(curiositiesLabel);
		
		gameCuriosities = new JTextArea("* In the 1987 Stephen King's novel The Tommyknockers, a\n"
				                      + "  forgotten SIMON game, left in the back seat of a reporters car,\n"
				                      + "  activates itself and, in an ever accelerated color switching,\n"
				                      + "  frenzy overheats and melts its casing, scorching the seat\n"
				                      + "  beneath. The driver, surprised by this, knocks it to the floor\n"
				                      + "  before the whole thing goes up in flames.\n"
				                      + "* Simon appeared on Its Always Sunny In Philadelphia in the\n"
				                      + "  episode A Very Sunny Christmas, during which Mac finds the\n"
				                      + "  game in his closet and Charlie finds the game extremely\n"
				                      + "  difficult.\n"
				                      + "* Simon appeared on an episode of Little Miss Gamer as her\n"
				                      + "  portable gaming system. It caused her to meet Tom Green and\n"
				                      + "  Blackwolf the Dragon Master.\n"
				                      + "* Simon appears in American Dad! episode The One That Got\n"
				                      + "  Away with the family becoming addicted to the game, playing\n"
				                      + "  it for days without moving.\n"
				                      + "* Simon appears in the film CWACOM (2009). Flint, the main\n"
				                      + "  character, has to click the correct sequence on a Simon to\n"
				                      + "  get into his lab.\n"
				                      + "* In a skit on Robot Chicken, Dick Cheneys heart is replaced\n"
				                      + "  with a Simon, in a parody of Iron Man.\n"
				                      + "* There is a Simon game signed by Baer on permanent display at\n"
				                      + "  the American Computer Museum in Bozeman, Montana.\n"
				                      + "* In the 2014 video game South Park: Stick of Truth, you have to\n"
				                      + "  play Simon in order to rescue Randy Marsh from an alien\n"
				                      + "  probe.\n"
				                      + "* The quick time event mechanic in the 2005 video game Indigo\n"
				                      + "  Prophecy was modeled after the toy.");
		gameCuriosities.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		gameCuriosities.setEditable(false);
		gameCuriosities.setBackground(getBackground());
		
		scrollPane = new JScrollPane(gameCuriosities);
		scrollPane.setBounds(30, 100, 440, 200);
		curiositiesPanel.add(scrollPane);
	}
}
