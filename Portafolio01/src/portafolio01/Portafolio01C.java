/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio01;
import java.util.Random;
/**
 *
 * @author djjav
 */
public class Portafolio01C {
    public static void main(String[] args) {
        // Generamos números aleatorios
        Random rand = new Random();
        int numero1 = rand.nextInt(100); // Genera un número aleatorio entre 0 y 99
        int numero2 = rand.nextInt(100); // Genera otro número aleatorio entre 0 y 99

        // Utilizamos métodos de la clase Math
        double raizCuadrada = Math.sqrt(numero1);
        double potencia = Math.pow(numero1, 2);
        double seno = Math.sin(numero1);
        double coseno = Math.cos(numero2);
        double redondeo = Math.round(Math.PI);

        // Realizamos conversiones de int a double
        double num1Double = (double) numero1;
        double num2Double = (double) numero2;

        // Operadores aritméticos
        double suma = num1Double + num2Double;
        double resta = num1Double - num2Double;
        double multiplicacion = num1Double * num2Double;
        double division = num1Double / num2Double;
        int modulo = numero1 % numero2;

        // Operadores de asignación
        double resultado = 0;
        resultado += suma;
        resultado -= resta;
        resultado *= multiplicacion;
        resultado /= division;

        // Imprimimos los resultados
        System.out.println("Número 1: " + numero1);
        System.out.println("Número 2: " + numero2);
        System.out.println("Raíz cuadrada de número 1: " + raizCuadrada);
        System.out.println("Número 1 elevado a la potencia 2: " + potencia);
        System.out.println("Seno de número 1: " + seno);
        System.out.println("Coseno de número 2: " + coseno);
        System.out.println("Redondeo de PI: " + redondeo);
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);
        System.out.println("Módulo: " + modulo);
        System.out.println("Resultado final: " + resultado);
    }
}
