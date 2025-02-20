import java.util.ArrayList;

public class GeneradorDeMadera extends Generador {
    public GeneradorDeMadera() {
        super(5, 3, 10, "madera");
    }

    @Override
    public void generarRecurso(ArrayList<Recursos> recursos) {
        for (Recursos r : recursos) {
            if (r.getTipo().equals("madera")) {
                r.incrementarCantidad(produccion);
            }
        }
    }
}
