package Vistas.Deposito;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import Vistas.Imagenes.*;

/**
 * La clase {@code PanelDepositos} representa un contenedor de varios paneles de depósitos de productos,
 * organizados en una cuadrícula, cada uno de los cuales muestra un tipo específico de producto.
 * Incluye depósitos para los tipos de bebidas y dulces, así como un panel separado para monedas.
 */
public class PanelDepositos extends JPanel {
    private PanelDepositoT<SpriteIma> panelSprite;
    private PanelDepositoT<SnickersIma> panelSnickers;
    private PanelDepositoT<CocacolaIma> panelCoca;
    private PanelDepositoT<FantaIma> panelFanta;
    private PanelDepositoT<Super8Ima> panelSuper8;
    private PanelMonedas panelMonedas;

    /**
     * Constructor de la clase {@code PanelDepositos} que inicializa los paneles de productos y monedas.
     * Configura el diseño del panel y el fondo.
     *
     * @param size el tamaño de los depósitos, que determina la cantidad de productos iniciales en cada panel.
     */
    public PanelDepositos(int size) {
        setOpaque(false);
        this.setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 1, -20, -80));

        this.panelSprite = new PanelDepositoT<>(SpriteIma::new, size);
        this.panelSnickers = new PanelDepositoT<>(SnickersIma::new, size);
        this.panelCoca = new PanelDepositoT<>(CocacolaIma::new, size);
        this.panelFanta = new PanelDepositoT<>(FantaIma::new, size);
        this.panelSuper8 = new PanelDepositoT<>(Super8Ima::new, size);
        this.panelMonedas = new PanelMonedas();

        add(panelCoca);
        add(panelSprite);
        add(panelFanta);
        add(panelSnickers);
        add(panelSuper8);
        add(panelMonedas);

        this.setBackground(Color.black);
    }

    /**
     * Actualiza el panel de monedas añadiendo una representación gráfica de una nueva moneda.
     *
     * @param moneda la moneda que se añadirá al panel.
     */
    public void actualizarMonedas(Moneda moneda) {
        panelMonedas.AñadirMonedaGrafica(moneda);
    }

    /**
     * Rellena cada panel de depósito con sus respectivos productos, llenando todas las posiciones disponibles.
     */
    public void rellenarImagenes() {
        panelCoca.rellenarTodo();
        panelFanta.rellenarTodo();
        panelSprite.rellenarTodo();
        panelSnickers.rellenarTodo();
        panelSuper8.rellenarTodo();
    }

    /**
     * Elimina un producto de un depósito específico según la selección de producto.
     *
     * @param seleccion el producto seleccionado que se removerá del depósito correspondiente.
     */
    public void removeProducto(Seleccionador seleccion) {
        int i = seleccion.ordinal();
        switch (i) {
            case 0:
                panelCoca.removeProducto();
                break;
            case 1:
                panelFanta.removeProducto();
                break;
            case 2:
                panelSprite.removeProducto();
                break;
            case 3:
                panelSnickers.removeProducto();
                break;
            case 4:
                panelSuper8.removeProducto();
                break;
        }
    }
}

