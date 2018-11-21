package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;
import com.company.modelo.unidades.estados.EstadoUnidadInactivo;

public class Arquero extends Unidad {
	
	private Ataque ataque;

	public Arquero(Jugador jugador) {
		super(jugador);
		this.estado =  new EstadoUnidadInactivo();
		ataque = new Ataque(10,15);
		
	}

    /*public void atacar(Edificio enemigo) {
    	ataque.atacar(enemigo);
    }
    
    public void atacarUnidad(Unidad enemigo) {
    	ataque.atacar(enemigo);
    }*/

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
