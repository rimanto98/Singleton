package nicholasCageProduction;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NicholasCage {
	
	Image nicholas;

	public Image immagine() {
		try {
			nicholas = ImageIO.read(new File("immaginiNicholasCage" + File.separator  + "nicholas2.jpeg"));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("2");
		return nicholas;
	}

}
