package nicholasCageProduction;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MainFrame extends JFrame implements Runnable{

	Menu menu;
	
	Pannello pannello;
	Pannello2 pannello2;
	
	public MainFrame() {
			
		menu = new Menu (1280,720);
		
		menu.setLocation(0, 0);
		menu.setSize(this.getSize());
		menu.setVisible(true);
		this.add(menu);
		Thread t = new Thread(this);
		t.start();
	}


	@Override
	public void run() {
			while (true)
			{	
				if (menu.getAvvio1())
				{
					//System.out.println("entro 1");
					menu.setAvvio1(false);
					if (!menu.nicholasConSimpleton.getIstanziato())
					{
						menu.nicholasConSimpleton = NicholasCageSingleton.getInstance();
						JFrame frame = new JFrame();
						frame.setSize(300,300);
						pannello = new Pannello(menu.nicholasConSimpleton);
						pannello.setLocation(0, 0);
						pannello.setSize(frame.getSize());
						//pannello.setVisible(true);
						pannello.setFocusable(true);
						frame.setContentPane(pannello);
						frame.setVisible(true);
					}
				}
				
				else if (menu.getAvvio2())
				{
					
					menu.setAvvio2(false);
					menu.nicholas = new NicholasCage();
					JFrame frame = new JFrame();
					pannello2 = new Pannello2(menu.nicholas);
					pannello2.setLocation(0, 0);
					pannello2.setSize(300,300);
					pannello2.setVisible(true);
					pannello2.setFocusable(true);
					frame.setSize(300,300);
					frame.setContentPane(pannello2);
					frame.setVisible(true);
				}
				
			}
	}
	
}
