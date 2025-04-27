package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.util.List;

public class Cocina {

    public static void mostrarPedidos(List<Pedido> pedidos) {
        StringBuilder mensaje = new StringBuilder("Pedidos en Cocina:\n");

        for (Pedido p : pedidos) {
            mensaje.append("Pedido #").append(p.getIdPedido())
                    .append(" - Cliente: ").append(p.getCliente())
                    .append("\nEstado: ").append(p.getEstado()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Pedidos en Cocina", JOptionPane.INFORMATION_MESSAGE);
    }
}
