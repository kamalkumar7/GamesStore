import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sound {
	void soundPlay(String s) {
	File file = new File(s);
	  AudioInputStream audioStream = null;
	  try {
		 audioStream = AudioSystem.getAudioInputStream(file);
		
	} catch (UnsupportedAudioFileException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  Clip clip = null;
	try {
		clip = AudioSystem.getClip();
	} catch (LineUnavailableException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  try {
		clip.open(audioStream);
	} catch (LineUnavailableException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  clip.start();
	}
}
