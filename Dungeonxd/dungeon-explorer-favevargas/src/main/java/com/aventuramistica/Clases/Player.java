package com.aventuramistica.Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase Player (Encapsulación)
 * Encapsula los datos y el comportamiento del jugador.
 * Mantiene el estado del jugador, como su nombre, vida e inventario.
 */
public class Player {
    private String name;
    private int health;
    private int attackPower; // Añadido para el combate
    private List<GameObject> inventory;
    private final Random random = new Random(); // Para variabilidad

    private final int maxHealth;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.maxHealth = health; // La vida inicial es la máxima
        this.attackPower = 15; // Poder de ataque inicial
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() { // Nuevo método
        // El poder de ataque también podría tener variabilidad, pero lo mantendremos simple por ahora.
        return attackPower;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int baseDamage) {
        // El daño varía entre el 80% y el 120% del daño base
        int damage = (int) (baseDamage * (0.8 + random.nextDouble() * 0.4));
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(name + " recibe " + damage + " de daño. Vida restante: " + health);
    }

    public void heal(int amount) {
        this.health += amount;
        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
        System.out.println(name + " se cura " + amount + " de vida. Vida actual: " + health);
    }

    public boolean useHealingPotion() {
        for (GameObject item : inventory) {
            if (item instanceof HealingPotion) {
                heal(((HealingPotion) item).getHealingAmount());
                inventory.remove(item);
                System.out.println("Has usado una Poción de Curación.");
                return true;
            }
        }
        System.out.println("No tienes Pociones de Curación.");
        return false;
    }

    public void collect(GameObject item) {
        inventory.add(item);
        System.out.println(name + " ha recogido: " + item.getName());
    }

    public void showStatus() {
        System.out.println("--- Estado del Jugador ---");
        System.out.println("Nombre: " + name);
        System.out.println("Vida: " + health);
        System.out.println("Inventario:");
        if (inventory.isEmpty()) {
            System.out.println("  (Vacío)");
        } else {
            for (GameObject item : inventory) {
                System.out.println("  - " + item.getName() + ": " + item.getDescription());
            }
        }
        System.out.println("--------------------------");
    }
}
