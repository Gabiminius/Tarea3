package Logica;

/**
 * Clase abstracta {@code Moneda} que representa una moneda.
 * Esta clase implementa la interfaz {@code Comparable} para permitir la
 * comparación entre diferentes monedas
 */
public abstract class Moneda implements Comparable<Moneda> {
protected int serie;
    public Moneda(int serie) {
        this.serie=serie;
    }

    /**
     * @return el valor de la moneda
     */
    public abstract int getValor();
    /**
     * @return el numero de serie de la moneda
     */
    public int getSerie(){
        return serie;
    }

    /**
     * Compara esta moneda con otra moneda.
     * @param otraMoneda la otra moneda a comparar
     * @return un valor negativo si esta moneda es menor,
     *cero si son iguales, o un valor positivo si esta moneda es mayor
     */
    @Override
    public int compareTo(Moneda otraMoneda) {
        return Integer.compare(this.getValor(), otraMoneda.getValor());
    }
}

