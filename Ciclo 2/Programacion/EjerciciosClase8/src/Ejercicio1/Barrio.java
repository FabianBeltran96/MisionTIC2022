package Ejercicio1;

import java.util.ArrayList;

public class Barrio {
    public String  nombre;
    public String  Presidente;
    public String  Localidad;
    public ArrayList<Direccion> direcciones;

    public Barrio() {
    }
    
   
    public Barrio(String nombre, String Presidente, String Localidad) {
        this.nombre = nombre;
        this.Presidente = Presidente;
        this.Localidad = Localidad;
    }  
    
    @Override
    public String toString() {
        return "Barrio{" + "nombre=" + nombre + ", Presidente=" + Presidente + ", Localidad=" + Localidad + '}';
    }

    public String getNombre() {
        return nombre;
    }
    
}
