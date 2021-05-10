import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PictureOne extends Transformaciones {

    private BufferedImage foto= null;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    private int color;

    public PictureOne(PictureObject foto) {

        imagenBase = foto;
    }

    @Override
    public void hacer() {
        try {
            File imagen = new File("equipo2020.jpg");
            foto = ImageIO.read(imagen);

            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = 0; j < foto.getWidth()/3; j++) {
                    color = foto.getRGB(j, i);
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se carga imagen #1 al 100%");

            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = foto.getWidth()/3; j < (foto.getWidth()/3)*2; j++) {
                    color = (foto.getRGB(j, i)/2);
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se carga imagen #1 al 50%");

            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = (foto.getWidth()/3)*2; j < foto.getWidth(); j++) {
                    color = (foto.getRGB(j, i)*0);
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se carga imagen #1 al 0%");
            imagenBase.cambioOk();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
