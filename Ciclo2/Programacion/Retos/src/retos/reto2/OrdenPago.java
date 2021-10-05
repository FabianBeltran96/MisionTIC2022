package retos.reto2;

public class OrdenPago extends Documento {

    public String subtotal;
    public String numeroPlanilla;

    public OrdenPago(String consecutivo, String ruta, String unidadGeneradora, String subtotal, String numeroPlanilla) {
        super(consecutivo, ruta, unidadGeneradora);
        this.subtotal = subtotal;
        this.numeroPlanilla = numeroPlanilla;
    }

    @Override
    public String toString() {
        return "\torden de pago - consecutivo: " + consecutivo + "\n"
                + "\truta: " + ruta + "\n"
                + "\tunidad generadora: " + unidadGeneradora + "\n"
                + "\tsubtotal: $" + subtotal + "\n"
                + "\tplanilla: " + numeroPlanilla;
    }

}
