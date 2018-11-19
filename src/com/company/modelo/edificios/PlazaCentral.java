package com.company.modelo.edificios;

import com.company.modelo.Jugador;

public class PlazaCentral extends Edificio {

	private static final Integer VIDA_MAXIMA = 1000;

	public PlazaCentral(Jugador jugador) {
		super(jugador);
		this.estado = new EstadoEdificio(VIDA_MAXIMA,0,0);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

}