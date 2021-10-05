package retos.reto2;

public class Contrato extends Documento {

    public String monto;

    public Contrato(String consecutivo, String ruta, String unidadGeneradora, String monto) {
        super(consecutivo, ruta, unidadGeneradora);
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "\tcontrato - consecutivo:" + consecutivo + "\n"
                + "\truta:" + ruta + "\n"
                + "\tunidad generadora:" + unidadGeneradora + "\n"
                + "\tmonto: " + monto;
    }
}
