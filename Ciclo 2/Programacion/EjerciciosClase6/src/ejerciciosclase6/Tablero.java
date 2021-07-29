package ejerciciosclase6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabia
 */
public class Tablero {

    int Nivel;
    Pacman personaje;

    public Tablero(Pacman personaje, int Nivel) {
        this.Nivel = Nivel;
        this.personaje = personaje;
    }

    public static void comprobarNivelActual( int puntuacion) {
        double test = puntuacion/25;
        System.out.printf("Se encuentra en el nivel %.2f", test);
    }

    @Override
    public String toString() {
        return "Tablero{" + "Nivel=" + Nivel + ", personaje=" + personaje + '}';
    }

}
