package reto3;

import java.util.ArrayList;
import java.util.Arrays;

public class Tazos {
    
    public static ArrayList<Integer> sinRepetidos(ArrayList<Integer> lista_categoria_tazos) {
        ArrayList<Integer> tazosSinRepetir = new ArrayList<>();
        lista_categoria_tazos.forEach(objeto -> {
            if (!(tazosSinRepetir.contains(objeto))) {
                tazosSinRepetir.add(objeto);
            }
        });
        return tazosSinRepetir;
    }

    public static ArrayList<Integer> apuestaTazos(ArrayList<Integer> apuesta, ArrayList<Integer> resultados, Integer categoria) {
        ArrayList<Integer> salida = new ArrayList<>();
        
        apuesta.forEach(objeto -> {
            System.out.println(objeto);
            if (resultados.get(objeto) == categoria) {
                salida.add(objeto);
            }
        });
        return salida;
    }

    public static ArrayList<Integer> notengo(ArrayList<Integer> listaada, ArrayList<Integer> listasneuman) {
        ArrayList<Integer> salida = new ArrayList<>();
        listaada.forEach(objeto -> {
            if (!listasneuman.contains(objeto)) {
                salida.add(objeto);
            }
        });
        return salida;
    }

    public static int intercambiables(ArrayList<Integer> listaada, ArrayList<Integer> listasneuman) {
        int salida = 0;
        Integer tamaño1 = notengo(listaada, listasneuman).size();
        Integer tamaño2 = notengo(listasneuman, listaada).size();

        if (tamaño1 < tamaño2) {
            salida = tamaño1;
        } else {
            salida = tamaño2;
        }
        return salida;
    }

    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 1, 3, 2, 5));

        ArrayList<Integer> apuesta = new ArrayList<>(Arrays.asList(0, 2, 3, 4, 8));
        ArrayList<Integer> resultados = new ArrayList<>(Arrays.asList(1, 2, 1, 5, 1, 6, 7, 8, 0, 1, 1, 9, 10, 4, 1));
        Integer categoria = 1;

        ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(3, 5, 7, 10, 15, 16));
        ArrayList<Integer> lista2 = new ArrayList<>(Arrays.asList(4, 10, 5, 8));
        //System.out.println(sinRepetidos(test));
        System.out.println(apuestaTazos(apuesta, resultados, categoria));
        //System.out.println(notengo(lista1, lista2));
        //System.out.println(intercambiables(lista1, lista2));
    }
}
