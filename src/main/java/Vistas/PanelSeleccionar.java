package Vistas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import Vistas.Productos.*;

/**
 * La clase {@code PanelSeleccionar} representa un panel que permite al usuario seleccionar
 * entre diferentes productos para agregar al carrito de compras. El panel contiene botones
 * para seleccionar productos como Super8, Snickers, CocaCola, Fanta y Sprite.
 */
public class PanelSeleccionar extends JPanel {
    // Variables que representan los botones para cada producto
    private Seleccionador tipo;
    private BotonSuper8 boton1;
    private BotonSnickers boton2;
    private BotonCocacola boton3;
    private BotonFanta boton4;
    private BotonSprite boton5;

    /**
     * Constructor de la clase {@code PanelSeleccionar}.
     * Configura el diseño del panel, crea los botones para seleccionar productos y
     * los agrupa en un ButtonGroup para que sólo se pueda seleccionar uno a la vez.
     */
    public PanelSeleccionar() {
        setLayout(new GridLayout(2, 3)); // Configuración de diseño con 2 filas y 3 columnas

        // Inicialización de los botones de los productos
        boton1 = new BotonSuper8(this);
        boton2 = new BotonSnickers(this);
        boton3 = new BotonCocacola(this);
        boton4 = new BotonFanta(this);
        boton5 = new BotonSprite(this);

        // Crear un grupo de botones para asegurar que sólo se puede seleccionar uno
        ButtonGroup productos = new ButtonGroup();
        productos.add(boton1);
        productos.add(boton2);
        productos.add(boton3);
        productos.add(boton4);
        productos.add(boton5);

        // Añadir los botones al panel
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);

        // Establecer el fondo del panel como blanco
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
