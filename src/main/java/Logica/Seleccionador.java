package Logica;

/**
 * Enumeración {@code Seleccionador} que define los diferentes productos disponibles
 * en el expendedor, incluyendo tipos de bebidas y dulces. Cada producto en la enumeración
 * tiene un precio fijo asociado y un método para crear instancias de dicho producto
 * a partir de un número de serie.
 *
 * <p>Cada constante en {@code Seleccionador} representa un tipo de producto y
 * permite la creación de dicho producto con un número de serie específico usando
 * el método {@code crearProducto}.
 */
public enum Seleccionador {
    COCACOLA(1000){
        @Override
        public Producto crearProducto(int serie){
            return new Cocacola(serie);
        }
    },
    FANTA(1000){
        @Override
        public Producto crearProducto(int serie){
            return new Fanta(serie);
        }
    },
    SPRITE(1000){
        @Override
        public Producto crearProducto(int serie){
            return new Sprite(serie);
        }
    },
    SNICKERS(500){
        @Override
        public Producto crearProducto(int serie){
            return new Snickers(serie);
        }
    },
    SUPER8(300){
        @Override
        public Producto crearProducto(int serie){
            return new Super8(serie);
        }
    };
    private final int precio;
    /**
     * Constructor de la clase Selector
     * @param precio Precio del producto
     */
    Seleccionador(int precio){
        this.precio = precio;
    }
    /**
     * Método que regresa el precio de un producto.
     * @return Retorna el precio de un producto
     */
    public int getprecio(){
        return precio;
    }

    /**
     * Método que crea un producto.
     * @param serie Número de serie del producto.
     * @return Retorna un producto
     */
    public abstract Producto crearProducto(int serie);

}
