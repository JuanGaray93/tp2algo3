package com.company.modelo;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.terreno.Mapa;

import java.util.ArrayList;
import java.util.Random;

public class Partida {

    private Turno turno;
    private static Integer NUMERO_DE_JUGADORES = 2;


    private Mapa mapa;
    private ArrayList<Jugador> jugadores;
    private boolean comenzada;

    public Partida() throws CasilleroLlenoException {

        jugadores.add(0, new Jugador());
        jugadores.add(1, new Jugador());

        this.comenzar();

    }

    private Jugador getRandom() {
        int rnd = new Random().nextInt(this.jugadores.size());
        return jugadores.get(rnd);
    }

    private void comenzar() {

        this.turno = new Turno(getRandom());

    }

    private void finalizar() {

    }

    public void correr() {
    }

/*public Partida(){
		turno = new Turno();
		for(Integer i = 0; i < NUMERO_DE_JUGADORES; i++){
			turno.sumarJugador(new Jugador());
		}
	}

	public void correr() throws Exception{
		Jugador jugadorCorriente = turno.obtenerJugadorCorriente();
		
		// jugadorCorriente.ejecutarAcciones();
		/*

		Acá podríamos recibir del controller un objeto acción - no sé bien cómo hacer.


		turno.pasar();
	}*/

}
