package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;

public class Espadachin extends UnidadAtacante {

	public Espadachin(Jugador jugador) {
		super(jugador);

		/*this.estado =  new EstadoUnidad(100,25);
		ataque = new Ataque(15,25);*/
		
	}

	@Override
	public void atacar(Unidad enemigo) {

	}

	@Override
	public void atacar(Edificio enemigo) {

	}

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	//@Override
	public void actualizar() {
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean verificarAlianza(Posicionable otroPosicionable) {
		return null;
	}

	@Override
	public Boolean verificarAlianza(Jugador otroJugador) {
		return null;
	}

}
