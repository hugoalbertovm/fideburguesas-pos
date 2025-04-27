package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.gestor;

import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.interfaz.InterfazCocina;
import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo.Pedido;
import java.awt.Image;
import javax.swing.*;
import java.util.List;

public class GestorCocina {

    private List<Pedido> pedidos;

    public GestorCocina(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void mostrarPedidosCocina() {
        if (pedidos.isEmpty()) {
            ImageIcon iconoOriginal = new ImageIcon(GestorCocina.class.getResource("/images/hamburguesa.png"));
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
            ImageIcon icono = new ImageIcon(imagenEscalada);

            JOptionPane.showMessageDialog(null, "No hay pedidos registrados.", "Información", JOptionPane.INFORMATION_MESSAGE, icono);
            return;
        }

        while (true) {
            Pedido pedidoSeleccionado = InterfazCocina.seleccionarPedido(pedidos);
            if (pedidoSeleccionado == null) {
                return;
            }

            String nuevoEstado = InterfazCocina.actualizarEstadoPedido(pedidoSeleccionado);
            if (nuevoEstado != null) {
                pedidoSeleccionado.actualizarEstado(nuevoEstado);

                ImageIcon iconoOriginal = new ImageIcon(GestorCocina.class.getResource("/images/hamburguesa.png"));
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(imagenEscalada);

                JOptionPane.showMessageDialog(null, "El pedido ha sido actualizado a: " + pedidoSeleccionado.getEstado(), "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE, icono);
            }
        }
    }

}
