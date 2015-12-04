package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import internationalization.Internationalization;

/* Class that represents the first window of the game, where all settings are chosen */
public class Welcome extends JFrame {
	/* Welcome attributes */
	private static final long serialVersionUID = 1L;
	
	private JLabel gameTitle;
	private JLabel gameIcon;
	private JLabel gameDescription;
	private JLabel gameDifficultyLabel;
	private JLabel gameThemeLabel;
	private JLabel gameLanguage;
	private JLabel easyLabel;
	private JLabel mediumLabel;
	private JLabel hardLabel;
	private JComboBox<String> themeComboBox;
	private JSlider difficultySlider;
	/* Component to add labels into the JSlider */
	private Hashtable<Integer, JLabel> difficulties;
	private JLabel soundLabel;
	private JRadioButton soundOn;
	private JRadioButton soundOff;
	private ButtonGroup soundGroup;
	private JButton startButton;
	private JList<String> languageList;
	
	private String themes[] = {"Green/Red/Blue/Yellow", "Magenta/Cyan/Orange/Gray"};
	private String languages[] = {"English", "Português"};
	private int themeChosen;
	private int difficultyChosen;
	private int soundChosen;
	
	private Internationalization internationalization = new Internationalization();
	
	/* Constants to standardize all fonts */
	public final String FONT_TITLE = "Andalus";
	public final String FONT_BODY = "Sylfaen";

