package Vistas;
import Logica.*;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelComprador extends JPanel {
    private PanelSeleccionar panel;
    private PanelMonedero monedero;
    private PanelVuelto vuelto;
    private PanelPedido bolsillo;


    public PanelComprador() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        panel = new PanelSeleccionar();
        panel.setPreferredSize(new Dimension(600, 295));
        panel.setBorder(new LineBorder(Color.cyan, 5));
        JPanel panelAjustado = new JPanel(new FlowLayout());

        panelAjustado.add(panel);


        monedero = new PanelMonedero();
        monedero.setPreferredSize(new Dimension(260, 300));
        monedero.setBorder(new LineBorder(Color.cyan, 5));
        monedero.setBackground(Color.white);
        JPanel monederoAjustado = new JPanel(new FlowLayout());
        monederoAjustado.add(monedero);
        monederoAjustado.setOpaque(false);//Para que se vea el fondo de la ventana


        bolsillo = new PanelPedido();
        bolsillo.setPreferredSize(new Dimension(160, 130));


        vuelto = new PanelVuelto();
        vuelto.setPreferredSize(new Dimension(400, 200));
        vuelto.setBorder(new LineBorder(Color.cyan, 5));


        add(bolsillo);
        add(vuelto);
        add(panelAjustado);
        add(monederoAjustado);
        this.setBackground(Color.black);

    }
    //Getters para que las otras clases de package vistas puedan acceder a estos elementos.
    public PanelSeleccionar getPanel(){
        return panel;
    }
    public PanelMonedero getMonedero(){
        return monedero;
    }
    public PanelPedido getBolsillo(){
        return bolsillo;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void ActualizarBolsilloVuelto(ArrayList<Moneda> monedasComprador){
        vuelto.RecibirVuelto(monedasComprador);
        updateUI();
    }
}
