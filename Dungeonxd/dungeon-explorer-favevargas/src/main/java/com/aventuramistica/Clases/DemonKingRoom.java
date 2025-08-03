package com.aventuramistica.Clases;

import java.util.Scanner;

/**
 * Clase DemonKingRoom (Herencia)
 * Hereda de EnemyRoom. Su comportamiento de entrada es único y finaliza el juego.
 */
public class DemonKingRoom extends EnemyRoom {
    public DemonKingRoom(int damage, int health) {
        super("Rey Demonio", damage, health);
    }

    @Override
    public void enter(Player player, Game game, Scanner scanner) {
        System.out.println("Has llegado a la cámara del trono del Rey Demonio.");
        System.out.println("¡Prepárate para la batalla final! No puedes huir.");

        // Bucle de combate (similar a EnemyRoom, pero sin la opción de huir)
        while (player.isAlive() && this.enemyHealth > 0) {
            System.out.println("\n--- Turno de " + player.getName() + " ---");
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.print("Elige una opción: ");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                System.out.println("¡Atacas con todas tus fuerzas al " + enemyName + "!");
                takeDamage(player.getAttackPower());

                if (this.enemyHealth > 0) {
                    System.out.println("¡El " + enemyName + " contraataca con furia!");
                    player.takeDamage(this.enemyDamage);
                }
            } else {
                System.out.println("Opción no válida. El Rey Demonio no espera.");
                System.out.println("¡El " + enemyName + " aprovecha tu indecisión y ataca!");
                player.takeDamage(this.enemyDamage);
            }
        }

        // Resultado de la batalla final
        if (player.isAlive() && this.enemyHealth <= 0) {
            System.out.println("Con un último esfuerzo, ¡has vencido al Rey Demonio!");
            game.finishGame(); // Señala al juego que ha terminado con una victoria
        }
    }
}