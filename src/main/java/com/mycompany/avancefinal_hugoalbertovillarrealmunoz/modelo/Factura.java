package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo;

import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo.Producto;
import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo.Pedido;
import javax.swing.*;
import java.util.Date;

public class Factura {

    private int idFactura;
    private Pedido pedidoAsociado;
    private Date fechaEmision;
    private double total;

    public Factura(int idFactura, Pedido pedido) {
        this.idFactura = idFactura;
        this.pedidoAsociado = pedido;
        this.fechaEmision = new Date();
        this.total = pedido.getTotal();
    }

    public void mostrarFactura() {
        StringBuilder factura = new StringBuilder("Factura #" + idFactura + "\nFecha: " + fechaEmision + "\n");

        for (Producto p : pedidoAsociado.getProductos()) {
            factura.append(p.getNombre()).append(" - $").append(p.getPrecio()).append("\n");
        }
        factura.append("Total: $").append(total);

        JOptionPane.showMessageDialog(null, factura.toString(), "Facturación", JOptionPane.INFORMATION_MESSAGE);
    }
}
