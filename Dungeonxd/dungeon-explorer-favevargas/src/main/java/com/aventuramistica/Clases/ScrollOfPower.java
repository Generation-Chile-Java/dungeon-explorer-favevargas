package com.aventuramistica.Clases;

/**
 * Clase ScrollOfPower (Implementación de GameObject)
 * Representa un tesoro específico que el jugador puede encontrar.
 */
public class ScrollOfPower implements GameObject {
    @Override
    public String getName() {
        return "Pergamino del Poder";
    }

    @Override
    public String getDescription() {
        return "Un antiguo pergamino que contiene la clave para sellar al Rey Demonio.";
    }
}
