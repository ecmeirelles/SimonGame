package functions;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BeepFunction {
    private File soundPath = new File("src\\resources");

	public void getBeep(int activeColor) {
		AudioClip beepSound = null;
		
		if(activeColor == 1) {
			try {
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "greenBeep.au"));					
			} 
			
			catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		else if(activeColor == 2) {
			try {
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "redBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		else if(activeColor == 3) {
			try {
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "yellowBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		else if(activeColor == 4) {
			try {
				beepSound = Applet.newAudioClip(new URL(soundPath.toURI().toURL(), "blueBeep.au"));				
			} 
			
			catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		   
		beepSound.play();
	}
}
