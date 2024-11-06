package Vistas.Monedas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import Vistas.*;

public class Boton100 extends JRadioButton implements MouseListener {
    private PanelMonedero panelMonedero;
    private int contador = 100;

    /**
     * Constructor de la clase Boton100.
     * @param panelMonedero panel del Monedero.
     */
    public Boton100(PanelMonedero panelMonedero) {
        super();

        URL url100 = getClass().getClassLoader().getResource("moneda100.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("moneda100Dark.png");

        if (url100 == null || urlSeleccionado == null) {
            throw new IllegalArgumentException("No se pudieron cargar los recursos de imagen.");
        }

        int ancho = 100;
        int alto = 100;
        ImageIcon icon100 = new ImageIcon(new ImageIcon(url100).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));

        this.setIcon(icon100);
        this.setSelectedIcon(iconSeleccionado);
        this.panelMonedero = panelMonedero; // Corrección para usar el objeto recibido
        this.addMouseListener(this);
    }


    /**
     * Se invoca cuando el mouse fue clickeado en el Boton100.
     * @param e evento de mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Moneda moneda = new Moneda100(contador);
        panelMonedero.setTipoMoneda(moneda);
        contador++;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
