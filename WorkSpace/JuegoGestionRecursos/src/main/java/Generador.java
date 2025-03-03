import java.util.ArrayList;

public abstract class Generador {
    protected int produccion;
    protected int costeMantenimiento;
    protected int costeMejora;
    protected int nivel;
    protected TipoRecursos recursoGenerados;

    public Generador(int produccion, int costeMantenimiento, int costeMejora, TipoRecursos recursoGenerado) {
        this.produccion = produccion;
        this.costeMantenimiento = costeMantenimiento;
        this.costeMejora = costeMejora;
        this.nivel = 1;
        this.recursoGenerados = recursoGenerado;
    }

    public void mejorarGenerador() {
        if (nivel < 3) {
            nivel++;
            produccion *= 2;
            costeMantenimiento *= 2;
            costeMejora *= 2;
        }
    }

    public abstract void generarRecurso(Recursos recurso);
    public abstract void mostrarInformacionDelGenerador();
}