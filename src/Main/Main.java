package Main;
import Modelo.Entrenador;
import Modelo.Pokemon;
import Modelo.HabilidadEspecial;
import Control.BatallaControlador;
import Vista.Vista;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vista vista = new Vista(scanner);

        vista.mostrarMensaje("Bienvenido al juego de batalla Pokémon (MVC)!");
        vista.mostrarMensaje("Entrenador 1, escribe tu nombre:");
        String nombre1 = scanner.nextLine();

        vista.mostrarMensaje("Entrenador 2, escribe tu nombre:");
        String nombre2 = scanner.nextLine();

        List<Pokemon> opciones = Arrays.asList(
                new Pokemon("Charmander", "Fuego", 50, 30, new HabilidadEspecial("Llama Final", "ataque", 15, 30)),
                new Pokemon("Bulbasaur", "Planta", 45, 35, new HabilidadEspecial("Escudo Natural", "defensa", 20, 30)),
                new Pokemon("Pikachu", "Eléctrico", 55, 25, new HabilidadEspecial("Impacto Relámpago", "daño", 10, 30)),
                new Pokemon("Squirtle", "Agua", 40, 40, new HabilidadEspecial("Escudo Acuático", "defensa", 25, 25)),
                new Pokemon("Torchic", "Fuego", 48, 32, new HabilidadEspecial("Llama Final", "ataque", 15, 30)),
                new Pokemon("Chikorita", "Planta", 43, 37, new HabilidadEspecial("Escudo Natural", "defensa", 20, 30)),
                new Pokemon("Magnemite", "Eléctrico", 50, 30, new HabilidadEspecial("Impacto Relámpago", "daño", 10, 30)),
                new Pokemon("Totodile", "Agua", 42, 38, new HabilidadEspecial("Mordisco", "ataque", 10, 20))
        );

        List<Pokemon> equipo1 = vista.seleccionarEquipo(nombre1, opciones);
        List<Pokemon> equipo2 = vista.seleccionarEquipo(nombre2, opciones);

        Entrenador e1 = new Entrenador(nombre1, equipo1);
        Entrenador e2 = new Entrenador(nombre2, equipo2);

        BatallaControlador controlador = new BatallaControlador(e1, e2, vista);
        controlador.jugarInteractivo();
    }
}