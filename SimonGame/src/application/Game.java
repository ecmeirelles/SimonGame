package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;
import javax.swing.UIManager;

import drawing.DrawingPanel;

/* Class that represents the main window of the game, where the game is played */
public class Game extends JFrame {
	/* Game attributes */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu gameMenu;
	private JMenu settingsMenu;
	private JMenu difficultyMenu;
	private JMenu themeMenu;
	private JMenu soundMenu;
	private JMenu questionMenu;
	private JMenuItem restartItem;
	private JMenuItem stopItem;
	private JMenuItem aboutItem;
	private JRadioButtonMenuItem easyItem;
	private JRadioButtonMenuItem mediumItem;
	private JRadioButtonMenuItem hardItem;
	private JRadioButtonMenuItem colorItem;
	private JRadioButtonMenuItem symbolItem;
	private JRadioButtonMenuItem soundOnItem;
	private JRadioButtonMenuItem soundOffItem;
	private ButtonGroup groupDifficulty;
	private ButtonGroup groupTheme;
	/* What color is brighter */
	public int activeColor = 0;
	private ArrayList<Integer> gameSequence = new ArrayList<Integer>();
	private boolean gameOver = false;
	
	private DrawingPanel simonArea = new DrawingPanel(this);
	private GameFunction simonFunction = new GameFunction(this, simonArea);
	/* ActionListener in GameFunction is executed each 0.02 seconds */
	public Timer timer = new Timer(20, simonFunction);
	public Welcome welcome;
	
	/* Constants to standardize all fonts */
	public final String FONT_MENU = "Andalus";
	public final String FONT_BODY = "Sylfaen";

	public Game() {
		/* Create the window - size = 900x900 and start = (400, 100) */
		setBounds(400, 100, 900, 900);
		setTitle("Simon | Play");
		/* Disable resize */
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Start asking for the ActionListener */
		timer.start();
		
		/* Add an action to every time that the player clicks in some area */
		addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* Attributes to get the position(x, y) the player has clicked */
				int x = e.getX();
				int y = e.getY();
				
				/* If the player clicks in the green area */
				if (x > 0 && x < 450 && y > 0 && y < 450) {
					/* activeColor is set as 1 */
					activeColor = 1;
				}
				
				/* If the player clicks in the red area */
				else if (x > 450 && x < 900 && y > 0 && y < 450) {
					/* activeColor is set as 2 */
					activeColor = 2;
				}
				
				/* If the player clicks in the yellow area */
				else if (x > 0 && x < 450 && y > 450 && y < 900) {
					/* activeColor is set as 3 */
					activeColor = 3;
				}
				
				/* If the player clicks in the blue area */
				else if (x > 450 && x < 900 && y > 450 && y < 900) {
					/* activeColor is set as 4 */
					activeColor = 4;
				}
				
				/* Every time the player clicks in a colorful area */
				if (activeColor != 0) {
					/* It compares if the area clicked is the same that one in the game sequence */
					if (gameSequence.get(simonFunction.getMovements()) == activeColor) {
						/* If so, increases the movement to compare the next one (if applicable) */
						simonFunction.setMovements(simonFunction.getMovements()+1);
					}
					/* Otherwise, the game ends */
					else {
						gameOver = true;
					}
				}
			} /* end of mouseClicked */
		}); /* end of mouseListener */
		
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
		
		/* Create a menu item called Restart inside Game menu */
		restartItem = new JMenuItem("Restart");
		/* Restart the game */
		restartItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Everything goes back to first settings */
				gameSequence.clear();
				gameOver = false;
				simonFunction.setMovements(0);
				simonFunction.setTick(0);
				simonFunction.setDelay(2);
				simonFunction.setGameOn(true);
				timer.restart();
			}
		});
		gameMenu.add(restartItem);
		/* Create a menu item called Stop inside Game menu */
		stopItem = new JMenuItem("Stop");
		/* Stop the game */
		stopItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameOver = true;
				simonArea.repaint();
			}
		});
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
		/* Create a menu called Sound inside Settings menu */
		soundMenu = new JMenu("Sound");
		settingsMenu.add(soundMenu);
		/* Create a menu item called On inside Sound sub-menu */
		soundOnItem = new JRadioButtonMenuItem("On");
		soundMenu.add(soundOnItem);
		/* Create a menu item called Off inside Sound sub-menu */
		soundOffItem = new JRadioButtonMenuItem("Off");
		soundMenu.add(soundOffItem);
		
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
		aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new About().setVisible(true);
			}
		});
		questionMenu.add(aboutItem);
		
		/* Adding the DrawingPanel into the frame */
		add(simonArea);
    }

	/* Get and Set methods to access and modify, respectively, the gameOver attribute */
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	/* Get method to access the gameSequence attribute */
	public ArrayList<Integer> getGameSequence() {
		return gameSequence;
	}
	
	/* Methods to receive information from welcome page */
	public void setThemeChosen(int themeChosen) {
		/* If theme selected was colors */
		if(themeChosen == 0) {
			colorItem.setSelected(true);
		}
		/* If theme selected was symbols */
		else if(themeChosen == 1) {
			symbolItem.setSelected(true);
		}
	}
	
	public void setDifficultyChosen(int difficultyChosen) {
		/* If difficulty selected was easy */
		if(difficultyChosen == 0) {
			easyItem.setSelected(true);
		}
		/* If difficulty selected was medium */
		else if(difficultyChosen == 1) {
			mediumItem.setSelected(true);
		}
		/* If difficulty selected was hard */
		else if(difficultyChosen == 2) {
			hardItem.setSelected(true);
		}
	}
	
	public void setSoundChosen(int soundChosen) {
		/* If sound selected was on */
		if(soundChosen == 0) {
			soundOnItem.setSelected(true);
		}
		/* If sound selected was off */
		else if(soundChosen == 1) {
			soundOffItem.setSelected(true);
		}
	}
}
