package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
/*import com.company.modelo.unidades.Arquero;
import com.company.modelo.unidades.Espadachin;*/
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
	
	/*public void crearEspadachin(Unidad unidad) throws CasilleroLlenoException {
		Posicion posicion = posiciones.get(0);
		Espadachin espadachin = new Espadachin(jugador);
		posicion.posicionarUnidad(espadachin);
		jugador.agregarAPoblacion(espadachin);
	}
	
	public void crearArquero() throws CasilleroLlenoException {
		Posicion posicion = posiciones.get(0);
		Arquero arquero = new Arquero(jugador);
		posicion.posicionarUnidad(new Arquero(jugador));
		jugador.agregarAPoblacion(espadachin);
	}*/
	
	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

}
