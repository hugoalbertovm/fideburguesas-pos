package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.util.List;

public class GestorRegistro {

    private List<Cajero> cajeros;

    public GestorRegistro(List<Cajero> cajeros) {
        this.cajeros = cajeros;
    }

    public void registrarCajero() {
        Cajero nuevoCajero = InterfazRegistro.mostrarRegistroCajero();
        if (nuevoCajero != null) {
            cajeros.add(nuevoCajero);
            JOptionPane.showMessageDialog(null, "Cajero registrado exitosamente.");
        }
    }

}
