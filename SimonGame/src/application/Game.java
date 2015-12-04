package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;
import javax.swing.UIManager;

import drawing.DrawingPanel;
import functions.BeepFunction;
import functions.DifficultyFunctions;
import functions.GameFunction;

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
	private JMenuItem cleanBestScoreItem;
	private JRadioButtonMenuItem easyItem;
	private JRadioButtonMenuItem mediumItem;
	private JRadioButtonMenuItem hardItem;
	private JRadioButtonMenuItem grbyItem;
	private JRadioButtonMenuItem mcogItem;
	private JRadioButtonMenuItem soundOnItem;
	private JRadioButtonMenuItem soundOffItem;
	private ButtonGroup groupDifficulty;
	private ButtonGroup groupTheme;
	private ButtonGroup groupSound;
	/* What color is brighter */
	public int activeColor = 0;
	private int level = 0;
	public int language;
	private static int bestScore = 0;
	private ArrayList<Integer> gameSequence = new ArrayList<Integer>();
	private boolean gameOver = false;
	
	private BeepFunction beep = new BeepFunction();
	private DrawingPanel simonArea = new DrawingPanel(this);
	private GameFunction simonFunction = new GameFunction(this, simonArea);
	private DifficultyFunctions simonDifficulties = new DifficultyFunctions(this);
	/* ActionListener in GameFunction is executed each 0.03 seconds */
	public Timer timer = new Timer(30, simonFunction);
	
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
					
					/* If sound ON is selected */
					if(soundOnItem.isSelected()) {
						/* Set the specific beep for this color */
						beep.getBeep(activeColor);
					}
				}
				
				/* If the player clicks in the red area */
				else if (x > 450 && x < 900 && y > 0 && y < 450) {
					/* activeColor is set as 2 */
					activeColor = 2;
					
					/* If sound ON is selected */
					if(soundOnItem.isSelected()) {
						/* Set the specific beep for this color */
						beep.getBeep(activeColor);
					}
				}
				
				/* If the player clicks in the yellow area */
				else if (x > 0 && x < 450 && y > 450 && y < 900) {
					/* activeColor is set as 3 */
					activeColor = 3;

					/* If sound ON is selected */
					if(soundOnItem.isSelected()) {
						/* Set the specific beep for this color */
						beep.getBeep(activeColor);
					}
				}
				
				/* If the player clicks in the blue area */
				else if (x > 450 && x < 900 && y > 450 && y < 900) {
					/* activeColor is set as 4 */
					activeColor = 4;

					/* If sound ON is selected */
					if(soundOnItem.isSelected()) {
						/* Set the specific beep for this color */
						beep.getBeep(activeColor);
					}
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
				restartGame();
			}
		});
		gameMenu.add(restartItem);
		/* Create a menu item called Stop inside Game menu */
		stopItem = new JMenuItem("Stop");
		/* Stop the game */
		stopItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int optionPane = JOptionPane.showConfirmDialog(null, "Stop means Game Over. Do you really want that?", "Simon | Stop", JOptionPane.YES_NO_OPTION);
				/* If the players confirms */
				if(optionPane == 0) {
					gameOver = true;
					simonArea.repaint();
				}
			}
		});
		gameMenu.add(stopItem);
		/* Create a menu item called Clean Best Score inside Game menu */
		cleanBestScoreItem = new JMenuItem("Clean Best Score");
		/* Set best score as zero again */
		cleanBestScoreItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int optionPane = JOptionPane.showConfirmDialog(null, "Do you really want to clean your best score?", "Simon | Best Score", JOptionPane.YES_NO_OPTION);
				/* If the players confirms */
				if(optionPane == 0) {
					setBestScore(0);
					simonArea.repaint();
				}
			}
		});
		gameMenu.add(cleanBestScoreItem);
		
		/* Create a menu called Settings inside menu bar */
		settingsMenu = new JMenu("SETTINGS");
		menuBar.add(settingsMenu);
		/* Create a menu called Difficulty inside Settings menu */
		difficultyMenu = new JMenu("Difficulty");
		settingsMenu.add(difficultyMenu);
		/* Create a menu item called Easy inside Difficulty sub-menu */
		easyItem = new JRadioButtonMenuItem("Easy");
		easyItem.addActionListener(simonDifficulties);
		difficultyMenu.add(easyItem);
		/* Create a menu item called Medium inside Difficulty sub-menu */
		mediumItem = new JRadioButtonMenuItem("Medium");
		mediumItem.addActionListener(simonDifficulties);
		difficultyMenu.add(mediumItem);
		/* Create a menu item called Hard inside Difficulty sub-menu */
		hardItem = new JRadioButtonMenuItem("Hard");
		hardItem.addActionListener(simonDifficulties);
		difficultyMenu.add(hardItem);
		/* Create a menu called Theme inside Settings menu */
		themeMenu = new JMenu("Theme");
		settingsMenu.add(themeMenu);
		/* Create a menu item called Green/Red/Blue/Yellow inside Theme sub-menu */
		grbyItem = new JRadioButtonMenuItem("Green/Red/Blue/Yellow");
		themeMenu.add(grbyItem);
		/* Create a menu item called Magenta/Cyan/Orange/Gray inside Theme sub-menu */
		mcogItem = new JRadioButtonMenuItem("Magenta/Cyan/Orange/Gray");
		themeMenu.add(mcogItem);
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
		groupTheme.add(grbyItem);
		groupTheme.add(mcogItem);
		
		groupSound = new ButtonGroup();
		groupSound.add(soundOnItem);
		groupSound.add(soundOffItem);
		
		/* Create a menu called ? inside menu bar */
		questionMenu = new JMenu("?");
		menuBar.add(questionMenu);
		/* Create a menu item called How to Play inside ? menu */
		aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new About(Game.this).setVisible(true);
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
	
	/* Get and Set methods to access and modify, respectively, the bestScore attribute.
	 * In this case, I/O from file has been used to do this. */
	public int getBestScore() {
		/* Initialize readers with null */
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			/* Read from bestScore.dat file. 
			 * This format was chosen because in this way the player cannot modify the content */
			fileReader = new FileReader("bestScore.dat");
			bufferedReader = new BufferedReader(fileReader);
			
			/* bestScore is equal to the number read from the file */
			bestScore = Integer.parseInt(bufferedReader.readLine());
			
		}
		
		catch(IOException ex){
			  ex.printStackTrace();
		}
		
		return bestScore;
	}
	
	public void setBestScore(int bestScore) {
		/* Initialize writers with null */
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			/* Write in bestScore.dat file. 
			 * This format was chosen because in this way the player cannot modify the content */
			fileWriter = new FileWriter("bestScore.dat");
			bufferedWriter = new BufferedWriter(fileWriter);
			
			/* Update bestScore writing the new number in the file */
			bufferedWriter.write(Integer.toString(bestScore));
			/* It flushes the output stream and forces any buffered output bytes to be written out */
			bufferedWriter.flush();  
		}
		
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	/* Get and Set methods to access and modify, respectively, the attribute level */
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	/* Get method to access all the difficulty menu elements */
	public JMenu getDifficultyMenu() {
		return difficultyMenu;
	}
	
	public JRadioButtonMenuItem getEasyDifficulty() {
		return easyItem;
	}
	
	public JRadioButtonMenuItem getMediumDifficulty() {
		return mediumItem;
	}
	
	public JRadioButtonMenuItem getHardDifficulty() {
		return hardItem;
	}
	
	/* Get methods to access sounds menu elements */
	public JMenu getSoundMenu() {
		return soundMenu;
	}
	
	public JMenuItem getSoundOn() {
		return soundOnItem;
	}
	
	public JMenuItem getSoundOff() {
		return soundOffItem;
	}
	
	/* Get methods to access theme menu elements */
	public JMenu getThemeMenu() {
		return themeMenu;
	}
	
	public JRadioButtonMenuItem getGrbyItem() {
		return grbyItem;
	}
	
	public JRadioButtonMenuItem getMcogItem() {
		return mcogItem;
	}
	
	/* Get methods to access general menu items */
	public JMenu getGameMenu() {
		return gameMenu;
	}
	
	public JMenuItem getAboutItem() {
		return aboutItem;
	}
	
	public JMenu getSettingsMenu() {
		return settingsMenu;
	}
	
	/* Get methods to access game menu items */
	public JMenuItem getRestartItem() {
		return restartItem;
	}
	
	public JMenuItem getStopItem() {
		return stopItem;
	}
	
	public JMenuItem getCleanBestScoreItem() {
		return cleanBestScoreItem;
	}
	
	/* Get method to access themeChosen */
	public int getThemeChosen() {
		int theme = 0;
		
		if(grbyItem.isSelected()) {
			theme = 0;
		}
		
		else if(mcogItem.isSelected()) {
			theme = 1;
		}
		
		return theme;
	}
	
	/* Method to restart the game */
	public void restartGame() {
		/* Everything goes back to first settings */
		gameSequence.clear();
		gameOver = false;
		level = 0;
		simonFunction.setMovements(0);
		simonFunction.setTick(0);
		simonFunction.setDelay(2);
		simonFunction.setGameOn(true);
		timer.restart();
	}
	
	/* Methods to receive information from welcome page */
	public void setThemeChosen(int themeChosen) {
		/* If theme selected was colors */
		if(themeChosen == 0) {
			grbyItem.setSelected(true);
		}
		/* If theme selected was symbols */
		else if(themeChosen == 1) {
			mcogItem.setSelected(true);
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
			/* Change timer to 0.02 seconds */
			timer.setDelay(20);
			/* Restart timer */
			timer.restart();
		}
		/* If difficulty selected was hard */
		else if(difficultyChosen == 2) {
			hardItem.setSelected(true);
			/* Change timer to 0.01 seconds */
			timer.setDelay(10);
			/* Restart timer */
			timer.restart();
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
	
	/* Method to Get and Set the language chosen */
	public int getLanguage() {
		return language;
	}
	
	public void setLanguage(int index) {
		this.language = index;
	}
}
