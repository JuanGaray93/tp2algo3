package com.company.modelo;

import com.company.modelo.terreno.Mapa;

import java.util.ArrayList;

public class Partida {

    private Turno turno;
    private static Integer NUMERO_DE_JUGADORES = 2;
    private Mapa mapa;
    private ArrayList<Jugador> jugadores;
    private boolean comenzada;

    public Partida(){
        turno = new Turno();

        for(Integer i = 0; i < NUMERO_DE_JUGADORES; i++) turno.sumarJugador(new Jugador());


    }

    public void correr() throws Exception{
        Jugador jugadorCorriente = turno.obtenerJugadorCorriente();

        // jugadorCorriente.ejecutarAcciones();
        /*

        Acá podríamos recibir del controller un objeto acción - no sé bien cómo hacer.

        */
         turno.pasar();
    }


}
