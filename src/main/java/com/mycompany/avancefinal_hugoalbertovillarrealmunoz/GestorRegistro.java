package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.Image;
import java.util.List;

public class GestorRegistro {

    private List<Cajero> cajeros;

    public GestorRegistro(List<Cajero> cajeros) {
        this.cajeros = cajeros;
    }

    public void registrarCajero() {

        ImageIcon iconoOriginal = new ImageIcon(GestorRegistro.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        Cajero nuevoCajero = InterfazRegistro.mostrarRegistroCajero();
        if (nuevoCajero != null) {
            ConexionBD.insertarUsuario(nuevoCajero.getNombre(), nuevoCajero.getContrasena());
            cajeros.add(nuevoCajero);
            JOptionPane.showMessageDialog(null, "Cajero registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE, icono);
        }
    }
}
