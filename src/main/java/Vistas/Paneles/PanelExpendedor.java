package Vistas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

/**
 * Clase que representa el panel del Expendedor con todos sus elementos.
 */
public class PanelExpendedor extends JPanel implements MouseListener {
    private Expendedor exp;
    private JPanelDepositos panelDepositos;
    private DepositoEspecial depositoEspecial;
    private ImageIcon icono;
    private Image fondo;

    /**
     * Constructor de la clase PanelExpendedor.
     * @param size Tamaño del expendedor.
     */
    public PanelExpendedor(int size) {
        this.exp = new Expendedor(size);
        this.panelDepositos = new JPanelDepositos(size);
        panelDepositos.setPreferredSize(new Dimension(375,500));
        depositoEspecial = new DepositoEspecial();
        add(depositoEspecial);
        add(panelDepositos);

        this.addMouseListener(this);
        URL imagenUrl = getClass().getClassLoader().getResource("expendedor.png");
        ImageIcon icono = new ImageIcon(new ImageIcon(imagenUrl).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        fondo = icono.getImage();

    }

    // Getters para que las otras clases puedan acceder a los componentes.
    public Expendedor getExpendedor(){
        return exp;
    }
    public JPanelDepositos getPanelDepositos(){
        return panelDepositos;
    }
    public DepositoEspecial getDepositoEspecial(){
        return depositoEspecial;
    }

    /*
     * Método que se encarga de pintar los componentes del panel.
     * Dibuja la imagen de fondo y los componentes del panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        }

    }

    /**
     * Se invoca cuando se hace click en el PanelExpendedor desde la clase PanelPrincipal.
     * Se encarga de rellenar los depósitos y las imágenes de los depósitos.
     * @param e Evento de mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        exp.rellenarDepositos();
        panelDepositos.rellenarImagenes();
        updateUI();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
