/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooavanzando;

/**
 *
 * @author fabianebg
 */
public class Profesor extends Persona{
    String tipoDeContratacion;
    Area area;

    public Profesor(String tipoDeContratacion) {
        this.tipoDeContratacion = tipoDeContratacion;
    }

    public String getTipoDeContratacion() {
        return tipoDeContratacion;
    }

    public void setTipoDeContratacion(String tipoDeContratacion) {
        this.tipoDeContratacion = tipoDeContratacion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    
    
    
}
