package com.company.modelo.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.estados.EstadoUnidad;

import unidades.Unidad;

public abstract class Unidad implements Posicionable {

	protected Posicion posicion;
	protected Jugador jugador;
	protected EstadoUnidad estado;

	public Unidad(Jugador jugador) {
		this.jugador = jugador;
	}

	public void establecerCoordenadasDeNacimiento(int posicionHorizontal, int posicionVertical) {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
	}

	public void moverA(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException, CasilleroNoExistenteException {
		this.eliminar();
		posicion = new Posicion(posicionHorizontal, posicionVertical);
		posicion.posicionar(this);
	}

	@Override
	public void recibirDanio(Integer montoDeDanio) {
		estado.recibirDanio(montoDeDanio);
	}

	private void eliminar() throws CasilleroNoExistenteException {
		posicion.eliminar();
	}
	
	public Boolean verificarAlianza(Unidad unidad1){
	    return(unidad1.verificarAlianza(this.jugador));
	}
	
	public Boolean verificarAlianza(Jugador jugador2) {
		return (jugador == jugador2);
	}
}

