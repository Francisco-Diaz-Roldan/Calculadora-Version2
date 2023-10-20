package org.example.ui;

import javax.swing.*;
import java.util.Objects;

public class Calculadora extends JFrame {
    private JTextField txtResultado;
    private JPanel Panel;
    private JPanel Panel1;
    private JButton btn0;
    private JButton btn00;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JButton btnMasMenos;
    private JButton btnPotencia;
    private JButton btnRaiz;
    private JButton btnIgual;
    private JButton btnC;
    private JButton btnCE;
    private JButton btnPunto;


    private double valor1 = 0.0;
    private char operador;
    private double resultado = 0.0;

    private final String txtErrorDiv0 ="No se puede dividir por 0";
    private final String txtErrorRaizNega ="Entrada no válida";
    private boolean existenErrores;

    public Calculadora() {
        // Configuro la vista de la ventana Calculadora
        this.setContentPane(Panel1);
        //this.pack();
        this.setSize(375,275);
        this.setTitle("Calculadora");
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mostrar();

        txtResultado.setEditable(false);//Impido la entrada de texto por teclado

        txtResultado.setText("0"); // Establezco "0" como valor predeterminado en la calculadora

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
            if (txtResultadoActual.isEmpty()){
                txtResultado.setText("0");
            }
            if (!txtResultadoActual.isEmpty() && !txtResultadoActual.equals("0")) {
                actualizarTxtResultado("00");
            }
        });
        btn1.addActionListener(e -> {
            actualizarTxtResultado("1");
        });
        btn2.addActionListener(e -> {
            actualizarTxtResultado("2");
        });
        btn3.addActionListener(e -> {
            actualizarTxtResultado("3");
        });
        btn4.addActionListener(e -> {
            actualizarTxtResultado("4");
        });
        btn5.addActionListener(e -> {
            actualizarTxtResultado("5");
        });
        btn6.addActionListener(e -> {
            actualizarTxtResultado("6");
        });
        btn7.addActionListener(e -> {
            actualizarTxtResultado("7");
        });
        btn8.addActionListener(e -> {
            actualizarTxtResultado("8");
        });
        btn9.addActionListener(e -> {
            actualizarTxtResultado("9");
        });

        // Configuro los botones operacionales
        setBotonOperacion(btnSumar);
        setBotonOperacion(btnRestar);
        setBotonOperacion(btnMultiplicar);
        setBotonOperacion(btnDividir);
        setBotonOperacion(btnPotencia);
        btnRaiz.addActionListener(e -> {
            String txtResultadoActual = txtResultado.getText();

            if (!txtResultadoActual.isEmpty()) {
                double numero = Double.parseDouble(txtResultadoActual);
                double resultado = Math.sqrt(numero);
                if (txtResultadoActual.contains("-")){
                    txtResultado.setText("Entrada no válida");
                }else{
                    // Comprueba a ver si el resultado es un número entero
                    if (resultado == (int) resultado) {
                        txtResultado.setText(Integer.toString((int) resultado));
                    } else {
                        txtResultado.setText(Double.toString(resultado));
                    }
                }
            }
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
            if (operador == '\0') {
                // No hace nada en caso de que no se seleccione un operador
                return;
            }
            double valor2 = Double.parseDouble(txtResultado.getText()); // Declaro el segundo operando
            realizarOperacion(valor1, valor2, operador);
            operador = '\0'; // Se reinicia el operador

            // Activa los botones de operación
            activarBotonOperacion();

        });

        btnCE.addActionListener(e -> {
            valor1 = 0;
            resultado = 0;
            txtResultado.setText("");
            operador = '\0'; // Se reinicia el operador
            activarBotonOperacion();
            btnC.setEnabled(true);
            existenErrores=false;
        });

        btnC.addActionListener(e -> {
            String resultado = null;
            if (!txtResultado.getText().isEmpty()) {
                StringBuilder strB = new StringBuilder(txtResultado.getText());
                strB.deleteCharAt(txtResultado.getText().length() - 1);
                resultado = String.valueOf(strB);
                txtResultado.setText(resultado);
            }else{//Si se ha pulsado sobre un operador por error, si se le da al botón C se reactivan los botones
                activarBotonOperacion();
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

    // Métodos
    // Consigo el operador cuando le doy al botón de operación
    private void getOperador(String btnTexto) {
        operador = btnTexto.charAt(0);

        if (txtResultado.getText().isEmpty()) {
            valor1 = 0.0;
        } else {
            valor1 = Double.parseDouble(txtResultado.getText());
        }        txtResultado.setText("");

        desactivarBotonOperacion();
    }

    // Configuro los botones operacionales
    private void setBotonOperacion(JButton boton) {
        boton.addActionListener(e -> {
            String btnTexto = boton.getText();
            getOperador(btnTexto);
            btnPotencia.setEnabled(true);
            btnSumar.setEnabled(true);
            btnRestar.setEnabled(true);
            btnMultiplicar.setEnabled(true);
            btnDividir.setEnabled(true);
            btnC.setEnabled(true);
        });
    }

    // Creo una función para actualizar txtResultado en caso de que se introduzca un número tras el 0 predeterminado,
    // en caso de que se haya hecho raiz de un número negativo o si se divide por 0
    private void actualizarTxtResultado(String num) {
        if (txtResultado.getText().equals("0")) {
            txtResultado.setText(num);
        } else {
            String texto = txtResultado.getText() + num;
            txtResultado.setText(texto);
        }
        if (existenErrores) {
            btnC.setEnabled(false);
            desactivarBotonOperacion();
        }

    }

    // Hago una función para deshabilitar los botones de operación
    //TODO cambiar metodo deshabilitarBotonOperacion() a deshabilitar botones, meto tambien los numericos y lo meto todo en la linea 236 dentro del metodo actualizarResultado
    private void desactivarBotonOperacion() {
        btnSumar.setEnabled(false);
        btnRestar.setEnabled(false);
        btnMultiplicar.setEnabled(false);
        btnDividir.setEnabled(false);
        btnPotencia.setEnabled(false);
    }

    // Hago otra función para habilitar los botones de operación
    private void activarBotonOperacion() {
        btnSumar.setEnabled(true);
        btnRestar.setEnabled(true);
        btnMultiplicar.setEnabled(true);
        btnDividir.setEnabled(true);
        btnPotencia.setEnabled(true);
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
                    txtResultado.setText(txtErrorDiv0);
                    existenErrores = true;
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
        if (resultado % 1 == 0) {
            txtResultado.setText(Integer.toString((int) resultado));
        } else {
            txtResultado.setText(Double.toString(resultado));
        }
    }

    public void mostrar() {
        this.setVisible(true);
    }
}

