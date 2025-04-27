package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazLogin {

    public static Cajero mostrarLogin(List<Cajero> cajeros) {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Usuario:"));
        JTextField usuarioField = new JTextField();
        panel.add(usuarioField);
        panel.add(new JLabel("Contraseña:"));
        JPasswordField contrasenaField = new JPasswordField();
        panel.add(contrasenaField);

        int opcion = JOptionPane.showConfirmDialog(null, panel, "Iniciar Sesión", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            String usuario = usuarioField.getText().trim();
            String contrasena = new String(contrasenaField.getPassword()).trim();

            for (Cajero cajero : cajeros) {
                if (cajero.iniciarSesion(usuario, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido, " + usuario + "!");
                    return cajero;
                }
            }
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
        }
        return null;
    }
}
