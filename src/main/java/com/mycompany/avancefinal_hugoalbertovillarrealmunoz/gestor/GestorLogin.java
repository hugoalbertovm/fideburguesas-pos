package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.gestor;

import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.modelo.Cajero;
import com.mycompany.avancefinal_hugoalbertovillarrealmunoz.interfaz.InterfazLogin;
import java.util.List;

public class GestorLogin {

    private List<Cajero> cajeros;
    private Cajero usuarioActual;

    public GestorLogin(List<Cajero> cajeros) {
        this.cajeros = cajeros;
        this.usuarioActual = null;
    }

    public Cajero iniciarSesion() {
        return InterfazLogin.mostrarLogin(cajeros);
    }

    public Cajero getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Cajero usuario) {
        this.usuarioActual = usuario;
    }
}
