package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidadInactivo;

public class Espadachin extends UnidadAtacante {

	public Espadachin(Jugador jugador) {
		super(jugador);
		this.rangoAtaque = 1;
		this.danioAEdifcio = 15;
		this.danioAUnidad = 25;
		VIDA_MAXIMA = 100;
		vidaActual = VIDA_MAXIMA;
		COSTO = 50;
		this.estado = new EstadoUnidadInactivo(VIDA_MAXIMA);
	}


	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
	}



}
