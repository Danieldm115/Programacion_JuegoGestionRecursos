
public class GeneradorDePiedra extends Generador {
    public GeneradorDePiedra() {
        super(3, 3, 15, TipoRecursos.PIEDRA);
    }

    @Override
    public void generarRecurso(Recursos recurso) {
        recurso.incrementarCantidad(produccion);
    }

    @Override
    public void mostrarInformacionDelGenerador() {
        System.out.println("Generador de Piedra - Nivel: " + nivel);
    }
}