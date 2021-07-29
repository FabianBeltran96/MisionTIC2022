/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotextiles;
/**
 *
 * @author fabia
 */
public class ProyectoTextiles {
    
    private int tiempo;
    private double capital, interes;

    public ProyectoTextiles(int tiempo, double capital, double interes) {
        this.tiempo = tiempo;
        this.capital = capital;
        this.interes = interes;
        /*return calcInteresS();*/
    } 
    
    public double calcInteresS() {

        return (double) Math.round(capital * interes /100 * tiempo);
    } 
    
    public double calcInteresC() {

        return (double) Math.round(capital * (Math.pow(1+(interes/100),tiempo)-1));
    } 
    
    public double compararIntereses() {
        return (double) Math.round(calcInteresC() - calcInteresS());
    }
    
    public static void main(String[] args) {

        ProyectoTextiles estudio1 = new ProyectoTextiles(2,10_000_000,6);

        System.out.println(estudio1.calcInteresS());
        System.out.println(estudio1.calcInteresC()); 
        System.out.println(estudio1.compararIntereses());

    }


}
