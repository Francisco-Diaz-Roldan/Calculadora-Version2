package org.example;

import org.example.ui.Calculadora;

/**
 * Esta es la clase principal desde la que se inicializa la aplicación de la calculadora.
 * Crea una instancia de la calculadora y la muestra por pantalla
 */
public class Main {
    public static void main(String[] args) {
            Calculadora calculadora = new Calculadora();
            calculadora.mostrar();
    }
}