package com.company.modelo.edificios;

import com.company.modelo.Jugador;

public class PlazaCentral extends Edificio {

	private static final int VIDA_MAXIMA = 0;
	
	public PlazaCentral(Jugador jugador) {
		super(jugador);
		this.estado = new EstadoEdificio(1000,0,0);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

}
