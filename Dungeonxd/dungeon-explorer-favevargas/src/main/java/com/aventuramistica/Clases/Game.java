package com.aventuramistica.Clases;

import java.util.List;
import java.util.Scanner;

/**
 * Clase Game (Motor del Juego - Encapsulación)
 * Encapsula la lógica principal y el estado del juego.
 * Ahora recibe el Scanner para manejar la entrada del usuario.
 */
public class Game {
    private final Player player;
    private final List<Room> dungeon;
    private final Scanner scanner; // Recibe el scanner en lugar de crearlo
    private boolean isFinished = false;

    public Game(Player player, List<Room> dungeon, Scanner scanner) {
        this.player = player;
        this.dungeon = dungeon;
        this.scanner = scanner;
    }

    public void run() {
        for (Room currentRoom : dungeon) {
            if (!player.isAlive() || isFinished) {
                break;
            }
            
            System.out.println("\nPresiona Enter para avanzar...");
            scanner.nextLine();
            System.out.println("--------------------------------------------------------");
            
            currentRoom.enter(player, this, scanner); // Pasar el scanner a la sala
            player.showStatus();
        }

        printGameResult();
        // No cerramos el scanner aquí, lo maneja Main
    }

    public void finishGame() {
        this.isFinished = true;
    }

    private void printGameResult() {
        System.out.println("\n--- FIN DEL JUEGO ---");
        if (player.isAlive() && isFinished) {
            System.out.println("¡VICTORIA! ¡Felicidades, " + player.getName() + "! Has completado tu misión.");
        } else {
            System.out.println("Has sido derrotado. La oscuridad consume el reino.");
        }
    }
}
