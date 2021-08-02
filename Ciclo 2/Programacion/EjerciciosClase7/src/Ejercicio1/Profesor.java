package Ejercicio1;

public class Profesor extends Persona {

    //Atributos
    private String Asignatura;
    private String Colegio;

    //Constructor
    public Profesor(String Asignatura, String Colegio, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.Asignatura = Asignatura;
        this.Colegio = Colegio;
    }

    //Metodos
    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String Asignatura) {
        this.Asignatura = Asignatura;
    }

    public String getColegio() {
        return Colegio;
    }

    public void setColegio(String Colegio) {
        this.Colegio = Colegio;
    }

    @Override
    public String toString() {
        return "Profesor{" + "Asignatura=" + Asignatura + ", Colegio=" + Colegio + '}';
    }
}
