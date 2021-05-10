import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelPictures extends JPanel implements PropertyChangeListener{

    private PictureObject imagen;

    public PanelPictures(PictureObject img) {

        imagen = img;
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(700,500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagen != null) {
            imagen.dibujar(g);
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        repaint();
    }
}
