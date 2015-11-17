package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import drawing.DrawingPanel;

/* Class that represents the main window of the game */
public class Game extends JFrame {
	/* Game attributes */
	private static final long serialVersionUID = 1L;
	public static Game simonSays;
	
	private JMenuBar menuBar;
	private JMenu gameMenu;
	private JMenu settingsMenu;
	private JMenu difficultyMenu;
	private JMenu themeMenu;
	private JMenu questionMenu;
	private JMenuItem pauseItem;
	private JMenuItem restartItem;
	private JMenuItem stopItem;
	private JMenuItem howToPlayItem;
	private JRadioButtonMenuItem easyItem;
	private JRadioButtonMenuItem mediumItem;
	private JRadioButtonMenuItem hardItem;
	private JRadioButtonMenuItem colorItem;
	private JRadioButtonMenuItem symbolItem;
	private ButtonGroup groupDifficulty;
	private ButtonGroup groupTheme;
	
	private DrawingPanel simonArea = new DrawingPanel();
	
	/* Constants to standardize all fonts */
	public final String FONT_MENU = "Andalus";
	public final String FONT_BODY = "Sylfaen";
	
public static void main(String[] args) {
		
		Game frame = new Game();
		/* Make the window visible */
		frame.setVisible(true);
	}
	
	public Game() {
		/* Create the window - size = 1000x860 and start = (400, 100) */
		setBounds(400, 100, 1000, 860);
		setTitle("Simon Game");
		/* Disable resize */
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(simonArea);
		
		/* Create a menu bar in the top */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		/* Set fonts according to type of component */
		UIManager.put("Menu.font", new Font(FONT_MENU, Font.BOLD, 18));
		UIManager.put("MenuItem.font", new Font(FONT_BODY, Font.PLAIN, 16));
		UIManager.put("RadioButtonMenuItem.font", new Font(FONT_BODY, Font.PLAIN, 16));
		
		/* Create a menu called Game inside the menu bar */
		gameMenu = new JMenu("GAME");
		menuBar.add(gameMenu);
		/* Create a menu item called Pause inside Game menu */
		pauseItem = new JMenuItem("Pause");
		gameMenu.add(pauseItem);
		/* Create a menu item called Restart inside Game menu */
		restartItem = new JMenuItem("Restart");
		gameMenu.add(restartItem);
		/* Create a menu item called Stop inside Game menu */
		stopItem = new JMenuItem("Stop");
		gameMenu.add(stopItem);
		
		/* Create a menu called Settings inside menu bar */
		settingsMenu = new JMenu("SETTINGS");
		menuBar.add(settingsMenu);
		/* Create a menu called Difficulty inside Settings menu */
		difficultyMenu = new JMenu("Difficulty");
		settingsMenu.add(difficultyMenu);
		/* Create a menu item called Easy inside Difficulty sub-menu */
		easyItem = new JRadioButtonMenuItem("Easy");
		difficultyMenu.add(easyItem);
		/* Create a menu item called Medium inside Difficulty sub-menu */
		mediumItem = new JRadioButtonMenuItem("Medium");
		difficultyMenu.add(mediumItem);
		/* Create a menu item called Hard inside Difficulty sub-menu */
		hardItem = new JRadioButtonMenuItem("Hard");
		difficultyMenu.add(hardItem);
		/* Create a menu called Theme inside Settings menu */
		themeMenu = new JMenu("Theme");
		settingsMenu.add(themeMenu);
		/* Create a menu item called Colors inside Theme sub-menu */
		colorItem = new JRadioButtonMenuItem("Colors");
		themeMenu.add(colorItem);
		/* Create a menu item called Symbols inside Theme sub-menu */
		symbolItem = new JRadioButtonMenuItem("Symbols");
		themeMenu.add(symbolItem);
		
		/* Create a button group to allow just one selection in the radio buttons */
		groupDifficulty = new ButtonGroup();
		groupDifficulty.add(easyItem);
		groupDifficulty.add(mediumItem);
		groupDifficulty.add(hardItem);
		
		groupTheme = new ButtonGroup();
		groupTheme.add(colorItem);
		groupTheme.add(symbolItem);
		
		/* Create a menu called ? inside menu bar */
		questionMenu = new JMenu("?");
		menuBar.add(questionMenu);
		/* Create a menu item called How to Play inside ? menu */
		howToPlayItem = new JMenuItem("How to Play");
		questionMenu.add(howToPlayItem);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g);
		
		/* Drawing the main circle */
		g2.fillOval(150, 100, 700, 700);
		/* Drawing the rectangles in the middle */
		g2.setColor(Color.BLACK);
		g2.fillRect(470, 130, 50, 640);
		g2.fillRect(180, 420, 640, 50);
		
		g2.setColor(Color.GREEN);
		g2.fillArc(180, 130, 580, 580, 90, 90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
		
		g2.setColor(Color.RED);
		g2.fillArc(220, 130, 600, 580, 0, 90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
		
		g2.setColor(Color.YELLOW);
		g2.fillArc(180, 170, 580, 600, 180, 90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
		
		g2.setColor(Color.BLUE);
		g2.fillArc(220, 170, 600, 600, 0, -90);
		/* Drawing the circle in the middle */
		g2.setColor(Color.BLACK);
		g2.fillOval(395, 345, 200, 200);
	}
}
