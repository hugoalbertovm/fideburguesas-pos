package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import javax.swing.*;
import java.awt.Image;
import java.util.List;

public class GestorPedido {

    private List<Pedido> pedidos;

    public GestorPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void registrarPedido(Cajero usuarioActual) {

        ImageIcon iconoOriginal = new ImageIcon(GestorPedido.class.getResource("/images/hamburguesa.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        if (usuarioActual == null) {
            JOptionPane.showMessageDialog(null, "Debe iniciar sesión primero.", "Error", JOptionPane.ERROR_MESSAGE, icono);
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
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE, icono);
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
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad y un precio válidos.", "Advertencia", JOptionPane.WARNING_MESSAGE, icono);
            return;
        }

        Pedido nuevoPedido = new Pedido(pedidos.size() + 1, cliente);
        for (int i = 0; i < cantidad; i++) {
            nuevoPedido.agregarProducto(new Producto(i + 1, producto, precio, "Comida"));
        }

        ClienteCajero.enviarPedido("Nuevo pedido de cliente: " + cliente);

        pedidos.add(nuevoPedido);
        ConexionBD.insertarPedido("Cliente: " + cliente + ", Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: " + precio);
        JOptionPane.showMessageDialog(null, "Pedido registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE, icono);
    }
}
