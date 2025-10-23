package com.model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {

    public static void play(String file, long duration){
		honk(file, duration);
    }

    private static void honk(String file, long duration){
        String fileName = "src/main/java/com/sounds/" + file;

        try {
			File soundFile = new File(fileName);

			if (!soundFile.exists()) {
				System.out.println("File does not exist!");
				return;
			}

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
			
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			long clipDuration;

			clip.start();
			if(duration == 0) {
				clipDuration = clip.getMicrosecondLength() / 1000; // Duration in milliseconds
			} else {
				clipDuration = duration;
			}
			
        	Thread.sleep(clipDuration); // Sleep for the duration of the clip

			clip.close();
			audioStream.close();
		} catch(Exception e){
			e.printStackTrace();
		}
    }
}

