package org.baleledger.java;

/*import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class PlayerMain {
	
	private void titleAlign(JFrame frame) {
		
        Font font = frame.getFont();

        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 10) + "s", pad);
        frame.setTitle(pad + currentTitle);

    }
	
	public static void main(String[] args) {
       

		PlayerImpl player = new PlayerImpl();
		PlayerMain pm = new PlayerMain();
		//set the cross platform look of the Jframe window
		try {
		    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		JFrame jf = new JFrame("Java MP3 player");
		//jframe titlebar icon
		ImageIcon playericon = new ImageIcon("src/resources/playbutton-icon.jpg","frame icon");
		
		//set size of jframe and bring the title text to centre
		jf.setSize(650, 500);
		//pm.titleAlign(jf);
		jf.setIconImage(playericon.getImage());
		

		//Panel for setting the player window
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		//set the button for choosing the MP3 file
		ImageIcon icon = new ImageIcon("src/resources/browseicon.jpg");
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		
		JButton filechooser = new JButton("Choose your song", icon);
		filechooser.setPreferredSize(new Dimension(190,60));
		filechooser.setMargin(new Insets(0,0,0,0));
		
		//add event for the button click event
		JLabel filelabel = new JLabel("hi",JLabel.CENTER);
		//jf.add(filechooser);
		controlPanel.add(filechooser);
		jf.add(controlPanel);
		//jf.add(filelabel);
		filechooser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser filexplorer = new JFileChooser();
				int ret = filexplorer.showOpenDialog(jf);
				if(ret == JFileChooser.APPROVE_OPTION) {
					File file = filexplorer.getSelectedFile();
					String name = file.getName();
					jf.add(filelabel);
					filelabel.setText("Playing song "+name);
					player.Play();
				}
			}
		});
		
		
		jf.setVisible(true);
		jf. setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
}*/

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
 
public class PlayerMain {
   private JFrame frame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public PlayerMain(){
      prepareGUI();
   }
   public static void main(String[] args){
      PlayerMain  pm = new PlayerMain();      
      pm.showButtonDemo();
   }
   private void prepareGUI(){
	   try {
		    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
      frame = new JFrame("Java MP3 player");
      ImageIcon playericon = new ImageIcon("src/resources/playbutton-icon.jpg","frame icon");
		
		//set size of jframe and bring the title text to centre
		frame.setSize(650, 500);
		//pm.titleAlign(jf);
		frame.setIconImage(playericon.getImage());
      frame.setSize(650,500);
      //frame.setLayout(new BoxLayout(frame, 0));
      BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS); // top to bottom
      frame.setLayout(boxLayout);
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });            
      statusLabel = new JLabel("");    
      statusLabel.setSize(250,100);
      Dimension size = statusLabel.getPreferredSize();
      statusLabel.setBounds(200,200,size.width, size.height);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
     
      frame.add(controlPanel);
      frame.add(statusLabel);
      frame.setVisible(true);  
   }
   private static ImageIcon createImageIcon(String path, String description) {
      java.net.URL imgURL = PlayerMain.class.getResource(path);
      if (imgURL != null) {
         return new ImageIcon(imgURL, description);
      } else {            
         System.err.println("Couldn't find file: " + path);
         return null;
      }
   }   
   private void showButtonDemo(){

     
      ImageIcon icon = createImageIcon("/resources/browseicon.jpg","Java");
      Image image = icon.getImage(); // transform it 
	  Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
	  icon = new ImageIcon(newimg);
		
      JButton SearchButton = new JButton("Browse your song", icon);
      //SearchButton.setHorizontalTextPosition(SwingConstants.); 
      SearchButton.setPreferredSize(new Dimension(190,60));
      SearchButton.setMargin(new Insets(0,0,0,0));
    
      SearchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 JFileChooser filexplorer = new JFileChooser();
				int ret = filexplorer.showOpenDialog(frame);
				if(ret == JFileChooser.APPROVE_OPTION) {
					File file = filexplorer.getSelectedFile();
					String name = file.getName();
            statusLabel.setText("Playing "+name);
         }
         }});
      
      controlPanel.add(SearchButton);       

      frame.setVisible(true);  
   }
}
