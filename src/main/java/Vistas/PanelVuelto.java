package Vistas;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import Logica.*;


public class PanelVuelto extends JPanel {
    private ArrayList<Moneda> monedas;

    /**
     * Constructor de la clase PanelVuelto
     */
    public PanelVuelto(){
        monedas = new ArrayList<>();
        setLayout(new FlowLayout(FlowLayout.CENTER, -50, 10));
        setBackground(Color.WHITE);

    }

    /**
     * Método que recibe el vuelto del expendedor y lo muestra gráficamente.
     * @param monedasComprador Monedas que se añadirán al vuelto.
     */
    public void RecibirVuelto(ArrayList<Moneda> monedasComprador){
        removeAll();
        monedas.addAll(monedasComprador);
        Collections.sort(monedas, (Moneda m1, Moneda m2) -> m2.getValor() - m1.getValor());
        for(int i = 0 ; i < monedas.size() ; i++){
            JLabel label = new JLabel();
            ImageIcon icon = null;
            if(monedas.get(i).getValor() == 100){
                URL imagenURL = getClass().getClassLoader().getResource("moneda100.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            }
            else if(monedas.get(i).getValor() == 500){
                URL imagenURL = getClass().getClassLoader().getResource("moneda500.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            }
            else if(monedas.get(i).getValor() == 1000){
                URL imagenURL = getClass().getClassLoader().getResource("1000pesos.png");
                icon = new ImageIcon(new ImageIcon(imagenURL).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            }
            label.setIcon(icon);
            add(label);
            updateUI();

        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
