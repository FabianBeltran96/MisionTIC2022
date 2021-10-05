package Ejercicio3;

public class Cuadrado extends Figura {

    private final double lado;

    public Cuadrado(double lado, String color) {
        super(color);
        this.lado = lado;
    }

    @Override
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
