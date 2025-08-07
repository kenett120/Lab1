package Modelo;

public class HabilidadEspecial{
    private String nombre;
    private String efecto;
    private int valor;
    private int probabilidad;

    public HabilidadEspecial(String nombre, String efecto, int valor, int probabilidad){
        this.nombre = nombre;
        this.efecto = efecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }

    public boolean activar() {
        int random = (int)(Math.random() * 100);
        return random < probabilidad;
    }

    public void aplicarEfecto(Pokemon propio, Pokemon enemigo) {
        switch (efecto) {
            case "ataque": propio.aumentarAtaque(valor); break;
            case "defensa": propio.aumentarDefensa(valor); break;
            case "daño": enemigo.recibirDaño(valor); break;
        }
    }
}