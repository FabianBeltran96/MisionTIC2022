package ejerciciosclase6;

import java.util.Random;

public final class Contraseña {

    static int  Longitud;
    static String Contraseña;

    public Contraseña(int Longitud) {
        this.Longitud = Longitud;
        this.Contraseña = randomPassword();
    }

    public static String randomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String str = "";
        Random r = new Random();
        for (int i = 0; i < Longitud; i++) {
            str += chars.charAt(r.nextInt(chars.length()));
        }
        return str;
    }

    public boolean esFuerte() {
        String minusculas = Contraseña.toLowerCase();
        String mayusculas = Contraseña.toUpperCase();

        if (Contraseña.equals(minusculas)) {
            return false;
        }
        if (Contraseña.equals(mayusculas)) {
            return false;
        }

        int contador = 0;
        for (int x = 0; x < Longitud; x++) {
            int numero = (int) Contraseña.charAt(x);
            if (numero >= 48 && numero <= 57) {
                contador++;
            }
        }
        return contador >= 5;
    }

    public void cambiarContraseña(String nuevaContraseña) {
        Contraseña = nuevaContraseña;
    }

    @Override
    public String toString() {
        return "Contrase\u00f1a{" + "Longitud=" + Longitud + ", Contrase\u00f1a=" + Contraseña + '}';
    }

    public static void main(String[] args) {
        /*
        int contador = 0;
        Contraseña miContraseña = new Contraseña(8);
        boolean bandera = true;
        while (bandera) {
            contador++;
            System.out.println(miContraseña.Contraseña);
            System.out.println(miContraseña.toString());
            if (miContraseña.esFuerte()) {
                bandera = false;
            }
            miContraseña.cambiarContraseña(randomPassword());
            System.out.println(contador);
        }
        */
    }
}
