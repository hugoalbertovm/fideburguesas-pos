package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

public class Usuario {

    protected int idUsuario;
    protected String nombre;
    protected String contraseña;

    public Usuario(int idUsuario, String nombre, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public boolean iniciarSesion(String usuario, String contraseña) {
        return this.nombre.equals(usuario) && this.contraseña.equals(contraseña);
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contraseña;
    }
}
