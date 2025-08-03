package com.aventuramistica.Clases;

import java.util.Random;
import java.util.Scanner;

public class EnemyRoom implements Room {
    protected final String enemyName;
    protected final int enemyDamage;
    protected int enemyHealth; // Vida del enemigo
    private boolean defeated = false;
    private final Random random = new Random(); // Para variabilidad

    public EnemyRoom(String enemyName, int enemyDamage, int enemyHealth) {
        this.enemyName = enemyName;
        this.enemyDamage = enemyDamage;
        this.enemyHealth = enemyHealth;
    }

    // Método para que el enemigo reciba daño
    public void takeDamage(int baseDamage) {
        // El daño varía entre el 80% y el 120% del daño base
        int damage = (int) (baseDamage * (0.8 + random.nextDouble() * 0.4));
        this.enemyHealth -= damage;
        if (this.enemyHealth < 0) {
            this.enemyHealth = 0;
        }
        System.out.println("¡El " + enemyName + " recibe " + damage + " de daño! Salud restante: " + this.enemyHealth);
    }

    @Override
    public void enter(Player player, Game game, Scanner scanner) {
        System.out.println(player.getName() + " ha entrado en " + getDescription());
        if (defeated) {
            System.out.println("El rastro de tu victoria sobre el " + enemyName + " aún es visible.");
            return;
        }

        System.out.println("¡Un " + enemyName + " (" + enemyHealth + " de vida) aparece!");

        // Bucle de combate
        while (player.isAlive() && this.enemyHealth > 0) {
            System.out.println("\n--- Turno de " + player.getName() + " ---");
            System.out.println("¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Huir");
            System.out.print("Elige una opción: ");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                // El jugador ataca
                System.out.println("¡Atacas al " + enemyName + "!");
                takeDamage(player.getAttackPower());

                if (this.enemyHealth > 0) {
                    // El enemigo contraataca
                    System.out.println("¡El " + enemyName + " contraataca!");
                    player.takeDamage(this.enemyDamage);
                }
            } else if ("2".equals(choice)) {
                System.out.println("Intentas huir, pero el " + enemyName + " te da un golpe de despedida.");
                player.takeDamage(this.enemyDamage / 2); // Penalización por huir
                System.out.println("¡Logras escapar de la sala!");
                return; // Sales de la sala
            } else {
                System.out.println("Opción no válida. Pierdes tu turno.");
                // El enemigo ataca igualmente
                System.out.println("¡El " + enemyName + " aprovecha tu indecisión y ataca!");
                player.takeDamage(this.enemyDamage);
            }
        }

        // Resultado del combate
        if (this.enemyHealth <= 0) {
            System.out.println("¡Has derrotado al " + enemyName + "!");
            defeated = true;
        }
    }

    @Override
    public String getDescription() {
        return "una sala oscura y maloliente.";
    }
}
