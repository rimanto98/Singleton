package nicholasCageProduction;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Pannello2 extends JPanel {

	private NicholasCage nicholas2;
	
	
	public Pannello2(NicholasCage nicholas) {
		
		this.nicholas2 = nicholas;
	}

	public void paint (Graphics g) {
		
		super.paint(g);
		
		Graphics2D grafica2d = (Graphics2D) g;
		
		grafica2d.drawImage(nicholas2.immagine(), 0 , 0 , 300, 300 - 20, null);
		
	}
}
