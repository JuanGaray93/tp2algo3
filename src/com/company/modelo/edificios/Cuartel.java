package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.unidades.Unidad;

public class Cuartel extends Edificio {
	
	public Cuartel(Jugador jugador) {
		super(jugador);
	
		this.estado = new EstadoEdificio(250,50,50);
		this.tamanio = 4;
	}
	
	public void crear(Unidad unidad){
		Posicion posicion = posiciones.get(0);
		try {
			posicion.posicionarUnidad(unidad);
		} catch (CasilleroLlenoException e) {
			//
		}
		jugador.agregarAPoblacion(unidad);
	}
	
	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

}
