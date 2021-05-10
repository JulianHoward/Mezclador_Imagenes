import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.core.Logger;

public class Frame extends JFrame {

    private PictureObject modelo;
    private final static Logger logger = (Logger) LogManager.getRootLogger();

    public Frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("DIFUMINACIÓN DE IMAGENES");
        init();
    }

    public void init() {

        modelo = new PictureObject(700, 500);

        PanelPictures panel = new PanelPictures(modelo);

        modelo.addObserver(panel);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu mnuImagen = new JMenu("Start");
        mnuImagen.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 19));

        JMenu mnuHelp = new JMenu("Help");
        mnuHelp.setFont(new Font("Calibri", Font.ROMAN_BASELINE, 19));

        JMenuItem item1 = new JMenuItem("Cargar imagen #1");
        item1.setFont(new Font("Calibri", Font.PLAIN, 16));
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    logger.debug("Carga la imagen #1");
                    PictureOne one = new PictureOne(modelo);
                    one.hacer();
            }
        });
        mnuImagen.add(item1);

        JMenuItem item2 = new JMenuItem("Cargar imagen #2");
        item2.setFont(new Font("Calibri", Font.PLAIN, 16));
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    logger.debug("Carga la imagen #2");
                    PictureTwo two = new PictureTwo(modelo);
                    two.hacer();
            }
        });
        mnuImagen.add(item2);

        JMenuItem item3 = new JMenuItem("Unir imagenes");
        item3.setFont(new Font("Calibri", Font.PLAIN, 16));
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea proceder y ver esta tremenda magia negra de unir dos imagenes?", "Confirmación de union de imagenes", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION) {
                    logger.debug("Cargan las dos imagenes");
                    Unidas unidas = new Unidas(modelo);
                    unidas.hacer();
                }
            }
        });
        mnuImagen.add(item3);

        JMenuItem item4 = new JMenuItem("About");
        item4.setFont(new Font("Calibri", Font.PLAIN, 16));
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.debug("Abre ventana explicando el funcionamiento de la app");
                JOptionPane.showMessageDialog(null, "Funcionamiento de mi app:\n " +
                        "  1.- Presionar boton 'Start'.\n" +
                        "  2.- Presionar boton 'Cargar imagen #1' y ver que imagen #1 se carga al 100%, 50% y 0%.\n" +
                        "  3.- Presionar boton 'Cargar imagen #2' y ver que imagen #2 se carga al 0%, 50% y 100%.\n" +
                        "  4.- Presionar boton 'Unir imagenes' y ver que ambas imagenes se cargan en los extremos al 100% y en el medio es 50% de cada imagen.\n" +
                        "  5.- Presionar boton 'Help' seguido del boton 'Exit' para terminar de ver la magia negra entre imagenes.");
            }
        });
        mnuHelp.add(item4);

        JMenuItem item5 = new JMenuItem("Exit");
        item5.setFont(new Font("Calibri", Font.PLAIN, 16));
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea cerrar mi increible app?", "Cerrar app", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                    logger.debug("Usuario sale de la ventana y finaliza app");
                }
            }
        });
        mnuHelp.add(item5);

        menuBar.add(mnuImagen);
        menuBar.add(mnuHelp);
        this.setJMenuBar(menuBar);
        this.pack();
    }
}








