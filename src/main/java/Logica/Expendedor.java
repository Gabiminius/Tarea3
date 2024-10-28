package Logica;

import java.util.ArrayList;

/**
 * @author Gabriela Escalona
 * @author Valentina Serón
 * @version version 2, 03 de octubre 2024
 * */

public class Expendedor {
    private Deposito <Producto> coca;
    private Deposito <Producto> sprite;
    private Deposito <Producto> fanta;
    private Deposito <Producto> snickers;
    private Deposito <Producto> super8;
    private Deposito <Producto> alfajores;
    private ArrayList<Deposito<Producto>> depositos;
    private Deposito<Moneda> monedaPago;
    private Deposito<Moneda> monedaVuelto;
    private int c = 100;
    private int size;
    private Producto producto; //Será el producto que se retornará

    /**
     * Constructor de la clase
     * @param size cantidad de productos para los depositos.
     */
    public Expendedor(int size){
        this.size = size;
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        alfajores = new Deposito<>();
        depositos = new ArrayList<>();
        monedaPago = new Deposito<>();
        monedaVuelto = new Deposito<>();

        depositos.add(coca);
        depositos.add(sprite);
        depositos.add(fanta);
        depositos.add(snickers);
        depositos.add(super8);
        depositos.add(alfajores);

        for(Seleccionador p : Seleccionador.values()){
            for(int i = 0; i < size; i++){
                Producto producto = p.crearProducto(i+c);
                depositos.get(p.ordinal()).addProducto(producto);
            }
            c+= 100;
        }

    }

    /** Método que rellena los depositos de productos. */
    public void rellenarDepositos() {
        if (coca.size() < size) {
            for (int i = coca.size(); i < size; i++) {
                Producto producto = Seleccionador.COCACOLA.crearProducto(i+c);
                coca.addProducto(producto);
                c++;
            }
        }
        if (sprite.size() < size) {
            for (int i = sprite.size(); i < size; i++) {
                Producto producto = Seleccionador.SPRITE.crearProducto(i+c);
                sprite.addProducto(producto);
                c++;
            }
        }
        if (fanta.size() < size) {
            for (int i = fanta.size(); i < size; i++) {
                Producto producto = Seleccionador.FANTA.crearProducto(i+c);
                fanta.addProducto(producto);
                c++;
            }
        }
        if (snickers.size() < size) {
            for (int i = snickers.size(); i < size; i++) {
                Producto producto = Seleccionador.SNICKERS.crearProducto(i+c);
                snickers.addProducto(producto);
                c++;
            }
        }
        if (super8.size() < size) {
            for (int i = super8.size(); i < size; i++) {
                Producto producto = Seleccionador.SUPER8.crearProducto(i+c);
                super8.addProducto(producto);
                c++;
            }
        }

    }

    /**
     * Método que saca un producto de los depositos de Expendedor, en el caso de que sea una compra exitosa.
     * @param pago moneda ingresada.
     * @param eleccion producto seleccionado.
     * @return deposito de productos.
     */
    public void comprarProducto (Moneda pago, Seleccionador eleccion) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException{
        int i = eleccion.ordinal();
        if(pago == null){
            throw new PagoIncorrectoException("El pago es incorrecto.");
        }
        else if(pago.getValor() < eleccion.getprecio()){
            monedaVuelto.addProducto(pago);
            throw new PagoInsuficienteException("El pago es insuficiente.");
        }
        else if( depositos.get(eleccion.ordinal()).isEmpty() ){
            monedaVuelto.addProducto(pago);
            throw new NoHayProductoException("No hay producto." + eleccion.toString().toLowerCase());
        }
        else {
            int vuelto = (pago.getValor() - eleccion.getprecio()) / 100;
            for (int j = 0; j < vuelto; j++) {
                monedaVuelto.addProducto(new Moneda100(j + 1));
            }
            producto = depositos.get(i).getProducto();
            monedaPago.addProducto(pago);
        }
    }

    /**
     * Método que retorna el producto comprado.
     * @return producto.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Método que retorna una moneda del depositos para el vuelto.
     * @return una moneda.
     */
    public Moneda getVuelto() {
        Moneda m = monedaVuelto.getProducto();
        return m;
    }
}

