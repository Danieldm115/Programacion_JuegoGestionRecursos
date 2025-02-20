import java.util.ArrayList;

abstract class Generador {
    protected int produccion;
    protected int mantenimiento;
    protected int costeMejora;
    protected int nivel;
    protected String recursoGenerado;

    public Generador(int produccion, int mantenimiento, int costeMejora, String recursoGenerado) {
        this.produccion = produccion;
        this.mantenimiento = mantenimiento;
        this.costeMejora = costeMejora;
        this.nivel = 1;
        this.recursoGenerado = recursoGenerado;
    }

    public void mejorarGenerador() {
        if (nivel < 3) {
            nivel++;
            produccion *= 2;
            mantenimiento *= 2;
            costeMejora *= 2;
            System.out.println("Generador mejorado a nivel " + nivel);
        } else {
            System.out.println("Este generador ya está al máximo nivel.");
        }
    }
    
    public abstract void generarRecurso(ArrayList<Recursos> recursos);

    public void mostrarInformacion() {
        System.out.println("Generador de " + recursoGenerado + " - Nivel: " + nivel + " - Producción: " + produccion);
    }
}