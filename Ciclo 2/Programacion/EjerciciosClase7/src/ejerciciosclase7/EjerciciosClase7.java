package ejerciciosclase7;

import Ejercicio3.Cuadrado;
import Ejercicio3.Circulo;

public class EjerciciosClase7 {

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
