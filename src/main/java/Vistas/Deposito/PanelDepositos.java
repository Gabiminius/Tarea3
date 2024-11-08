package Vistas.Deposito;
import Logica.*;
import javax.swing.*;
import java.awt.*;
import Vistas.Imagenes.*;





public class PanelDepositos extends JPanel {
    private PanelDepositoT<SpriteIma> panelSprite;
    private PanelDepositoT<SnickersIma> panelSnickers;
    private PanelDepositoT<CocacolaIma> panelCoca;
    private PanelDepositoT<FantaIma> panelFanta;
    private PanelDepositoT<Super8Ima> panelSuper8;
    private PanelMonedas panelMonedas;


    public PanelDepositos(int size){
        setOpaque(false);
        this.setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 1, -20, -80));

        this.panelSprite = new PanelDepositoT<>(SpriteIma::new, size);
        this.panelSnickers = new PanelDepositoT<>(SnickersIma::new, size);
        this.panelCoca = new PanelDepositoT<>(CocacolaIma::new, size);
        this.panelFanta = new PanelDepositoT<>(FantaIma::new, size);
        this.panelSuper8 = new PanelDepositoT<>(Super8Ima::new, size);
        this.panelMonedas = new PanelMonedas();
        add(panelCoca);
        add(panelSprite);
        add(panelFanta);
        add(panelSnickers);
        add(panelSuper8);
        add(panelMonedas);
        this.setBackground(Color.black);
    }


    public void actualizarMonedas(Moneda moneda){
        panelMonedas.AñadirMonedaGrafica(moneda);
    }


    public void rellenarImagenes(){
        panelCoca.rellenarTodo();
        panelFanta.rellenarTodo();
        panelSprite.rellenarTodo();
        panelSnickers.rellenarTodo();
        panelSuper8.rellenarTodo();
    }


    public void removeProducto(Seleccionador seleccion){
        int i = seleccion.ordinal();
        switch(i){
            case 0:
                panelCoca.removeProducto();
                break;
            case 1:
                panelFanta.removeProducto();
                break;
            case 2:
                panelSprite.removeProducto();
                break;
            case 3:
                panelSnickers.removeProducto();
                break;
            case 4:
                panelSuper8.removeProducto();
                break;
        }
    }
}
