package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.*;

public class InterfazRegistro {

    public static Cajero mostrarRegistroCajero() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);
        panel.add(new JLabel("Usuario:"));
        JTextField usuarioField = new JTextField();
        panel.add(usuarioField);
        panel.add(new JLabel("Contraseña:"));
        JPasswordField contrasenaField = new JPasswordField();
        panel.add(contrasenaField);

        int opcion = JOptionPane.showConfirmDialog(null, panel, "Registrar Nuevo Cajero", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText().trim();
            String usuario = usuarioField.getText().trim();
            String contrasena = new String(contrasenaField.getPassword()).trim();

            if (nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                return null;
            }

            return new Cajero(0, usuario, contrasena); // ID se asignará en la lista
        }
        return null;
    }
}
