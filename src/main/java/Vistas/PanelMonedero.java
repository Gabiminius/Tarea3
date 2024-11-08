package Vistas;
import Logica.Moneda;
import javax.swing.*;
import Vistas.Monedas.*;

import java.awt.*;

/**
 * La clase {@code PanelMonedero} representa el panel que contiene los botones para seleccionar
 * monedas de diferentes valores (100, 500 y 1000) en una interfaz de usuario.
 * El panel permite al usuario seleccionar una moneda para realizar una compra.
 */
public class PanelMonedero extends JPanel {
    private Boton100 boton100;
    private Boton500 boton500;
    private Boton1000 boton1000;
    private Moneda moneda;

    /**
     * Constructor de la clase {@code PanelMonedero}.
     * Inicializa los botones para seleccionar monedas de diferentes valores
     * y agrega estos botones al panel utilizando un layout de tipo {@code GridLayout}.
     * Los botones son agrupados en un {@code ButtonGroup} para asegurar que solo
     * se pueda seleccionar una moneda a la vez.
     */
    public PanelMonedero() {
        // Establece el layout para organizar los botones en una cuadrícula
        setLayout(new GridLayout(2, 2, 0, 0));

        // Crea los botones para las diferentes monedas
        boton100 = new Boton100(this);
        boton500 = new Boton500(this);
        boton1000 = new Boton1000(this);

        // Agrupa los botones para que solo se pueda seleccionar uno a la vez
        ButtonGroup monedas = new ButtonGroup();
        monedas.add(boton100);
        monedas.add(boton500);
        monedas.add(boton1000);

        // Añade los botones al panel
        add(boton100);
        add(boton500);
        add(boton1000);

        // Establece el fondo blanco para el panel
        setBackground(Color.WHITE);
    }

    /**
     * Instancia el tipo de moneda que se seleccionó
     * @param moneda Moneda seleccionada.
     */
    public void setTipoMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * Retorna la moneda seleccionada.
     * @return Moneda seleccionada.
     */
    public Moneda getMoneda(){
        return this.moneda;
    }
}
