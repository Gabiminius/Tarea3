package Logica;

/**
 * Clase {@code Moneda1000} que representa una moneda con un valor fijo de 1000.
 * Hereda de la clase abstracta {@code Moneda} e implementa el método {@code getValor}
 * para devolver el valor específico de esta moneda.
 *
 * <p>Incluye un constructor que inicializa la moneda con un número de serie
 * único, que se pasa como parámetro.
 */
public class Moneda1000 extends Moneda {
    public Moneda1000(int serie) {
        super(serie);
    }

    /**
     * @return el valor de la moneda, que es 1000
     */
    @Override
    public int getValor() {
        return 1000;
    }
}
