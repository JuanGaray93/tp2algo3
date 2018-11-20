package com.company.modelo.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicion;
import com.company.modelo.Posicionable;

public abstract class Unidad implements Posicionable {

	protected Posicion posicion;
	protected Boolean atacando;
	protected Jugador jugador;
	protected EstadoUnidad estado;
	
	public Unidad(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public boolean saludable() {
		return estado.saludable();
	}

	public void naciEn(int posicionHorizontal, int posicionVertical) {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
	}

	public void moverA(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException, CasilleroNoExistenteException {
		this.eliminar();
		posicion = new Posicion(posicionHorizontal, posicionVertical);
		posicion.posicionar(this);
	}

	public void recibirDanio(int unDanio){
		estado.recibirDanio(unDanio);
	}

	private void eliminar() throws CasilleroNoExistenteException {
		posicion.eliminar();
	}

}
