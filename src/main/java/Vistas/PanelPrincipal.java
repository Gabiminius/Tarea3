package Vistas;

import javax.swing.*;
import java.awt.*;
/**
 * La clase {@code PanelPrincipal} representa el panel principal de la interfaz gráfica,
 * que contiene el expendedor, el panel del comprador y el botón de compra.
 * Este panel actúa como el contenedor principal de los componentes de la interfaz.
 */
public class PanelPrincipal extends JPanel {
    // Instancias de los paneles y el botón de compra
    private PanelComprador com;
    private PanelExpendedor exp;
    private BotonCompra botonComprar;

    /**
     * Constructor de la clase {@code PanelPrincipal}.
     * Este constructor inicializa los componentes del panel y los organiza dentro de un
     * layout de flujo (FlowLayout).
     */
    public PanelPrincipal() {
        this.com = new PanelComprador(); // Inicializa el panel del comprador
        this.exp = new PanelExpendedor(5); // Inicializa el panel del expendedor con capacidad para 5 productos
        this.botonComprar = new BotonCompra(exp, com); // Inicializa el botón de compra que interactúa con los paneles

        this.setBackground(Color.black); // Establece el color de fondo del panel principal

        // Añade los componentes al panel principal
        add(exp); // Añade el panel del expendedor
        add(botonComprar, BorderLayout.CENTER); // Añade el botón de compra al centro del panel
        add(com); // Añade el panel del comprador

        setLayout(new FlowLayout()); // Establece el diseño del panel como un flujo
    }

    /**
     * Método que se encarga de pintar los componentes del panel.
     * Este método sobrescribe el método {@code paintComponent} de {@code JPanel}
     * para personalizar el proceso de renderizado. Actualmente no realiza ninguna acción adicional.
     * @param g Objeto {@code Graphics} utilizado para pintar los componentes.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método de la superclase para asegurar la correcta pintura
    }
}






