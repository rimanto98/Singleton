package nicholasCageProduction;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NicholasCageSingleton {
	
	Image nicholas;
	
	private static NicholasCageSingleton instance;
	
	private static Boolean istanziato = false;
	
	private NicholasCageSingleton(){}
	
	public static synchronized NicholasCageSingleton getInstance() {
        if(instance == null) {
            instance = new NicholasCageSingleton();
            istanziato = true;
            /*if (istanziato)
            	System.out.println("Istanziato");*/
        }
        return instance;
    }
	
	

	public static Boolean getIstanziato() {
		return istanziato;
	}

	public Image immagine() {
		try {
			nicholas = ImageIO.read(new File("immaginiNicholasCage" + File.separator  + "nicholas1.jpeg"));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nicholas;
	}

}
