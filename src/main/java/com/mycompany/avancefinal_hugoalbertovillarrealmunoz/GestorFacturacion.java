package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class GestorFacturacion {

    private List<Pedido> pedidos;

    public GestorFacturacion(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void mostrarFacturacion() {
        // Filtrar pedidos que estén en estado "Listo"
        List<Pedido> pedidosListos = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getEstado().equals("Listo")) {
                pedidosListos.add(p);
            }
        }

        if (pedidosListos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos listos para facturar.");
            return;
        }

        // Llamar a la interfaz para seleccionar el pedido
        Pedido pedidoSeleccionado = InterfazFacturacion.seleccionarPedidoParaFacturar(pedidosListos);
        if (pedidoSeleccionado == null) {
            return; // Si el usuario cancela, no hace nada
        }

        // Llamar a la interfaz para mostrar la factura
        InterfazFacturacion.mostrarFactura(pedidoSeleccionado);
    }
}
