package Vistas.Deposito;
import Logica.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;




public class DepositoE extends JPanel implements MouseListener {
    private Producto producto;
    private ImageIcon icon;

    public DepositoE(){
        this.setPreferredSize(new Dimension(130, 150));
        this.addMouseListener(this);
        this.setBackground(Color.black);

        setIcon();
    }


    private void setIcon() {
        if(producto == null) {
            icon = null;
        } else if (producto instanceof Cocacola) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/Coca-Cola.png").getImage().getScaledInstance(100,200, Image.SCALE_DEFAULT));
        } else if(producto instanceof Fanta) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/fanta.png").getImage().getScaledInstance(100,200, Image.SCALE_DEFAULT));
        } else if(producto instanceof Sprite) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/sprite.png").getImage().getScaledInstance(100,200, Image.SCALE_DEFAULT));
        } else if(producto instanceof Snickers) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/snickers.png").getImage().getScaledInstance(100,200, Image.SCALE_DEFAULT));
        } else if(producto instanceof Super8) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/super8.png").getImage().getScaledInstance(100,200, Image.SCALE_DEFAULT));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        //analizar que consiumio el comprador
        super.paintComponent(g);
        if(icon != null) {
            g.drawImage(icon.getImage(), 0, 0,getWidth(), getHeight(), this);
        }
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
        setIcon();
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        setProducto(null);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(producto != null)
            JOptionPane.showMessageDialog(this, "N° de serie: " + producto.getSerie());
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
