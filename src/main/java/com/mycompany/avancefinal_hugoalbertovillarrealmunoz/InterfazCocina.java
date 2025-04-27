package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.util.List;

public class InterfazCocina {

    public static Pedido seleccionarPedido(List<Pedido> pedidos) {
        // Crear lista de pedidos
        String[] listaPedidos = new String[pedidos.size()];
        for (int i = 0; i < pedidos.size(); i++) {
            listaPedidos[i] = "Pedido #" + pedidos.get(i).getIdPedido()
                    + " - Cliente: " + pedidos.get(i).getCliente()
                    + " - Estado: " + pedidos.get(i).getEstado();
        }

        // Mostrar pedidos en JComboBox
        JComboBox<String> pedidoBox = new JComboBox<>(listaPedidos);
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.add(new JLabel("Seleccione un pedido:"));
        panelSeleccion.add(pedidoBox);

        Object[] opciones = {"Regresar al Menú", "Actualizar Estado del Pedido"};

        int opcionSeleccion = JOptionPane.showOptionDialog(
                null, panelSeleccion, "Monitor de Cocina",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[1]);

        if (opcionSeleccion == JOptionPane.YES_OPTION) {
            return null; // Si el usuario elige "Regresar al menú", retorna null
        }

        return pedidos.get(pedidoBox.getSelectedIndex());
    }

    public static String actualizarEstadoPedido(Pedido pedidoSeleccionado) {
        // Crear opciones de estado
        String[] estados = {"Pendiente", "En Preparación", "Listo"};
        JComboBox<String> estadoBox = new JComboBox<>(estados);
        estadoBox.setSelectedItem(pedidoSeleccionado.getEstado());

        JPanel panelEstado = new JPanel();
        panelEstado.add(new JLabel("Seleccione el estado del pedido:"));
        panelEstado.add(estadoBox);

        int opcionEstado = JOptionPane.showConfirmDialog(
                null, panelEstado, "Actualizar Estado", JOptionPane.OK_CANCEL_OPTION);

        if (opcionEstado == JOptionPane.OK_OPTION) {
            return (String) estadoBox.getSelectedItem();
        }
        return null; // Si cancela, no actualiza nada
    }
}
