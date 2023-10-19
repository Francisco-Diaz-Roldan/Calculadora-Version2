package org.example.ui;

import javax.swing.*;

import static java.lang.Math.sqrt;


public class Calculadora extends JFrame{
    private JTextField txtResultado;
    private JPanel PanelBotones;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnMultiplicar;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnRestar;
    private JButton btnSumar;
    private JButton btnC;
    private JButton btnIgual;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnDividir;
    private JButton btnMasMenos;
    private JButton btnPotencia;
    private JButton btnRaiz;
    private JButton btnCE;
    private JButton btn0;
    private JButton btnPunto;
    private JButton btn00;
    private JPanel Panel1;
    private JPanel PanelTexto;

    private double valor1 = 0.0;
    private double valor2 = 0.0;
    private char operador;


    public Calculadora(){

        //Configuro la vista de mi ventana Calculadora
        this.setContentPane(Panel1);
        this.pack();
        this.setTitle("Calculadora");
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mostrar();

        txtResultado.setText("0");//Establezco "0" como valor predeterminado en la calculadora

        btn0.addActionListener(e -> {
            //Para poder escribir un solo "0" al principio
            String txtResultadoActual = txtResultado.getText();
            //Se comprueba que el resultado que aparece en pantalla esté vacío
            if (txtResultadoActual.isEmpty()){
                txtResultado.setText("0");
            }else if (txtResultadoActual.equals("0")) {
            // Si el resultado que aparece en pantalla es de "0" no deja que se añada otro
            }else{
            //En cualquier otro caso se añade "0"
                String btn0Text = txtResultado.getText() + btn0.getText();
                txtResultado.setText(btn0Text);
            }
        });

        btn00.addActionListener(e -> {
            String txtResultadoActual = txtResultado.getText();
            //Compruebo el valor del resultado actual para no escribir "00" tras un "0" si no es detrás de un "."
            if(txtResultadoActual.isEmpty()|| txtResultadoActual.endsWith(".")){actualizarTxtResultado("00");}
        });

        //Configuro los botones numéricos
        btn1.addActionListener(e -> {actualizarTxtResultado("1");});

        btn2.addActionListener(e -> {actualizarTxtResultado("2");});

        btn3.addActionListener(e -> {actualizarTxtResultado("3");});

        btn4.addActionListener(e -> {actualizarTxtResultado("4");});

        btn5.addActionListener(e -> {actualizarTxtResultado("5");});

        btn6.addActionListener(e -> {actualizarTxtResultado("6");});

        btn7.addActionListener(e -> {actualizarTxtResultado("7");});

        btn8.addActionListener(e -> {actualizarTxtResultado("8");});

        btn9.addActionListener(e -> {actualizarTxtResultado("9");});

       //Configuro los botones operacionales
        setBotonOperacion(btnSumar);
        setBotonOperacion(btnRestar);
        setBotonOperacion(btnMultiplicar);
        setBotonOperacion(btnDividir);
        setBotonOperacion(btnPotencia);
        setBotonOperacion(btnPotencia);
        btnRaiz.addActionListener(e -> {
            valor2 = sqrt(Double.parseDouble(txtResultado.getText()));
            txtResultado.setText(String.valueOf(valor2));
        });

        btnMasMenos.addActionListener(e ->{
            if(txtResultado.getText().contains(".")){
                double num = Double.parseDouble(txtResultado.getText());
                num=num*-1;
                txtResultado.setText(String.valueOf(num));
            }else{
                Long num = Long.parseLong(txtResultado.getText());
                num=num*-1;
                txtResultado.setText(String.valueOf(num));
            }
        });


        btnIgual.addActionListener(e -> {
            double valor2 = Double.parseDouble(txtResultado.getText()); // Obtengo el segundo operando
            switch (operador){
                case '+':
                    valor2 = valor1 + Double.parseDouble(txtResultado.getText());
                    break;
                case '-':
                    valor2 = valor1 - Double.parseDouble(txtResultado.getText());
                    break;
                case 'x':
                    valor2 = valor1 * Double.parseDouble(txtResultado.getText());
                    break;
                case '÷':
                    if (valor2 ==0){
                        txtResultado.setText("No se puede dividir por 0");
                        return;  //Salgo de la función sin actualizar el valor1
                    }else{
                        valor2 = valor1 / Double.parseDouble(txtResultado.getText());
                    }
                    break;
                case '^':
                    valor2 = Math.pow(valor1, Double.parseDouble(txtResultado.getText()));
                    break;
            }

            //Restablezco el "valor1" y muestro el resultado por pantalla
            valor1 = valor2;
            txtResultado.setText(String.valueOf(valor2));

            //Me aseguro que devuelva números enteros en caso de devolver un número terminado en ".0"
            if (valor2 %1 == 0){
                txtResultado.setText(Integer.toString((int) valor2));
            }else{
                txtResultado.setText(Double.toString(valor2));
            }

        });

        btnCE.addActionListener(e -> {
            valor2 = 0;
            txtResultado.setText("");
        });

        btnC.addActionListener(e -> {
            String resultado = null;
            if (!txtResultado.getText().isEmpty()){
                StringBuilder strB = new StringBuilder(txtResultado.getText());
                strB.deleteCharAt(txtResultado.getText().length() - 1);
                resultado = String.valueOf(strB);
                txtResultado.setText(resultado);
            }
        });

        btnPunto.addActionListener(e -> {
            if (txtResultado.getText().equals("")){
                txtResultado.setText("0.");
            }else if(txtResultado.getText().contains(".")){
                btnPunto.setEnabled(false);
            }else{
                String btnPuntoText = txtResultado.getText()+btnPunto.getText();
                txtResultado.setText(btnPuntoText);
            }
            btnPunto.setEnabled(true);
        });

    }


    //Consigo el operador cuando le doy al botón de operación
    private void getOperador(String btnTexto){
        operador = btnTexto.charAt(0);
        valor1 = valor1 +Double.parseDouble( txtResultado.getText());
        txtResultado.setText("");
    }

    //Configuro los botones operacionales
    private void setBotonOperacion(JButton boton) {
        boton.addActionListener(e -> {
            String btnTexto = boton.getText();
            getOperador(btnTexto);
        });
    }

    //Creo una función para actualizar txtResultado en caso de que se introduzca un numero tras el 0 predeterminado
    private void actualizarTxtResultado(String num){
        if(txtResultado.getText().equals("0")){
            txtResultado.setText(num);
        }else{
            String texto = txtResultado.getText() + num;
            txtResultado.setText(texto);
        }
    }

    public void mostrar(){
        this.setVisible(true);
    }
}