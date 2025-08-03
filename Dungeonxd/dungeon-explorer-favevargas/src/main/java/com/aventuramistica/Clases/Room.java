package com.aventuramistica.Clases;

import java.util.Scanner;

/**
 * Interfaz Room (Abstracción)
 * Define el contrato para cualquier sala. Ahora puede afectar el estado del juego
 * y recibir entrada del usuario.
 */
public interface Room {
    void enter(Player player, Game game, Scanner scanner); // Se añade el Scanner
    String getDescription();
}