//DUNIER JAVIER BOLAÑOS RAMÍREZ, JAVA, 03-09-2023
package portafolio02;

/**
 *
 * @author djjav
 */
public class BuscarNumMayor {


   public static int biggestNum(int[][] matriz) {
    int result = Integer.MIN_VALUE; // Initialize result to the smallest possible integer value

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] > result) {
                result = matriz[i][j]; // Update result if a larger number is found
            }
        }
    }

    return result; // Return the largest number found
}

    public static boolean revisarMatriz(int[][] matrix) {
        boolean result = false;
        if (matrix.length > 0) {
            result = true;
            System.out.println(matrix.length);
        }
        return result;
    }
}
