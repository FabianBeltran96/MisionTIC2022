package reto2Karina;

public class Profesional extends Balon {

    String color;

    public Profesional(String serial, String velocidad, String tamaño, String color) {
        super(serial, velocidad, tamaño);
        this.color = color;
    }

    @Override
    public String toString() {
        return "\tBalon Profesional - Serial: " + serial + "\n"
                + "\tvelocidad: " + velocidad + " km/h" + "\n"
                + "\ttamaño: " + tamaño + "\n"
                + "\tcolor: " + color;
    }

}
