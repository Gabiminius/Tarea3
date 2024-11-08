package Vistas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import Vistas.Deposito.*;




public class PanelExpendedor extends JPanel implements MouseListener {
    private Expendedor exp;
    private PanelDepositos panelDepositos;
    private DepositoE depositoEspecial;
    private ImageIcon icono;
    private Image fondo;


    public PanelExpendedor(int size) {
        this.exp = new Expendedor(size);
        this.panelDepositos = new PanelDepositos(size);
        panelDepositos.setPreferredSize(new Dimension(480,570));
        depositoEspecial = new DepositoE();
        add(depositoEspecial);
        add(panelDepositos);



        this.addMouseListener(this);
        URL imagenUrl = getClass().getClassLoader().getResource("expendedor4.png");
        ImageIcon icono = new ImageIcon(new ImageIcon(imagenUrl).getImage().getScaledInstance(110, 90, Image.SCALE_DEFAULT));
        fondo = icono.getImage();
        this.setBackground(Color.black);

    }

    // Getters para que las otras clases puedan acceder a los componentes.
    public Expendedor getExpendedor(){
        return exp;
    }
    public PanelDepositos getPanelDepositos(){
        return panelDepositos;
    }
    public DepositoE getDepositoE(){
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
            g.drawImage(fondo, -34, 0, this.getWidth(), this.getHeight(), this);
        }

    }


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
