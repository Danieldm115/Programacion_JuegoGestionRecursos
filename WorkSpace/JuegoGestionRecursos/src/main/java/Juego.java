
import java.util.*;

public class Juego {
    private ArrayList<Recurso> recursos;
    private ArrayList<Generador> generadores;
    private int turnoActual;
    private int turnosParaGanar;

    public Juego(int turnosParaGanar) {
        recursos = new ArrayList<Recurso>();
        generadores = new ArrayList<Generador>();
        turnoActual = 0;
        this.turnosParaGanar = turnosParaGanar;

        recursos.add(new Recurso(TipoRecurso.MADERA, 20));
        recursos.add(new Recurso(TipoRecurso.COMIDA, 50));
        recursos.add(new Recurso(TipoRecurso.PIEDRA, 0));
        generadores.add(new GeneradorDeMadera(10, 3, 40));
    }

    public void crearGenerador(Generador generador) {
        TipoRecurso tipoRecurso = generador.getTipoRecurso();
        Recurso madera = obtenerRecurso(TipoRecurso.MADERA);
        Recurso comida = obtenerRecurso(TipoRecurso.COMIDA);

        boolean puedeCrear = false;

        if (generador instanceof GeneradorDeMadera) {
            if (madera.getCantidad() >= 10 && comida.getCantidad() >= 5) {
                madera.setCantidad(madera.getCantidad() - 10);
                comida.setCantidad(comida.getCantidad() - 5);
                puedeCrear = true;
            } else {
                System.out.println("No tienes suficientes recursos.");
            }
        } else if (generador instanceof GeneradorDeComida) {
            if (madera.getCantidad() >= 20) {
                madera.setCantidad(madera.getCantidad() - 20);
                puedeCrear = true;
            } else {
                System.out.println("No tienes suficientes recursos.");
            }
        } else if (generador instanceof GeneradorDePiedra) {
            if (madera.getCantidad() >= 10 && comida.getCantidad() >= 15) {
                madera.setCantidad(madera.getCantidad() - 10);
                comida.setCantidad(comida.getCantidad() - 15);
                puedeCrear = true;
            } else {
                System.out.println("No tienes suficientes recursos.");
            }
        }

        if (puedeCrear) {
            generadores.add(generador);
            System.out.println("Generador de " + tipoRecurso + " creado.");
        }
    }

    public void destruirGenerador(Generador generador) {
        generadores.remove(generador);
    }

    public void mejorarGenerador(Generador generador, Recurso recurso) {
        generador.mejorarGenerador(recurso);
    }

    public void mostrarEstadoJuego() {
        System.out.println("Turno: " + turnoActual);
        System.out.println("Recursos:");
        for (Recurso recurso : recursos) {
            System.out.println(recurso.getTipo() + ": " + recurso.getCantidad());
        }
        System.out.println("Generadores:");
        for (Generador generador : generadores) {
            generador.mostrarInformacionDelGenerdador();
        }
    }

    public void realizarTurno() {
        System.out.println("Turno: " + turnoActual);
        sumarRecursosGeneradores();
        turnoJugador();
        restarRecursosDeMantenimiento();
        turnoActual++;
        mostrarEstadoJuego();
    }

    private void sumarRecursosGeneradores() {
        Recurso comida = obtenerRecurso(TipoRecurso.COMIDA);
        Recurso madera = obtenerRecurso(TipoRecurso.MADERA);

        if (comida == null || madera == null) {
            System.out.println("Error: No se encontraron los recursos de mantenimiento necesarios.");
            return;
        }

        for (Generador generador : generadores) {
            int recursosProducidos = 0;

            if (generador instanceof GeneradorDeMadera || generador instanceof GeneradorDePiedra) {
                recursosProducidos = generador.generarRecurso(comida);
            } else if (generador instanceof GeneradorDeComida) {
                recursosProducidos = generador.generarRecurso(madera);
            }

            if (recursosProducidos > 0) {
                TipoRecurso tipoRecursoGenerado = generador.getTipoRecurso();
                Recurso recursoGenerado = obtenerRecurso(tipoRecursoGenerado);

                if (recursoGenerado != null) {
                    recursoGenerado.setCantidad(recursoGenerado.getCantidad() + recursosProducidos);
                    System.out.println("El generador de " + generador.getClass().getSimpleName() + " produjo: " + recursosProducidos + " de " + tipoRecursoGenerado);
                } else {
                    System.out.println("Error: No se encontró el recurso " + tipoRecursoGenerado);
                }
            }
        }
    }

