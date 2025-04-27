package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.gestor;

import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.interfaz.InterfazFacturacion;
import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo.Pedido;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Image;

public class GestorFacturacion {

    private List<Pedido> pedidos;

    public GestorFacturacion(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void mostrarFacturacion() {

        ImageIcon iconoOriginal = new ImageIcon(GestorFacturacion.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        List<Pedido> pedidosListos = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getEstado().equals("Listo")) {
                pedidosListos.add(p);
            }
        }

        if (pedidosListos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos listos para facturar.", "Información", JOptionPane.INFORMATION_MESSAGE, icono);
            return;
        }

        Pedido pedidoSeleccionado = InterfazFacturacion.seleccionarPedidoParaFacturar(pedidosListos);
        if (pedidoSeleccionado == null) {
            return;
        }

        InterfazFacturacion.mostrarFactura(pedidoSeleccionado);
    }
}
