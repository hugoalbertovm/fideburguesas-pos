package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import java.util.List;

public class Combo {

    private int idCombo;
    private String nombre;
    private List<Producto> listaProductos;

    public Combo(int idCombo, String nombre, List<Producto> listaProductos) {
        this.idCombo = idCombo;
        this.nombre = nombre;
        this.listaProductos = listaProductos;
    }

    public double precioTotal() {
        return listaProductos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}
