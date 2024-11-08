package Vistas;
import Logica.*;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * La clase {@code PanelComprador} representa el panel que contiene la interfaz del comprador en el sistema,
 * gestionando la visualización de los componentes relacionados con la selección de productos, el monedero,
 * el vuelto y el bolsillo donde se guarda el producto comprado.
 */
public class PanelComprador extends JPanel {
    private PanelSeleccionar panel;
    private PanelMonedero monedero;
    private PanelVuelto vuelto;
    private PanelPedido bolsillo;

    /**
     * Constructor de la clase {@code PanelComprador}.
     * Configura el layout del panel y los subcomponentes de la interfaz del comprador,
     * como los paneles para seleccionar productos, mostrar el monedero, mostrar el vuelto y el bolsillo.
     */
    public PanelComprador() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        // Inicializa y configura el panel de selección de productos
        panel = new PanelSeleccionar();
        panel.setPreferredSize(new Dimension(600, 295));
        panel.setBorder(new LineBorder(Color.cyan, 5));
        JPanel panelAjustado = new JPanel(new FlowLayout());
        panelAjustado.add(panel);

        // Inicializa y configura el panel del monedero
        monedero = new PanelMonedero();
        monedero.setPreferredSize(new Dimension(260, 300));
        monedero.setBorder(new LineBorder(Color.cyan, 5));
        monedero.setBackground(Color.white);
        JPanel monederoAjustado = new JPanel(new FlowLayout());
        monederoAjustado.add(monedero);
        monederoAjustado.setOpaque(false); // Para que se vea el fondo de la ventana

        // Inicializa y configura el bolsillo donde se coloca el producto comprado
        bolsillo = new PanelPedido();
        bolsillo.setPreferredSize(new Dimension(160, 130));

        // Inicializa y configura el panel del vuelto
        vuelto = new PanelVuelto();
        vuelto.setPreferredSize(new Dimension(400, 200));
        vuelto.setBorder(new LineBorder(Color.cyan, 5));

        // Añade los subcomponentes al panel principal
        add(bolsillo);
        add(vuelto);
        add(panelAjustado);
        add(monederoAjustado);

        // Establece el fondo del panel principal
        this.setBackground(Color.black);
    }

    /**
     * Obtiene el panel de selección de productos.
     * @return el panel de selección.
     */
    public PanelSeleccionar getPanel(){
        return panel;
    }

    /**
     * Obtiene el panel del monedero.
     * @return el panel del monedero.
     */
    public PanelMonedero getMonedero(){
        return monedero;
    }

    /**
     * Obtiene el bolsillo del comprador, donde se muestra el producto comprado.
     * @return el panel del bolsillo.
     */
    public PanelPedido getBolsillo(){
        return bolsillo;
    }

    /**
     * Sobrescribe el método {@code paintComponent} para permitir la personalización
     * de la pintura del componente. En este caso, no realiza ninguna acción adicional.
     * @param g el objeto Graphics utilizado para pintar el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * Actualiza el panel del vuelto con las monedas que el comprador recibe como cambio.
     * @param monedasComprador las monedas que el comprador recibe como vuelto.
     */
    public void ActualizarBolsilloVuelto(ArrayList<Moneda> monedasComprador){
        vuelto.RecibirVuelto(monedasComprador);
        updateUI();
    }
}
