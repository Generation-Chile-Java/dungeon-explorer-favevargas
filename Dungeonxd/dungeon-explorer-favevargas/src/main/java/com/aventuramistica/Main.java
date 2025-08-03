package com.aventuramistica;

import com.aventuramistica.Clases.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Main (Punto de Entrada)
 * Responsabilidad única: inicializar los componentes principales y empezar el juego.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Pedir el nombre del jugador
        System.out.println("========================================================");
        System.out.println("==         Bienvenido a The Messenger Game          ==");
        System.out.println("========================================================");
        System.out.print("Por favor, introduce el nombre de tu héroe: ");
        String playerName = scanner.nextLine();

        // 2. Crear los objetos necesarios con el nombre del jugador
        Player player = new Player(playerName, 100);
        DungeonMaster dungeonMaster = new DungeonMaster();
        List<Room> dungeon = dungeonMaster.createDungeon();

        // 3. Imprimir introducción
        System.out.println("\nTu misión, " + playerName + ": Vence al Rey Demonio para salvar el mundo.");
        player.showStatus();

        // 4. Ensamblar y ejecutar el juego
        Game game = new Game(player, dungeon, scanner);
        game.run();
        
        // 5. Cerrar el scanner al final
        scanner.close();
    }
}