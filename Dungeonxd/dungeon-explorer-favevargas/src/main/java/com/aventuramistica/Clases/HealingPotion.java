package com.aventuramistica.Clases;

/**
 * Clase HealingPotion (Implementación de GameObject)
 * Representa un objeto consumible que restaura la salud del jugador.
 */
public class HealingPotion implements GameObject {
    private final int healingAmount = 30; // Cantidad de vida que restaura

    @Override
    public String getName() {
        return "Poción de Curación";
    }

    @Override
    public String getDescription() {
        return "Una poción roja y brillante. Restaura " + healingAmount + " de vida.";
    }

    public int getHealingAmount() {
        return healingAmount;
    }
}
