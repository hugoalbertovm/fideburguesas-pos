package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import java.util.ArrayList;
import java.util.List;

public class Cajero extends Usuario {

    private List<Pedido> pedidos;

    public Cajero(int idUsuario, String nombre, String contraseña) {
        super(idUsuario, nombre, contraseña);
        this.pedidos = new ArrayList<>();
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public String getNombre() {
        return nombre;
    }
}
