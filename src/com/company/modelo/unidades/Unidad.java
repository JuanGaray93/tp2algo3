package com.company.modelo.unidades;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.terreno.Mapa;
import com.company.modelo.Posicion;

public abstract class Unidad implements Posicionable {

	protected int vida, costo;
	protected Posicion posicion;
	protected Boolean atacando;
	protected Boolean construyendo;

	public void naciEn(int posicionHorizontal, int posicionVertical) {
		posicion = new Posicion(posicionHorizontal, posicionVertical);
	}

	public void moverA(int posicionHorizontal, int posicionVertical) throws CasilleroLlenoException, CasilleroNoExistenteException {
		this.eliminar();
		posicion = new Posicion(posicionHorizontal, posicionVertical);
		posicion.posicionarUnidad(this);
	}

	public void recibirDanio(int unDanio){
		vida -= unDanio;
	}

	public void eliminar() throws CasilleroNoExistenteException {
		posicion.eliminar();
	}

	public abstract void atacarEdificio(Edificio unEdificio);

	public abstract void atacarUnidad(Unidad unaUnidad);
}
