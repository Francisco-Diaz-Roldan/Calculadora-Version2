package org.example.ui;

import javax.swing.*;

import static org.example.ui.Constantes.ERROR_DIVISION_CERO;

public class BotonManager {
    //Creo funciones para activar los botones de forma agrupada
    //Creo activarBotonOperacion para activar los botones de operación
    public static void activarBotonOperacion(Calculadora calculadora) {
        calculadora.btnSumar.setEnabled(true);
        calculadora.btnRestar.setEnabled(true);
        calculadora.btnMultiplicar.setEnabled(true);
        calculadora.btnDividir.setEnabled(true);
        calculadora.btnPotencia.setEnabled(true);
    }
    //Creo activarBotonesNum para activar los botones numéricos
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
    //Creo activarBotonesOtros para activar el resto de botones(raiz cuadrada, igual, punto y cambio de signo)
    static void activarBotonesOtros(Calculadora calculadora) {
        calculadora.btnRaiz.setEnabled(true);
        calculadora.btnIgual.setEnabled(true);
        calculadora.btnPunto.setEnabled(true);
        calculadora.btnMasMenos.setEnabled(true);
    }
    //Creo activarBotonesTodos para activar todos los botones a la vez
    public static void activarBotonesTodos(Calculadora calculadora) {
        activarBotonOperacion(calculadora);
        activarBotonesOtros(calculadora);
        activarBotonesNum(calculadora);
    }

    // Creo funciones para desactivar los botones de forma agrupada
    //Creo desactivarBotonOperacion para desactivar los botones de operación
    public static void desactivarBotonOperacion(Calculadora calculadora) {
        calculadora.btnSumar.setEnabled(false);
        calculadora.btnRestar.setEnabled(false);
        calculadora.btnMultiplicar.setEnabled(false);
        calculadora.btnDividir.setEnabled(false);
        calculadora.btnPotencia.setEnabled(false);
    }
    //Creo desactivarBotonesNum para desactivar los botones numéricos
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
    //Creo desactivarBotonesOtros para desactivar el resto de botones(raiz cuadrada, igual, punto y cambio de signo)
    public static void desactivarBotonesOtros(Calculadora calculadora) {
        calculadora.btnRaiz.setEnabled(false);
        calculadora.btnIgual.setEnabled(false);
        calculadora.btnPunto.setEnabled(false);
        calculadora.btnMasMenos.setEnabled(false);
    }
    //Creo desactivarBotonesTodos para desactivar todos los botones a la vez
    public static void desactivarBotonesTodos(Calculadora calculadora) {
        desactivarBotonOperacion(calculadora);
        desactivarBotonesOtros(calculadora);
        desactivarBotonesNum(calculadora);
    }
}