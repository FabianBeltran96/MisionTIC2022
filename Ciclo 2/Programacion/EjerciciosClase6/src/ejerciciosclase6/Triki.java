package ejerciciosclase6;


public class Triki {

    public char[][] matriz;

    public Triki() {
        this.matriz = new char[][]{{'a', 'a', 'a'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}};

    }

    public void marcarCasilla(char simbolo, int fila, int columna) {
        matriz[fila][columna] = simbolo;
    }

    public char verificadorGanador() {
        
        if ((matriz[0][0] == matriz[1][1]) && (matriz[0][0] == matriz[2][2]) && (matriz[0][0] != 'a'))
            return matriz[0][0];
        if ((matriz[0][2] == matriz[1][1]) && (matriz[2][0] == matriz[1][1]) && (matriz[1][1] != 'a'))
            return matriz[1][1];

        for (int i = 0; i < 3; i++) {
            if (matriz[i][i] == 'a')
                continue;

            if ((matriz[i][0] == matriz[i][1]) && (matriz[i][0] == matriz[i][2]))
                return matriz[i][0];

            if ((matriz[0][i] == matriz[1][i]) && (matriz[0][i] == matriz[2][i]))
                return matriz[0][i];

        }

        return '5';
    }

    public char verificarCasilla(int fila, int columna) {
        return matriz[fila][columna];
    }

    public void imprimir() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
