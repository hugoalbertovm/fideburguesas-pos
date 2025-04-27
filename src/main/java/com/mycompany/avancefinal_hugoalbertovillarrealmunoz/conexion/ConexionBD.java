package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.conexion;

import java.sql.*;

public class ConexionBD {

    private static final String URL = "jdbc:derby:fideburguesasDB;create=true";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Conexión a la base de datos establecida.");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void crearTablas() {
        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {

            String crearUsuarios = "CREATE TABLE USUARIOS ("
                    + "ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
                    + "NOMBRE VARCHAR(50), "
                    + "CONTRASENA VARCHAR(50))";

            String crearPedidos = "CREATE TABLE PEDIDOS ("
                    + "ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
                    + "DESCRIPCION VARCHAR(100))";

            stmt.executeUpdate(crearUsuarios);
            stmt.executeUpdate(crearPedidos);

            System.out.println("Tablas creadas correctamente.");
        } catch (SQLException e) {
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("Las tablas ya existen.");
            } else {
                e.printStackTrace();
            }
        }
    }

    public static void insertarUsuario(String nombre, String contrasena) {
        String sql = "INSERT INTO USUARIOS (NOMBRE, CONTRASENA) VALUES (?, ?)";

        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);
            pstmt.executeUpdate();

            System.out.println("Usuario insertado en la base de datos.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarPedido(String descripcion) {
        String sql = "INSERT INTO PEDIDOS (DESCRIPCION) VALUES (?)";

        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, descripcion);
            pstmt.executeUpdate();

            System.out.println("Pedido insertado en la base de datos.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
