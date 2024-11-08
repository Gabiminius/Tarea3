package Vistas.Productos;
import Logica.Seleccionador;
import Vistas.PanelSeleccionar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
/**
 * La clase {@code BotonSprite} representa un botón de radio para seleccionar una bebida Sprite,
 * mostrando su precio y cambiando de icono cuando está seleccionado.
 * Implementa {@link MouseListener} para manejar eventos de clic en el botón.
 */
public class BotonSprite extends JRadioButton implements MouseListener {
    private PanelSeleccionar panelSelect;

    /**
     * Constructor de la clase {@code BotonSprite}.
     * Configura el botón con un texto de precio, iconos personalizados para los estados normal y
     * seleccionado, y asocia el botón al panel de selección especificado.
     *
     * @param panelSelect el panel de tipo {@code PanelSeleccionar} al que se asociará este botón.
     */
    public  BotonSprite(PanelSeleccionar panelSelect) {
        super("Precio: $1000");

        URL urlSprite = getClass().getClassLoader().getResource("Sprite.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("Spriteseleccionado.png");

        int ancho = 60;
        int alto = 80;
        ImageIcon iconSprite = new ImageIcon(new ImageIcon(urlSprite).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(iconSprite);
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
        panelSelect.setTipoProducto(Seleccionador.SPRITE);
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
