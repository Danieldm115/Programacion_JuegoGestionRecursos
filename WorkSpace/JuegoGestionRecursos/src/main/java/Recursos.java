import java.util.*;

public class Recursos {
    private TipoRecursos tipo;
    private int cantidad;

    public Recursos(TipoRecursos tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public void incrementarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void decrementarCantidad(int cantidad) {
        this.cantidad -= cantidad;
    }

    public boolean quedaRecurso() {
        return this.cantidad > 0;
    }

    public boolean quedariaRecurso(int cantidad) {
        return this.cantidad - cantidad >= 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public TipoRecursos getTipo() {
        return tipo;
    }
}