package org.example.ui;

import javax.swing.*;
import java.util.Objects;
import static org.example.ui.BotonManager.*;
import static org.example.ui.Constantes.*;

public class Calculadora extends JFrame {
    //Declaro las variables
    private JTextField txtResultado;
    private JPanel Panel;
    private JPanel Panel1;
    protected JButton btn0;
    protected JButton btn00;
    protected JButton btn1;
    protected JButton btn2;
    protected JButton btn3;
    protected JButton btn4;
    protected JButton btn5;
    protected JButton btn6;
    protected JButton btn7;
    protected JButton btn8;
    protected JButton btn9;
    protected JButton btnSumar;
    protected JButton btnRestar;
    protected JButton btnMultiplicar;
    protected JButton btnDividir;
    protected JButton btnMasMenos;
    protected JButton btnPotencia;
    protected JButton btnRaiz;
    protected JButton btnIgual;
    protected JButton btnC;
    protected JButton btnAC;
    protected JButton btnPunto;
    private double valor1 = 0.0;
    private double resultado = 0.0;
    private char operador;



    private final String txtErrorDiv0 ="No se puede dividir por 0";
    private final String txtErrorRaizNega ="Entrada no válida";
    private boolean existenErrores;
    private boolean calculoRealizado = false;

    public Calculadora() {
        // Configuro la vista de la ventana Calculadora
        configurarVentana();
        mostrar();

        // Llamo a BotonManager para activar los botones
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
        btn0.addActionListener(e -> {
            // Para poder escribir un solo "0" al principio
            String txtResultadoActual = txtResultado.getText();
            // Se comprueba que el resultado que aparece en pantalla esté vacío
            if (txtResultadoActual.isEmpty()) {
                txtResultado.setText("0");
            } else if (txtResultadoActual.equals("0")) {
                // Si el resultado que aparece en pantalla es "0", no deja que se añada otro
            } else {
                // En cualquier otro caso se añade "0"
                String btn0Text = txtResultado.getText() + btn0.getText();
                txtResultado.setText(btn0Text);
            }
        });

        btn00.addActionListener(e -> {
            String txtResultadoActual = txtResultado.getText();
            if (!txtResultadoActual.equals(CERO) && !calculoRealizado) {
                actualizarTxtResultado(DOBLE_CERO);
            }
        });
        btn1.addActionListener(e -> {
            actualizarTxtResultado(UNO);
        });
        btn2.addActionListener(e -> {
            actualizarTxtResultado(DOS);
        });
        btn3.addActionListener(e -> {
            actualizarTxtResultado(TRES);
        });
        btn4.addActionListener(e -> {
            actualizarTxtResultado(CUATRO);
        });
        btn5.addActionListener(e -> {
            actualizarTxtResultado(CINCO);
        });
        btn6.addActionListener(e -> {
            actualizarTxtResultado(SEIS);
        });
        btn7.addActionListener(e -> {
            actualizarTxtResultado(SIETE);
        });
        btn8.addActionListener(e -> {
            actualizarTxtResultado(OCHO);
        });
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
            calcularRaiz();
        });

        // Para cambiar de positivo a negativo un valor y viceversa
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

        btnIgual.addActionListener(e -> {
            //Compruebo que txtResultado no esté vacío
            if (txtResultado.getText().isEmpty()){
                return;
            }
            // Para que no siga operando tras darle al "=" tras una operación
            if (operador == '\0') {// No hace nada en caso de que no se seleccione un operador
                return;
            }
            double valor2 = Double.parseDouble(txtResultado.getText()); // Declaro el segundo operando
            realizarOperacion(valor1, valor2, operador);
            operador = '\0'; // Se reinicia el operador
            if (!existenErrores){
                // Activa los botones de operación
                BotonManager.activarBotonOperacion(this);
            }
            conversorDouble();
            valor1 = resultado;
            calculoRealizado = true;
        });

        btnAC.addActionListener(e -> {
            valor1 = 0;
            resultado = 0;
            limpiarPantalla();
            operador = '\0'; // Se reinicia el operador
            btnC.setEnabled(true);
            existenErrores=false;
            activarBotonesTodos(this);
        });

        btnC.addActionListener(e -> {
            String resultado = null;
            if (!txtResultado.getText().isEmpty()) {
                StringBuilder strB = new StringBuilder(txtResultado.getText());
                strB.deleteCharAt(txtResultado.getText().length() - 1);
                resultado = String.valueOf(strB);
                txtResultado.setText(resultado);
            }else{//Si se ha pulsado sobre un operador por error, si se le da al botón C se reactivan los botones
                activarBotonOperacion(this);
            }
        });

        btnPunto.addActionListener(e -> {
            if (txtResultado.getText().isEmpty()) {
                txtResultado.setText("0.");
            } else if (txtResultado.getText().contains(".")) {
                btnPunto.setEnabled(false);
            } else {
                String btnPuntoText = txtResultado.getText() + btnPunto.getText();
                txtResultado.setText(btnPuntoText);
            }
            btnPunto.setEnabled(true);
        });
    }

    private void reiniciarPantalla() {
        txtResultado.setText("0");
    }

    private void calcularRaiz() {
        String txtResultadoActual = txtResultado.getText();
        if (!txtResultadoActual.isEmpty()) {
            double numero = Double.parseDouble(txtResultadoActual);
            double resultado = Math.sqrt(numero);
            if (txtResultadoActual.contains("-")){
                txtResultado.setText("Entrada no válida");
                existenErrores=true;
                btnC.setEnabled(false);//Me aseguro de que btnC no se vuelve a activar
                desactivarBotonesTodos(this);
            }else{
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


    // Métodos
    // Consigo el operador cuando le doy al botón de operación

    private void getOperador(String btnTexto) {
        operador = btnTexto.charAt(0);
        if (!txtResultado.getText().equals("No se puede dividir por 0") &&
                (!txtResultado.getText().equals("Entrada no válida"))) {
            if (txtResultado.getText().isEmpty()) {
                valor1 = 0.0;
            } else {
                valor1 = Double.parseDouble(txtResultado.getText());
            }
            limpiarPantalla();
            desactivarBotonOperacion(this);
        }
        btnC.setEnabled(false);
    }
    private void limpiarPantalla() {
        txtResultado.setText("");
    }

    // Configuro los botones operacionales

    private void setBotonOperacion(JButton boton) {
        boton.addActionListener(e -> {
            String btnTexto = boton.getText();
            getOperador(btnTexto);
            if (!existenErrores) {
                activarBotonOperacion(this);
            }
            btnC.setEnabled(true);
            if (txtResultado.getText().equals("No se puede dividir por 0")) {
                btnC.setEnabled(false);
                desactivarBotonOperacion(this);
            }
        });
    }
    // Creo una función para actualizar txtResultado en caso de que se introduzca un número tras el 0 predeterminado,
    // en caso de que se haya hecho raiz de un número negativo o si se divide por 0

    private void actualizarTxtResultado(String num) {
        if (txtResultado.getText().equals(CERO) || calculoRealizado) {
            txtResultado.setText(num);
            calculoRealizado = false; // Reiniciar el estado de cálculo de la raíz
            btnC.setEnabled(true);
        } else {
            String texto = txtResultado.getText() + num;
            txtResultado.setText(texto);
        }
        if (existenErrores) {
            btnC.setEnabled(false);
            btnRaiz.setEnabled(false);
            desactivarBotonOperacion(this);
        }
    }

    // Hago un método para que el btnIgual no esté tan cargado
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
                if (valor2 == 0) {
                    txtResultado.setText("No se puede dividir por 0");
                    existenErrores=true;
                    BotonManager.desactivarBotonesTodos(this);
                    return;
                } else {
                    resultado = valor1 / valor2;
                }
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
    private void conversorDouble() {
        if (resultado % 1 == 0) {
            txtResultado.setText(Integer.toString((int) resultado));
        } else {
            txtResultado.setText(Double.toString(resultado));
        }
    }

    private void configurarVentana() {
        this.setContentPane(Panel1);
        //this.pack();
        this.setSize(375,275);
        this.setTitle("Calculadora");
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void mostrar() {
        this.setVisible(true);
    }
}