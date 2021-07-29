/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosclase6;

import java.util.Scanner;

/**
 *
 * @author fabia
 */
public class EjerciciosClase6 {
    
    
    
    public void testContraseñas() {
        Contraseña password = new Contraseña(8);
        System.out.println(password.Contraseña);
        System.out.println(password.esFuerte());

    }

    public static void testPacman() {
        Pacman Jugador1 = new Pacman("Amarillo", 0, 3);
        System.out.println(Jugador1.toString());
        Jugador1.sumarPuntuacion();
        System.out.println(Jugador1.toString());
        Jugador1.puntuacion = 99;
        Tablero Nivel = new Tablero(Jugador1, 0);
        Nivel.comprobarNivelActual(Jugador1.puntuacion);
    }

    public static void testTriki() {
        Triki partida = new Triki();
        partida.imprimir();
        partida.marcarCasilla('x', 0, 0);
        partida.imprimir();
        System.out.println(partida.verificarCasilla(0, 0));
    }

    public static void juegoTriki() {
        Triki partida = new Triki(); //Creo la partida
        int[] posiciones = {0, 0};

        Scanner sc = new Scanner(System.in); //Capturo los datos
        partida.imprimir(); //imprimir estado de la partida
        System.out.println("Inicia el juego!");

        System.out.println("Ingresa la posicion de la siguiente manera:");
        System.out.println("FILA COLUMNA");
        System.out.println("EJEMPLO: 0 0");

        int turno = 1;
        int jugadas = 0;
        char caracter = 'x';
        while (true) {
            System.out.println("Marca Casilla jugador " + turno + ":");
            //capura de la posicion
            for (int i = 0; i < 2; i++) {
                posiciones[i] = Integer.parseInt(sc.next());
            }
            //System.out.println(posiciones[0] +" " + posiciones[1]);
            //Verificacion de estado de la casilla, PENDIENTE!
            if (partida.verificarCasilla(posiciones[0], posiciones[1]) != 'a') {
                System.out.println("Esta casilla no esta disponible!");
                jugadas--;

            } else {
                partida.marcarCasilla(caracter, posiciones[0], posiciones[1]);
                partida.imprimir();

                //Cambio de turnos y caracteres
                if (partida.verificadorGanador() == '5') {

                } else {
                    System.out.println("El ganador es el jugador " + turno + "!");
                    break;
                }
                if (turno == 1) {
                    turno = 2;
                    caracter = 'o';
                } else {
                    turno = 1;
                    caracter = 'x';
                }
            }
            
            if (jugadas == 8) {
                System.out.println("El juego ha sido empatado!");
                break;
            }
            //System.out.println("El ganador es: " + partida.verificadorGanador());
            jugadas++;
        }
        //System.out.println(partida.verificarCasilla(0, 0));
    }

    public static void main(String[] args) {
        //testPacman();
        //testTriki();
        juegoTriki();
    }

}
