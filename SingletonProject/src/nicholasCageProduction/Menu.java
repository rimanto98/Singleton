package nicholasCageProduction;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu extends JPanel implements KeyListener{

	Image background;
	Image freccia;
	Image tasti;
	Boolean[] indicatore;
	NicholasCage nicholas;
	NicholasCageSingleton nicholasConSimpleton;
	volatile Boolean avvio1;
	volatile Boolean avvio2;
	
	int larghezza;
	int altezza;
	
	public Menu(int larghezzaFrame,int altezzaFrame) {
		super();
		
		avvio1 = false;
		avvio2 = false;
		
		larghezza = larghezzaFrame;
		altezza =altezzaFrame;		
		
		indicatore = new Boolean[3];
		indicatore [0] = true;
		for (int i = 1; i<3;i++)
			indicatore[i] = false;
		
		this.addKeyListener(this);
		
		this.setFocusable(true);
	
		caricaImmagini();
	}

	public void caricaImmagini()
	{
		try {
			background = ImageIO.read(new File("title" + File.separator  + "titlescreen.jpg"));
			freccia = ImageIO.read(new File("title" + File.separator  + "freccina.png"));
			tasti = ImageIO.read(new File("title" + File.separator  + "scritte.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disegnaTasti (Graphics2D g2d){
		g2d.drawImage(tasti,  25, 30, 1280, 720, null);	
	}
	
	public void disegnaBackground (Graphics2D g2d){
		g2d.drawImage(background, 0 , 0 , larghezza, altezza - 20, null);	
	}
	
	public void disegnaFreccia (Graphics2D g2d){
		if (indicatore[0])
			g2d.drawImage(freccia,  larghezza/2-600, altezza/3-10, 50, 50, null);
		if (indicatore[1])
			g2d.drawImage(freccia,  larghezza/2-600, altezza/3+65, 50, 50, null);
		if (indicatore[2])
			g2d.drawImage(freccia,  larghezza/2-600, altezza/3+150, 50, 50, null);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D grafica2d = (Graphics2D) g;
		disegnaBackground(grafica2d);
		disegnaTasti(grafica2d);
		disegnaFreccia(grafica2d);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE ) 
		{
			System.exit(0);
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if (indicatore[0] == true)
			{
				indicatore[0] = false;
				indicatore[1] = true;
			}
			
			else if (indicatore[1] == true)
			{
				indicatore[1] = false;
				indicatore[2] = true;
			}
			
			else if (indicatore[2] == true)
			{
				indicatore[2] = false;
				indicatore[0] = true;
			}
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			if (indicatore[0] == true)
			{
				indicatore[0] = false;
				indicatore[2] = true;
			}
			
			else if (indicatore[1] == true)
			{
				indicatore[1] = false;
				indicatore[0] = true;
			}
			
			else if (indicatore[2] == true)
			{
				indicatore[2] = false;
				indicatore[1] = true;
			}
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if (indicatore[0])
			{
				avvio1 = true;
			}
			
			if (indicatore[1])
			{
				avvio2 = true;
			}
			
			if (indicatore[2])
			{
				System.exit(0);
			}
			
		}
		
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Boolean getAvvio1() {
		return avvio1;
	}

	public void setAvvio1(Boolean avvio) {
		this.avvio1 = avvio;
	}
	
	public Boolean getAvvio2() {
		return avvio2;
	}

	public void setAvvio2(Boolean avvio) {
		this.avvio2 = avvio;
	}
	
	

}
