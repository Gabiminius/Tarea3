package Vistas;

import javax.swing.*;
import java.awt.*;


public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal = new PanelPrincipal();

    /**
     * Constructor de la clase Ventana.
     * Configura la ventana principal de la aplicación.
     * Agrega el panel principal a la ventana.
     * Hace visible la ventana.
     */
    public Ventana() {
        add(panelPrincipal);
        this.setSize(1455, 940);
        this.setTitle("SUPER EXPENDEDOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.black);
    }

}



