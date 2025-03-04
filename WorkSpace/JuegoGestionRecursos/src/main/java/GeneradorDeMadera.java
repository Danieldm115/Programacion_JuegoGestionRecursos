
public class GeneradorDeMadera extends Generador{
    public GeneradorDeMadera(int cantidadProducidaPorTurno, int costeMantenimiento, int costeMejora) {
        super(cantidadProducidaPorTurno, costeMantenimiento, costeMejora);
    }
    
    @Override
    public void mejorarGenerador(Recurso recurso) {
        if(getNivelGenerador() < 3){
            
            if (recurso.getCantidad() >= getCosteMejora()) {
                recurso.setCantidad(recurso.getCantidad() - getCosteMejora());
            setCantidadProducidaPorTurno(getCantidadProducidaPorTurno() + 2);
            setCosteMejora(getCosteMejora() + 5);
            setNivelGenerador(getNivelGenerador() + 1);
            }else{
                System.out.println("No tienes suficientes materiales para mejorar el generador");
            }

        }else{
            System.out.println("El generador ya esta en su nivel maximo");
        }
    }

    @Override
    public int generarRecurso(Recurso recursoMantenimiento) {
        if(recursoMantenimiento.getTipo() != TipoRecurso.COMIDA){
            System.out.println("El recurso de mantenimiento no es valido");
            return 0;

        }else{

            if (recursoMantenimiento.getCantidad() < getCosteMantenimiento()) {
                System.out.println("Generador de Madera:");
                System.out.println("No se genero madera por falta de recursos");
                return 0;
                
            }else{
                recursoMantenimiento.setCantidad(recursoMantenimiento.getCantidad() - getCosteMantenimiento());
                System.out.println("Generador de Madera:");
                System.out.println("Se generaron " + getCantidadProducidaPorTurno() + " de madera");
                return getCantidadProducidaPorTurno();
            }
        }
    }

    @Override
    public void mostrarInformacionDelGenerdador() {
        System.out.println("Generador de Madera:");
        System.out.println("Nivel: " + getNivelGenerador());
        System.out.println("Cantidad producida por turno: " + getCantidadProducidaPorTurno());
        System.out.println("Coste de mantenimiento: " + getCosteMantenimiento());
        System.out.println("Coste de mejora: " + getCosteMejora());
    }

    @Override
    public TipoRecurso getTipoRecurso() {
        return TipoRecurso.MADERA;
    }
}

