//DUNIER JAVIER BOLANOS RAMIREZ 8/9/23
package portafolio03;

import java.util.Scanner;

/**
 *
 * @author djjav
 */
public class Empleados {

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
        
        int[] edades = null;
        String[] nombres = null;
        double[] salarios = null;
        int cantidadTrabajadores = 0;
        
        // Menú
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1) Indicar la cantidad de trabajadores.");
            System.out.println("2) Introducir los datos de los trabajadores.");
            System.out.println("3) Ordenar por nombre.");
            System.out.println("4) Ordenar por edad.");
            System.out.println("5) Ordenar por salario.");
            System.out.println("6) Mostrar información de los empleados.");
            System.out.println("7) Salir.");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de trabajadores: ");
                    cantidadTrabajadores = scanner.nextInt();
                    edades = new int[cantidadTrabajadores];
                    nombres = new String[cantidadTrabajadores];
                    salarios = new double[cantidadTrabajadores];
                    break;
                case 2:
                   if (cantidadTrabajadores > 0) {
                        for (int i = 0; i < cantidadTrabajadores; i++) {
                            System.out.println("Ingrese datos del trabajador #" + (i + 1));
                            scanner.nextLine(); // Consumir la línea en blanco
                            System.out.print("Nombre: ");
                            nombres[i] = scanner.nextLine();
                            System.out.print("Edad: ");
                            edades[i] = scanner.nextInt();
                            System.out.print("Salario: ");
                            salarios[i] = scanner.nextDouble();
                        }
                    } else {
                        System.out.println("Primero debe indicar la cantidad de trabajadores (Opción 1).");
                    }
                    break;
               case 3:
                    ordenarPorNombre(nombres, edades, salarios);
                    // Mostrar el resultado de ordenamiento
                    mostrarInformacionEmpleados(nombres, edades, salarios);
                    break;
                case 4:
                    ordenarPorEdad(nombres, edades, salarios);
                    // Mostrar el resultado de ordenamiento
                    mostrarInformacionEmpleados(nombres, edades, salarios);
                    break;
                case 5:
                    ordenarPorSalario(nombres, edades, salarios);
                    // Mostrar el resultado de ordenamiento
                    mostrarInformacionEmpleados(nombres, edades, salarios);
                    break;
                case 6:
                    // Mostrar información de los empleados
                    mostrarInformacionEmpleados(nombres, edades, salarios);
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    // Implementación de ordenamiento por nombre (usando el método de selección)
    public static void ordenarPorNombre(String[] nombres, int[] edades, double[] salarios) {
        for (int i = 0; i < nombres.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nombres.length; j++) {
                if (nombres[j].compareTo(nombres[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                intercambiar(nombres, i, minIndex);
                intercambiar(edades, i, minIndex);
                intercambiar(salarios, i, minIndex);
            }
        }
    }

    // Implementación de ordenamiento por edad (usando el método de selección)
    public static void ordenarPorEdad(String[] nombres, int[] edades, double[] salarios) {
        for (int i = 0; i < edades.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < edades.length; j++) {
                if (edades[j] < edades[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                intercambiar(nombres, i, minIndex);
                intercambiar(edades, i, minIndex);
                intercambiar(salarios, i, minIndex);
            }
        }
    }

    // Implementación de ordenamiento por salario (usando el método de selección)
    public static void ordenarPorSalario(String[] nombres, int[] edades, double[] salarios) {
        for (int i = 0; i < salarios.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < salarios.length; j++) {
                if (salarios[j] < salarios[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                intercambiar(nombres, i, minIndex);
                intercambiar(edades, i, minIndex);
                intercambiar(salarios, i, minIndex);
            }
        }
    }

    // Método para intercambiar elementos en los arreglos
    public static void intercambiar(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void intercambiar(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Método para mostrar la información de los empleados
    public static void mostrarInformacionEmpleados(String[] nombres, int[] edades, double[] salarios) {
        System.out.println("\nInformación de los empleados:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Trabajador #" + (i + 1));
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Edad: " + edades[i]);
            System.out.println("Salario: " + salarios[i]);
        }
    }

}
