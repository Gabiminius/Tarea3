package Vistas.Deposito;
import Logica.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;

/**
 * La clase {@code DepositoE} representa un panel que contiene un producto,
 * mostrando su imagen cuando está presente y permitiendo al usuario interactuar
 * con el panel mediante clics y eventos de ratón.
 */
public class DepositoE extends JPanel implements MouseListener {
    private Producto producto;
    private ImageIcon icon;

    /**
     * Constructor de la clase {@code DepositoE}. Inicializa el panel con un
     * tamaño predeterminado y un fondo negro. Añade el evento de ratón y configura el ícono.
     */
    public DepositoE() {
        this.setPreferredSize(new Dimension(120, 150));
        this.addMouseListener(this);
        this.setBackground(Color.black);
        setIcon();
    }

    /**
     * Configura el ícono según el tipo de producto presente en el depósito.
     * Si el producto es nulo, el ícono no se muestra.
     */
    private void setIcon() {
        if (producto == null) {
            icon = null;
        } else if (producto instanceof Cocacola) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/Coca-Cola.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
        } else if (producto instanceof Fanta) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/fanta.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
        } else if (producto instanceof Sprite) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/sprite.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
        } else if (producto instanceof Snickers) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/snickers.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
        } else if (producto instanceof Super8) {
            icon = new ImageIcon(new ImageIcon("src/main/resources/super8.png").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
        }
    }

    /**
     * Sobreescribe el método de renderizado del panel para mostrar la imagen del producto,
     * si está presente.
     *
     * @param g el contexto gráfico usado para renderizar la imagen del producto.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (icon != null) {
            g.drawImage(icon.getImage(), 20, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Asigna un producto al depósito y actualiza el ícono para reflejar el producto actual.
     *
     * @param producto el producto a asignar.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
        setIcon();
        repaint();
    }

    /**
     * Evento que se ejecuta al hacer clic en el panel. Si se hace clic,
     * el producto se elimina del depósito.
     *
     * @param e el evento del ratón.
     */
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

    /**
     * Evento que se activa cuando el ratón entra en el panel.
     * Muestra un mensaje con el número de serie del producto si está presente.
     *
     * @param e el evento del ratón.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (producto != null) {
            JOptionPane.showMessageDialog(this, "N° de serie: " + producto.getSerie());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

