package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioDesmontada;

public class MaquinaAsedio extends UnidadAtacante {
	
	//private Ataque ataque;

	public MaquinaAsedio(Jugador jugador) {
		super(jugador);
		this.rangoAtaque = 5;
		this.danioAEdifcio = 75;
		this.danioAUnidad = 0;
		VIDA_MAXIMA = 150;
		vidaActual = VIDA_MAXIMA;
		COSTO = 200;
		this.estado =  new EstadoArmaAsedioDesmontada(VIDA_MAXIMA);
	}


	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	//@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}


}
