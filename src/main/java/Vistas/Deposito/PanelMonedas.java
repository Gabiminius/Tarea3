package Vistas.Deposito;

import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;


public class PanelMonedas extends JPanel {
    private ArrayList<Integer> monedas = new ArrayList<>();


    public PanelMonedas(){
        setLayout(new FlowLayout(FlowLayout.CENTER, -10, 10));
        setOpaque(false);
    }


    public void AñadirMonedaGrafica(Moneda moneda){
        removeAll();  // Limpiar todos los componentes para actualizar el panel
        monedas.add(moneda.getValor());
        Collections.sort(monedas);  // Ordena las monedas para visualizarlas en orden


        for (int valorMoneda : monedas) {
            JLabel label = new JLabel();
            ImageIcon icon = null;
            if (valorMoneda == 100) {
                URL imagenURL = getClass().getClassLoader().getResource("moneda100.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            } else if (valorMoneda == 500) {
                URL imagenURL = getClass().getClassLoader().getResource("moneda500.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
            } else if (valorMoneda == 1000) {
                URL imagenURL = getClass().getClassLoader().getResource("1000pesos.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            }
            label.setIcon(icon);
            add(label);  // Añadir el JLabel al panel

        }

        revalidate();  // Refresca el diseño del panel después de añadir elementos
        repaint();     // Redibuja el panel para mostrar las nuevas monedas
    }


    public boolean tieneMonedas() {
        return !monedas.isEmpty();
    }

    public Integer getMoneda() {
        if (!monedas.isEmpty()) {
            return monedas.remove(0);  // Remueve y retorna la primera moneda
        }
        return null;
    }
}
