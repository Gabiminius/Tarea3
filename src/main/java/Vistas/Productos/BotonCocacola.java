package Vistas.Productos;
import Logica.Seleccionador;
import Vistas.PanelSeleccionar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
/**
 * La clase {@code BotonCocacola} representa un botón de radio para seleccionar una bebida Coca-Cola,
 * mostrando su precio y cambiando de icono cuando está seleccionado.
 * Implementa {@link MouseListener} para manejar eventos de clic en el botón.
 */
public class BotonCocacola extends JRadioButton implements MouseListener{
    private PanelSeleccionar panelSelect;
    /**
     * Constructor de la clase {@code BotonCocacola}.
     * Configura el botón con un texto de precio, iconos personalizados para los estados normal y
     * seleccionado, y asocia el botón al panel de selección especificado.
     *
     * @param panelSelect el panel de tipo {@code PanelSeleccionar} al que se asociará este botón.
     */
    public BotonCocacola(PanelSeleccionar panelSelect) {
        super("Precio: $1000");

        URL urlCoca = getClass().getClassLoader().getResource("Coca-Cola.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("Coca-ColaSeleccionado.png");

        int ancho = 60;
        int alto = 80;
        ImageIcon iconCoca = new ImageIcon(new ImageIcon(urlCoca).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(iconCoca);
        this.setSelectedIcon(iconSeleccionado);
        this.panelSelect = panelSelect;
        this.addMouseListener(this);
        setBackground(Color.white);
    }

    /**
     * Se invoca cuando el mouse ha sido presionado y soltado en un componente.
     * @param e Evento del mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        panelSelect.setTipoProducto(Seleccionador.COCACOLA);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
