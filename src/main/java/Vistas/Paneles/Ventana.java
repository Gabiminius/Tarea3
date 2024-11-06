package Vistas;
import Vistas.Imagens.*;
import Vistas.Paneles.*;
import Vistas.botones.*;

import javax.swing.*;



public class Ventana extends JFrame {
    private Vistas.PanelPrincipal panelPrincipal = new Vistas.PanelPrincipal();
    public Ventana() {
        add(panelPrincipal);
        this.setTitle("Expendedor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);  // Establecer el tamaño de la ventana
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}


