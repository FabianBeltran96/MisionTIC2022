package ejerciciosclase6;

import java.util.Scanner;

public class Triki {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_BLUE = "\u001B[34m";

    public char[][] matriz;

    public Triki() {
        this.matriz = new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    }

    public void marcarCasilla(char simbolo, int fila, int columna) {
        matriz[fila][columna] = simbolo;
    }

    public char verificadorGanador() {

        if ((matriz[0][0] == matriz[1][1]) && (matriz[0][0] == matriz[2][2]) && (matriz[0][0] != '-')) {
            return matriz[0][0];
        }
        if ((matriz[0][2] == matriz[1][1]) && (matriz[2][0] == matriz[1][1]) && (matriz[1][1] != '-')) {
            return matriz[1][1];
        }

        for (int i = 0; i < 3; i++) {
            if (matriz[i][i] == '-') {
                continue;
            }

            if ((matriz[i][0] == matriz[i][1]) && (matriz[i][0] == matriz[i][2])) {
                return matriz[i][0];
            }

            if ((matriz[0][i] == matriz[1][i]) && (matriz[0][i] == matriz[2][i])) {
                return matriz[0][i];
            }

        }

        return '5';
    }

    public char verificarCasilla(int fila, int columna) {
        return matriz[fila][columna];
    }

    public void imprimir() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == 'x') {
                    System.out.print(ANSI_RED + matriz[i][j] + " " + ANSI_RESET);
                } else if (matriz[i][j] == 'o') {
                    System.out.print(ANSI_BLUE + matriz[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Triki partida = new Triki(); //Creo la partida
        int[] posiciones = {0, 0};
        Scanner sc = new Scanner(System.in); //Capturo los datos
        System.out.println("Inicia el juego!");
        System.out.println("Ingresa la posicion de la siguiente manera:");
        System.out.println("FILA COLUMNA");
        System.out.println("EJEMPLO: 0 0");
        partida.imprimir(); //imprimir estado de la partida
        int turno = 1;
        int jugadas = 0;
        char caracter = 'x';
        while (true) {
            System.out.println("Marca Casilla jugador " + turno + ":");
            //capura de la posicion
            for (int i = 0; i < 2; i++) {
                posiciones[i] = Integer.parseInt(sc.next());
            }
            //Verificacion de estado de la casilla
            if (partida.verificarCasilla(posiciones[0], posiciones[1]) != '-') {
                System.out.println("Esta casilla no esta disponible!");
                jugadas--;
            } else {
                partida.marcarCasilla(caracter, posiciones[0], posiciones[1]);
                partida.imprimir();
                //Cambio de turnos y caracteres
                if (partida.verificadorGanador() != '5') {
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
            jugadas++;
        }
    }
}
