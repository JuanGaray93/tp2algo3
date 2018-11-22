package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.estadosArmaAsedio.EstadoArmaAsedioDesmontada;

public class MaquinaAsedio extends UnidadAtacante {

	public MaquinaAsedio(Jugador jugador) {
		super(jugador);
		this.estado =  new EstadoArmaAsedioDesmontada();
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

}
