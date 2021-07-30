/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author fabia
 */
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
