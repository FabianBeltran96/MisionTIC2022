package ejerciciosclase6;

public class Pacman {

    public String color;
    public int puntuacion;
    public int vidasRestantes;

    public Pacman(String color, int puntuacion, int vidasRestantes) {
        this.color = color;
        this.puntuacion = puntuacion;
        this.vidasRestantes = vidasRestantes;
    }

    public void sumarPuntuacion() {
        puntuacion++;
    }

    public int obtenerPuntuacion() {
        return puntuacion;
    }

    public void restarVida() {
        vidasRestantes--;
    }

    public boolean sigueVivo() {
        return vidasRestantes > 0;
    }

    @Override
    public String toString() {
        return "Pacman{" + "color=" + color + ", puntuacion=" + puntuacion + ", vidasRestantes=" + vidasRestantes + '}';
    }

    public static void main(String[] args) {
        Pacman Jugador1 = new Pacman("Amarillo", 0, 3);
        System.out.println(Jugador1.toString());
        Jugador1.sumarPuntuacion();
        System.out.println(Jugador1.toString());
        Jugador1.puntuacion = 99;
        Tablero Nivel = new Tablero(Jugador1, 0);
        Nivel.comprobarNivelActual(Jugador1.puntuacion);
    }
}
