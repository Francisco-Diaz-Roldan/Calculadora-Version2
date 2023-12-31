package org.example.ui;

import javax.swing.*;
import java.util.Objects;
import static org.example.ui.BotonManager.*;
import static org.example.ui.Constantes.*;

/**
 * Esta clase representa una calculadora con su propia interfaz de usuario.
 * Permite la realización de operaciones matemáticas y muestra los resultados por pantalla
 */

 public class Calculadora extends JFrame {
    //Declaro las variables que va a utilizar la clase Calculadora
    /**
     * JTextField se utilizaa para mostrar el resultado de las operaciones en la interfaz de usuario.
     */
    private JTextField txtResultado;
    /**
     * JPanel principal con la interfaz de la calculadora.
     */
    private JPanel Panel;
    /**
     * JPanel adicional que contiene elementos extra en la interfaz.
     */
    private JPanel Panel1;
    /**
     * Botón 0.
     */
    protected JButton btn0;
    /**
     * Botón 00.
     */
    protected JButton btn00;
    /**
     * Botón 1.
     */
    protected JButton btn1;
    /**
     * Botón 2.
     */
    protected JButton btn2;
    /**
     * Botón 3.
     */
    protected JButton btn3;
    /**
     * Botón 4.
     */
    protected JButton btn4;
    /**
     * Botón 5.
     */
    protected JButton btn5;
    /**
     * Botón 6.
     */
    protected JButton btn6;
    /**
     * Botón 7.
     */
    protected JButton btn7;
    /**
     * Botón 8.
     */
    protected JButton btn8;
    /**
     * Botón 9.
     */
    protected JButton btn9;
    /**
     * Botón de suma.
     */
    protected JButton btnSumar;
    /**
     * Botón de resta.
     */
    protected JButton btnRestar;
    /**
     * Botón de multiplicar.
     */
    protected JButton btnMultiplicar;
    /**
     * Botón de dividir.
     */
    protected JButton btnDividir;
    /**
     * Botón de cambio de signo.
     */
    protected JButton btnMasMenos;
    /**
     * Botón de potencia.
     */
    protected JButton btnPotencia;
    /**
     * Botón de raiz.
     */
    protected JButton btnRaiz;
    /**
     * Botón de igualar.
     */
    protected JButton btnIgual;
    /**
     * Botón C.
     */
    protected JButton btnC;
    /**
     * Botón AC.
     */
    protected JButton btnAC;
    /**
     * Botón punto.
     */
    protected JButton btnPunto;
    /**
     * Valor valor1.
     */
    private double valor1 = 0.0;
    /**
     * Valor valor2.
     */
    private double valor2 = 0.0;
    /**
     * Valor resultado.
     */
    private double resultado = 0.0;
    /**
     * Caracter operador.
     */
    private char operador;
    /**
     * Booleano para la detección de errores.
     */
    private boolean existenErrores;
    /**
     * Booleano para la detección de cálculos realizados.
     */
    private boolean calculoRealizado = false;

    /**
     * Constructor de la clase Calculadora.
     * Configura la vista de la ventana Calculadora y sus componentes.
     */
    public Calculadora() {
        // Configuro la vista de la ventana Calculadora
        configurarVentana();
        mostrar();

        // Llamo a BotonManager para activar y para desactivar los botones
        activarBotonOperacion(this);
        activarBotonesNum(this);
        activarBotonesOtros(this);
        activarBotonesTodos(this);
        desactivarBotonOperacion(this);
        desactivarBotonesNum(this);
        activarBotonesOtros(this);
        activarBotonesTodos(this);
        reiniciarPantalla(); // Establezco "0" como valor predeterminado en la calculadora

        // Configuro los botones numéricos
        // Configuro el boton0
        btn0.addActionListener(e -> {
            String txtResultadoActual = txtResultado.getText();
            if (txtResultadoActual.contains(".")){
                if (txtResultadoActual.isEmpty()) {// Compruebo que el resultado que aparece en pantalla esté vacío
                    reiniciarPantalla();           // Para poder escribir un solo "0" al iniciar la calculadora
                } else if (txtResultadoActual.equals("0")||txtResultadoActual.equals("00")) {
                    // Si el resultado que aparece en pantalla es "0", no añade otro "0"
                } else {// En cualquier otro caso se añade "0"
                    String btn0Text = txtResultado.getText() + btn0.getText();
                    txtResultado.setText(btn0Text);
                }
            }else{
                actualizarTxtResultado("0");
            }

        });
        // Configuro el boton00
        btn00.addActionListener(e -> {
            String txtResultadoActual = txtResultado.getText();
            if (txtResultadoActual.isEmpty()){
                reiniciarPantalla();// Para no escribir "00" en lugar de "0" en caso de que no haya nada en pantalla
            }//Para que escriba "00" en lugar de 0
            if (!txtResultadoActual.isEmpty() && !txtResultadoActual.equals("0") && !txtResultadoActual.equals("00")) {
                actualizarTxtResultado("00");
            } else if (txtResultadoActual.isEmpty() && txtResultadoActual.equals("00")){
                reiniciarPantalla();// Para no escribir "00" en lugar de "0" en caso de que no haya nada en pantalla
            }
        });
        // Configuro el boton1
        btn1.addActionListener(e -> {
            actualizarTxtResultado(UNO);
        });
        // Configuro el boton2
        btn2.addActionListener(e -> {
            actualizarTxtResultado(DOS);
        });
        // Configuro el boton3
        btn3.addActionListener(e -> {
            actualizarTxtResultado(TRES);
        });
        // Configuro el boton4
        btn4.addActionListener(e -> {
            actualizarTxtResultado(CUATRO);
        });
        // Configuro el boton5
        btn5.addActionListener(e -> {
            actualizarTxtResultado(CINCO);
        });
        // Configuro el boton6
        btn6.addActionListener(e -> {
            actualizarTxtResultado(SEIS);
        });
        // Configuro el boton7
        btn7.addActionListener(e -> {
            actualizarTxtResultado(SIETE);
        });
        // Configuro el boton8
        btn8.addActionListener(e -> {
            actualizarTxtResultado(OCHO);
        });
        // Configuro el boton9
        btn9.addActionListener(e -> {
            actualizarTxtResultado(NUEVE);
        });

        // Configuro los botones operacionales
        setBotonOperacion(btnSumar);
        setBotonOperacion(btnRestar);
        setBotonOperacion(btnMultiplicar);
        setBotonOperacion(btnDividir);
        setBotonOperacion(btnPotencia);
        btnRaiz.addActionListener(e -> {
            calcularRaiz();// Llamo al método que me permite hacer raices cuadradas
        });
        // Configuro el boton de cambio de signo
        btnMasMenos.addActionListener(e -> {
            if (!txtResultado.getText().isEmpty() && !Objects.equals(txtResultado.getText(), "0")){
                double num = Double.parseDouble(txtResultado.getText());
                num = num * -1;
                if (num == (int) num) {
                    txtResultado.setText(String.valueOf((int) num));
                } else {
                    txtResultado.setText(String.valueOf(num));
                }
            }
        });
        // Configuro el boton de igualdad
        btnIgual.addActionListener(e -> {
            // Compruebo que txtResultado no esté vacío
            if (txtResultado.getText().isEmpty()){
                return;
            }
            // Para que no siga operando tras darle al "=" tras una operación
            if (operador == '\0') {// No hace nada en caso de que no se seleccione un operador
                return;
            }
            valor2 = Double.parseDouble(txtResultado.getText()); // Declaro el segundo operando
            if (valor2 == 0 && operador=='÷') {// En caso de que el segundo valor sea 0 y el operador de division
                txtResultado.setText(ERROR_DIVISION_CERO);// Se imprime por pantalla el error
                existenErrores=true;// La variable de control de errores pasa a true
                BotonManager.desactivarBotonesTodos(this);// Se desactivan los botones
                btnC.setEnabled(false);// Aseguramos la desactivación del boton C
                return;
            }else{
                realizarOperacion(valor1, valor2, operador);// Realizamos la operación
                operador = '\0'; // Reiniciamos el operador
                if (!existenErrores){
                    // Activamos los botones de operación en caso de que no haya errores
                    BotonManager.activarBotonOperacion(this);
                }
                conversorDouble();// Convertimos el resultado a enteros en caso de que los decimales sean "0"
                valor1 = resultado;
                calculoRealizado = true;
                btnC.setEnabled(true);
            }
            btnC.setEnabled(false);
        });
        // Configuro el botonAC que borra todo en pantalla
        btnAC.addActionListener(e -> {
            valor1 = 0;
            valor2 =0;
            resultado = 0;
            operador = '\0'; // Se reinicia el operador
            btnC.setEnabled(true);
            existenErrores=false;
            activarBotonesTodos(this);
            reiniciarPantalla();
        });
        // Configuro el botonC, que borra el último número en pantalla
        btnC.addActionListener(e -> {
            String resultado = null;
            if (!txtResultado.getText().isEmpty()) {
                StringBuilder strB = new StringBuilder(txtResultado.getText());
                strB.deleteCharAt(txtResultado.getText().length() - 1);
                resultado = String.valueOf(strB);
                txtResultado.setText(resultado);
            }else{// Si se ha pulsado sobre un operador por error, si se le da al botón C se reactivan los botones
                activarBotonOperacion(this);
            }
        });
        // Configuro el botonPunto para que funcione correctamente como en cualquier calculadora
        btnPunto.addActionListener(e -> {
            if (calculoRealizado) {
                txtResultado.setText("0.");
                calculoRealizado = false;
            } else {
                String txtResultadoActual = txtResultado.getText();
                if (txtResultadoActual.isEmpty() || txtResultadoActual.equals("0") || txtResultadoActual.equals("00")) {
                    txtResultado.setText("0.");// En este caso tras pulsar sobre el boton se escribe "0."
                } else if (!txtResultadoActual.contains(".")) {// En caso de que no haya "." lo añade
                    String btnPuntoText = txtResultado.getText() + btnPunto.getText();
                    txtResultado.setText(btnPuntoText);
                }
            }
            btnPunto.setEnabled(true);
        });
    }
    // Creo los métodos de la clase Calculadora
    /**
     * Reinicia la pantalla de la calculadora, estableciendo el valor del texto en "0".
     */
    private void reiniciarPantalla() {
        txtResultado.setText("0");
    }
    /**
     * Establece el campo de texto de la calculadora en una cadena de texto vacía, limpiando la pantalla.
     */
    private void limpiarPantalla() {
        txtResultado.setText("");
    }
    /**
     * Actualiza el campo de texto de la calculadora con el valor proporcionado.
     *
     * @param num El número que se va a mostrar por pantalla.
     */
    private void actualizarTxtResultado(String num) {
        if (txtResultado.getText().equals("0") || calculoRealizado) {
            if (num.equals(".")) {
                txtResultado.setText("0.");
            } else {
                txtResultado.setText(num);
            }
            calculoRealizado = false; // Reiniciar el estado de cálculo de la raíz
            btnC.setEnabled(true);
        } else if (txtResultado.getText().endsWith(".") && num.equals(".")) {
            // Si ya hay un punto y se agrega otro punto, mantén el valor actual
            return;
        } else {
            String texto = txtResultado.getText() + num;
            txtResultado.setText(texto);
        }
        if (existenErrores) {
            desactivarBotonOperacion(this);
            btnC.setEnabled(false);
            btnRaiz.setEnabled(false);
        }
    }
    /**
     * Configura un botón de operación para que realice la operación correspondiente cuando se pulse en un operador.
     *
     * @param boton El botón de operación.
     */
    private void setBotonOperacion(JButton boton) {
        boton.addActionListener(e -> {
            String btnTexto = boton.getText();
            getOperador(btnTexto);// Le añado el operador correspondiente
            if (!existenErrores){ // En caso de que no existan errores actúa con normalidad
                activarBotonOperacion(this);
            }
            btnC.setEnabled(true);
            if (txtResultado.getText().equals(ERROR_DIVISION_CERO)) {// En caso contrario imprime el error por pantalla
                desactivarBotonOperacion(this);// Desactiva todos los botones
                btnC.setEnabled(false);// Me aseguro de que el btnC esté inactivo
            }
        });
    }
    /**
     * Obtiene el operador a partir del texto de un botón y realiza las operaciones correspondientes.
     *
     * @param btnTexto El texto del botón que contiene el operador.
     */
    private void getOperador(String btnTexto) {
        char ultimoOperador = '\0';// Char para almacenar el último operador seleccionado.
        if (!txtResultado.getText().isEmpty()) {
            if (operador == '\0') {
                valor1 = Double.parseDouble(txtResultado.getText());
            } else {
                valor2 = Double.parseDouble(txtResultado.getText());
                realizarOperacion(valor1, valor2, operador);
                valor1 = resultado;
                valor2 = 0.0;
            }
            operador = btnTexto.charAt(0);
            limpiarPantalla();
            desactivarBotonOperacion(this);
            btnC.setEnabled(false);
            ultimoOperador = operador;
        } else if (operador != '\0') {
            operador = btnTexto.charAt(0);
            ultimoOperador = operador;
        }
    }
    /**
     * Realiza todas las operaciones, a excepcion de la raiz cuadrada, utilizando el operador y los valores actuales.
     *
     * @param valor1    El primer valor numérico de la operación.
     * @param valor2    El segundo valor numérico de la operación.
     * @param operador  El operador matemático.
     */
    private void realizarOperacion(double valor1, double valor2, char operador) {
        btnC.setEnabled(false);
        switch (operador) {
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case 'x':
                resultado = valor1 * valor2;
                break;
            case '÷':
                resultado = valor1 / valor2;
                break;
            case '^':
                resultado = Math.pow(valor1, valor2);
                break;
        }
        // Restablezco el "valor1" y muestro el resultado por pantalla
        valor1 = resultado; //Guardo este valor para futuribles operaciones
        txtResultado.setText(Double.toString(resultado));
        // Me aseguro de que devuelva números enteros en caso de devolver un número terminado en ".0"
        conversorDouble();
    }
    /**
     * Calcula la raíz cuadrada de un número y actualiza la pantalla con el resultado.
     */
    private void calcularRaiz() {
        String txtResultadoActual = txtResultado.getText();
        if (!txtResultadoActual.isEmpty()) {
            double numero = Double.parseDouble(txtResultadoActual);
            double resultado = Math.sqrt(numero);
            if (txtResultadoActual.contains("-")){// En caso de que el numero sea negativo
                txtResultado.setText(ERROR_RAIZ);// Se imprime el mensaje de error por pantalla
                existenErrores=true;// Activo la variable de control de errores
                btnC.setEnabled(false);// Me aseguro de que btnC no se vuelve a activar
                desactivarBotonesTodos(this);
            }else{// En cualquier otro caso hace las raices cuadradas con normalidad
                // Comprueba a ver si el resultado es un número entero
                if (resultado == (int) resultado) {
                    txtResultado.setText(Integer.toString((int) resultado));
                } else {
                    txtResultado.setText(Double.toString(resultado));
                }
                calculoRealizado = true;
            }
        }
    }
    /**
     * Convierte el resultado actual en un número entero si es necesario.
     */
    private void conversorDouble() {
        if (resultado % 1 == 0) {
            txtResultado.setText(Integer.toString((int) resultado));
        } else {
            txtResultado.setText(Double.toString(resultado));
        }
    }
    // Creo los métodos para mostrar la ventana por pantalla
    /**
     * Configura el tamaño y el título de la ventana de la calculadora.
     */
    private void configurarVentana() {
        this.setContentPane(Panel1);
        //this.pack();
        this.setSize(375,275);
        this.setTitle("Calculadora");
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    /**
     * Muestra la ventana de la calculadora en pantalla.
     */
    public void mostrar() {
        this.setVisible(true);
    }
}