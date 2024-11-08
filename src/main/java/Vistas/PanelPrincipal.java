package Vistas;

import javax.swing.*;
import java.awt.*;


public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    private BotonCompra botonComprar;

    /**
     * Constructor de la clase PanelPrincipal.
     */
    public PanelPrincipal () {
        this.com = new PanelComprador();
        this.exp = new PanelExpendedor (5);
        this.botonComprar = new BotonCompra(exp,com);
        this.setBackground(Color.black);

        add(exp);
        add(botonComprar, BorderLayout.CENTER);
        add(com);
        setLayout(new FlowLayout());
    }

    /**
     * Método que se encarga de pintar los componentes del panel.
     * @param g
     */
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
    }
    }








