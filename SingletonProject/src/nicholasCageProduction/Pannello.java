package nicholasCageProduction;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Pannello extends JPanel{

	private NicholasCageSingleton nicholas;
	
	
	public Pannello(NicholasCageSingleton nicholas) {
		
		this.nicholas = nicholas;
	}

	public void paint (Graphics g) {
		
		super.paint(g);
		
		Graphics2D grafica2d = (Graphics2D) g;
		
		grafica2d.drawImage(nicholas.immagine(), 0 , 0 , 300, 300 - 20, null);
		
		//System.out.println("1 aperto");
		
	}
	
}
