package com.aventuramistica.Clases;

import java.util.Scanner;

public class TreasureRoom implements Room {
    private final GameObject treasure;
    private boolean collected = false;

    public TreasureRoom(GameObject treasure) {
        this.treasure = treasure;
    }

    @Override
    public void enter(Player player, Game game, Scanner scanner) {
        System.out.println(player.getName() + " ha entrado en " + getDescription());
        if (!collected) {
            System.out.println("¡Encuentras un tesoro!");
            player.collect(treasure);
            collected = true;
        } else {
            System.out.println("Ya has recogido el tesoro de esta sala.");
        }
    }

    @Override
    public String getDescription() {
        return "una sala con un pedestal en el centro.";
    }
}
