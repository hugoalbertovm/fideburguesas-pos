package com.mycompany.avancefinal_hugoalbertovillarrealmunoz.servidor;

import java.io.*;
import java.net.*;

public class ServidorCocina {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Servidor de Cocina escuchando en el puerto 5001...");

            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String pedido = entrada.readLine();
                System.out.println("Pedido recibido: " + pedido);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
