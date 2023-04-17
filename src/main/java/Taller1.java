import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Taller1 {
    public static void main(String[] args) {
        double [][] estudiantes = new double[50][5];
        menu(estudiantes);
    }

    public static void menu(double [][] estudiantes) {
        int opcionUsuario;

        do {
            mostrarMenu();
            opcionUsuario = pedirInput();

            switch (opcionUsuario) {
                case 1 -> agregarEstudiante(estudiantes);
                case 2 -> mostrarAprobados(estudiantes);
                case 3 -> mostrarReprobados(estudiantes);
                case 4 -> mostrarRindenExamen(estudiantes);
                case 5 -> mostrarEstadoAsignatura(estudiantes);
                case 6 -> System.out.println("Programa finalizado.");
            }
        } while (opcionUsuario != 6);
    }

    public static void mostrarMenu() {
        System.out.println("""
                Menú
                1) Agregar estudiante.
                2) Mostrar la cantidad de estudiantes que aprueban la asignatura.
                3) Mostrar la cantidad de estudiantes que reprueban la asignatura.
                4) Mostrar la cantidad de estudiantes que van a examen.
                5) Mostrar el estado de todos los estudiantes.
                6)Salir.
                """);
    }

    public static void mostrarReprobados(double[][] estudiantes) {
        System.out.println("Hay " + contarReprobados(estudiantes) + " estudiantes reprobados.");
    }

    public static int contarReprobados(double [][] estudiantes) {
        int reprobados = 0;
        int ultimoEstudiante = obtenerUltimoEspacio(estudiantes);

        for (int i = 0; i < ultimoEstudiante; i++) {
            if (calcularPromedio(estudiantes[i]) < 3.6) reprobados++;
        }

        return reprobados;
    }

    public static void mostrarAprobados(double[][] estudiantes) {
        System.out.println("Hay " + contarAprobados(estudiantes) + " estudiantes aprobados.");
    }

    public static int contarAprobados(double [][] estudiantes) {
        int aprobados = 0;

        for (double [] estudiante : estudiantes) {
            if (calcularPromedio(estudiante) > 4) aprobados++;
        }

        return aprobados;
    }

    public static void mostrarRindenExamen(double[][] estudiantes) {
        int rindeExamen = obtenerUltimoEspacio(estudiantes) - (contarAprobados(estudiantes) + contarReprobados(estudiantes));

        System.out.println("Hay " + rindeExamen + " estudiantes que rinden examen.");
    }

    public static void mostrarEstadoAsignatura(double [][] estudiantes) {
        int ultimoEstudiante = obtenerUltimoEspacio(estudiantes);

        for(int i = 0; i < ultimoEstudiante; i++) {
            System.out.println("Notas alumno " + (i + 1));

            for(int j = 0; j < estudiantes[0].length; j++) {
                System.out.print (formatearPromedio(estudiantes[i][j]) + "    ");
            }

            System.out.println();

            double promedio = calcularPromedio(estudiantes[i]);

            System.out.println(evaluarEstadoEstudiante(promedio) +
                    " con un promedio de: " +  formatearPromedio(promedio));
        }
    }

    public static String evaluarEstadoEstudiante(double promedio) {
        if(promedio > 4) {
            return "Aprueba";
        } else if(promedio < 3.6) {
            return  "Reprueba";
        }

        return "Rinde examen";
    }

    public static void agregarEstudiante(double [][] estudiantes) {
        if(hayCupo(estudiantes)) {
            int indiceDisponible = obtenerUltimoEspacio(estudiantes);
            estudiantes[indiceDisponible] = generarNotas();
            System.out.println("Estudiante agregado.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    public static int obtenerUltimoEspacio(double [][] estudiantes) {
        return estudiantes.length - espaciosDisponibles(estudiantes);
    }

    public static boolean hayCupo(double [][] estudiantes) {
        return espaciosDisponibles(estudiantes) != 0;
    }

    public static int espaciosDisponibles(double [][] estudiantes) {
        for(int i = 0; i < estudiantes.length; i++) {
            if(estudiantes[i][0] == 0){
                return estudiantes.length - i;
            }
        }

        return 0;
    }

    public static double calcularPromedio(double [] notas) {
        double [] ponderacionNotas = {0.25, 0.25, 0.25, 0.15, 0.10};
        double promedio = 0;

        for (int i = 0; i < notas.length; i++) {
            promedio += (notas[i] * ponderacionNotas[i]);
        }

        return promedio;
    }

    public static double [] generarNotas() {
        double [] notas = new double[5];

        for(int i = 0; i < notas.length; i++) {
            notas[i] = (Math.random() * 6) + 1;
        }

        return notas;
    }

    public static int pedirInput() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Opción inválida");
            return pedirInput();
        }
    }

    public static String formatearPromedio(double promedio) {
        DecimalFormat formateador = new DecimalFormat("#.00");
        return formateador.format(promedio);
    }
}