import java.util.ArrayList;
import java.util.Scanner;

public class Recursos {
    private String tipo;
    private int cantidad;

    public Recursos(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
		return cantidad;
	}
    
    public String getTipo() {
		return tipo;
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

    
}