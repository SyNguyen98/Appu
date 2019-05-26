package Sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    public static void play(String url) {
        try {       
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(url)));
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException exc) {}
    }
}
