package Vistas;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import Logica.*;
/**
 * La clase {@code PanelVuelto} representa un panel donde se muestra el vuelto recibido
 * por el expendedor en forma de monedas. Las monedas se ordenan de mayor a menor valor
 * y se representan gráficamente con imágenes.
 */
public class PanelVuelto extends JPanel {
    // Lista que almacena las monedas del vuelto
    private ArrayList<Moneda> monedas;

    /**
     * Constructor de la clase {@code PanelVuelto}.
     * Inicializa la lista de monedas y configura el diseño del panel.
     */
    public PanelVuelto() {
        monedas = new ArrayList<>(); // Inicializa la lista de monedas
        setLayout(new FlowLayout(FlowLayout.CENTER, -50, 10)); // Configura el diseño en flujo centrado
        setBackground(Color.WHITE); // Establece el color de fondo del panel
    }

    /**
     * Método que recibe el vuelto del expendedor y lo muestra gráficamente.
     * Las monedas se ordenan de mayor a menor valor antes de ser mostradas.
     * @param monedasComprador Lista de monedas que se añadirán al vuelto.
     */
    public void RecibirVuelto(ArrayList<Moneda> monedasComprador) {
        removeAll(); // Elimina todos los componentes actuales del panel
        monedas.addAll(monedasComprador); // Añade las monedas recibidas
        Collections.sort(monedas, (Moneda m1, Moneda m2) -> m2.getValor() - m1.getValor()); // Ordena las monedas de mayor a menor valor

        // Itera sobre la lista de monedas y las añade al panel
        for (int i = 0; i < monedas.size(); i++) {
            JLabel label = new JLabel(); // Crea una etiqueta para la moneda
            ImageIcon icon = null; // Variable para almacenar el icono de la moneda

            // Verifica el valor de la moneda y asigna la imagen correspondiente
            if (monedas.get(i).getValor() == 100) {
                URL imagenURL = getClass().getClassLoader().getResource("moneda100.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            } else if (monedas.get(i).getValor() == 500) {
                URL imagenURL = getClass().getClassLoader().getResource("moneda500.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            } else if (monedas.get(i).getValor() == 1000) {
                URL imagenURL = getClass().getClassLoader().getResource("1000pesos.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            }

            label.setIcon(icon); // Establece el icono de la moneda en la etiqueta
            add(label); // Añade la etiqueta al panel
            updateUI(); // Actualiza la interfaz gráfica del panel
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
