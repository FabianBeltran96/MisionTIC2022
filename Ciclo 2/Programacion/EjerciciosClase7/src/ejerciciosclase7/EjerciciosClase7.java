/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosclase7;

import Ejercicio3.Cuadrado;
import Ejercicio3.Circulo;


/**
 *
 * @author fabia
 */
public class EjerciciosClase7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circulo titan = new Circulo(3, "Verde");
        System.out.println(titan);    
        System.out.println(titan.Area());
        Cuadrado sami = new Cuadrado(12,"Rojo");
        System.out.println(sami);    
        System.out.println(sami.Perimetro());
    }
}
