package Logica;

/**
 * Clase {@code Moneda500} que representa una moneda con un valor fijo de 500 .
 * Hereda de la clase abstracta {@code Moneda} e implementa el método {@code getValor}
 * para devolver el valor específico de esta moneda.
 *
 * <p>Incluye un constructor que inicializa la moneda con un número de serie
 * único, que se pasa como parámetro.
 */
public class Moneda500 extends Moneda {
    public Moneda500(int serie) {
        super(serie);
    }

    /**
     * @return el valor de la moneda, que es 500
     */
    @Override
    public int getValor() {
        return 500;
    }
}

