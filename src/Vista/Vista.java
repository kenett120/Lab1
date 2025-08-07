package Vista;
import Modelo.*;
import java.util.*;

public class Vista {
    private Scanner scanner;

    public Vista(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public List<Pokemon> seleccionarEquipo(String nombre, List<Pokemon> opciones) {
        List<Pokemon> seleccionados = new ArrayList<>();
        mostrarMensaje("\n" + nombre + ", selecciona 4 Pokémon para tu equipo:");
        while (seleccionados.size() < 4) {
            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i).getNombre());
            }
            mostrarMensaje("Escribe el número del Pokémon que quieres elegir:");
            try {
                int eleccion = Integer.parseInt(scanner.nextLine()) - 1;
                if (eleccion >= 0 && eleccion < opciones.size() && !seleccionados.contains(opciones.get(eleccion))) {
                    seleccionados.add(opciones.get(eleccion));
                } else {
                    mostrarMensaje("Selección inválida o Pokémon ya elegido.");
                }
            } catch (Exception e) {
                mostrarMensaje("Entrada inválida.");
            }
        }
        return seleccionados;
    }

    public Pokemon seleccionarPokemonRonda(Entrenador entrenador) {
        mostrarMensaje("\n" + entrenador.getNombre() + ", elige el Pokémon para esta ronda:");
        List<Pokemon> disponibles = entrenador.getDisponibles();
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).getNombre());
        }
        while (true) {
            try {
                int eleccion = Integer.parseInt(scanner.nextLine()) - 1;
                if (eleccion >= 0 && eleccion < disponibles.size()) {
                    return disponibles.get(eleccion);
                } else {
                    mostrarMensaje("Selección inválida.");
                }
            } catch (Exception e) {
                mostrarMensaje("Entrada inválida.");
            }
        }
    }

    public void mostrarSeleccion(String entrenador, String pokemon) {
        System.out.println(entrenador + " usa a " + pokemon);
    }

    public void mostrarAtaque(String nombre, int ataque) {
        System.out.println("Ataque total de " + nombre + ": " + ataque);
    }

    public void mostrarGanadorRonda(String nombre) {
        System.out.println(nombre + " gana la ronda.\n");
    }

    public void mostrarEmpate() {
        System.out.println("Empate en la ronda.\n");
    }

    public void mostrarResultadoFinal(Entrenador e1, Entrenador e2) {
        System.out.println("Resultado final:");
        System.out.println(e1.getNombre() + ": " + e1.getRondasGanadas());
        System.out.println(e2.getNombre() + ": " + e2.getRondasGanadas());
        if (e1.getRondasGanadas() > e2.getRondasGanadas())
            System.out.println(e1.getNombre() + " gana la batalla!");
        else if (e2.getRondasGanadas() > e1.getRondasGanadas())
            System.out.println(e2.getNombre() + " gana la batalla!");
        else
            System.out.println("La batalla terminó en empate.");
    }

    public boolean preguntarUsoHabilidad(Pokemon pokemon) {
        mostrarMensaje("¿Deseas usar la habilidad especial de " + pokemon.getNombre() + "? (s/n)");
        while (true) {
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) return true;
            if (respuesta.equals("n")) return false;
            mostrarMensaje("Respuesta inválida. Escribe 's' o 'n'.");
        }
    }
}
