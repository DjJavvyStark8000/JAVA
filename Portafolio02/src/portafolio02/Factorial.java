//DUNIER JAVIER BOLAÑOS RAMÍREZ, JAVA, 03-09-2023
package portafolio02;

import java.util.Scanner;

/**
 *
 * @author djjav
 */
public class Factorial {

    public static void main(String[] args) {

    }

    public static int findFactorial() {
        int factorial = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número entero positivo: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("El factorial no está definido para números negativos.");
        } else {
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            System.out.println("El factorial de " + numero + " es " + factorial);
        }

        return factorial;
    }
}
