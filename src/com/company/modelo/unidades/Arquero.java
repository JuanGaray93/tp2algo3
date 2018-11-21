package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class Arquero extends Unidad {
	
	private Ataque ataque;

	public Arquero(Jugador jugador) {
		super(jugador);
		this.estado =  new EstadoUnidad(75,75);
		ataque = new Ataque(10,15);
		
	}

    public void atacar(Edificio enemigo) {
    	ataque.atacar(enemigo);
    }

    
    public void atacarUnidad(Unidad enemigo) {
    	ataque.atacar(enemigo);
    }

	//@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

}
