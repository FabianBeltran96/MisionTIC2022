/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosclase6;

/**
 *
 * @author fabia
 */
public class Persona {

    private String Nombre;
    private int Edad;
    private int Peso;
    private int Altura;
    private char Genero;

    public Persona(String Nombre, int Edad, int Peso, int Altura, char Genero) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Peso = Peso;
        this.Altura = Altura;
        this.Genero = Genero;
    }

    public double calcularIMC() {
        return Peso / Math.pow(Altura, 2);
    }

    public boolean esMayorDeEdad() {
        return (Edad >= 18);
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombre=" + Nombre + ", Edad=" + Edad + ", Peso=" + Peso + ", Altura=" + Altura + ", Genero=" + Genero + '}';
    }

    public static void main(String[] args) {
        Persona Fabian = new Persona("Cristian", 24, 68, 171, 'H');
        Persona Cristian = new Persona("Cristian", 23, 70, 178, 'H');
        System.out.println(Cristian.calcularIMC());
        System.out.println(Fabian.esMayorDeEdad());
    }
}
