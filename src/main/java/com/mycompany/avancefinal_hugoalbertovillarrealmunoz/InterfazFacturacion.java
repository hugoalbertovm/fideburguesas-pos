package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazFacturacion {

    public static Pedido seleccionarPedidoParaFacturar(List<Pedido> pedidosListos) {

        String[] listaPedidos = new String[pedidosListos.size()];
        for (int i = 0; i < pedidosListos.size(); i++) {
            listaPedidos[i] = "Pedido #" + pedidosListos.get(i).getIdPedido() + " - Cliente: " + pedidosListos.get(i).getCliente();
        }

        JComboBox<String> pedidoBox = new JComboBox<>(listaPedidos);
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.add(new JLabel("Seleccione un pedido para facturar:"));
        panelSeleccion.add(pedidoBox);

        ImageIcon iconoOriginal = new ImageIcon(InterfazFacturacion.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        int opcionSeleccion = JOptionPane.showConfirmDialog(
                null, panelSeleccion, "Seleccionar Pedido", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icono);

        if (opcionSeleccion == JOptionPane.OK_OPTION) {
            return pedidosListos.get(pedidoBox.getSelectedIndex());
        }
        return null;
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

        ImageIcon iconoOriginal = new ImageIcon(InterfazFacturacion.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        JOptionPane.showConfirmDialog(null, panel, "Facturación", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icono);
    }
}
