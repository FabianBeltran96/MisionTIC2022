package reto2Karina;

public class Novato extends Balon {

    //Atributos
    String resistenciaMaxima;

    //Constructor
    public Novato(String serial,  String velocidad, String tamaño, String resistenciaMaxima) {
        super(serial, velocidad, tamaño);
        this.resistenciaMaxima = resistenciaMaxima;
    }

    //Metodos
    @Override
    public String toString() {
        return "\tBalon Novato - Serial: " + serial + "\n" +
               "\tvelocidad: " + velocidad + " km/h\n" +
               "\ttamaño: " + tamaño + "\n" + 
               "\tResistencia máxima: " + resistenciaMaxima;
    }

}
