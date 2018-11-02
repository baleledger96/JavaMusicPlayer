package org.baleledger.java;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.*;

public class PlayerImpl{

	public void Play(File file) {

		System.out.println("Eclipse Music Player!!");
		System.out.println("Made in eclipse..");
		System.out.println("Processing the MP3 file : "+file.getName());
		 Clip clip = AudioSystem.getClip();
		AudioInputStream as = AudioSystem.getAudioInputStream(file);
	
		clip.open(as);
		clip.start();

		
	}

	public void Stop() {
		
		
	}

	public void Repeat() {
	
		
	}
	
	
}
