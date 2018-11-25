package com.company.modelo.unidades;

import com.company.excepciones.PosicionableEsAliadoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidadInactivo;

public class Arquero extends UnidadAtacante {

	public Arquero(Jugador jugador) {
		super(jugador);
		this.estado =  new EstadoUnidadInactivo();
	}

	@Override
	public void atacar(Unidad enemigo) {
		// TODO Martin
	}

	@Override
	public void atacar(Edificio enemigo) throws PosicionableEsAliadoException {
		// TODO Martin
	}
}
