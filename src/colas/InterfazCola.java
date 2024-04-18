/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author HP
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazCola extends JFrame implements ActionListener {
    private JButton btnAgregarFrente, btnAgregarFinal, btnEliminar;
    private JLabel lblMensaje;
    private Bicola bicola;

    public InterfazCola() {
        bicola = new Bicola();

        setTitle("Interfaz de Cola");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnAgregarFrente = new JButton("Agregar al Frente");
        btnAgregarFinal = new JButton("Agregar al Final");
        btnEliminar = new JButton("Eliminar");

        lblMensaje = new JLabel();

        btnAgregarFrente.addActionListener(this);
        btnAgregarFinal.addActionListener(this);
        btnEliminar.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(btnAgregarFrente);
        panel.add(btnAgregarFinal);
        panel.add(btnEliminar);
        panel.add(lblMensaje);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregarFrente) {
            agregarAlFrente();
        } else if (e.getSource() == btnAgregarFinal) {
            agregarAlFinal();
        } else if (e.getSource() == btnEliminar) {
            eliminar();
        }
    }

    private void agregarAlFrente() {
        String elemento = JOptionPane.showInputDialog("Ingrese el elemento a agregar al frente:");
        try {
            bicola.ponerFrente(elemento);
            lblMensaje.setText("Elemento agregado al frente con éxito: " + elemento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarAlFinal() {
        String elemento = JOptionPane.showInputDialog("Ingrese el elemento a agregar al final:");
        try {
            bicola.ponerFinal(elemento);
            lblMensaje.setText("Elemento agregado al final con éxito: " + elemento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        try {
            Object elemento = bicola.quitarFrente();
            lblMensaje.setText("Elemento eliminado: " + elemento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        InterfazCola interfaz = new InterfazCola();
        interfaz.setVisible(true);
    }
}
