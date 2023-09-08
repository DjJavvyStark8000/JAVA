//DUNIER JAVIER BOLAÑOS RAMÍREZ, JAVA, 03-09-2023
package portafolio02;

/**
 *
 * @author djjav
 */
public class NumerosPrimos {
 
  
    public static String filterNumbers() {
        int num = 2;
    int cantidadPrimosEncontrados = 0; // Contador de números primos encontrado
    StringBuilder numerosPrimos = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        
    while (cantidadPrimosEncontrados < 10) {
        if (isPrime(num)) {
            cantidadPrimosEncontrados++;
            numerosPrimos.append(num);
            if (cantidadPrimosEncontrados < 10) {
                numerosPrimos.append(", "); // Add a comma and space as a separator
            }
        }
        num++;
    }
    return numerosPrimos.toString();
    }  
    
    public static boolean isPrime(int num){
    if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;   
    }
    
}
