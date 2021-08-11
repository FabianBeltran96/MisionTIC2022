/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author fabia
 */
public class materialBiblioteca {

    private String titulo;
    private String temas;
    private String tipo;
    private String fuente;
    private String descripcion;
    private String idioma;
    private String creador;
    private String editor;
    private String otrosColaboradores;
    private String propiedadIntelectual;
    private String formato;
    private String identificador;
    private int fecha;

    public materialBiblioteca(String titulo, String temas, String tipo, String fuente, String descripcion, String idioma, String creador, String editor, String otrosColaboradores, String propiedadIntelectual, String formato, String identificador, int fecha) {
        this.titulo = titulo;
        this.temas = temas;
        this.tipo = tipo;
        this.fuente = fuente;
        this.descripcion = descripcion;
        this.idioma = idioma;
        this.creador = creador;
        this.editor = editor;
        this.otrosColaboradores = otrosColaboradores;
        this.propiedadIntelectual = propiedadIntelectual;
        this.formato = formato;
        this.identificador = identificador;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getOtrosColaboradores() {
        return otrosColaboradores;
    }

    public void setOtrosColaboradores(String otrosColaboradores) {
        this.otrosColaboradores = otrosColaboradores;
    }

    public String getPropiedadIntelectual() {
        return propiedadIntelectual;
    }

    public void setPropiedadIntelectual(String propiedadIntelectual) {
        this.propiedadIntelectual = propiedadIntelectual;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "tipo=" + tipo + "titulo=" + titulo + ", fecha=" + fecha + '}';
    }

    public static void main(String[] args) {
        System.out.println("test");
    }

}
