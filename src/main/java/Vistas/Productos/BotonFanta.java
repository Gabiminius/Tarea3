package Vistas.Productos;
import Logica.Seleccionador;
import Vistas.PanelSeleccionar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
/**
 * La clase {@code BotonFanta} representa un botón de radio para seleccionar una bebida fanta,
 * mostrando su precio y cambiando de icono cuando está seleccionado.
 * Implementa {@link MouseListener} para manejar eventos de clic en el botón.
 */
public class BotonFanta extends JRadioButton implements MouseListener{
    private PanelSeleccionar panelSelect;

     /**
     * Constructor de la clase {@code BotonFanta}.
     * Configura el botón con un texto de precio, iconos personalizados para los estados normal y
     * seleccionado, y asocia el botón al panel de selección especificado.
     *
     * @param panelSelect el panel de tipo {@code PanelSeleccionar} al que se asociará este botón.
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
