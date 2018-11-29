package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidadInactivo;

public class Arquero extends UnidadAtacante {

	public Arquero(Jugador jugador) {
		super(jugador);
		this.rangoAtaque = 3;
		this.danioAEdifcio = 10;
		this.danioAUnidad = 15;
		VIDA_MAXIMA = 75;
		vidaActual = VIDA_MAXIMA;
		COSTO = 75;
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
