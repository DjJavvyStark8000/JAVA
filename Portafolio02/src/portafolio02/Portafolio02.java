//DUNIER JAVIER BOLAÑOS RAMÍREZ, JAVA, 03-09-2023
package portafolio02;

import java.util.Scanner;

/**
 *
 * @author djjav
 */
public class Portafolio02 {

    public static int[][] matriz;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showMenu();
        Scanner scanUser = new Scanner(System.in);
        String fromUser = scanUser.nextLine();

        Portafolio02 forMenu = new Portafolio02();//access by instance
        forMenu.seleccionarMenu(forMenu.numForMenu(fromUser));
    }

    public static void showMenu() {
        System.out.println("--FAVOR SELECCCIONE UNA OPCIÓN--");
        System.out.println("1- Número Factorial");
        System.out.println("2- Los 10 primeros números primos");
        System.out.println("3- Crear una matriz de números al azar");
        System.out.println("4- Obtener el número mayor de la matriz");
        System.out.println("5- Salir");
        System.out.println();
    }

    public int numForMenu(String num) {//returns numeric value selected by user
        int numeric = 0;
        try {
            numeric = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("Debe de ingresar un número válido");
        }
        return numeric;
    }

    public void seleccionarMenu(int num) {

        do {
            switch (num) {
                case 1:
                    Factorial factorial = new Factorial();
                    factorial.findFactorial();
                    break;
                case 2:
                    NumerosPrimos primo = new NumerosPrimos();
                    System.out.println(primo.filterNumbers());
                    break;
                case 3:
                    CrearMatriz matrix = new CrearMatriz();
                    int[][] matriz = matrix.crearMatriz(5, 6);
                    matrix.llenarMatriz(matriz, 1, 200);
                    matrix.mostrarMatriz(matriz);

                    break;
                case 4:
                    CrearMatriz matrix2 = new CrearMatriz();
                    int[][] matriz2 = matrix2.crearMatriz(5, 6);
                    matrix2.llenarMatriz(matriz2, 1, 200);
                    BuscarNumMayor mayor = new BuscarNumMayor();                    
                    System.out.println("El numero mas grande encontrado es: " + mayor.biggestNum(matriz2));
                    break;
                case 5:
                    System.out.println("Adios amigos");
                    break;
                default:
                    fakeClean();//this is a fake CLEAN option 
                    showMenu();
                    Scanner scanUser = new Scanner(System.in);
                    String fromUser = scanUser.nextLine();
                    Portafolio02 forMenu = new Portafolio02();//access by instance
                    forMenu.seleccionarMenu(forMenu.numForMenu(fromUser));
            }

        } while (num <= 0 || num > 5);

    }

    public static void fakeClean() {
        for (int i = 0; i <= 5; i++) {
            System.out.println();
        }
    }

}
