package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.terreno.Mapa;

import java.util.ArrayList;

public class Partida {

    private Turno turno;
    private static Integer NUMERO_DE_JUGADORES = 2;
    private Mapa mapa;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private boolean comenzada;

    public Partida() throws CasilleroNoExistenteException, CasilleroLlenoException {
        turno = new Turno();

        for (Integer i = 0; i < NUMERO_DE_JUGADORES; i++){
            Jugador jugador = new Jugador();
            turno.sumarJugador(jugador);
            jugadores.add(jugador);
        }

        for (Jugador jugador : jugadores) { jugador.crearEntidadesIniciales(); }
    }
    public void correr() throws Exception{
        Jugador jugadorCorriente = turno.obtenerJugadorCorriente();

        /*TODO

        Acá podríamos recibir del controller un objeto acción - no sé bien cómo hacer.

        */
         turno.pasar();
    }


}
