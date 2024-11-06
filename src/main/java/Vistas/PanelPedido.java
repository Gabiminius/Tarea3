package Vistas;

import Logica.*;
import javax.swing.*;
import java.awt.*;

public class PanelPedido extends JPanel {
    int cantidadCocacolas = 0;
    int cantidadSprites = 0;
    int cantidadFantas = 0;
    int cantidadSnickers = 0;
    int cantidadSuper8s = 0;

    private JLabel cuantasCocacolas;
    private JLabel cuantasSprites;
    private JLabel cuantasFantas;
    private JLabel cuantosSnickers;
    private JLabel cuantosSuper8s;

    /**
     * Constructor de la clase PanelPedido.
     */
    public PanelPedido() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Configuración de diseño vertical

        JLabel label = new JLabel("Tus Compras:");
        label.setFont(new Font("Arial", Font.BOLD, 15)); // Título estilizado
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrado en el panel

        cuantasCocacolas = new JLabel("Cocacola: 0");
        cuantasSprites = new JLabel("Sprite: 0");
        cuantasFantas = new JLabel("Fanta: 0");
        cuantosSnickers = new JLabel("Snickers: 0");
        cuantosSuper8s = new JLabel("Super8: 0");

        // Estilizar los textos de productos
        Font fontProducto = new Font("Arial", Font.PLAIN, 14);
        cuantasCocacolas.setFont(fontProducto);
        cuantasSprites.setFont(fontProducto);
        cuantasFantas.setFont(fontProducto);
        cuantosSnickers.setFont(fontProducto);
        cuantosSuper8s.setFont(fontProducto);

        // Alinear todos los elementos al centro
        cuantasCocacolas.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantasSprites.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantasFantas.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantosSnickers.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuantosSuper8s.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir los elementos al panel
        add(Box.createVerticalStrut(10)); // Espacio superior
        add(label);
        add(Box.createVerticalStrut(10)); // Espacio entre título y productos
        add(cuantasCocacolas);
        add(cuantasSprites);
        add(cuantasFantas);
        add(cuantosSnickers);
        add(cuantosSuper8s);
        setBackground(Color.WHITE); // Fondo blanco del panel
    }

    /**
     * Método que agrega un producto al carro.
     * En caso de que el producto ya esté en el carro, se aumenta la cantidad.
     * @param producto Producto comprado exitosamente y debe ser agregado al carro.
     */
    public void addProducto(Producto producto) {
        if (producto instanceof Cocacola) {
            cantidadCocacolas++;
            cuantasCocacolas.setText("Cocacola: " + cantidadCocacolas);
        } else if (producto instanceof Sprite) {
            cantidadSprites++;
            cuantasSprites.setText("Sprite: " + cantidadSprites);
        } else if (producto instanceof Fanta) {
            cantidadFantas++;
            cuantasFantas.setText("Fanta: " + cantidadFantas);
        } else if (producto instanceof Snickers) {
            cantidadSnickers++;
            cuantosSnickers.setText("Snickers: " + cantidadSnickers);
        } else if (producto instanceof Super8) {
            cantidadSuper8s++;
            cuantosSuper8s.setText("Super8: " + cantidadSuper8s);
        }
    }
}
