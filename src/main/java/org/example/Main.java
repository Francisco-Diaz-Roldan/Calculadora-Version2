package org.example;

import org.example.ui.Calculadora;

/**
 * Esta es la clase principal desde la que se inicializa la aplicación de la calculadora.
 */
public class Main {
    /**
     * Este es el método principal que inicia la aplicación de la calculadora.
     * @param args Los argumentos pasados a la aplicación (no se utilizan en este caso).
     */
    public static void main(String[] args) {
            Calculadora calculadora = new Calculadora();
            calculadora.mostrar();
    }
}