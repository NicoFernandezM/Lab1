public class Matriz {
    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static int [][] generarMatriz(int dimensionMatriz) {
        int [][] matriz = new int[dimensionMatriz][dimensionMatriz];

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = generarNumero();
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        return matriz;
    }

    private static int generarNumero() {
        return (int) ((Math.random() * 25) + 1);
    }

    public static int [] sumarFilas(int [][] matriz) {
        int [] sumaFilas = new int[matriz.length];

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[0].length; j++) {
                sumaFilas[i] += matriz[i][j];
            }
            System.out.println("Suma fila " + (i+1) + ": " + sumaFilas[i]);
        }

        System.out.println();

        return sumaFilas;
    }

    public static int [] sumarColumnas(int [][] matriz) {
        int [] sumaColumnas = new int[matriz.length];

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[0].length; j++) {
                sumaColumnas[i] += matriz[j][i];
            }
            System.out.println("Suma columna " + (i+1) + ": " + sumaColumnas[i]);
        }

        System.out.println();

        return sumaColumnas;
    }

    public static void mostrarMayor(int [] filas, int [] columnas) {
        for(int i = 0; i < filas.length; i++) {
            if(filaEsMayor(filas[i], columnas[i])) {
                System.out.println("La fila " + (i+1) + " es mayor");
            } else {
                System.out.println("La columna " + (i+1) + " es mayor");
            }
        }
        System.out.println();
    }

    public static boolean filaEsMayor(int fila, int columna) {
        return fila > columna;
    }

    public static void mostrarPrimos(int [][] matriz) {
        System.out.println("Números primos encontrados: ");
        int cantidadDePrimos = 0;

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[0].length; j++) {
                if(esPrimo(matriz[i][j])) {
                    System.out.print(matriz[i][j] + ", ");
                    cantidadDePrimos++;
                }
            }

        }

        System.out.println("\nHay " + cantidadDePrimos + " números primos");
    }

    public static boolean esPrimo(int numero) {
        if (numero == 1) return false;

        for(int i = 2; i < numero; i++) {
            if(numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void iniciarPrograma() {
        int [][] matriz = generarMatriz(5);
        int [] sumaFilas = sumarFilas(matriz);
        int [] sumaColumnas = sumarColumnas(matriz);
        mostrarMayor(sumaFilas, sumaColumnas);
        mostrarPrimos(matriz);
    }
}
