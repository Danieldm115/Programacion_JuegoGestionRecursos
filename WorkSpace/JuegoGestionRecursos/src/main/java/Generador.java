
public abstract class Generador {
    private int cantidadProducidaPorTurno;
    private int costeMantenimiento;
    private int costeMejora;
    private int nivelGenerador;

    public Generador(int cantidadProducidaPorTurno, int costeMantenimiento, int costeMejora) {
        this.cantidadProducidaPorTurno = cantidadProducidaPorTurno;
        this.costeMantenimiento = costeMantenimiento;
        this.costeMejora = costeMejora;
        this.nivelGenerador = 1;
    }

    public abstract  void mejorarGenerador(Recurso recurso);

    public abstract int generarRecurso(Recurso recursoMantenimiento);

    public abstract void mostrarInformacionDelGenerdador();

    public abstract TipoRecurso getTipoRecurso();
    
    public int getCantidadProducidaPorTurno() {
        return cantidadProducidaPorTurno;
    }

    public int getCosteMantenimiento() {
        return costeMantenimiento;
    }

    public int getCosteMejora() {
        return costeMejora;
    }

    public int getNivelGenerador() {
        return nivelGenerador;
    }
    
    public void setCantidadProducidaPorTurno(int cantidadProducidaPorTurno) {
        this.cantidadProducidaPorTurno = cantidadProducidaPorTurno;
    }

    public void setCosteMantenimiento(int costeMantenimiento) {
        this.costeMantenimiento = costeMantenimiento;
    }

    public void setCosteMejora(int costeMejora) {
        this.costeMejora = costeMejora;
    }

    public void setNivelGenerador(int nivelGenerador) {
        this.nivelGenerador = nivelGenerador;
    }
}
