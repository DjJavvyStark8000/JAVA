/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio01;

/**
 *
 * @author djjav
 */
public class Portafolio01B {
  public static void main(String[] args) {
        // Parte a: Métodos de la clase String
        String texto = "Hola, esto es un ejemplo de String en Java.";

        // 1. Obtener la longitud del texto
        int longitud = texto.length();
        System.out.println("Longitud del texto: " + longitud);

        // 2. Convertir todo el texto a mayúsculas
        String textoEnMayusculas = texto.toUpperCase();
        System.out.println("Texto en mayúsculas: " + textoEnMayusculas);

        // 3. Obtener el índice de la primera aparición de una palabra o carácter
        int indice = texto.indexOf("ejemplo");
        System.out.println("Índice de 'ejemplo': " + indice);

        // 4. Extraer una parte del texto
        String subtexto = texto.substring(9, 18);
        System.out.println("Subtexto: " + subtexto);

        // 5. Reemplazar una parte del texto
        String textoReemplazado = texto.replace("Java", "Programación Java");
        System.out.println("Texto reemplazado: " + textoReemplazado);

        // Parte b: Conversiones de tipo String a int y double
        String numeroEnteroComoString = "123";
        int entero = Integer.parseInt(numeroEnteroComoString);
        System.out.println("Entero: " + entero);

        String numeroDecimalComoString = "45.67";
        double decimal = Double.parseDouble(numeroDecimalComoString);
        System.out.println("Decimal: " + decimal);

        // Parte c: Conversiones de tipos numéricos a String
        int numeroEntero = 456;
        String enteroComoString = String.valueOf(numeroEntero);
        System.out.println("Entero como String: " + enteroComoString);

        double numeroDecimal = 78.90;
        String decimalComoString = String.valueOf(numeroDecimal);
        System.out.println("Decimal como String: " + decimalComoString);

        // Parte d: Comparaciones y concatenaciones entre Strings
        String cadena1 = "Hola";
        String cadena2 = "Mundo";

        // Comparación de cadenas
        boolean sonIguales = cadena1.equals(cadena2);
        System.out.println("¿Las cadenas son iguales? " + sonIguales);

        // Concatenación de cadenas
        String concatenacion = cadena1 + ", " + cadena2;
        System.out.println("Concatenación: " + concatenacion);
    }  
}
