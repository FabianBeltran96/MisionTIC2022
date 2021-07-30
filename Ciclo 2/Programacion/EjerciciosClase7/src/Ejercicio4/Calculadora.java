/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author fabia
 */
class Calculadora implements Operaciones, Constantes {

    double a;
    double b;

    public Calculadora(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double suma() {
        return a + b;
    }

    @Override
    public double resta() {
        return a - b;
    }

    @Override
    public double multiplicaion() {
        return a * b;
    }

    @Override
    public double division() {
        return a / b;
    }
    
}
