package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idPedido;
    private String cliente;
    private List<Producto> listaProductos;
    private double total;
    private String estado; // Pendiente, En Cocina, Listo

    public Pedido(int idPedido, String cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.listaProductos = new ArrayList<>();
        this.total = 0.0;
        this.estado = "Pendiente";
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        total += producto.getPrecio();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public List<Producto> getProductos() {
        return listaProductos;
    }

    public String getEstado() {
        return estado;
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
