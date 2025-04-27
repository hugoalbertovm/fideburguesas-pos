package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private String tipo;

    public Producto(int idProducto, String nombre, double precio, String tipo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }
}
