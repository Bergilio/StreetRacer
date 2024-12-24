package trafficracer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {
    public void playSound(String soundPath) {
        try {
            AudioInputStream audioStream = getAudioStream(soundPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-20); // entre -80 e 6
            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void playSound_loop(String soundPath) {
        try {
            AudioInputStream audioStream = getAudioStream(soundPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10);

            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public AudioInputStream getAudioStream(String soundPath) throws UnsupportedAudioFileException, IOException {
        File soundFile = new File(soundPath);
        if (soundFile.exists()) {
            return AudioSystem.getAudioInputStream(soundFile);
        } else {
            URL resource = getClass().getResource(soundPath);
            if (resource == null) {
                throw new IOException("File not found: " + soundPath);
            }
            return AudioSystem.getAudioInputStream(resource);
        }
    }
}