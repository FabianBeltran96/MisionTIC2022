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

}
