package Vistas;
import Logica.Moneda;
import javax.swing.*;
import Vistas.Monedas.*;

import java.awt.*;

public class PanelMonedero extends JPanel {
    private Boton100 boton100;
    private Boton500 boton500;
    private Boton1000 boton1000;
    private Moneda moneda;

    /**
     * Constructor de la clase PanelMonedero
     */
    public PanelMonedero() {
        setLayout(new GridLayout(2, 2, 0, 0));
        boton100 = new Boton100(this);
        boton500 = new Boton500(this);
        boton1000 = new Boton1000(this);


        ButtonGroup monedas = new ButtonGroup();
        monedas.add(boton100);
        monedas.add(boton500);
        monedas.add(boton1000);
        add(boton100);
        add(boton500);
        add(boton1000);
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
