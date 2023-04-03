import java.util.Scanner;

public class Palabras {
    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static boolean estaVacio(String input) {
        return input.isEmpty() || input.isBlank();
    }

    public static int encontrarCoincidencias(String [] inputUsuario, String letra) {
        int contador = 0;

        for (int i = 0; i < inputUsuario.length; i++) {
            if(inputUsuario[i].equalsIgnoreCase(letra)) {
                System.out.println("Hay una " + letra + " en la posición " + i);
                contador++;
            }
        }

        return contador;
     }

    public static boolean esLetra(String input) {
        return !estaVacio(input) && input.matches("^[a-zA-Z]*$") && input.chars().count() == 1;
    }

    public static String pedirLetra() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Ingrese una letra.");
            input = scanner.nextLine();
        }while(!esLetra(input));

        return input;
    }

    public static String [] convertirArreglo(char[] arregloChar) {
        String [] arregloString = new String[arregloChar.length];

        for(int i = 0; i < arregloString.length; i++) {
            arregloString[i] = String.valueOf(arregloChar[i]);
        }

        return arregloString;
    }

    public static String pedirInput(String enunciado) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(enunciado);
            input = scanner.nextLine();
        }while(estaVacio(input));

        return input;
    }

    public static void iniciarPrograma() {
        String palabra = pedirInput("Por favor ingrese una palabra o frase.");
        String [] palabraArreglo = convertirArreglo(palabra.toCharArray());
        String letra = pedirLetra();
        int contador = encontrarCoincidencias(palabraArreglo, letra);

        if(contador == 0) {
            System.out.println("No hay coincidencias.");
        }else {
            System.out.println("Hay " + contador + " coincidencia(s).");
        }
    }
}
