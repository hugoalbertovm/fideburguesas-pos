package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {

    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();
        List<Cajero> cajeros = new ArrayList<>();

        GestorFacturacion gestorFacturacion = new GestorFacturacion(pedidos);
        GestorCocina gestorCocina = new GestorCocina(pedidos);
        GestorPedido gestorPedidos = new GestorPedido(pedidos);
        GestorLogin gestorLogin = new GestorLogin(cajeros);
        GestorRegistro gestorRegistro = new GestorRegistro(cajeros);

        while (true) {
            String[] opciones = {
                "Registrar Cajero", "Iniciar Sesión", "Registrar Pedido",
                "Ver Pedidos en Cocina", "Facturación", "Salir"
            };

            String seleccion = (String) javax.swing.JOptionPane.showInputDialog(
                    null, "Seleccione una opción:", "Sistema POS - FideBurguesas",
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]
            );

            if (seleccion == null || seleccion.equals("Salir")) {
                break;
            }

            switch (seleccion) {
                case "Registrar Cajero" ->
                    gestorRegistro.registrarCajero();
                case "Iniciar Sesión" ->
                    gestorLogin.setUsuarioActual(gestorLogin.iniciarSesion());
                case "Registrar Pedido" ->
                    gestorPedidos.registrarPedido(gestorLogin.getUsuarioActual());
                case "Ver Pedidos en Cocina" ->
                    gestorCocina.mostrarPedidosCocina();
                case "Facturación" ->
                    gestorFacturacion.mostrarFacturacion();
            }
        }
    }
}
