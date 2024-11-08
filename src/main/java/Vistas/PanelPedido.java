package Vistas;

import Logica.*;
import javax.swing.*;
import java.awt.*;

/**
 * La clase {@code PanelPedido} representa un panel en la interfaz de usuario que muestra los productos
 * que un comprador ha añadido a su carrito. El panel muestra la cantidad de cada producto que ha sido
 * comprado (Cocacola, Sprite, Fanta, Snickers y Super8), y actualiza los contadores de manera dinámica
 * cuando un producto es añadido.
 */
public class PanelPedido extends JPanel {
    // Variables para almacenar la cantidad de cada producto
    int cantidadCocacolas = 0;
    int cantidadSprites = 0;
    int cantidadFantas = 0;
    int cantidadSnickers = 0;
    int cantidadSuper8s = 0;

    // Etiquetas que muestran la cantidad de cada producto
    private JLabel cuantasCocacolas;
    private JLabel cuantasSprites;
    private JLabel cuantasFantas;
    private JLabel cuantosSnickers;
    private JLabel cuantosSuper8s;

    /**
     * Constructor de la clase {@code PanelPedido}.
     * Configura el diseño vertical del panel, establece los títulos y etiquetas para cada producto,
     * y estiliza los textos y colores de los productos mostrados en el carrito.
     */
    public PanelPedido() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Configuración de diseño vertical

        // Título del panel
        JLabel label = new JLabel("    Tus Compras:");
        label.setFont(new Font("Arial", Font.BOLD, 20)); // Título estilizado
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrado en el panel
        label.setForeground(Color.white);

        // Inicialización de las etiquetas de los productos
        cuantasCocacolas = new JLabel("    Cocacola: 0");
        cuantasSprites = new JLabel("Sprite: 0");
        cuantasFantas = new JLabel("Fanta: 0");
        cuantosSnickers = new JLabel("    Snickers: 0");
        cuantosSuper8s = new JLabel("  Super8: 0");

        // Estilización de las etiquetas de productos
        Font fontProducto = new Font("Arial", Font.ITALIC, 20);
        cuantasCocacolas.setFont(fontProducto);
        cuantasSprites.setFont(fontProducto);
        cuantasFantas.setFont(fontProducto);
        cuantosSnickers.setFont(fontProducto);
        cuantosSuper8s.setFont(fontProducto);

        // Colores de cada producto
        cuantasCocacolas.setForeground(Color.RED);   // Cambia el color de la Coca-Cola a rojo
        cuantasSprites.setForeground(Color.GREEN);   // Cambia el color de Sprite a verde
        cuantasFantas.setForeground(Color.ORANGE);   // Cambia el color de Fanta a naranja
        cuantosSnickers.setForeground(Color.MAGENTA); // Cambia el color de Snickers a magenta
        cuantosSuper8s.setForeground(Color.PINK);    // Cambia el color de Super8 a rosa

        // Alineación de las etiquetas al centro
        cuantasCocacolas.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantasSprites.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantasFantas.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantosSnickers.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantosSuper8s.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir los elementos al panel con espaciado adecuado
        add(Box.createVerticalStrut(10)); // Espacio superior
        add(label);
        add(Box.createVerticalStrut(10)); // Espacio entre título y productos
        add(cuantasCocacolas);
        add(cuantasSprites);
        add(cuantasFantas);
        add(cuantosSnickers);
        add(cuantosSuper8s);

        setBackground(Color.black); // Fondo negro del panel
    }

    /**
     * Método que agrega un producto al carrito de compras.
     * Si el producto ya está en el carrito, se incrementa la cantidad correspondiente.
     *
     * @param producto Producto que ha sido comprado y debe ser añadido al carrito.
     */
    public void addProducto(Producto producto) {
        // Verifica el tipo de producto y actualiza la cantidad correspondiente
        if (producto instanceof Cocacola) {
            cantidadCocacolas++;
            cuantasCocacolas.setText("  Cocacola: " + cantidadCocacolas);
        } else if (producto instanceof Sprite) {
            cantidadSprites++;
            cuantasSprites.setText("Sprite: " + cantidadSprites);
        } else if (producto instanceof Fanta) {
            cantidadFantas++;
            cuantasFantas.setText("Fanta: " + cantidadFantas);
        } else if (producto instanceof Snickers) {
            cantidadSnickers++;
            cuantosSnickers.setText("  Snickers: " + cantidadSnickers);
        } else if (producto instanceof Super8) {
            cantidadSuper8s++;
            cuantosSuper8s.setText("Super8: " + cantidadSuper8s);
        }
    }
}