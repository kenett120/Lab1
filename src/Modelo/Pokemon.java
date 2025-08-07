package Modelo;
import Control.BatallaControlador;

public class Pokemon {
    private String nombre, tipo;
    private int ataque, defensa, penalizacion = 0, turnosConHabilidad = 0;
    private HabilidadEspecial habilidad;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    public boolean usarHabilidad(Pokemon enemigo) {
        if (habilidad.activar()) {
            habilidad.aplicarEfecto(this, enemigo);
            turnosConHabilidad = 2;
            return true;
        }
        return false;
    }

    public int calcularAtaqueTotal(Pokemon enemigo) {
        int bonusTipo = BatallaControlador.aplicarEfectosTipo(this.tipo, enemigo.tipo);
        int total = ataque + bonusTipo - penalizacion;
        penalizacion = 0;
        if (turnosConHabilidad > 0) turnosConHabilidad--;
        return total;
    }

    public void aumentarAtaque(int valor) { ataque += valor; }
    public void aumentarDefensa(int valor) { defensa += valor; }
    public void recibirDaño(int valor) { penalizacion += valor; }

    public String getNombre() { return nombre; }
}

