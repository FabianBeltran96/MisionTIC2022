/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciossemana1;

import java.util.Scanner;

public class EjerciciosSemana1 {

    public static double VolumenTotal(int r1, int r2, double h) {
        double Volumen, Vesfera, Vcono;
        Vesfera = (4 * Math.PI * Math.pow(r1, 3)) / 3;
        Vcono = (Math.PI * Math.pow(r2, 2) * h) / 3;
        Volumen = Vesfera + Vcono;
        return Volumen;
    }

    public static void cantidadDeCarne() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cantidad de gallina:");
        int gallinas = sc.nextInt();
        System.out.println("Ingrese cantidad de gallos:");
        int gallos = sc.nextInt();
        System.out.println("Ingrese cantidad de pollos:");
        int pollos = sc.nextInt();
        System.out.println("La cantidad de carne total son: " + ((gallinas * 6) + (gallos * 7) + (pollos)) + " Kilos");
    }

    public static int vueltosTienda(int panes, int leche, int huevos, int billete) {
        return billete - (panes * 300 + leche * 3300 + huevos * 350);
    }

    public static boolean isVocal(int numeroVocal) {
        switch (numeroVocal) {
            case 97:
            case 101:
            case 105:
            case 111:
            case 117:
                return true;
            default:
                return false;
        }
    }

    public static boolean parAscii(char Caracter) {
        return ((int) Caracter % 2 == 0);
    }

    public static void numerosCuadrados() {
        for (int x = 1; x < 100; x++) {
            System.out.println("La variable X vale: " + x + ", y su cuadrado es: " + (x * x));
        }
    }

    public static void numeroImparPar() {
        System.out.println("Listado de numeros impares:");
        for (int i = 1; i < 999; i += 2) {
            System.out.println(i);
        }
        System.out.println("Listado de numeros pares:");
        for (int i = 2; i < 100; i += 2) {
            System.out.println(i);
        }
    }

    public static double volumenEsfera(double radio) {
        double esfera = (4 * Math.PI * Math.pow(radio, 3)) / 3;
        return esfera;
    }

    public static double volumenCono(double radio, double h) {
        double cono = (Math.PI * Math.pow(radio, 2) * h) / 3;
        return cono;
    }

    public static void cuadrados() {
        int x = 1;
        while (x < 101) {
            System.out.println("La variable X vale: " + x + ", y su cuadrado es: " + (x * x));
            x++;
        }
    }

    public static void imparpar() {
        System.out.println("Impares");
        int impares = 1;
        while (impares < 1000) {
            System.out.println(impares);
            impares += 2;
        }
        System.out.println("Pares");
        int pares = 2;
        while (pares < 1001) {
            System.out.println(pares);
            pares += 2;
        }
    }

    public static void reto1() {
        int cantidadDatos;
        //LEER CANTIDAD DE DATOS
        Scanner input = new Scanner(System.in);
        cantidadDatos = Integer.parseInt(input.nextLine());

        String datos[][] = new String[cantidadDatos][4];
        String datosArr[] = new String[cantidadDatos];

        for (int i = 0; i < cantidadDatos; i++) {
            datosArr[i] = input.nextLine();
            datos[i] = datosArr[i].split(" ");
        }

        float ultArr[][] = new float[cantidadDatos][4];

        for (int x = 0; x < cantidadDatos; x++) {
            for (int y = 0; y < 4; y++) {
                ultArr[x][y] = Float.parseFloat(datos[x][y]);
                //System.out.println(ultArr[x][y]);
                //System.out.println(x + "_" + y);
            }
        }

        int porcentaje = 0;
        int insuficiente = 0;
        for (int u = 0; u < cantidadDatos; u++) {
            //System.out.println(ultArr[u][3] + " Cada Dato ");
            if (ultArr[u][3] >= 2.5) {
                porcentaje++;
                //System.out.println(porcentaje + " porcentaje ");
            }
            if (ultArr[u][3] > 1 && ultArr[u][3] < 2.5) {
                insuficiente++;
                //System.out.println(insuficiente + " insuficiente ");
            }
        }
        //System.out.println(porcentaje + " Cuenta final");
        System.out.println((float) porcentaje / cantidadDatos);
        System.out.println(insuficiente);
    }

    public static void main(String[] args) {
        //System.out.println(VolumenTotal(3, 4, 4.5));
        //cantidadDeCarne();
        //System.out.println(vueltosTienda(1, 2, 3, 50_000));
        //System.out.println(isVocal(101));
        System.out.println(parAscii('f'));
        //cuadrados();
        //imparpar();
        //numerosCuadrados();
        //numeroImparPar();
        //reto1();
    }

}
 

