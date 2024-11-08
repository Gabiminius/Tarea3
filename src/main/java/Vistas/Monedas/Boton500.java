package Vistas.Monedas;

import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import Vistas.*;
/**
 * La clase {@code Boton500} representa un botón de radio que simula una moneda de 500.
 * Implementa {@link MouseListener} para manejar eventos de clic en el botón.
 */
public class Boton500 extends JRadioButton implements MouseListener {
    private PanelMonedero panelMonedero;
    private int contador = 423;

    /**
     * Constructor de la clase {@code Boton500}.
     * Configura el botón con iconos personalizados para el estado normal y seleccionado, y
     * asocia el botón al panel del monedero especificado.
     *
     * @param panelMonedero el panel de tipo {@code PanelMonedero} al que se asociará este botón.
     */
    public Boton500(PanelMonedero panelMonedero) {
        super();

        URL url500 = getClass().getClassLoader().getResource("moneda500.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("moneda500Dark.png");

        int ancho = 100;
        int alto = 100;
        ImageIcon icon500 = new ImageIcon(new ImageIcon(url500).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(icon500);
        this.setSelectedIcon(iconSeleccionado);
        this.panelMonedero = panelMonedero;
        this.addMouseListener(this);
        setBackground(Color.WHITE);

    }

    /**
     * Se invoca cuando el mouse fue clickeado en el Boton500.
     * @param e evento de mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Moneda moneda = new Moneda500(contador);
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