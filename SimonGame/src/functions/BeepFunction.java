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
		
		/* If color is green */
		if(activeColor == 1) {
			try {
				/* Audio is equal to src\\resources\\greenBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "greenBeep.au"));					
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		/* If color is red */
		else if(activeColor == 2) {
			try {
				/* Audio is equal to src\\resources\\redBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "redBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		/* If color is yellow */
		else if(activeColor == 3) {
			try {
				/* Audio is equal to src\\resources\\yellowBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "yellowBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		/* If color is blue */
		else if(activeColor == 4) {
			try {
				/* Audio is equal to src\\resources\\blueBeep.au */
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "blueBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				System.out.println("Sound could not be found");
			}
		}
		
		/* Play sound chosen */
		beepSound.play();
	}
}
