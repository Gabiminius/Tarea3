package Vistas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import Vistas.Deposito.DepositoE;

/**
 * La clase {@code BotonCompra} representa un botón que gestiona la acción de compra en el sistema del expendedor.
 * Al hacer clic en el botón, se realiza el proceso de verificación y compra de un producto en el expendedor,
 * gestionando las monedas, el producto seleccionado y actualizando el estado de los paneles de selección y monedero.
 */
public class BotonCompra extends JButton {
    private Expendedor expendedor;
    private PanelSeleccionar comPanel;
    private PanelMonedero monedero;
    private Seleccionador seleccion;
    private Moneda moneda;
    private Comprador comprador;
    private DepositoE depositoEspecial;
    private JButton BotonComprar = new JButton("Compra");

    /**
     * Constructor de la clase {@code BotonCompra}.
     * Configura el botón de compra, asociando los paneles de expendedor y comprador,
     * y define el comportamiento al hacer clic en el botón.
     *
     * @param panelExpendedor el panel que contiene el expendedor y el depósito especial.
     * @param panelComprador el panel que contiene la información del comprador y su monedero.
     */
    public BotonCompra(PanelExpendedor panelExpendedor, PanelComprador panelComprador) {
        this.expendedor = panelExpendedor.getExpendedor();
        this.comPanel = panelComprador.getPanel();
        this.monedero = panelComprador.getMonedero();
        this.depositoEspecial = panelExpendedor.getDepositoE();
        add(BotonComprar);
        this.setBackground(Color.green);

        // Define el comportamiento del botón cuando se hace clic.
        BotonComprar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Obtiene la selección del producto y la moneda del comprador
                    seleccion = comPanel.getTipoProducto();
                    moneda = monedero.getMoneda();
                    comprador = new Comprador(moneda, seleccion, expendedor);

                    // Actualiza el depósito especial y el panel de depósitos
                    depositoEspecial.setProducto(expendedor.getProducto());
                    panelExpendedor.getPanelDepositos().removeProducto(seleccion);

                    // Mueve el producto al bolsillo del comprador
                    panelComprador.getBolsillo().addProducto(expendedor.getProducto());
                    panelExpendedor.getPanelDepositos().actualizarMonedas(moneda);

                    // Actualiza el bolsillo con el vuelto
                    panelComprador.ActualizarBolsilloVuelto(comprador.getMonedasVuelto());
                } catch (PagoIncorrectoException ex) {
                    // Maneja el caso cuando no se ha seleccionado ninguna moneda
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una moneda.");
                } catch (NoHayProductoException ex) {
                    // Maneja el caso cuando no hay stock o el producto no existe
                    Moneda moneda = expendedor.getVuelto();
                    JOptionPane.showMessageDialog(null, "No hay stock o el producto no existe. \nVuelto: " + moneda.getValor());
                    ArrayList<Moneda> monedas = new ArrayList<>();
                    monedas.add(moneda);
                    panelComprador.ActualizarBolsilloVuelto(monedas);
                } catch (PagoInsuficienteException ex) {
                    // Maneja el caso cuando el pago es insuficiente
                    Moneda moneda = expendedor.getVuelto();
                    JOptionPane.showMessageDialog(null, "El pago es insuficiente. \nVuelto: " + moneda.getValor());
                    ArrayList<Moneda> monedas = new ArrayList<>();
                    monedas.add(moneda);
                    panelComprador.ActualizarBolsilloVuelto(monedas);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) { //presionado

            }

            @Override
            public void mouseReleased(MouseEvent e) { //soltado

            }

            @Override
            public void mouseEntered(MouseEvent e) { //entra (por encima)

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
