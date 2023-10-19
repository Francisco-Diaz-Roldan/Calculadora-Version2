package org.example.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    public Calculadora(){

        this.setContentPane(Panel1);
        this.pack();
        this.setTitle("Calculadora de primos");
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mostrar();

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn0Text = txtResultado.getText() + btn0.getText();
                txtResultado.setText(btn0Text);
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = txtResultado.getText() + btn1.getText();
                txtResultado.setText(btn1Text);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn2Text = txtResultado.getText() + btn2.getText();
                txtResultado.setText(btn2Text);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn3Text = txtResultado.getText() + btn3.getText();
                txtResultado.setText(btn3Text);
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn4Text = txtResultado.getText() + btn4.getText();
                txtResultado.setText(btn4Text);
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn5Text = txtResultado.getText() + btn5.getText();
                txtResultado.setText(btn5Text);
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn6Text = txtResultado.getText() + btn6.getText();
                txtResultado.setText(btn6Text);
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn7Text = txtResultado.getText() + btn7.getText();
                txtResultado.setText(btn7Text);
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn8Text = txtResultado.getText() + btn8.getText();
                txtResultado.setText(btn8Text);
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn9Text = txtResultado.getText() + btn9.getText();
                txtResultado.setText(btn9Text);
            }
        });

        btn00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn00Text = txtResultado.getText() + btn00.getText();
                txtResultado.setText(btn00Text);
            }
        });

    }

    public void mostrar(){
        this.setVisible(true);
    }
}
