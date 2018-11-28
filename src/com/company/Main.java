package com.company;

import com.company.modelo.Partida;

public class Main {

    public static void main(String[] args) {
        try {

            Partida partida = new Partida();

            while (true) {
                partida.correr();
            }

        } catch (Exception e) {
            // Terminar programa
        }
    }
}
