package Control;

import Modelo.*;
import Vista.Vista;

public class BatallaControlador {
    private Entrenador e1, e2;
    private Vista vista;

    public BatallaControlador(Entrenador e1, Entrenador e2, Vista vista) {
        this.e1 = e1;
        this.e2 = e2;
        this.vista = vista;
    }

    public void jugarInteractivo() {
        for (int i = 1; i <= 4; i++) {
            vista.mostrarMensaje("\n=== Ronda " + i + " ===");
            Pokemon p1 = vista.seleccionarPokemonRonda(e1);
            Pokemon p2 = vista.seleccionarPokemonRonda(e2);
            e1.marcarUsado(p1);
            e2.marcarUsado(p2);

            vista.mostrarSeleccion(e1.getNombre(), p1.getNombre());
            vista.mostrarSeleccion(e2.getNombre(), p2.getNombre());

            p1.usarHabilidad(p2);
            p2.usarHabilidad(p1);

            int atk1 = p1.calcularAtaqueTotal(p2);
            int atk2 = p2.calcularAtaqueTotal(p1);

            vista.mostrarAtaque(p1.getNombre(), atk1);
            vista.mostrarAtaque(p2.getNombre(), atk2);

            if (atk1 > atk2) {
                e1.ganarRonda();
                vista.mostrarGanadorRonda(e1.getNombre());
            } else if (atk2 > atk1) {
                e2.ganarRonda();
                vista.mostrarGanadorRonda(e2.getNombre());
            } else {
                vista.mostrarEmpate();
            }
        }
        vista.mostrarResultadoFinal(e1, e2);
    }

    public static int aplicarEfectosTipo(String a, String d) {
        return switch (a + "-" + d) {
            case "Fuego-Planta", "Planta-Agua", "Agua-Fuego", "Eléctrico-Agua" -> 20;
            case "Fuego-Agua", "Agua-Planta", "Planta-Fuego" -> -10;
            default -> 0;
        };
    }
}