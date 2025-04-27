package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.*;

public class InterfazPedido {

    public static String[] mostrarRegistroPedido() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Cliente:"));
        JTextField clienteField = new JTextField();
        panel.add(clienteField);

        panel.add(new JLabel("Producto:"));
        JTextField productoField = new JTextField();
        panel.add(productoField);

        panel.add(new JLabel("Cantidad:"));
        JTextField cantidadField = new JTextField();
        panel.add(cantidadField);

        panel.add(new JLabel("Precio por unidad (₡):"));
        JTextField precioField = new JTextField();
        panel.add(precioField);

        ImageIcon iconoOriginal = new ImageIcon(InterfazPedido.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        int opcion = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Registrar Pedido",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icono
        );

        if (opcion == JOptionPane.OK_OPTION) {
            return new String[]{
                clienteField.getText().trim(),
                productoField.getText().trim(),
                cantidadField.getText().trim(),
                precioField.getText().trim()
            };
        }
        return null;
    }
}
