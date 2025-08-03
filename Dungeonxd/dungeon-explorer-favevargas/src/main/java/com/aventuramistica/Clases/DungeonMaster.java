package com.aventuramistica.Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DungeonMaster (Modularidad - Patrón Factory simple)
 * Responsable de crear y configurar la mazmorra.
 * Separa la lógica de creación del mundo de la lógica del juego.
 */
public class DungeonMaster {
    public List<Room> createDungeon() {
        List<Room> dungeon = new ArrayList<>();
        dungeon.add(new EmptyRoom());
        // Los enemigos ahora tienen vida: new EnemyRoom(nombre, daño, vida)
        dungeon.add(new EnemyRoom("Demoníaco Menor", 10, 30));
        dungeon.add(new TreasureRoom(new ScrollOfPower()));
        dungeon.add(new EnemyRoom("Caballero Corrupto", 15, 50));
        dungeon.add(new DemonKingRoom(25, 80)); // El Rey Demonio también tiene vida
        return dungeon;
    }
}
