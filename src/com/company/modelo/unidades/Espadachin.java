package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;

public class Espadachin extends UnidadAtacante {


	public Espadachin(Jugador jugador) {
		super(jugador);
		this.rangoAtaque = 1;
		this.danioAEdifcio = 15;
		this.danioAUnidad = 25;
		VIDA_MAXIMA = 100;
		vidaActual = VIDA_MAXIMA;
		COSTO = 50;
	}


	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}



}
