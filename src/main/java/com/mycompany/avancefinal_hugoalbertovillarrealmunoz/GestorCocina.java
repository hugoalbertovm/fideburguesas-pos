package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.util.List;

public class GestorCocina {

    private List<Pedido> pedidos;

    public GestorCocina(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void mostrarPedidosCocina() {
        if (pedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados.");
            return;
        }

        while (true) { // Mantiene la pantalla activa hasta que el usuario decida salir
            Pedido pedidoSeleccionado = InterfazCocina.seleccionarPedido(pedidos);
            if (pedidoSeleccionado == null) {
                return; // Si el usuario elige "Regresar al menú", sale
            }

            // Mostrar ventana para actualizar estado
            String nuevoEstado = InterfazCocina.actualizarEstadoPedido(pedidoSeleccionado);
            if (nuevoEstado != null) {
                pedidoSeleccionado.actualizarEstado(nuevoEstado);
                JOptionPane.showMessageDialog(null, "El pedido ha sido actualizado a: " + pedidoSeleccionado.getEstado());
            }
        }
    }
}
