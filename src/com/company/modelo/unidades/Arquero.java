package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidadInactivo;

public class Arquero extends UnidadAtacante {

	public Arquero(Jugador jugador) {
		super(jugador);
		this.estado =  new EstadoUnidadInactivo();
	}

    public void atacar(Edificio enemigo) {
		// TODO
    }
    
    public void atacar(Unidad enemigo) {
    	// TODO
    }

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	//@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

}
