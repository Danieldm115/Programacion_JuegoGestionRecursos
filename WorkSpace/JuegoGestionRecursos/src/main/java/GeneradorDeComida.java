
public class GeneradorDeComida extends Generador {
    public GeneradorDeComida() {
        super(8, 4, 20, TipoRecursos.COMIDA);
    }

    @Override
    public void generarRecurso(Recursos recurso) {
        recurso.incrementarCantidad(produccion);
    }

    @Override
    public void mostrarInformacionDelGenerador() {
        System.out.println("Generador de Comida - Nivel: " + nivel);
    }
}
