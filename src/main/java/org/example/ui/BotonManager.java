package org.example.ui;

/**
 * Clase que administra la activación y desactivación de botones en una calculadora.
 */
public class BotonManager {
    // Creo funciones para activar los botones de forma agrupada
    /**
     * Activa los botones de operación en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    public static void activarBotonOperacion(Calculadora calculadora) {
        calculadora.btnSumar.setEnabled(true);
        calculadora.btnRestar.setEnabled(true);
        calculadora.btnMultiplicar.setEnabled(true);
        calculadora.btnDividir.setEnabled(true);
        calculadora.btnPotencia.setEnabled(true);
    }
    /**
     * Activa los botones numéricos en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    public static void activarBotonesNum(Calculadora calculadora) {
        calculadora.btn1.setEnabled(true);
        calculadora.btn2.setEnabled(true);
        calculadora.btn3.setEnabled(true);
        calculadora.btn4.setEnabled(true);
        calculadora.btn5.setEnabled(true);
        calculadora.btn6.setEnabled(true);
        calculadora.btn7.setEnabled(true);
        calculadora.btn8.setEnabled(true);
        calculadora.btn9.setEnabled(true);
        calculadora.btn0.setEnabled(true);
        calculadora.btn00.setEnabled(true);
    }
    /**
     * Activa los botones restantes (raíz cuadrada, igual, punto y cambio de signo) en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    static void activarBotonesOtros(Calculadora calculadora) {
        calculadora.btnRaiz.setEnabled(true);
        calculadora.btnIgual.setEnabled(true);
        calculadora.btnPunto.setEnabled(true);
        calculadora.btnMasMenos.setEnabled(true);
    }
    /**
     * Activa todos los botones en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    public static void activarBotonesTodos(Calculadora calculadora) {
        activarBotonOperacion(calculadora);
        activarBotonesOtros(calculadora);
        activarBotonesNum(calculadora);
    }

    // Creo funciones para desactivar los botones de forma agrupada
    /**
     * Desactiva los botones de operación en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    public static void desactivarBotonOperacion(Calculadora calculadora) {
        calculadora.btnSumar.setEnabled(false);
        calculadora.btnRestar.setEnabled(false);
        calculadora.btnMultiplicar.setEnabled(false);
        calculadora.btnDividir.setEnabled(false);
        calculadora.btnPotencia.setEnabled(false);
    }
    /**
     * Desactiva los botones numéricos en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    public static void desactivarBotonesNum(Calculadora calculadora) {
        calculadora.btn1.setEnabled(false);
        calculadora.btn2.setEnabled(false);
        calculadora.btn3.setEnabled(false);
        calculadora.btn4.setEnabled(false);
        calculadora.btn5.setEnabled(false);
        calculadora.btn6.setEnabled(false);
        calculadora.btn7.setEnabled(false);
        calculadora.btn8.setEnabled(false);
        calculadora.btn9.setEnabled(false);
        calculadora.btn0.setEnabled(false);
        calculadora.btn00.setEnabled(false);
    }
    /**
     * Desactiva los botones restantes (raíz cuadrada, igual, punto y cambio de signo) en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    public static void desactivarBotonesOtros(Calculadora calculadora) {
        calculadora.btnRaiz.setEnabled(false);
        calculadora.btnIgual.setEnabled(false);
        calculadora.btnPunto.setEnabled(false);
        calculadora.btnMasMenos.setEnabled(false);
    }
    /**
     * Desactiva todos los botones en la calculadora.
     *
     * @param calculadora Hace referencia a la instancia de la calculadora en la que se activarán los botones.
     */
    public static void desactivarBotonesTodos(Calculadora calculadora) {
        desactivarBotonOperacion(calculadora);
        desactivarBotonesOtros(calculadora);
        desactivarBotonesNum(calculadora);
    }
}