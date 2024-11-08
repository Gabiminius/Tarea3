package Vistas;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import Vistas.Deposito.DepositoE;

public class BotonCompra extends JButton {
    private Expendedor expendedor;
    private PanelSeleccionar comPanel;
    private PanelMonedero monedero;
    private Seleccionador seleccion;
    private Moneda moneda;
    private Comprador comprador;
    private DepositoE depositoEspecial;
    private JButton BotonComprar= new JButton("Compra");


    public BotonCompra(PanelExpendedor panelExpendedor, PanelComprador panelComprador) {
        this.expendedor = panelExpendedor.getExpendedor();
        this.comPanel = panelComprador.getPanel();
        this.monedero = panelComprador.getMonedero();
        this.depositoEspecial = panelExpendedor.getDepositoE();
        add(BotonComprar);
        this.setBackground(Color.green);



        BotonComprar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    seleccion = comPanel.getTipoProducto();
                    moneda = monedero.getMoneda();
                    comprador = new Comprador(moneda, seleccion, expendedor);
                    depositoEspecial.setProducto(expendedor.getProducto());
                    panelExpendedor.getPanelDepositos().removeProducto(seleccion);
                    panelComprador.getBolsillo().addProducto(expendedor.getProducto());
                    panelExpendedor.getPanelDepositos().actualizarMonedas(moneda);
                    panelComprador.ActualizarBolsilloVuelto(comprador.getMonedasVuelto());
                } catch (PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una moneda.");
                } catch(NoHayProductoException ex) {
                    Moneda moneda = expendedor.getVuelto();
                    JOptionPane.showMessageDialog(null, "No hay stock o el producto no existe. \nVuelto: " + moneda.getValor());
                    ArrayList<Moneda> monedas = new ArrayList<>();
                    monedas.add(moneda);
                    panelComprador.ActualizarBolsilloVuelto(monedas);
                } catch(PagoInsuficienteException ex) {
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
