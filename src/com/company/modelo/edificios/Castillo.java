package com.company.modelo.edificios;

import com.company.modelo.Jugador;
import com.company.modelo.unidades.Ataque;
import com.company.modelo.unidades.Unidad;

public class Castillo extends Edificio {

private Ataque ataque;

	public Castillo(Jugador jugador) {
		super(jugador);
		this.estado = new EstadoEdificio(1000,0,0,16,0);
	}

	/*public void crearMaquinaAsedio() throws Exception {
		try {
			posiciones.get(1).ubicar(new MaquinaAsedio(this.jugador));
		} catch (CasilleroLlenoException e) {
			// 
		}
	}*/


	public void atacar(Unidad enemigo) {
		ataque.atacar(enemigo);
	}


}
