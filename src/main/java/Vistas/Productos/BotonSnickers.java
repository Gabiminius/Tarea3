package Vistas.Productos;
import Logica.Seleccionador;
import Vistas.PanelSeleccionar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
/**
 * La clase {@code BotonSnickers} representa un botón de radio para seleccionar un Snicker,
 * mostrando su precio y cambiando de icono cuando está seleccionado.
 * Implementa {@link MouseListener} para manejar eventos de clic en el botón.
 */
public class BotonSnickers extends JRadioButton implements MouseListener{
    private PanelSeleccionar panelSelect;

    /**
     * Constructor de la clase {@code BotonSnickers}.
     * Configura el botón con un texto de precio, iconos personalizados para los estados normal y
     * seleccionado, y asocia el botón al panel de selección especificado.
     *
     * @param panelSelect el panel de tipo {@code PanelSeleccionar} al que se asociará este botón.
     */
    public BotonSnickers(PanelSeleccionar panelSelect) {
        super("Precio: $500");

        URL urlSnickers = getClass().getClassLoader().getResource("snickers.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("snickersSeleccionado.png");

        int ancho = 60;
        int alto = 80;
        ImageIcon iconSnickers = new ImageIcon(new ImageIcon(urlSnickers).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(iconSnickers);
        this.setSelectedIcon(iconSeleccionado);
        setBackground(Color.WHITE);
        this.panelSelect = panelSelect;
        this.addMouseListener(this);
    }

    /**
     * Se invoca cuando el mouse ha sido presionado y soltado en un componente.
     * @param e evento de mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        panelSelect.setTipoProducto(Seleccionador.SNICKERS);
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
