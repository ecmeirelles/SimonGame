package functions;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* Class that represents the sounds played in the game */
public class BeepFunction {
	/* BeepFunction attributes 
	 * Sound's location in the project */
    private File soundPath = new File("src\\resources");

    /* Method to play the sound according to the color */
	public void getBeep(int activeColor) {
		AudioClip beepSound = null;
		
		/* If color is green or magenta */
		if(activeColor == 1) {
			try {
				/* Audio is equal to src\\resources\\greenMagentaBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "greenMagentaBeep.au"));					
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		/* If color is red or cyan */
		else if(activeColor == 2) {
			try {
				/* Audio is equal to src\\resources\\redCyanBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "redCyanBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		/* If color is yellow or gray */
		else if(activeColor == 3) {
			try {
				/* Audio is equal to src\\resources\\yellowGrayBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "yellowGrayBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		/* If color is blue or orange */
		else if(activeColor == 4) {
			try {
				/* Audio is equal to src\\resources\\blueOrangeBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "blueOrangeBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		
		/* Play sound chosen */
		beepSound.play();
	}
}
