package Vistas.Productos;
import Logica.Seleccionador;
import Vistas.PanelSeleccionar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class BotonFanta extends JRadioButton implements MouseListener{
    private PanelSeleccionar panelSelect;

    /**
     * Constructor de la clase JButtonFanta.
     * @param panelSelect panel de selección.
     */
    public  BotonFanta(PanelSeleccionar panelSelect) {
        super("Precio: $1000");

        URL urlFanta = getClass().getClassLoader().getResource("fanta.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("fantaSeleccionado.png");

        int ancho = 60;
        int alto = 80;
        ImageIcon iconFanta = new ImageIcon(new ImageIcon(urlFanta).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(iconFanta);
        this.setSelectedIcon(iconSeleccionado);
        setBackground(Color.WHITE);
        this.panelSelect = panelSelect;
        this.addMouseListener(this);
    }

    /**
     * Método que se ejecuta cuando se hace click en el botón.
     * @param e Evento de click.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        panelSelect.setTipoProducto(Seleccionador.FANTA);
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
