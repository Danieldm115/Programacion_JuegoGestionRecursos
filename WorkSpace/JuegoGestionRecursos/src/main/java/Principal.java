
public class Principal {
	public static void main(String[] args) {
        Juego juego = new Juego(10);

        while (juego.getTurnoActual() < juego.getTurnosParaGanar()) {
            if (juego.getTurnosRestantes() == 5) {
                System.out.println("¡Atención! Quedan 5 turnos para el final del juego.");
            }

            juego.realizarTurno();

            if (juego.getTurnoActual() >= juego.getTurnosParaGanar() || juego.seHaAcabadoLaComida()) {
                System.out.print("Fin del juego: ");
                if(juego.seHaAcabadoLaComida()) {
                	System.out.print("Moriste de hambre");
                } else {
                	System.out.print("¡GANASTE!");
                }
                break;
            }
        }
    }
}