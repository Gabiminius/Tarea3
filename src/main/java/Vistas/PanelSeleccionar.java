package Vistas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import Vistas.Productos.*;

public class PanelSeleccionar extends JPanel {
    private Seleccionador tipo;
    private BotonSuper8 boton1;
    private BotonSnickers boton2;
    private BotonCocacola boton3;
    private BotonFanta boton4;
    private BotonSprite boton5;


    /**
     * Constructor de la clase JPanelSelect.
     */
    public PanelSeleccionar(){
        setLayout(new GridLayout(2, 3));
        boton1 = new BotonSuper8(this);
        boton2 = new BotonSnickers(this);
        boton3 = new BotonCocacola(this);
        boton4 = new BotonFanta(this);
        boton5 = new BotonSprite(this);


        ButtonGroup productos = new ButtonGroup();
        productos.add(boton1);
        productos.add(boton2);
        productos.add(boton3);
        productos.add(boton4);
        productos.add(boton5);

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        setBackground(Color.WHITE);

    }

    /**
     * Método que establece el tipo de producto seleccionado.
     * @param seleccionador Seleccionador (tipo de producto seleccionado).
     */
    public void setTipoProducto(Seleccionador seleccionador) {
        this.tipo = seleccionador;
    }

    /**
     * Método que retorna el tipo de producto seleccionado.
     * @return Selector (tipo de producto seleccionado).
     */
    public Seleccionador getTipoProducto() {
        return this.tipo;
    }
}
