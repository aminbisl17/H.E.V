import java.io.*;
import javax.sound.sampled.*;
public class hevaudio {
    File accessDenied, accessAccepted, welcomehev; Clip clip1, clip2, clip3;
     
    public static void ad(File file, Clip clip, int i) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       AudioInputStream as = AudioSystem.getAudioInputStream(file);
       clip = AudioSystem.getClip();
       clip.open(as);
       clip.start();
       clip.setMicrosecondPosition(i);
    }
    public hevaudio() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
        // files
        accessAccepted = new File("button3.wav");
        accessDenied = new File("button2.wav");
        welcomehev = new File("hev_logon.wav");
    }
    public void accepted() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        // ... button accepted
        ad(accessAccepted, clip3, 10);
       clip3.setMicrosecondPosition(10);
    }
    public void denied() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        // ...button denied
       ad(accessDenied, clip1, 10);
       clip1.setMicrosecondPosition(10);
    }
    public void welcome() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        // ... hev logon
      ad(welcomehev, clip2, 10);
    }
}
