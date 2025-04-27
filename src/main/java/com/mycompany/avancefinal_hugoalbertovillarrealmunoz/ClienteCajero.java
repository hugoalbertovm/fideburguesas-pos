package com.mycompany.avancefinal_hugoalbertovillarrealmunoz;

import java.io.*;
import java.net.*;

public class ClienteCajero {

    public static void enviarPedido(String pedido) {
        try (Socket socket = new Socket("localhost", 5001)) {
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            salida.write(pedido);
            salida.newLine();
            salida.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
