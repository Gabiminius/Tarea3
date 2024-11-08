package Vistas.Deposito;
import java.awt.*;
import java.util.function.Supplier;
import javax.swing.*;

/**
 * La clase genérica {@code PanelDepositoT} representa un panel de depósito que puede contener múltiples componentes
 * de un tipo específico, definido por el parámetro de tipo {@code T}, el cual debe extender de {@code JComponent}.
 * Se utiliza principalmente para representar visualmente productos del depósito dentro de la interfaz gráfica.
 *
 * @param <T> el tipo de componente que se almacenará en este panel de depósito
 */
public class PanelDepositoT<T extends JComponent> extends JPanel {
    private Supplier<T> tipo; // Proveedor de instancias del tipo T
    private int size; // Tamaño máximo de elementos en el depósito

    /**
     * Constructor de la clase {@code PanelDepositoT}.
     * Inicializa el panel con una cantidad fija de componentes del tipo especificado.
     *
     * @param tipo un proveedor ({@link Supplier}) que genera instancias de {@code T} para ser añadidas al panel
     * @param size el tamaño máximo del depósito, que define cuántos elementos se pueden añadir
     */
    public PanelDepositoT(Supplier<T> tipo, int size) {
        this.size = size;
        this.setBackground(Color.ORANGE);
        this.tipo = tipo;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        for (int i = 0; i < 5; i++) {
            T imagen = tipo.get();
            add(imagen);
        }
        setOpaque(false);
        this.setBackground(Color.WHITE);
    }

    /**
     * Elimina el primer producto del panel si existe algún componente presente.
     * Actualiza la interfaz de usuario para reflejar la eliminación.
     */
    public void removeProducto() {
        if (this.getComponentCount() > 0) {
            this.remove(0);
            this.updateUI();
        }
    }

    /**
     * Rellena el panel con la cantidad máxima de componentes del tipo especificado,
     * eliminando cualquier componente existente previamente.
     */
    public void rellenarTodo() {
        this.removeAll();
        for (int i = 0; i < size; i++) {
            T imagen = tipo.get();
            add(imagen);
        }
    }
}

