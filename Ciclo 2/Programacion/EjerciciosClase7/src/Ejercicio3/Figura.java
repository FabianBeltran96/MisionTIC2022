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
public abstract class Figura {

    public String color;

    public Figura(String color) {
        this.color = color;
    }
    

    public double Perimetro() {
        return 0;
    }

    public double Area() {
        return 0;
    }

    @Override
    public String toString() {
        return "Figura{" + "color=" + color + '}';
    }

}
