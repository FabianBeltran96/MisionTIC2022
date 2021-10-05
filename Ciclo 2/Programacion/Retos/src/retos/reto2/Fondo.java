package retos.reto2;

import java.util.ArrayList;
import java.util.Scanner;

public class Fondo {

    ArrayList<Documento> Documentos;

    public static void main(String[] args) {
        Fondo reto2 = new Fondo();
        reto2.procesarComandos();
    }

    public Fondo() {
        this.Documentos = new ArrayList<>();
    }

    public void agregarDocumento(Documento documento) {
        Documentos.add(documento);

    }

    public void listarDocumentos() {
        System.out.println("***Fondo documental***");
        Documentos.forEach(objeto -> {
            System.out.println(objeto);
        });
    }

    public void procesarComandos() {

        Scanner sc = new Scanner(System.in);
        String[] entrada;
        do {
            entrada = sc.next().split("&");

            if (entrada[0].equals("1")) {
                if (entrada[1].equals("OrdenPago")) {
                    OrdenPago pago = new OrdenPago(entrada[2], entrada[3], entrada[4], entrada[5], entrada[6]);
                    agregarDocumento(pago);
                } else {
                    Contrato contrato = new Contrato(entrada[2], entrada[3], entrada[4], entrada[5]);
                    agregarDocumento(contrato);
                }
            } else if (entrada[0].equals("2")) {
                listarDocumentos();
            }
        } while (!"3".equals(entrada[0]));
    }
}
