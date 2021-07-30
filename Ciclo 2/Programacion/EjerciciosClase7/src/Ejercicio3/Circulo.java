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
public class Circulo extends Figura {

    private final double radio;

    public Circulo(double radio, String color) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double Perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double Area() {
        return Math.PI * radio * radio;
    }

    @Override
    public String toString() {
        return "Circulo{" + "radio=" + radio + '}';
    }


}
