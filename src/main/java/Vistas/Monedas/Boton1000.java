package Vistas.Monedas;

import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import Vistas.*;

public class Boton1000 extends JRadioButton implements MouseListener {
    private PanelMonedero panelMonedero;
    private int contador = 250;

    /**
     * Constructor de la clase Boton1000.
     * @param panelMonedero panel deL Monedero.
     */
    public Boton1000(PanelMonedero panelMonedero) {
        super();

        URL url1000 = getClass().getClassLoader().getResource("1000pesos.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("1000pesosDark.png");

        int ancho = 150;
        int alto = 100;
        ImageIcon icon1000 = new ImageIcon(new ImageIcon(url1000).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(icon1000);
        this.setSelectedIcon(iconSeleccionado);
        this.panelMonedero = panelMonedero;
        this.addMouseListener(this);
    }

    /**
     * Se invoca cuando el mouse fue clickeado en el Boton1000.
     * @param e evento de mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Moneda moneda = new Moneda1000(contador);
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