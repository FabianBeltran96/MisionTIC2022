/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author fabia
 */
public class Cuadrado extends Figura {

    private final double lado;

    public Cuadrado(double lado, String color) {
        super(color);
        this.lado = lado;
    }

    public double Perimetro() {
        return 4 * lado;
    }

    @Override
    public double Area() {
        return lado * lado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" + "lado=" + lado + ", Color=" + color +'}';
    }

}
