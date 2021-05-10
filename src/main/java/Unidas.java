import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Unidas extends Transformaciones{
    private BufferedImage foto= null;
    private BufferedImage fotoDos= null;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    private int color;

    public Unidas(PictureObject foto){
        imagenBase = foto;
    }

    @Override
    public void hacer() {
        try {
            File one = new File("equipo2015.jpg");
            foto = ImageIO.read(one);
            File dos = new File("equipo2020.jpg");
            fotoDos = ImageIO.read(dos);

            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = 0; j < foto.getWidth()/3; j++) {
                    color = (foto.getRGB(j, i));
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se carga imagen #1 al 100%");



            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = (foto.getWidth()/3); j < (foto.getWidth()/3)*2; j++) {
                    color = (foto.getRGB(j, i)+fotoDos.getRGB(j,i))/2;
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se carga imagen #1 y #2 al 50% cada una");

            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = (foto.getWidth()/3)*2; j < foto.getWidth(); j++) {
                    color = fotoDos.getRGB(j, i);
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se carga imagen #2 al 100%");


            imagenBase.cambioOk();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
