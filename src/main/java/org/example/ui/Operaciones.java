package org.example.ui;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.example.ui.Constantes;

import static org.example.ui.BotonManager.activarBotonOperacion;
import static org.example.ui.BotonManager.desactivarBotonOperacion;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Operaciones {
    private JTextField txtResultado;
    private char operador;
    private double valor1 = 0.0;
    private double valor2 = 0.0;
    private double resultado = 0.0;

    public Operaciones(JTextField txtResultado) {
        this.txtResultado = txtResultado;
    }

    public void setBotonOperacion(JButton boton) {
        boton.addActionListener(e -> {
            String btnTexto = boton.getText();
            getOperador(btnTexto);
        });
    }

    private void getOperador(String btnTexto) {
        operador = btnTexto.charAt(0);
        if (txtResultado.getText().isEmpty()) {
            valor1 = 0.0;
        } else {
            valor1 = Double.parseDouble(txtResultado.getText());
        }
        limpiarPantalla();
    }

    private void limpiarPantalla() {
        txtResultado.setText("");
    }
}
