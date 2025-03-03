import java.util.ArrayList;

public class GeneradorDeMadera extends Generador {
	public GeneradorDeMadera() {
        super(5, 2, 10, TipoRecursos.MADERA);
    }

    @Override
    public void generarRecurso(Recursos recurso) {
        recurso.incrementarCantidad(produccion);
    }

    @Override
    public void mostrarInformacionDelGenerador() {
        System.out.println("Generador de Madera - Nivel: " + nivel);
    }
}
