package com.company.modelo;

import java.util.ArrayList;

public class Turno {
	
	ArrayList<Jugador> jugadores;
	Integer turnoActual = 0;

	public Turno() {

		jugadores = new ArrayList <>();
	}

	public void sumarJugador(Jugador nuevoJugador)
	{
		jugadores.add(nuevoJugador);
	}

	public void pasar(){

		turnoActual = (turnoActual + 1) % jugadores.size();
		jugadores.get(turnoActual).ejecutarAcciones();
	}

	public Jugador obtenerJugadorCorriente(){

		return jugadores.get(turnoActual);
	}

}
