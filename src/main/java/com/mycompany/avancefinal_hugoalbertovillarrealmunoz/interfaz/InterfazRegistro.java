package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.interfaz;

import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo.Cajero;
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

        ImageIcon iconoOriginal = new ImageIcon(InterfazRegistro.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        int opcion = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Registrar Nuevo Cajero",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icono
        );

        if (opcion == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText().trim();
            String usuario = usuarioField.getText().trim();
            String contrasena = new String(contrasenaField.getPassword()).trim();

            if (nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error de Registro", JOptionPane.PLAIN_MESSAGE, icono);
                return null;
            }

            return new Cajero(0, usuario, contrasena);
        }
        return null;
    }
}
