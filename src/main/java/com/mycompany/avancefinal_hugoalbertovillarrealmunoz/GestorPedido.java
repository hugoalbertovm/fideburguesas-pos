package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.util.List;

public class GestorPedido {

    private List<Pedido> pedidos;

    public GestorPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void registrarPedido(Cajero usuarioActual) {
        if (usuarioActual == null) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión primero.");
            return;
        }

        String[] datos = InterfazPedido.mostrarRegistroPedido();
        if (datos == null) {
            return;
        }

        String cliente = datos[0];
        String producto = datos[1];
        String cantidadStr = datos[2];
        String precioStr = datos[3];

        if (cliente.isEmpty() || producto.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return;
        }

        int cantidad;
        double precio;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            precio = Double.parseDouble(precioStr);
            if (cantidad <= 0 || precio <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad y un precio válidos.");
            return;
        }

        Pedido nuevoPedido = new Pedido(pedidos.size() + 1, cliente);
        for (int i = 0; i < cantidad; i++) {
            nuevoPedido.agregarProducto(new Producto(i + 1, producto, precio, "Comida"));
        }

        ClienteCajero.enviarPedido("Nuevo pedido de cliente: " + cliente);

        pedidos.add(nuevoPedido);
        ConexionBD.insertarPedido("Cliente: " + cliente + ", Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: " + precio);
        JOptionPane.showMessageDialog(null, "Pedido registrado exitosamente.");
    }
}
