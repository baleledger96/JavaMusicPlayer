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

public class PlayerImpl implements IGuiLook{

	@Override
	public void Play(File file) {
<<<<<<< Updated upstream
		
=======
>>>>>>> Stashed changes
		
		System.out.println("Processing the MP3 file : "+file.getName());
	}

	@Override
	public void Stop() {
		
		
	}

	@Override
	public void Repeat() {
	
		
	}
	
	
}
