package Vistas.Imagenes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
/**
 * La clase {@code CocacolaIma} representa un componente gráfico que muestra una imagen de una Coca-Cola.
 * Extiende {@link JPanel} y se encarga de cargar y escalar la imagen.
 */

public class CocacolaIma extends JPanel {
    private Image imagen;

    /**
     * Constructor de la clase ImageCoca.
     */
    public CocacolaIma() {
        setOpaque(false);
        URL imagenURL = getClass().getClassLoader().getResource("Coca-Cola.png");
        try{
            imagen = ImageIO.read(imagenURL);
            int ancho = 40;
            int alto = 60;
            imagen = imagen.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setPreferredSize(new Dimension(imagen.getWidth(null), imagen.getHeight(null)));

    }

    /**
     * Metodo que se encarga de pintar la imagen en el componente.
     * @param g Objeto Graphics.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 3, this);
    }

}
