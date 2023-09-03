//DUNIER JAVIER BOLAÑOS RAMÍREZ, JAVA, 03-09-2023
package portafolio02;

/**
 *
 * @author djjav
 */
public class CrearMatriz {

    public static void main(String[] args) {

    }

    // Método para crear una matriz con las dimensiones especificadas
    public static int[][] crearMatriz(int rows, int columns) {
        return new int[rows][columns];
    }

    // Método para llenar la matriz con números del rango especificado3
    public static void llenarMatriz(int[][] matriz, int min, int max) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * (max - min + 1)) + min;
            }
        }
    }

    //Método para mostrar la matriz 
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t"); // Use \t for tab character
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

}
