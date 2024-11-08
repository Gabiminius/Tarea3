package Vistas;

import javax.swing.*;
import java.awt.*;

/**
 * La clase {@code Ventana} representa la ventana principal de la aplicación.
 * Esta ventana contiene el {@code PanelPrincipal}, que organiza todos los componentes
 * interactivos del expendedor.
 */
public class Ventana extends JFrame {
    // Instancia del panel principal de la aplicación
    private PanelPrincipal panelPrincipal = new PanelPrincipal();

    /**
     * Constructor de la clase {@code Ventana}.
     * Este constructor configura la ventana principal de la aplicación,
     * establece su tamaño, título, comportamiento de cierre, color de fondo,
     * y hace visible la ventana.
     */
    public Ventana() {
        // Añade el panel principal a la ventana
        add(panelPrincipal);

        // Configura el tamaño de la ventana
        this.setSize(1455, 940);

        // Establece el título de la ventana
        this.setTitle("SUPER EXPENDEDOR");

        // Define el comportamiento de cierre de la ventana: al cerrar se termina la aplicación
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Hace visible la ventana
        this.setVisible(true);

        // Establece el color de fondo de la ventana a negro
        this.setBackground(Color.black);
    }
}




