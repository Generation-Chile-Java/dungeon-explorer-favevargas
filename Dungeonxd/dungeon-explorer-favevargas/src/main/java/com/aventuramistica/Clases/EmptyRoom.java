package com.aventuramistica.Clases;

import java.util.Scanner;

public class EmptyRoom implements Room {
    @Override
    public void enter(Player player, Game game, Scanner scanner) {
        System.out.println(player.getName() + " ha entrado en " + getDescription());
        System.out.println("No hay nada de interés aquí.");
    }

    @Override
    public String getDescription() {
        return "una caverna silenciosa y vacía.";
    }
}