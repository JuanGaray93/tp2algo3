package com.company.modelo.edificios;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.Unidad;

public class Cuartel extends Edificio {

	private static Integer VIDA = 250;
	private static Integer COSTO = 50;
	
	public Cuartel(Jugador jugador) {
		super(jugador);
	
		this.estado = new EstadoEdificio(VIDA,COSTO,50,4, 3);
	}
	
	public void crearUnidad(Unidad unidad){
		/*Posicion posicion = posiciones.get(0);
		try {
			posicion.posicionarUnidad(unidad);
		} catch (CasilleroLlenoException e) {
			//
		}*/
		jugador.agregarAPoblacion(unidad);
	}

	@Override
	public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

	}

	@Override
	public void actualizar() {

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
