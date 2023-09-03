//Instituto Nacional de Aprendizaje
//Docente: Luis Alonso Bogantes
//Módulo: JAVA
//Estudiante: Dunier Javier Bolaños Ramírez
//03/09/2023
package portafolio01;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author djjav
 */
public class Portafolio01A {
// Instance variables with default values

    int intValue;          // Defaults to 0
    double doubleValue;    // Defaults to 0.0
    boolean booleanValue;  // Defaults to false
    String stringValue;    // Defaults to null

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //(1) DATOS BOOLEANOS.............................................................
        boolean esVedadero = true;
        boolean esFalso = false;

        System.out.println(esVedadero);
        System.out.println(esFalso);

        //OPERADORES RELACIONALES.........................................................
        int numero1 = 10;
        int numero2 = 5;

// Igual a (==)
        boolean esIgual = (numero1 == numero2);
        System.out.println("¿numero1 es igual a numero2? " + esIgual);

// Diferente de (!=)
        boolean esDiferente = (numero1 != numero2);
        System.out.println("¿numero1 es diferente de numero2? " + esDiferente);

// Mayor que (>)
        boolean esMayor = (numero1 > numero2);
        System.out.println("¿numero1 es mayor que numero2? " + esMayor);

// Menor que (<)
        boolean esMenor = (numero1 < numero2);
        System.out.println("¿numero1 es menor que numero2? " + esMenor);

// Mayor o igual que (>=)
        boolean esMayorOigual = (numero1 >= numero2);
        System.out.println("¿numero1 es mayor o igual que numero2? " + esMayorOigual);

// Menor o igual que (<=)
        boolean esMenorOigual = (numero1 <= numero2);
        System.out.println("¿numero1 es menor o igual que numero2? " + esMenorOigual);

        //OPERADORES LOGICOS..............................................................
        boolean a = true;
        boolean b = false;
        boolean c = true;
        boolean resultado = a || b;

        System.out.println(resultado);//true

        resultado = !a;
        System.out.println(resultado); // false   

        resultado = (a && b) || (c && !b);//true
        System.out.println(resultado);

        //VALORES POR DEFECTO.............................................................
        Portafolio01A example = new Portafolio01A();

        System.out.println("Default values:");
        System.out.println("int: " + example.intValue);
        System.out.println("double: " + example.doubleValue);
        System.out.println("boolean: " + example.booleanValue);
        System.out.println("String: " + example.stringValue);

        //VARIABLE CONSTANTE.............................................................
        final int ANIO = 2023;

        // ANIO = 2024; //genera un error por que el valor su valor es final
        //CARACTERES DE ESCAPE...........................................................
        System.out.println("\\" + '\"' + "\'" + "\n" + "\\");

        //EJEMPLO ENUM NO PUEDE SE LOCAL..................................................
        Mascotas mascota = Mascotas.Perro;
        System.out.println(mascota);

        //INSTRUCCIONES DE SALIDA Y ENTRADA DE CONSOLA 
        System.out.println("Ingrese un dato:");

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Leer el dato ingresado por el usuario
        String dato = scanner.nextLine();

        // Mostrar el dato ingresado por el usuario
        System.out.println("Lo ingresado fue: " + dato);

        // Cerrar el objeto Scanner
        scanner.close();

        //ENVIO DE MENSAJES CON LA CLASE SWING............................................
        // Mostrar un cuadro de diálogo de mensaje de información
        JOptionPane.showMessageDialog(null, "Este es un mensaje de información.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        // Mostrar un cuadro de diálogo de mensaje de advertencia
        JOptionPane.showMessageDialog(null, "Esto es una advertencia.", "Advertencia", JOptionPane.WARNING_MESSAGE);

        // Mostrar un cuadro de diálogo de mensaje de error
        JOptionPane.showMessageDialog(null, "Se ha producido un error.", "Error", JOptionPane.ERROR_MESSAGE);

        // Mostrar un cuadro de diálogo de mensaje de pregunta (sí/no)
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Pregunta", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.out.println("El usuario eligió continuar.");
        } else {
            System.out.println("El usuario eligió no continuar.");
        }

        // Mostrar un cuadro de diálogo de entrada
        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:", "Entrada de Datos", JOptionPane.QUESTION_MESSAGE);
        if (nombre != null && !nombre.isEmpty()) {
            System.out.println("Hola, " + nombre + "!");
        } else {
            System.out.println("No ingresó un nombre.");
        }
    }
}

//EJEMPLO ENUM
enum Mascotas {
    Gato,
    Perro,
    Loro
}
