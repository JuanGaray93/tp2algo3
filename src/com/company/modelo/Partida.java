package com.company.modelo;



import java.util.ArrayList;
import java.util.Random;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.terreno.Mapa;

public class Partida {
	
	private Mapa mapa;
	private ArrayList <Jugador> jugadores;
	private Turno turno;
	private boolean comenzada;
	
	public Partida() throws CasilleroLlenoException {
	
		jugadores.add(0,new Jugador(Mapa.getMapa()));
		jugadores.add(1,new Jugador(Mapa.getMapa()));
		
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

}
