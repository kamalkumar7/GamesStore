import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;


 public class Music   {

    public void playsoundBG(boolean stop) throws UnsupportedAudioFileException,IOException,LineUnavailableException
    {
        File file = new File("res/New.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
         Clip  clip=  AudioSystem.getClip();
         clip.open(audioStream);
         clip.start();
         if(stop ==true)
         {
             clip.stop();
         }
    }

    void playsoundSettle() throws UnsupportedAudioFileException,IOException,LineUnavailableException
    {
        File file = new File("res/settle.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
         Clip  clip=  AudioSystem.getClip();
         clip.open(audioStream);
         clip.start();
    }
    
 
   

}
