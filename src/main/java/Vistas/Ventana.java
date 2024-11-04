package Vistas;
import javax.swing.*;



public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal=new PanelPrincipal();
    public Ventana() {
        add(panelPrincipal);
        pack(); // Ajustar el tamaño de la ventana al tamaño preferido de sus componentes
        this.setTitle("Expendedor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Ventana ventana= new Ventana();
    }



}


