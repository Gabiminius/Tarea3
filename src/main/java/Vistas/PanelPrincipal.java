package Vistas;

import javax.swing.*;
import java.awt.*;


public class PanelPrincipal extends JPanel {
    public PanelComprador com;
    public PanelExpendedor exp;
    public PanelPrincipal () {
        exp = new PanelExpendedor ();
        com = new PanelComprador();
        this.setBackground(Color.gray);
    }
    public void paintComponent (Graphics g) { //todo se dibuja a partir de este método
        super.paintComponent(g); //llama al método pint al que hace override en la super clase
//el de la super clase solo pinta el fondo (background)
        com.paintComponent(g); //llama al metodo paintComponent definido en el PanelComprador
        exp.paintComponent(g); //llama al metodo paintComponent definido en el PanelExpendedor
    }
}




