package Modelo;
import java.util.*;

public class Entrenador {
    private String nombre;
    private List<Pokemon> equipo;
    private Set<Pokemon> usados;
    private int rondasGanadas;

    public Entrenador(String nombre, List<Pokemon> equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.usados = new HashSet<>();
        this.rondasGanadas = 0;
    }

    public List<Pokemon> getDisponibles() {
        List<Pokemon> disponibles = new ArrayList<>();
        for (Pokemon p : equipo) {
            if (!usados.contains(p)) disponibles.add(p);
        }
        return disponibles;
    }

    public void marcarUsado(Pokemon p) {
        usados.add(p);
    }

    public void ganarRonda() {
        rondasGanadas++;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public String getNombre() {
        return nombre;
    }
}
