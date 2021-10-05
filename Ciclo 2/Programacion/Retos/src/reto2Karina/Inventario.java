package reto2Karina;

import java.util.*;

public class Inventario {

    ArrayList<Balon> Balones;

    public static void main(String[] args) {
        Inventario listadosBalones = new Inventario();

        listadosBalones.procesarComandos();
    }

    public Inventario() {
        this.Balones = new ArrayList<>();
    }

    public void agregarBalones(Balon b) {
        Balones.add(b);
    }

    public void listarBalones() {
        System.out.println("***Inventario de balones***");
        Balones.forEach(objeto -> {
            System.out.println(objeto);
        });
    }

    public void procesarComandos() {
        Scanner sc = new Scanner(System.in);
        String[] entradas;
        do {
            entradas = sc.next().split("&");
            if (entradas[0].equals("1")) {
                if (entradas[1].equals("Profesional")) {
                    Profesional balonProfesional = new Profesional(entradas[4],entradas[3],entradas[2],entradas[5]);
                    agregarBalones(balonProfesional);
                } else if (entradas[1].equals("Novato")) {
                    Novato balonNovato = new Novato(entradas[4],entradas[3],entradas[2],entradas[5]);
                    agregarBalones(balonNovato);
                }
            }else if(entradas[0].equals("2")){
                listarBalones();
            }
        } while (!entradas[0].equals("3"));

    }

}
