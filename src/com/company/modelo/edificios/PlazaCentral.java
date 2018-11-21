package com.company.modelo.edificios;

import com.company.modelo.Jugador;

public class PlazaCentral extends Edificio {

	private static final Integer VIDA_MAXIMA = 450;

	public PlazaCentral(Jugador jugador) {
		super(jugador, 100, );
		this.estado = new EstadoEnConstruccion(VIDA_MAXIMA,100,25,4 ,3);
	}

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}
}