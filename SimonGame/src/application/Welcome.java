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
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/* Class that represents the first window of the game, where all settings are chosen */
public class Welcome extends JFrame {
	/* Welcome attributes */
	private static final long serialVersionUID = 1L;
	
	private JLabel gameTitle;
	private JLabel gameIcon;
	private JLabel gameDescription;
	private JLabel gameDifficultyLabel;
	private JLabel gameThemeLabel;
	private JComboBox<String> themeComboBox;
	private JSlider difficultySlider;
	/* Component to add labels into the JSlider */
	private Hashtable<Integer, JLabel> difficulties;
	private JLabel soundLabel;
	private JRadioButton soundOn;
	private JRadioButton soundOff;
	private ButtonGroup soundGroup;
	private JButton startButton;
	
	private String themes[] = {"Colors", "Symbols"};
	private int themeChosen;
	private int difficultyChosen;
	private int soundChosen;
	
	/* Constants to standardize all fonts */
	public final String FONT_MENU = "Andalus";
	public final String FONT_BODY = "Sylfaen";

	public Welcome() {
		/* Create the window - size = 900x900 and start = (400, 100) */
		setBounds(400, 100, 900, 900);
		setTitle("Simon Says");
		/* Disable resize */
		setResizable(false);
		/* Set layout as null means set it as AbsolutLayout */
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Create an icon and add it in the frame */
		gameIcon = new JLabel("");
		/* Location of the image */
		gameIcon.setIcon(new ImageIcon("src\\kidsPlaying.png"));
		/* When layout is set as null, it is needed to specify the exact position of the component */
		gameIcon.setBounds(0, 90, 900, 92);
		/* Component being horizontally centralized */
		gameIcon.setHorizontalAlignment(SwingConstants.CENTER);
		add(gameIcon);
		
		/* Create a label (Simon) and add it in the frame */
		gameTitle = new JLabel("SIMON");
		/* Insert an specific font to the component */
		gameTitle.setFont(new Font(FONT_MENU, Font.BOLD, 30));
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
		
		/* Create a label (Theme) and add it in the frame */
		gameThemeLabel = new JLabel("THEME:");
		gameThemeLabel.setFont(new Font(FONT_MENU, Font.BOLD, 18));
		gameThemeLabel.setForeground(Color.BLUE);
		gameThemeLabel.setBounds(270, 400, 100, 30);
		add(gameThemeLabel);
		
		/* Create a combo box of strings (with the themes) and add it in the frame */
		themeComboBox = new JComboBox<String>(themes);
		themeComboBox.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		themeComboBox.setBounds(400, 400, 200, 30);
		add(themeComboBox);
		
		/* Create a label (Difficulty) and add it in the frame */
		gameDifficultyLabel = new JLabel("DIFFICULTY:");
		gameDifficultyLabel.setFont(new Font(FONT_MENU, Font.BOLD, 18));
		gameDifficultyLabel.setForeground(Color.BLUE);
		gameDifficultyLabel.setBounds(270, 500, 150, 30);
		add(gameDifficultyLabel);
		
		/* Create an horizontal slider, starting in 10 and ending in 30, and add it in the frame */
		difficultySlider = new JSlider(JSlider.HORIZONTAL, 10, 30, 10);
		/* Show the little ticks above the slider */
		difficultySlider.setMajorTickSpacing(10);
		difficultySlider.setPaintTicks(true);
		difficultySlider.setFont(new Font(FONT_BODY, Font.BOLD, 18));
		difficultySlider.setBounds(400, 500, 200, 50);
		add(difficultySlider);
		
		/* Create labels (Easy, Medium and Hard) and add it in the JSlider */
		difficulties = new Hashtable<Integer, JLabel>();
		difficulties.put(new Integer(10), new JLabel("Easy"));
		difficulties.put(new Integer(20), new JLabel("Medium"));
		difficulties.put(new Integer(30), new JLabel("Hard"));
		/* Allow the slider to show the labels */
		difficultySlider.setLabelTable(difficulties);
		difficultySlider.setPaintLabels(true);
		
		/* Create a label (Sound) and add it in the frame */
		soundLabel = new JLabel("SOUND:");
		soundLabel.setFont(new Font(FONT_MENU, Font.BOLD, 18));
		soundLabel.setForeground(Color.BLUE);
		soundLabel.setBounds(270, 600, 100, 30);
		add(soundLabel);
		
		/* Create a radio button (On) and add it in the frame */
		soundOn = new JRadioButton("On");
		soundOn.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		soundOn.setBounds(400, 600, 100, 30);
		/* It is true by default */
		soundOn.setSelected(true);
		add(soundOn);
		
		/* Create a radio button (Off) and add it in the frame */
		soundOff = new JRadioButton("Off");
		soundOff.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		soundOff.setBounds(530, 600, 100, 30);
		add(soundOff);
		
		/* Allow just one radio button to be selected at a time */
		soundGroup = new ButtonGroup();
		soundGroup.add(soundOn);
		soundGroup.add(soundOff);
		
		/* Create a button (Start) and add it in the frame */
		startButton = new JButton("START");
		startButton.setFont(new Font(FONT_BODY, Font.BOLD, 16));
		startButton.setBounds(400, 720, 100, 30);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Change to Game frame */
				Welcome.this.setVisible(false);
				new Game().setVisible(true);
				
				/* If color is selected, themeChosen is zero */
				if(themeComboBox.getSelectedIndex() == 0) {
					themeChosen = 0;
				}
				/* If symbol is selected, themeChosen is one */
				else if(themeComboBox.getSelectedIndex() == 1){
					themeChosen = 1;
				}
				
				/* If slider is between 10 and 15, it means that difficulty will be easy and difficultChosen is zero */
				if(difficultySlider.getExtent() >= 10 && difficultySlider.getExtent() < 15) {
					difficultyChosen = 0;
				} 
				/* If slider is between 15 and 25, it means that difficulty will be medium and difficultChosen is one */
				else if(difficultySlider.getExtent() >= 15 && difficultySlider.getExtent() < 25) {
					difficultyChosen = 1;
				} 
				/* If slider is between 25 and 30, it means that difficulty will be hard and difficultChosen is two */
				else if(difficultySlider.getExtent() >= 25 && difficultySlider.getExtent() < 30) {
					difficultyChosen = 2;
				}
				
				/* If on is selected, soundChosen is zero */
				if(soundOn.isSelected()) {
					soundChosen = 0;
				} 
				/* If off is selected, soundChosen is one */
				else if(soundOff.isSelected()) {
					soundChosen = 1;
				}
			}
		});
		add(startButton);
    }
	
	/* Getters and setters to access and modify, respectively, the attributes themeChosen, difficultyChosen and SoundChosen */
	public int getThemeChosen() {
		return themeChosen;
	}
	
	public void setThemeChosen(int themeChosen) {
		this.themeChosen = themeChosen;
	}
	
	public int getDifficultyChosen() {
		return difficultyChosen;
	}
	
	public void setDifficultyChosen(int difficultyChosen) {
		this.difficultyChosen = difficultyChosen;
	}
	
	public int getSoundChosen() {
		return soundChosen;
	}
	
	public void setSoundChosen(int soundChosen) {
		this.soundChosen = soundChosen;
	}
}

