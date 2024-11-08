package Vistas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import Vistas.Deposito.*;
/**
 * La clase {@code PanelExpendedor} representa el panel principal donde se muestra el expendedor de productos,
 * gestionando la visualización de los depósitos, el depósito especial y el fondo del expendedor.
 * Implementa la interfaz {@code MouseListener} para gestionar eventos de mouse.
 */
public class PanelExpendedor extends JPanel implements MouseListener {
    private Expendedor exp;
    private PanelDepositos panelDepositos;
    private DepositoE depositoEspecial;
    private ImageIcon icono;
    private Image fondo;

    /**
     * Constructor de la clase {@code PanelExpendedor}.
     * Inicializa los componentes visuales relacionados con el expendedor,
     * los depósitos y el fondo. Establece el tamaño del panel y añade los componentes
     * necesarios al panel principal.
     * @param size tamaño de los depósitos del expendedor.
     */
    public PanelExpendedor(int size) {
        // Inicializa el expendedor y los depósitos
        this.exp = new Expendedor(size);
        this.panelDepositos = new PanelDepositos(size);
        panelDepositos.setPreferredSize(new Dimension(480, 570));
        depositoEspecial = new DepositoE();

        // Añade los componentes al panel principal
        add(depositoEspecial);
        add(panelDepositos);

        // Agrega el listener de mouse para detectar interacciones del usuario
        this.addMouseListener(this);

        // Carga y ajusta el fondo del expendedor
        URL imagenUrl = getClass().getClassLoader().getResource("expendedor4.png");
        ImageIcon icono = new ImageIcon(new ImageIcon(imagenUrl).getImage().getScaledInstance(110, 90, Image.SCALE_DEFAULT));
        fondo = icono.getImage();

        // Establece el color de fondo del panel principal
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
