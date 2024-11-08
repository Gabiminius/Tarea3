package Vistas.Deposito;
import java.awt.*;
import java.util.function.Supplier;
import javax.swing.*;

public class PanelDepositoT <T extends JComponent> extends JPanel {
    //Permite crear un objeto de tipo T
    private Supplier<T> tipo;
    private int size;


    public PanelDepositoT(Supplier<T> tipo, int size) {
        this.size = size;
        this.setBackground(Color.ORANGE);
        this.tipo = tipo;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        for(int i = 0; i < 5; i++) {
            T imagen = tipo.get();
            add(imagen);
        }
        setOpaque(false);
        this.setBackground(Color.WHITE);
    }


    public void removeProducto(){
        if(this.getComponentCount() > 0){
            this.remove(0);
            this.updateUI();
        }
    }


    public void rellenarTodo() {
        this.removeAll();
        for(int i = 0; i < size; i++) {
            T imagen = tipo.get();
            add(imagen);
        }
    }
}