	public Welcome() {
		/* Create the window - size = 900x900 and start = (400, 100) */
		setBounds(400, 100, 900, 900);
		setTitle("Simon | Settings");
		/* Disable resize */
		setResizable(false);
		/* Set layout as null means set it as AbsolutLayout */
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Create an icon and add it in the frame */
		gameIcon = new JLabel("");
		/* Location of the image */
		gameIcon.setIcon(new ImageIcon("src\\resources\\kidsPlaying.png"));
		/* When layout is set as null, it is needed to specify the exact position of the component */
		gameIcon.setBounds(0, 90, 900, 92);
		/* Component being horizontally centralized */
		gameIcon.setHorizontalAlignment(SwingConstants.CENTER);
		add(gameIcon);
		
		/* Create a label (Simon) and add it in the frame */
		gameTitle = new JLabel("SIMON");
		/* Insert an specific font to the component */
		gameTitle.setFont(new Font(FONT_TITLE, Font.BOLD, 30));
		/* Insert an specific font color to the component */
		gameTitle.setForeground(Color.ORANGE);
		gameTitle.setBounds(0, 215, 900, 30);
		gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(gameTitle);
	
		/* Create a label (Customize your own game) and add it in the frame */
		gameDescription = new JLabel("Customize your own game:");
		gameDescription.setFont(new Font(FONT_BODY, Font.BOLD, 20));
		gameDescription.setBounds(50, 300, 400, 30);
		add(gameDescription);
		
		/* Create a label (Language) and add it in the frame */
		gameLanguage = new JLabel("LANGUAGE:");
		gameLanguage.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		gameLanguage.setForeground(Color.BLUE);
		gameLanguage.setBounds(270, 400, 200, 30);
		add(gameLanguage);
		
		/* Create a list of strings (with the languages) and add it in the frame */
		languageList = new JList<String>(languages);
		languageList.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		languageList.setBounds(420, 400, 250, 60);
		languageList.setBackground(getBackground());
		languageList.setSelectedIndex(0);
		languageList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				/* ---------------------------------------------- WELCOME ------------------------------------------------------*/
				/* Translate the frame's title using the getTranslation method */
				setTitle("Simon | " + internationalization.getTranslation(languageList.getSelectedIndex(), "Settings"));
				
				/* Translate the gameDescription text using the getTranslation method, word by word */
				gameDescription.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Customize") + " " + 
						internationalization.getTranslation(languageList.getSelectedIndex(), "your") + " " +
				        internationalization.getTranslation(languageList.getSelectedIndex(), "own") + " " + 
						internationalization.getTranslation(languageList.getSelectedIndex(), "game") + ":");
				/* Translate the gameLanguage text using the getTranslation method */
				gameLanguage.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "LANGUAGE") + ":");
				/* Translate the gameThemeLabel text using the getTranslation method */
				gameThemeLabel.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "THEME") + ":");
				/* Translate the difficultyLabel text using the getTranslation method */
				gameDifficultyLabel.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "DIFFICULTY") + ":");
				
				/* To translate the lableTabel, first of all it is needed to set paintLabels as false */
				difficultySlider.setPaintLabels(false);
				/* Translate the difficulties texts using the getTranslation method */
				easyLabel.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Easy"));
				mediumLabel.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Medium"));
				hardLabel.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Hard"));
				/* Add it to the HashTable and add it to the labelTable */
				difficulties.put(new Integer(10), easyLabel);
				difficulties.put(new Integer(20), mediumLabel);
				difficulties.put(new Integer(30), hardLabel);
				difficultySlider.setLabelTable(difficulties);
				/* Finally, set paintLabels as true again */
				difficultySlider.setPaintLabels(true);
				
				/* Translate the soundLabel text using the getTranslation method */
				soundLabel.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "SOUND") + ":");
				/* Translate soundOn and soundOff texts using the getTranslation method */
				soundOn.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "On"));
				soundOff.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Off"));
				
				/* To translate the themeComboBox elements, first of all it is needed to set remove them */
				themeComboBox.removeAllItems();
				/* And translate the elements text using the getTranslation method */
				themeComboBox.addItem(internationalization.getTranslation(languageList.getSelectedIndex(), "Green/Red/Blue/Yellow"));
				themeComboBox.addItem(internationalization.getTranslation(languageList.getSelectedIndex(), "Magenta/Cyan/Orange/Gray"));	
				
				/* Translate the startButton text using the getTranslation method */
				startButton.setText(internationalization.getTranslation(languageList.getSelectedIndex(), "START"));
			}
		});
		add(languageList);
		
		/* Create a label (Theme) and add it in the frame */
		gameThemeLabel = new JLabel("THEME:");
		gameThemeLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		gameThemeLabel.setForeground(Color.BLUE);
		gameThemeLabel.setBounds(270, 500, 100, 30);
		add(gameThemeLabel);
		
		/* Create a combo box of strings (with the themes) and add it in the frame */
		themeComboBox = new JComboBox<String>(themes);
		themeComboBox.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		themeComboBox.setBounds(420, 500, 250, 30);
		add(themeComboBox);
		
		/* Create a label (Difficulty) and add it in the frame */
		gameDifficultyLabel = new JLabel("DIFFICULTY:");
		gameDifficultyLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		gameDifficultyLabel.setForeground(Color.BLUE);
		gameDifficultyLabel.setBounds(270, 600, 150, 30);
		add(gameDifficultyLabel);
		
		/* Create an horizontal slider, starting in 10 and ending in 30, and add it in the frame */
		difficultySlider = new JSlider(JSlider.HORIZONTAL, 10, 30, 10);
		/* Show the little ticks above the slider */
		difficultySlider.setMajorTickSpacing(10);
		difficultySlider.setPaintTicks(true);
		difficultySlider.setFont(new Font(FONT_BODY, Font.BOLD, 18));
		difficultySlider.setBounds(420, 600, 250, 50);
		add(difficultySlider);
		
		/* Create labels (Easy, Medium and Hard) and add it in the JSlider */
		easyLabel = new JLabel("Easy");
		mediumLabel = new JLabel("Medium");
		hardLabel = new JLabel("Hard");
		
		difficulties = new Hashtable<Integer, JLabel>();
		difficulties.put(new Integer(10), easyLabel);
		difficulties.put(new Integer(20), mediumLabel);
		difficulties.put(new Integer(30), hardLabel);
		/* Allow the slider to show the labels */
		difficultySlider.setLabelTable(difficulties);
		difficultySlider.setPaintLabels(true);
		
		/* Create a label (Sound) and add it in the frame */
		soundLabel = new JLabel("SOUND:");
		soundLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		soundLabel.setForeground(Color.BLUE);
		soundLabel.setBounds(270, 700, 100, 30);
		add(soundLabel);
		
		/* Create a radio button (On) and add it in the frame */
		soundOn = new JRadioButton("On");
		soundOn.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		soundOn.setBounds(445, 700, 100, 30);
		/* It is true by default */
		soundOn.setSelected(true);
		add(soundOn);
		
		/* Create a radio button (Off) and add it in the frame */
		soundOff = new JRadioButton("Off");
		soundOff.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		soundOff.setBounds(555, 700, 100, 30);
		add(soundOff);
		
		/* Allow just one radio button to be selected at a time */
		soundGroup = new ButtonGroup();
		soundGroup.add(soundOn);
		soundGroup.add(soundOff);
		
		/* Create a button (Start) and add it in the frame */
		startButton = new JButton("START");
		startButton.setFont(new Font(FONT_BODY, Font.BOLD, 16));
		startButton.setBounds(380, 780, 200, 30);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Change to Game frame */
				Welcome.this.setVisible(false);
				Game gameFrame = new Game();
				
				/* If Green/Red/Blue/Yellow is selected, themeChosen is zero */
				if(themeComboBox.getSelectedIndex() == 0) {
					themeChosen = 0;
					gameFrame.setThemeChosen(themeChosen);
				}
				/* If Magenta/Cyan/Orange/Gray is selected, themeChosen is one */
				else if(themeComboBox.getSelectedIndex() == 1){
					themeChosen = 1;
					gameFrame.setThemeChosen(themeChosen);
				}
				
				/* If slider is between 10 and 15, it means that difficulty will be easy and difficultChosen is zero */
				if(difficultySlider.getValue() >= 10 && difficultySlider.getValue() < 15) {
					difficultyChosen = 0;
					gameFrame.setDifficultyChosen(difficultyChosen);
				} 
				/* If slider is between 15 and 25, it means that difficulty will be medium and difficultChosen is one */
				else if(difficultySlider.getValue() >= 15 && difficultySlider.getValue() < 25) {
					difficultyChosen = 1;
					gameFrame.setDifficultyChosen(difficultyChosen);
				} 
				/* If slider is between 25 and 30, it means that difficulty will be hard and difficultChosen is two */
				else if(difficultySlider.getValue() >= 25 && difficultySlider.getValue() <= 30) {
					difficultyChosen = 2;
					gameFrame.setDifficultyChosen(difficultyChosen);
				}
				
				/* If on is selected, soundChosen is zero */
				if(soundOn.isSelected()) {
					soundChosen = 0;
					gameFrame.setSoundChosen(soundChosen);
				} 
				/* If off is selected, soundChosen is one */
				else if(soundOff.isSelected()) {
					soundChosen = 1;
					gameFrame.setSoundChosen(soundChosen);
				}
				
				/* ---------------------------------------- INTERNATIONALIZATION ----------------------------------------------*/
				/* ----------------------------------------------- GAME -------------------------------------------------------*/
				/* Translate the frame's title using getTranslation method */
				gameFrame.setTitle("Simon | " + internationalization.getTranslation(languageList.getSelectedIndex(), "Play"));
				/* Translate the game menu texts using the getTranslation method */
				gameFrame.getGameMenu().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "GAME"));
				gameFrame.getStopItem().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Stop"));
				gameFrame.getRestartItem().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Restart"));
				gameFrame.getCleanBestScoreItem().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Clean") + " " +
						internationalization.getTranslation(languageList.getSelectedIndex(), "best") + " " +
						internationalization.getTranslation(languageList.getSelectedIndex(), "score"));
				/* Translate the settings menu texts using the getTranslation method */
				gameFrame.getSettingsMenu().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "SETTINGS"));
				/* Translate the difficulties texts using the getTranslation method */
				gameFrame.getDifficultyMenu().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Difficulty"));
				gameFrame.getEasyDifficulty().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Easy"));
				gameFrame.getMediumDifficulty().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Medium"));
				gameFrame.getHardDifficulty().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Hard"));
				/* Translate the sounds texts using the getTranslation method */
				gameFrame.getSoundMenu().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Sound"));
				gameFrame.getSoundOn().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "On"));
				gameFrame.getSoundOff().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Off"));
				/* Translate the themes texts using the getTranslation method */
				gameFrame.getThemeMenu().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Theme"));
				gameFrame.getGrbyItem().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Green/Red/Blue/Yellow"));
				gameFrame.getMcogItem().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "Magenta/Cyan/Orange/Gray"));
				/* Translate the ? menu texts using the getTranslation method */
				gameFrame.getAboutItem().setText(internationalization.getTranslation(languageList.getSelectedIndex(), "About"));
				
				gameFrame.setLanguage(languageList.getSelectedIndex());
				gameFrame.setVisible(true);
			}
		});
		add(startButton);
    }
}

