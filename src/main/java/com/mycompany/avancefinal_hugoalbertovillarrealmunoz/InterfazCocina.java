package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazCocina {

    public static Pedido seleccionarPedido(List<Pedido> pedidos) {
        String[] listaPedidos = new String[pedidos.size()];
        for (int i = 0; i < pedidos.size(); i++) {
            listaPedidos[i] = "Pedido #" + pedidos.get(i).getIdPedido()
                    + " - Cliente: " + pedidos.get(i).getCliente()
                    + " - Estado: " + pedidos.get(i).getEstado();
        }

        JComboBox<String> pedidoBox = new JComboBox<>(listaPedidos);
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.add(new JLabel("Seleccione un pedido:"));
        panelSeleccion.add(pedidoBox);

        Object[] opciones = {"Regresar al Menú", "Actualizar Estado del Pedido"};

        ImageIcon iconoOriginal = new ImageIcon(InterfazCocina.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        int opcionSeleccion = JOptionPane.showOptionDialog(
                null, panelSeleccion, "Monitor de Cocina",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                icono, opciones, opciones[1]);

        if (opcionSeleccion == JOptionPane.YES_OPTION) {
            return null;
        }

        return pedidos.get(pedidoBox.getSelectedIndex());
    }

    public static String actualizarEstadoPedido(Pedido pedidoSeleccionado) {
        String[] estados = {"Pendiente", "En Preparación", "Listo"};
        JComboBox<String> estadoBox = new JComboBox<>(estados);
        estadoBox.setSelectedItem(pedidoSeleccionado.getEstado());

        JPanel panelEstado = new JPanel();
        panelEstado.add(new JLabel("Seleccione el estado del pedido:"));
        panelEstado.add(estadoBox);

        ImageIcon iconoOriginal = new ImageIcon(InterfazCocina.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        int opcionEstado = JOptionPane.showConfirmDialog(
                null, panelEstado, "Actualizar Estado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icono);

        if (opcionEstado == JOptionPane.OK_OPTION) {
            return (String) estadoBox.getSelectedItem();
        }
        return null;
    }
}
