import java.util.*;

class Juego {
    private Recursos madera;
    private Recursos piedra;
    private Recursos comida;
    private List<Generador> generadores;
    private int turnoActual;
    private final int turnosParaGanar;
    
    public Juego(int turnosParaGanar) {
        madera = new Recursos(TipoRecursos.MADERA, 20);
        piedra = new Recursos(TipoRecursos.PIEDRA, 0);
        comida = new Recursos(TipoRecursos.COMIDA, 50);
        
        generadores = new ArrayList<>();
        generadores.add(new GeneradorDeMadera());
        
        this.turnoActual = 1;
        this.turnosParaGanar = turnosParaGanar;
    }

    public void realizarTurno() {
        System.out.println("\nTurno " + turnoActual);
        for (Generador g : generadores) {
            if (g.recursoGenerados == TipoRecursos.MADERA) {
                g.generarRecurso(madera);
            } else if (g.recursoGenerados == TipoRecursos.PIEDRA) {
                g.generarRecurso(piedra);
            } else if (g.recursoGenerados == TipoRecursos.COMIDA) {
                g.generarRecurso(comida);
            }
        }
        
        // Implementar lógica de juego...
        
        turnoActual++;
    }
}
