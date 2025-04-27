# Proyecto POS - FideBurguesas

Este proyecto corresponde al avance final del curso **Programación Cliente Servidor Concurrente**.

## Descripción
Sistema POS básico para un restaurante de hamburguesas llamado "FideBurguesas", donde los cajeros registran pedidos y se visualizan en cocina en tiempo real.

## Tecnologías Utilizadas
- Java SE
- Java Sockets (Cliente-Servidor)
- Base de Datos Embedded Apache Derby
- Maven para gestión de proyecto

## Funcionalidades
- Registro e inicio de sesión de cajeros
- Registro de pedidos
- Envío de pedidos vía socket a cocina
- Almacenamiento de usuarios y pedidos en base de datos Derby
- Facturación básica

## Estructura
- `ServidorCocina.java`: Recibe pedidos vía sockets.
- `ClienteCajero.java`: Cliente que envía pedidos a la cocina.
- `ConexionBD.java`: Maneja conexión con la base de datos Derby.
- `MenuPrincipal.java`: Menu principal de interacción con el sistema.

## Autor
Hugo Alberto Villarreal Muñoz