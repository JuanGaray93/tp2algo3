package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;

public class MaquinaAsedio  extends Unidad {
	
	private Ataque ataque;

	public MaquinaAsedio(Jugador jugador) {
		super(jugador);
		this.estado =  new EstadoUnidad(150,200);
		ataque = new Ataque(75,0);
		
	}
	
	public void atacar(Unidad enemigo) {
		ataque.atacar(enemigo);
	}
	
	public void atacar(Edificio enemigo) {
		ataque.atacar(enemigo);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}
	
}
