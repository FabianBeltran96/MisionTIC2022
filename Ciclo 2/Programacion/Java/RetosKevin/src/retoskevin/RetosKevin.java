/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
18
1.0 0.0 1.0 1.6
1.0 0.0 2.0 3.5
1.0 0.0 3.0 1.3
2.0 0.0 1.0 0.3
2.0 0.0 2.0 4.4
2.0 0.0 3.0 2.0
3.0 0.0 1.0 4.2
3.0 0.0 2.0 3.9
3.0 0.0 3.0 3.2
4.0 1.0 1.0 4.3
4.0 1.0 2.0 2.7
4.0 1.0 3.0 3.9
5.0 1.0 1.0 1.8
5.0 1.0 2.0 1.8
5.0 1.0 3.0 0.2
6.0 1.0 1.0 1.6
6.0 1.0 2.0 0.4
6.0 1.0 3.0 2.4
*/
package retoskevin;

import java.util.Scanner;

/**
 *
 * @author fabia
 */
public class RetosKevin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        float suma = 0;
        float num = 0;
        float[][] matriz = new float[total][4];
        float desempeñoG = 0;
        float desempeñoM = 0;
        float desempeñoI = 0;
        float mejorDesempeño = 0;
        int indice = -1;
        String[] estudiantes = {" ", "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};

        int insuficiente = 0;
        for (int j = 0; j < total; j++) {
            for (int i = 0; i < 4; i++) {
                matriz[j][i] = Float.parseFloat(sc.next());
            }
            if (matriz[j][3] >= 2.5) {
                suma++;
            }
            if (matriz[j][3] >= 1 && matriz[j][3] <= 2.5) {
                insuficiente++;
            }
            if (matriz[j][1] == 0) {
                if (matriz[j][2] == 1) {
                    desempeñoG += matriz[j][3];
                }
                if (matriz[j][2] == 2) {
                    desempeñoM += matriz[j][3];
                }
                if (matriz[j][2] == 3) {
                    desempeñoI += matriz[j][3];
                }
            }
            if (matriz[j][2] == 1) {
                if (matriz[j][3] > mejorDesempeño) {
                    mejorDesempeño = matriz[j][3];
                    indice = (int) matriz[j][0];
                }
            }
        }
        System.out.printf("%.2f",suma/total);
        System.out.println("");        
        System.out.println(insuficiente);
        float[] desempeñoMaterias = {desempeñoG, desempeñoM, desempeñoI};
        float menor = 100;
        for (int x = 0; x < desempeñoMaterias.length; x++) {
            if (desempeñoMaterias[x] < menor) {
                menor = desempeñoMaterias[x];
            }
        }
        for (int y = 0; y < desempeñoMaterias.length; y++) {
            if (menor == desempeñoMaterias[y]) {
                if (y == 0) {
                    System.out.println("geografia");
                    break;
                }
                if (y == 1) {
                    System.out.println("matematicas");
                    break;
                }
                if (y == 2) {
                    System.out.println("informatica");
                    break;
                }
            }
        }
        System.out.println(estudiantes[indice]);
    }
}