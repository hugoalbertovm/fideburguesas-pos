package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazFacturacion {

    public static Pedido seleccionarPedidoParaFacturar(List<Pedido> pedidosListos) {
        // Crear una lista con los pedidos disponibles
        String[] listaPedidos = new String[pedidosListos.size()];
        for (int i = 0; i < pedidosListos.size(); i++) {
            listaPedidos[i] = "Pedido #" + pedidosListos.get(i).getIdPedido() + " - Cliente: " + pedidosListos.get(i).getCliente();
        }

        // Mostrar un JComboBox para seleccionar el pedido
        JComboBox<String> pedidoBox = new JComboBox<>(listaPedidos);
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.add(new JLabel("Seleccione un pedido para facturar:"));
        panelSeleccion.add(pedidoBox);

        int opcionSeleccion = JOptionPane.showConfirmDialog(
                null, panelSeleccion, "Seleccionar Pedido", JOptionPane.OK_CANCEL_OPTION);

        if (opcionSeleccion == JOptionPane.OK_OPTION) {
            return pedidosListos.get(pedidoBox.getSelectedIndex());
        }
        return null; // Si se cancela, retorna null
    }

    public static void mostrarFactura(Pedido pedido) {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Cliente:"));
        JTextField clienteField = new JTextField(pedido.getCliente());
        clienteField.setEditable(false);
        panel.add(clienteField);

        panel.add(new JLabel("Producto:"));
        JTextField productoField = new JTextField(pedido.getProductos().get(0).getNombre());
        productoField.setEditable(false);
        panel.add(productoField);

        panel.add(new JLabel("Cantidad:"));
        JTextField cantidadField = new JTextField(String.valueOf(pedido.getProductos().size()));
        cantidadField.setEditable(false);
        panel.add(cantidadField);

        panel.add(new JLabel("Total:"));
        JTextField totalField = new JTextField("₡" + pedido.getTotal());
        totalField.setEditable(false);
        panel.add(totalField);

        JOptionPane.showConfirmDialog(null, panel, "Facturación", JOptionPane.DEFAULT_OPTION);
    }
}
