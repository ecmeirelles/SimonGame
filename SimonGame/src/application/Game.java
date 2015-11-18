package application;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
	
	public int activeColor = 0;

	public ArrayList<Integer> gameSequence = new ArrayList<Integer>();
	public ArrayList<Integer> playerSequence = new ArrayList<Integer>();
	
	private DrawingPanel simonArea = new DrawingPanel(this);
	private GameFunction simonFunction = new GameFunction(this);
	
	/* Constants to standardize all fonts */
	public final String FONT_MENU = "Andalus";
	public final String FONT_BODY = "Sylfaen";

	public Game() {
		/* Create the window - size = 1000x860 and start = (400, 100) */
		setBounds(400, 100, 900, 900);
		setTitle("Simon Says");
		/* Disable resize */
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Add an action to every time that the player clicks in some area */
		addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* Attributes to get the position(x, y) the player has clicked */
				int x = e.getX();
				int y = e.getY();
				
				/* If the player clicks in the green area */
				if (x > 0 && x < 450 && y > 0 && y < 450) {
					/* activeColor is set as 1 and this number is add to the playerSequence */
					activeColor = 1;
					playerSequence.add(1);
				}
				
				/* If the player clicks in the red area */
				else if (x > 450 && x < 900 && y > 0 && y < 450) {
					/* activeColor is set as 2 and this number is add to the playerSequence */
					activeColor = 2;
					playerSequence.add(2);
				}
				
				/* If the player clicks in the yellow area */
				else if (x > 0 && x < 450 && y > 450 && y < 900) {
					/* activeColor is set as 3 and this number is add to the playerSequence */
					activeColor = 3;
					playerSequence.add(3);
				}
				
				/* If the player clicks in the blue area */
				else if (x > 450 && x < 900 && y > 450 && y < 900) {
					/* activeColor is set as 4 and this number is add to the playerSequence */
					activeColor = 4;
					playerSequence.add(4);
				}
				
				/* The drawing is repainted to implement the new settings */
				simonArea.repaint();
			}
		});
		
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
		
		/* Adding the DrawingPanel into the frame */
		add(simonArea);
    }
	
	public void playGame() {
		//TODO: Method playGame;
	}
}
