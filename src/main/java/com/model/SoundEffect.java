package com.model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {

    public static void play(boolean warning, int num){
        for(int i=0; i < num; i++){
            honk(warning);
        }
    }

    private static void honk(boolean warning){
        String fileName = "escape-room/src/main/java/com/sounds/";

        if(warning){
            fileName += "trumpet.wav";
        } else {
            fileName += "fanfare.wav";
        }

        try {
			File soundFile = new File(fileName);

			if (!soundFile.exists()) {
				System.out.println("File does not exist!");
				return;
			}

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
			
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);

			clip.start();
			long clipDuration = clip.getMicrosecondLength() / 1000; // Duration in milliseconds
        	Thread.sleep(clipDuration); // Sleep for the duration of the clip

			clip.close();
			audioStream.close();
		} catch(Exception e){
			e.printStackTrace();
		}
    }
}

