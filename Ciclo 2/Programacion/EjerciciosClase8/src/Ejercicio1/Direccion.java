/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author fabia
 */
public class Direccion {
    private String direccion;
    private String piso;
    private String estrato;   

    public Direccion(String direccion, String piso, String estrato) {
        this.direccion = direccion;
        this.piso = piso;
        this.estrato = estrato;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public String getPiso() {
        return piso;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    
}

