package application;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import internationalization.Internationalization;

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
	
	private String howToPlayText = "";
	private String historyText = "";
	private String curiositiesText = "";
	
	private Game game;
	private Internationalization internationalization = new Internationalization();
	
	/* Constants to standardize all fonts */
	public final String FONT_TITLE = "Andalus";
	public final String FONT_BODY = "Sylfaen";

	public About(Game gameFrame) {
		this.game = gameFrame;
				
		/* Create the window - size = 500x400 and start = (600, 400) */
		setBounds(600, 400, 500, 400);
		setTitle("Simon | " + internationalization.getTranslation(game.getLanguage(), "About"));
		/* Disable resize */
		setResizable(false);
		
		/* Create a JTabbedPane and add in the frame */
		tabbedPane = new JTabbedPane();
		add(tabbedPane);
		
		/* Create a panel to be the body of one of the tabs */
		howToPlayPanel = new JPanel();
		howToPlayPanel.setLayout(null);
		/* Add panel, using internationalization into JTabbedPane */
		tabbedPane.addTab(internationalization.getTranslation(game.getLanguage(), "HOW") + " " +
				internationalization.getTranslation(game.getLanguage(), "TO") + " " +
				internationalization.getTranslation(game.getLanguage(), "PLAY"), null, howToPlayPanel, null);
		
		howToPlayLabel = new JLabel(internationalization.getTranslation(game.getLanguage(), "How") + " " +
				internationalization.getTranslation(game.getLanguage(), "to") + " " +
				internationalization.getTranslation(game.getLanguage(), "play"));
		howToPlayLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		howToPlayLabel.setBounds(30, 40, 200, 30);
		howToPlayPanel.add(howToPlayLabel);
		
		gameDescription = new JTextArea(readHowToPlay());
		gameDescription.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		gameDescription.setBounds(30, 100, 440, 200);
		gameDescription.setEditable(false);
		gameDescription.setBackground(getBackground());
		howToPlayPanel.add(gameDescription);
		
		/* Create a panel to be the body of one of the tabs */
		historyPanel = new JPanel();
		historyPanel.setLayout(null);
		/* Add panel, using internationalization, into JTabbedPane */
		tabbedPane.addTab(internationalization.getTranslation(game.getLanguage(), "HISTORY"), null, historyPanel, null);
		
		historyLabel = new JLabel(internationalization.getTranslation(game.getLanguage(), "History"));
		historyLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		historyLabel.setBounds(30, 40, 200, 30);
		historyPanel.add(historyLabel);
		
		gameHistory = new JTextArea(readHistory());
		gameHistory.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		gameHistory.setBounds(30, 100, 440, 200);
		gameHistory.setEditable(false);
		gameHistory.setBackground(getBackground());
		historyPanel.add(gameHistory);
		
		/* Create a panel to be the body of one of the tabs */
		curiositiesPanel = new JPanel();
		curiositiesPanel.setLayout(null);
		/* Add panel, using internationalization into JTabbedPane */
		tabbedPane.addTab(internationalization.getTranslation(game.getLanguage(), "CURIOSITIES"), null, curiositiesPanel, null);
		
		curiositiesLabel = new JLabel(internationalization.getTranslation(game.getLanguage(), "Curiosities"));
		curiositiesLabel.setFont(new Font(FONT_TITLE, Font.BOLD, 18));
		curiositiesLabel.setBounds(30, 40, 200, 30);
		curiositiesPanel.add(curiositiesLabel);
		
		gameCuriosities = new JTextArea(readCuriosities());
		gameCuriosities.setFont(new Font(FONT_BODY, Font.PLAIN, 16));
		gameCuriosities.setEditable(false);
		gameCuriosities.setBackground(getBackground());
		
		scrollPane = new JScrollPane(gameCuriosities);
		scrollPane.setBounds(30, 100, 440, 200);
		curiositiesPanel.add(scrollPane);
	}
	
	public String readHowToPlay() {
		String string;
		/* Initialize readers with null */
		File file = null;
		Scanner scanner = null;
		
		try {
			/* Read from howToPlay_en.dat or howToPlay_pt.dat file, depending on the language chosen 
			 * This format was chosen because in this way the player cannot modify the content */
			
			/* If language chosen is English */
			if(game.getLanguage() == 0) {
				file = new File("howToPlay_en.dat");
			}
			/* If language chosen is Portuguese */
			else if(game.getLanguage() == 1) {
				file = new File("howToPlay_pt.dat");
			}
			scanner = new Scanner(file);
			
			/* While file has content */
			while(scanner.hasNext()) {
				/* string is equal to the word read */
				string = scanner.next();
				
				/* If string is equal to /n, it means that the content has to be break in a new line */
				if(string.equals("\\n")) {
					howToPlayText = howToPlayText.concat(System.getProperty("line.separator"));
				}
				/* Otherwise, add the string to the end of the text */
				else {
					howToPlayText = howToPlayText.concat(string + " ");
				}
			}			
		}
		
		catch(IOException ex){
			  ex.printStackTrace();
		}
		
		return howToPlayText;
	}
	
	public String readHistory() {
		String string;
		/* Initialize readers with null */
		File file = null;
		Scanner scanner = null;
		
		try {
			/* Read from history_en.dat or history_pt.dat file, depending on the language chosen 
			 * This format was chosen because in this way the player cannot modify the content */
			
			/* If language chosen is English */
			if(game.getLanguage() == 0) {
				file = new File("history_en.dat");
			}
			/* If language chosen is Portuguese */
			else if(game.getLanguage() == 1) {
				file = new File("history_pt.dat");
			}
			scanner = new Scanner(file);
			
			/* While file has content */
			while(scanner.hasNext()) {
				/* string is equal to the word read */
				string = scanner.next();
				
				/* If string is equal to /n, it means that the content has to be break in a new line */
				if(string.equals("\\n")) {
					historyText = historyText.concat(System.getProperty("line.separator"));
				}
				/* Otherwise, add the string to the end of the text */
				else {
					historyText = historyText.concat(string + " ");
				}
			}			
		}
		
		catch(IOException ex){
			  ex.printStackTrace();
		}
		
		return historyText;
	}
	
	public String readCuriosities() {
		String string;
		/* Initialize readers with null */
		File file = null;
		Scanner scanner = null;
		
		try {
			/* Read from curiosities_en.dat or curiosities_pt.dat file, depending on the language chosen 
			 * This format was chosen because in this way the player cannot modify the content */
			
			/* If language chosen is English */
			if(game.getLanguage() == 0) {
				file = new File("curiosities_en.dat");
			}
			/* If language chosen is Portuguese */
			else if(game.getLanguage() == 1) {
				file = new File("curiosities_pt.dat");
			}
			scanner = new Scanner(file);
			
			/* While file has content */
			while(scanner.hasNext()) {
				/* string is equal to the word read */
				string = scanner.next();
				
				/* If string is equal to /n, it means that the content has to be break in a new line */
				if(string.equals("\\n")) {
					curiositiesText = curiositiesText.concat(System.getProperty("line.separator"));
				}
				/* Otherwise, add the string to the end of the text */
				else {
					curiositiesText = curiositiesText.concat(string + " ");
				}
			}			
		}
		
		catch(IOException ex){
			  ex.printStackTrace();
		}
		
		return curiositiesText;
	}
}
