package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;

public class Espadachin extends UnidadAtacante {

	public Espadachin(Jugador jugador) {
		super(jugador);

		/*this.estado =  new EstadoUnidad(100,25);
		ataque = new Ataque(15,25); TODO Martin*/
		
	}

	@Override
	public void atacar(Unidad enemigo) {
		// TODO Martin
	}

	@Override
	public void atacar(Edificio enemigo) {
		// TODO Martin
	}

}