    private void turnoJugador() {
        Scanner teclado = new Scanner(System.in);
        boolean pasarTurno = false;

        while (!pasarTurno) {
        	System.out.print("Tus recursos disponibles son: [ ");
            for (Recurso recurso : recursos) {
                System.out.print(recurso.getTipo() + ": " + recurso.getCantidad()+" ");
            }
            System.out.println("]");
            
            System.out.println("Opciones: 1) Crear Generador  2) Mejorar Generador  3) Pasar Turno");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Que generador quieres crear? :");
                    System.out.println("1. Madera");
                    System.out.println("2. Piedra");
                    System.out.println("3. Comida");
                    int opcionGenerador = teclado.nextInt();

                    switch (opcionGenerador) {
                        case 1:
                            crearGenerador(new GeneradorDeMadera(10, 3, 40));
                            break;
                        case 2:
                            crearGenerador(new GeneradorDePiedra(5, 2, 30));
                            break;
                        case 3:
                            crearGenerador(new GeneradorDeComida(3, 3, 10));
                            break;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Seleccione el generador a mejorar:");
                    for (int i = 0; i < generadores.size(); i++) {
                        System.out.println(i+1 + ". " + generadores.get(i).getClass().getSimpleName());
                    }

                    int opcionGeneradorMejora = teclado.nextInt();
                    if (opcionGeneradorMejora >= 0 && opcionGeneradorMejora < generadores.size()) {
                        Generador generador = generadores.get(opcionGeneradorMejora);

                        if (generador instanceof GeneradorDeMadera || generador instanceof GeneradorDePiedra) {
                        	mejorarGenerador(generador, obtenerRecurso(TipoRecurso.COMIDA));
                        } else if (generador instanceof GeneradorDeComida) {
                            mejorarGenerador(generador, obtenerRecurso(TipoRecurso.MADERA));
                        } else {
                            System.out.println("Error: Tipo de generador no reconocido.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 3:
                    pasarTurno = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void restarRecursosDeMantenimiento() {
        int maderaNecesaria = 0;
        int comidaNecesaria = 0;

        for (Generador generador : generadores) {
            if (generador instanceof GeneradorDeMadera || generador instanceof GeneradorDePiedra) {
                comidaNecesaria += generador.getCosteMantenimiento();
            } else {
                maderaNecesaria += generador.getCosteMantenimiento();
            }
        }

        Recurso madera = obtenerRecurso(TipoRecurso.MADERA);
        Recurso comida = obtenerRecurso(TipoRecurso.COMIDA);

        while (madera.getCantidad() < maderaNecesaria || comida.getCantidad() < comidaNecesaria) {
            if (generadores.isEmpty()) {
                System.out.println("No hay generadores para destruir. El juego no puede continuar.");
                return;
            }

            System.out.println("No hay suficientes recursos para el mantenimiento. Debe destruir un generador.");
            destruirGeneradorParaMantenimiento(new Scanner(System.in));

            maderaNecesaria = 0;
            comidaNecesaria = 0;
            for (Generador generador : generadores) {
                if (generador instanceof GeneradorDeMadera || generador instanceof GeneradorDePiedra) {
                    comidaNecesaria += generador.getCosteMantenimiento();
                } else {
                    maderaNecesaria += generador.getCosteMantenimiento();
                }
            }
        }

        madera.setCantidad(madera.getCantidad() - maderaNecesaria);
        comida.setCantidad(comida.getCantidad() - comidaNecesaria);
        
        //Aqui pondre lo que come el propio jugador para que pueda perder de hambre
        comida.decrementarCantidad(1);
    }

    private void destruirGeneradorParaMantenimiento(Scanner scanner) {
        System.out.println("Seleccione el generador a destruir:");
        for (int i = 0; i < generadores.size(); i++) {
            System.out.println(i + ". " + generadores.get(i).getClass().getSimpleName());
        }
        int opcion = scanner.nextInt();
        if (opcion >= 0 && opcion < generadores.size()) {
            destruirGenerador(generadores.get(opcion));
            System.out.println("Generador destruido.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private Recurso obtenerRecurso(TipoRecurso tipo) {
        for (Recurso recurso : recursos) {
            if (recurso.getTipo() == tipo) {
                return recurso;
            }
        }
        return null;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public int getTurnosParaGanar() {
        return turnosParaGanar;
    }

    public int getTurnosRestantes() {
        return turnosParaGanar - turnoActual;
    }

    public boolean seHaAcabadoLaComida() {
        Recurso comida = obtenerRecurso(TipoRecurso.COMIDA);
        return comida.getCantidad() <= 0;
    }
}
